/*package step_definitions;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.LoginPage;
import Pages.MyAppsPage;
import Pages.NewslettersPage;
import Pages.DripsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

public class DripsTest extends KeywordUtil {
	

	@SuppressWarnings("rawtypes")
	static Class thisClass = DripsTest.class;
	static String testCaseID = thisClass.getSimpleName();
	
	static String logStep;
	public WebDriver driver;
	public static HashMap<String, String> dataMap = new HashMap<String, String>();
	String newsletter = "testing"+KeywordUtil.getCurrentDateTime();
	
	@Given("^Read the test data  \"([^\"]*)\" from Excel file for Drips$")
	public void read_the_test_data_from_Excel_file_for_Drips(String arg1) throws Throwable {
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

	@When("^user navigates to site url for Drips$")
	public void user_navigates_to_site_url_for_Drips() throws Throwable {
	    

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

	@Then("^verify the title of the Login Page for drips$")
	public void verify_the_title_of_the_Login_Page_for_drips() throws Throwable {
	    
	   
	}

	@When("^Enter Email address and password for drips$")
	public void enter_Email_address_and_password_for_drips() throws Throwable {
		KeywordUtil.inputText(LoginPage.email, dataMap.get("Email"), "Enter Email address");
		KeywordUtil.inputText(LoginPage.password, dataMap.get("Password"), "Enter Password");

	   
	}
	@When("^Click on Login button for drips$")
	public void click_on_Login_button_for_drips() throws Throwable {
		KeywordUtil.click(LoginPage.loginbtn, "Click on Login button");
	    
	   
	}

	@When("^Click on Drips option$")
	public void click_on_MailSend_link_for_drips() throws Throwable {
		KeywordUtil.clickElementFromList(MyAppsPage.allappslink, dataMap.get("myapp"), "Click on Mail Send Link");

	   
	}

	@When("^Click on Drips from Dashboard menu for drips$")
	public void click_on_Drips_from_Dashboard_menu_for_drips() throws Throwable {
	    KeywordUtil.clickElementFromList(DripsPage.dashboardlinks, dataMap.get("dashboardlink"), "Click on drips link");

	   
	}

	@When("^Click on Add Drips button$")
	public void click_on_Add_drips_button() throws Throwable {
	    KeywordUtil.click(DripsPage.adddripsbtn, "click on Add drips button");

	   
	}

//	@When("^Click on Add Cutom button at right side in drips$")
//	public void click_on_Add_Cutom_button_at_right_side_in_drips() throws Throwable {
//		KeywordUtil.click(Drips.adddripsbtn, "click on Add Custom button");
//
//	   
//	}

	@When("^Enter Name of drips$")
	public void enter_Name_of_drips() throws Throwable {
		KeywordUtil.inputText(DripsPage.nametxt, newsletter, "Enter the Name of drips");

	   
	}

	@When("^Action of drips$")
	public void subject_of_drips() throws Throwable {
	//KeywordUtil.inputText(DripsPage.actionclick, dataMap.get("Action"), "Enter the Subject of drips");
	KeywordUtil.click(DripsPage.actionclick, "click on Action  button");

	}
   
	@When("^trigger is selected$")
	public void trigger_is_selected() throws Throwable {
		}

	@When("^Clickc on Save button$")
	public void clickc_on_Save_button() throws Throwable {
		KeywordUtil.click(DripsPage.savebtn, "click on Save button");

		}	
	   
	
	@Then("^Verify the drip created successfully or not$")
	public void verify_the_drip_created_successfully_or_not() throws Throwable {	    
	   
	}



}
*/