/*package step_definitions;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.TemplatesPage;
import Pages.LoginPage;
import Pages.MyAppsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;


public class TemplatesTest extends KeywordUtil {
	
	@SuppressWarnings("rawtypes")
	static Class thisClass = TemplatesTest.class;
	static String testCaseID = thisClass.getSimpleName();
	
	public WebDriver driver;
	
	public static HashMap<String, String> dataMap = new HashMap<String, String>();
	String templates = "testing"+KeywordUtil.getCurrentDateTime();
	
	@Given("^Read the test data  \"([^\"]*)\" from Excel file for Template$")
	public void read_the_test_data_from_Excel_file(String arg1){
		try 
		{
			dataMap = ExcelDataUtil.getTestDataWithTestCaseID("templates", arg1);
			
		} 
		catch (Throwable e) 
		{
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
		
		
	}
	
	@When("^user navigates to site url$")
	public void user_navigates_to_site_url() throws Throwable {
	    

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

@Then("^verify the title of the Login Page for Templates$")
public void verify_the_title_of_the_Login_Page_for_Templates() throws Throwable {
	
	String title = KeywordUtil.getElementText(LoginPage.loginlbl);
	System.out.println("Title of the Page " + title);
	Assert.assertEquals(title, dataMap.get("Title"));
    
}

@When("^Enter Email address and password$")
public void enter_Email_address_and_password() throws Throwable {
	KeywordUtil.inputText(LoginPage.email, dataMap.get("Email"), LoginPage.emailnm+dataMap.get("Email"));
	KeywordUtil.inputText(LoginPage.password, dataMap.get("Password"), LoginPage.passwordnm+ dataMap.get("Password"));

   
    
}

@When("^I Click on Login Button$")
public void click_Login_button() throws Throwable {
	KeywordUtil.click(LoginPage.loginbtn, "Click on Login button");

}

//	try {
//		KeywordUtil.click(LoginPage.loginbtn, "Click on Login button");
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//   
//    
//}

@When("^Click on MailSend link$")
public void click_on_MailSend_link() throws Throwable {
	KeywordUtil.clickElementFromList(MyAppsPage.allappslink, dataMap.get("myapp"), "Click on Mail Send Link");
	
   
    
}

@When("^Click on Templates from Dashboard menu$")
public void click_on_Templates_from_Dashboard_menu() throws Throwable {
    KeywordUtil.clickElementFromList(TemplatesPage.dashboardlinks, dataMap.get("dashboardlink"), "Click on Templates link");

    
}

@When("^Click on Add Templates button$")
public void click_on_Add_Templates_button() throws Throwable {
    KeywordUtil.click(TemplatesPage.addtemplatebtn, "click on Add templates button");

    
}

@When("^Click on Add Cutom button at right side$")
public void click_on_Add_Cutom_button_at_right_side() throws Throwable {
	KeywordUtil.click(TemplatesPage.addcustombtn, "click on Add Custom button");

    
}

@When("^Enter Name of Templates$")
public void enter_Name_of_Templates() throws Throwable {
   
	KeywordUtil.inputText(TemplatesPage.nametxt, templates, "Enter the Name of template");
  
}

@When("^Subject of Templates$")
public void subject_of_Templates() throws Throwable {
	KeywordUtil.inputText(TemplatesPage.subjecttxt, dataMap.get("Subject"), "Enter the Subject of template");

   
    
}

@When("^Click  Submit button$")
public void click_Submit_button() throws Throwable {
	KeywordUtil.click(TemplatesPage.submitbtn, "click on Submit button");

   
    
}

@When("^Clickc  OK button$")
public void clickc_OK_button() throws Throwable {
   
    
}

@Then("^Verify the Templates created successfully or not$")
public void verify_the_Templates_created_successfully_or_not() throws Throwable {
   
    
}


	

}
*/