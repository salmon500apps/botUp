/*package step_definitions;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.ContactsPage;
import Pages.DripsPage;
import Pages.LoginPage;
import Pages.MyAppsPage;
import Pages.TemplatesPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

public class ContactsTest extends KeywordUtil  {
	

	@SuppressWarnings("rawtypes")
	static Class thisClass = DripsTest.class;
	static String testCaseID = thisClass.getSimpleName();
	
	static String logStep;
	public WebDriver driver;
	public static HashMap<String, String> dataMap = new HashMap<String, String>();
	String contacts = KeywordUtil.getCurrentDateTime();
	
	

@Given("^Read the test data  \"([^\"]*)\" from Excel file for contacts$")
public void read_the_test_data_from_Excel_file_for_contacts(String arg1) throws Throwable {
	try 
	{
		KeywordUtil.cucumberTagName = "Web";
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID("contacts", arg1);
		
	} 
	catch (Throwable e) 
	{
		GlobalUtil.e = e;
		GlobalUtil.ErrorMsg = e.getMessage();
		Assert.fail(e.getMessage());
	}
	
}

@When("^user navigates to site url for contacts$")
public void user_navigates_to_site_url_for_contacts() throws Throwable {
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

@Then("^verify the title of the Login Page for contacts$")
public void verify_the_title_of_the_Login_Page_for_contacts() throws Throwable {
	String title = KeywordUtil.getElementText(LoginPage.loginlbl);
	System.out.println("Title of the Page " + title);
	Assert.assertEquals(title, dataMap.get("Title"));

	
    
}

@When("^Enter Email address and password for contacts$")
public void enter_Email_address_and_password_for_contacts() throws Throwable {
	KeywordUtil.inputText(LoginPage.email, dataMap.get("Email"), "Enter Email address");
	KeywordUtil.inputText(LoginPage.password, dataMap.get("Password"), "Enter Password");

    
}

@When("^Click on Login button for contacts$")
public void click_on_Login_button_for_contacts() throws Throwable {
	KeywordUtil.click(LoginPage.loginbtn, "Click on Login button");

	
    
}

@When("^Click on MailSend option for contacts$")
public void click_on_MailSend_option_for_contacts() throws Throwable {
	KeywordUtil.clickElementFromList(MyAppsPage.allappslink, dataMap.get("myapp"), "Click on Mail Send Link");
}

//@When("^Click on contacts option$")
//public void click_on_contacts_option() throws Throwable {
//	KeywordUtil.clickElementFromList(MyAppsPage.allappslink, dataMap.get("myapp"), "Click on Mail Send Link");
//	   
//    
//}

@When("^Click on contacts from Dashboard menu for contacts$")
public void click_on_contacts_from_Dashboard_menu_for_contacts() throws Throwable {
	KeywordUtil.clickElementFromList(ContactsPage.dashboardlinks, dataMap.get("dashboardlink"), "Click on Contacts link");

    
}

@When("^Click on Add contacts button$")
public void click_on_Add_contacts_button() throws Throwable {
	 KeywordUtil.click(ContactsPage.addcontactbtn, "click on Add contacts button");

    
}
//
//@When("^Enter All the details of the contacts$")
//public void enter_All_the_details_of_the_contacts() throws Throwable {
//	KeywordUtil.inputText(ContactsPage.firstname, newsletter, "Enter the Name of drips");
//
//    
//}

@When("^Enter First Name for contacts$")
public void enter_First_Name_for_contacts() throws Throwable {
	//KeywordUtil.inputText(LoginPage.email, dataMap.get("Email"), "Enter Email address");(reference for static
	KeywordUtil.inputText(ContactsPage.firstname, dataMap.get("First Name")+contacts, "Enter First Name for contacts");
   
}

@When("^Enter Last Name for Contacts$")
public void enter_Last_Name_for_Contacts() throws Throwable {
	//KeywordUtil.inputText(ContactsPage.lastname, contacts, "Enter Last Name for contacts");
	KeywordUtil.inputText(ContactsPage.lastname, dataMap.get("Last Name")+contacts, "Enter Last Name for contacts");
	   
}

@When("^Enter for EMail ID for contacts$")
public void enter_for_EMail_ID_for_contacts() throws Throwable {
	//KeywordUtil.inputText(ContactsPage.email, contacts, "Enter EMail for contacts");
	KeywordUtil.inputText(ContactsPage.email, dataMap.get("Email"), "Enter Email for contacts");

	
    
}

@When("^Enter Phone number$")
public void enter_Phone_number() throws Throwable {
	//KeywordUtil.inputText(ContactsPage.phonenumber, contacts, "Enter Phone Number for contacts");
	KeywordUtil.inputText(ContactsPage.phonenumber, dataMap.get("phone"), "Enter Phone Number for contacts");

   
}
//
//@When("^Enter custom(\\d+) details$")
//public void enter_custom_details(int arg1) throws Throwable {
//	KeywordUtil.inputText(ContactsPage.customone, contacts, "Enter custom1 for contacts");
//  
//}


@When("^Enter customone details$")
public void enter_customone_details() throws Throwable {
	KeywordUtil.inputText(ContactsPage.customone, contacts, "Enter customone for contacts");
   
}

@When("^Enter customtwo details$")
public void enter_customtwo_details() throws Throwable {
	KeywordUtil.inputText(ContactsPage.customtwo, contacts, "Enter customtwo for contacts");
}

@When("^Click on Save button to save contact details$")
public void click_on_Save_button_to_save_contact_details() throws Throwable {
	KeywordUtil.click(ContactsPage.savetbtn, "click on save button");
 
    
}

@Then("^Verify the contacts created successfully or not$")
public void verify_the_contacts_created_successfully_or_not() throws Throwable {
    
    
}



}
*/