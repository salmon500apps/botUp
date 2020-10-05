/*package step_definitions;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.DripsPage;
import Pages.IntegrationPage;
import Pages.LoginPage;
import Pages.MyAppsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

public class IntegrationTest extends KeywordUtil {

	@SuppressWarnings("rawtypes")
	static Class thisClass = IntegrationTest.class;
	static String testCaseID = thisClass.getSimpleName();

	static String logStep;
	public WebDriver driver;
	public static HashMap<String, String> dataMap = new HashMap<String, String>();
	String newsletter = "testing" + KeywordUtil.getCurrentDateTime();

	@Given("^Read the test data  \"([^\"]*)\" from Excel file for integration$")
	public void read_the_test_data_from_Excel_file_for_integration(String arg1) throws Throwable {
		try {
			KeywordUtil.cucumberTagName = "Web";
			dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Intergations", arg1);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	@When("^user navigates to site url for integration$")
	public void user_navigates_to_site_url_for_integration() throws Throwable {
		try {
			navigateToUrl(dataMap.get("URL"));

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	@Then("^verify the title of the Login Page for integration$")
	public void verify_the_title_of_the_Login_Page_for_integration() throws Throwable {

	}

	@When("^Enter Email address and password for integration$")
	public void enter_Email_address_and_password_for_integration() throws Throwable {
		KeywordUtil.inputText(LoginPage.email, dataMap.get("Email"), "Enter Email address");
		KeywordUtil.inputText(LoginPage.password, dataMap.get("Password"), "Enter Password");
	}

	@When("^Click on Login button for integration$")
	public void click_on_Login_button_for_integration() throws Throwable {
		KeywordUtil.click(LoginPage.loginbtn, "Click on Login button");

	}

	@When("^Click on integration option$")
	public void click_on_integration_option() throws Throwable {
		KeywordUtil.clickElementFromList(MyAppsPage.allappslink, dataMap.get("myapp"), "Click on Mail Send Link");

	}

	@When("^Click on integration from Dashboard menu for integration$")
	public void click_on_intergration_from_Dashboard_menu_for_integration() throws Throwable {
		KeywordUtil.clickElementFromList(IntegrationPage.dashboardlinks, dataMap.get("dashboardlink"),
				"Click on Integrations link");

	}

	@When("^User click on Integrations app as Twilio$")
	public void user_click_on_Integrations_app_as_Twilio() throws Throwable {
		String value = KeywordUtil.getElementText(IntegrationPage.twilioApp);
		System.out.println("value from Above code "+ value);
		if (value.contains("Disable")) {
			KeywordUtil.clickInstallIntegrationsApp(IntegrationPage.twilioApp,
					"Click on Install button for Twillio app");
			Thread.sleep(4000);
			System.out.println("Before Clicking on Confirm button");
			KeywordUtil.clickElementUsingActions(IntegrationPage.confirmbtn, "Click on Confirm button");
		}
		Thread.sleep(2000);
		KeywordUtil.clickInstallIntegrationsApp(IntegrationPage.twilioApp, "Click on Install button for Twillio app");

	}

	@When("^I Enter the Account Sid for Twillio$")
	public void i_Enter_the_Account_Sid_for_Twillio() throws Throwable {
		KeywordUtil.inputText(IntegrationPage.accountsidtxt, dataMap.get("twillio_ACCOUNT_SID"),
				"Enter the Account Sid ID :" + dataMap.get("twillio_ACCOUNT_SID"));

	}

	@When("^I Enter the Auth Token$")
	public void i_Enter_the_Auth_Token() throws Throwable {

		KeywordUtil.inputText(IntegrationPage.auth_key, dataMap.get("twillio_AUTH_TOKEN"),
				"Enter the Auth key :" + dataMap.get("twillio_AUTH_TOKEN"));
	}

	@When("^I Click on Authentication button$")
	public void i_Click_on_Authentication_button() throws Throwable {

		KeywordUtil.click(IntegrationPage.authenticationbtn, "Click on Authentication button");
	}

	@Then("^User validate the disabled button for twillio app$")
	public void user_validate_the_disabled_button_for_twillio_app() throws Throwable {
		String actualvalue = KeywordUtil.clickInstallIntegrationsApp(IntegrationPage.twilioApp,
				"Click on Install or Dsiable button for Twillio app");
		Assert.assertEquals(actualvalue, dataMap.get("appStatus"));
	}

	
	// Validating the ENable/Disable Mode
	
	@Then("^User validate the disabled button for twillio app$")
	public void user_validate_the_disabled_button_for_twillio_app() throws Throwable {
		String actualvalue = KeywordUtil.getElementText(IntegrationPage.diabledbtn);
		KeywordUtil.getElementText(IntegrationPage.diabledbtn);
			}
		
	
	
	@When("^Click on Disabled button for Twillio App$")
	public void click_on_Disabled_button_for_Twillio_App() throws Throwable {
		Thread.sleep(4000);
		KeywordUtil.clickInstallIntegrationsApp(IntegrationPage.twilioApp,
				"Click on Dsiable button for Twillio app");
	}

	@Then("^I verify the modal title for Are you sure to diable$")
	public void i_verify_the_modal_title_for_Are_you_sure_to_diable() throws Throwable {
		Thread.sleep(3000);
		String modalTitle = KeywordUtil.getElementText(IntegrationPage.modalTitlePopup);
		Assert.assertEquals(modalTitle, dataMap.get("modeltitlepopup"));
	}

	@When("^I click on Confirm button$")
	public void i_click_on_Confirm_button() throws Throwable {
		Thread.sleep(2000);
		String value = KeywordUtil.getElementText(IntegrationPage.twilioApp);
		System.out.println("value from Above code "+ value);
		}

	@Then("^I verify the Twillio app enable mode to install or not$")
	public void i_verify_the_Twillio_app_enable_mode_to_install_or_not() throws Throwable {
		String actualvalue = KeywordUtil.clickInstallIntegrationsApp(IntegrationPage.twilioApp,
				"Click on Install or Dsiable button for Twillio app");
		Assert.assertEquals(actualvalue, "Install");
		Thread.sleep(5000);
	}

}
*/