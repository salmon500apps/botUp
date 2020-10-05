package step_definitions;

import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import mantisutil.MantisReport;
import testlink.api.java.client.TestLinkAPIResults;
import utilities.ConfigReader;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;
import utilities.LogUtil;


public class Hooks {

	String imagePath;
	String pathForLogger;
	String testCaseDescription;

	@Before("@botup")
	public void before(Scenario scenario) {

		if (scenario.getName().contains("_"))
			testCaseDescription = scenario.getName().split("_")[1];
		else
			testCaseDescription = scenario.getName();
		RunCukesTest.logger = RunCukesTest.extent.startTest(testCaseDescription);

		LogUtil.infoLog(getClass(),
				"\n+----------------------------------------------------------------------------------------------------------------------------+");
		LogUtil.infoLog(getClass(), "Test Started: " + scenario.getName());

		LogUtil.infoLog("Test Environment",
				"Test is executed in Environment: " + GlobalUtil.getCommonSettings().getExecutionEnv());

		LogUtil.infoLog("TestStarted", "Test is started with browser: " + GlobalUtil.getCommonSettings().getBrowser());
	
	}

	@After("@botup")
	public void after(Scenario scenario) {
		String testName = scenario.getName().split("_")[0].trim();
		if (scenario.isFailed()) {
			try {
				String scFileName = "ScreenShot_" + System.currentTimeMillis();
				String screenshotFilePath = ConfigReader.getValue("screenshotPath") + "\\" + scFileName + ".png";

				imagePath = HTMLReportUtil.testFailTakeScreenshot(screenshotFilePath);
				pathForLogger = RunCukesTest.logger.addScreenCapture(imagePath);
				RunCukesTest.logger.log(LogStatus.FAIL,
						HTMLReportUtil.failStringRedColor("Failed at point: " + pathForLogger) + GlobalUtil.e);

				scenario.write("Current Page URL is " + GlobalUtil.getDriver().getCurrentUrl());

				byte[] screenshot = KeywordUtil.takeScreenshot(screenshotFilePath);
				scenario.embed(screenshot, "image/png");

				// report the bug
				String bugID = "Please check the Bug tool Configuration";
				if (GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")) {
					bugID = MantisReport
							.reporIssue(scenario.getName(), GlobalUtil.ErrorMsg, "General",
									"Automated on Browser: " + GlobalUtil.getCommonSettings().getBrowser()
											+ " and Build Name: " + GlobalUtil.getCommonSettings().getBuildNumber(),
									screenshotFilePath);
				}

				if (GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")) {
					// getting the os name to report the bug
					String osName = System.getProperty("os.name");
					if (GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote")) {
						osName = GlobalUtil.getCommonSettings().getRemoteOS();
					}
					bugID = GlobalUtil.jiraapi.reporIssue(scenario.getName(),
							"Automated on OS: " + osName + ",\n Automated on Browser: "
									+ GlobalUtil.getCommonSettings().getBrowser() + ",\n Build Name: "
									+ GlobalUtil.getCommonSettings().getBuildNumber() + ". \n\n\n\n"
									+ GlobalUtil.ErrorMsg,
							screenshotFilePath);
				}

				// updating the results in Testmangement tool
				if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")) {
					GlobalUtil.testlinkapi
							.updateTestLinkResult(
									testName, "Please find the BUGID in "
											+ GlobalUtil.getCommonSettings().getBugToolName() + " : " + bugID,
									TestLinkAPIResults.TEST_PASSED);
				}
				if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")) {
					GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in "
							+ GlobalUtil.getCommonSettings().getBugToolName() + " : " + bugID, "Fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			LogUtil.infoLog("TestEnded",
					"Test has ended closing browser: " + GlobalUtil.getCommonSettings().getBrowser());
			// updating the results in Testmangement tool
			if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")) {
				GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed",
						TestLinkAPIResults.TEST_PASSED);
			}
			if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")) {
				GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
			}
		}	
		RunCukesTest.extent.endTest(RunCukesTest.logger);
	}
}
