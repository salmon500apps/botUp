/*package step_definitions;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.DripsPage;
import Pages.LoginPage;
import Pages.MyAppsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

public class ReportsTest extends KeywordUtil {
	
	@SuppressWarnings("rawtypes")
	static Class thisClass = DripsTest.class;
	static String testCaseID = thisClass.getSimpleName();
	
	static String logStep;
	public WebDriver driver;
	public static HashMap<String, String> dataMap = new HashMap<String, String>();
	String newsletter = "testing"+KeywordUtil.getCurrentDateTime();
	

	
	@Given("^Read the test data  \"([^\"]*)\" from Excel file for reports$")
	public void read_the_test_data_from_Excel_file_for_reports(String arg1) throws Throwable {
	    
		try 
		{
			KeywordUtil.cucumberTagName = "Web";
			dataMap = ExcelDataUtil.getTestDataWithTestCaseID("drips", arg1);
			
		} 
		catch (Throwable e) 
		{
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
		
	}

	@When("^user navigates to site url for reports$")
	public void user_navigates_to_site_url_for_reports() throws Throwable {
		try 
		{
			navigateToUrl(dataMap.get("URL"));	
			
		} 
		catch (Throwable e) 
		{
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		} 

	}

	@Then("^verify the title of the Login Page for reports$")
	public void verify_the_title_of_the_Login_Page_for_reports() throws Throwable {
	    

	}

	@When("^Enter Email address and password for reports$")
	public void enter_Email_address_and_password_for_reports() throws Throwable {
		KeywordUtil.inputText(LoginPage.email, dataMap.get("Email"), "Enter Email address");
		KeywordUtil.inputText(LoginPage.password, dataMap.get("Password"), "Enter Password");


	}

	@When("^Click on Login button for reports$")
	public void click_on_Login_button_for_reports() throws Throwable {
	    

	}

	@When("^Click on reports option$")
	public void click_on_reports_option() throws Throwable {
		KeywordUtil.clickElementFromList(MyAppsPage.allappslink, dataMap.get("myapp"), "Click on Mail Send Link");


	}

	@When("^Click on reports from Dashboard menu for reports$")
	public void click_on_reports_from_Dashboard_menu_for_reports() throws Throwable {
		KeywordUtil.clickElementFromList(DripsPage.dashboardlinks, dataMap.get("dashboardlink"), "Click on News letter link");


	}


}
*/