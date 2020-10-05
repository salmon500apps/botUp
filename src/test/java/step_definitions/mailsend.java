package step_definitions;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Pages.ContactsPage;
import Pages.DashBoardPage;
import Pages.DripsPage;
import Pages.IntegrationPage;
import Pages.LoginPage;
import Pages.MyAppsPage;
import Pages.NewslettersPage;
import Pages.TemplatesPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

public class mailsend extends KeywordUtil {

	@SuppressWarnings("rawtypes")
	static Class thisClass = mailsend.class;
	static String testCaseID = thisClass.getSimpleName();

	public WebDriver driver;
	String enteredContact;
	public static HashMap<String, String> dataMap = new HashMap<String, String>();
	String ranmdom = KeywordUtil.getCurrentDateTime();

	@Given("^Read the test data  \"([^\"]*)\" from Excel file$")
	public void read_the_test_data_from_Excel_file(String arg1) {
		try {

			dataMap = ExcelDataUtil.getTestDataWithTestCaseID("mailsend", arg1);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	@When("^Navigates to the url$")
	public void navigates_to_the_url() throws Throwable {

		try {
			navigateToUrl(dataMap.get("URL"));

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Verify the title of the Login Page$")
	public void verify_the_title_of_the_Login_Page() throws Throwable {

		// KeywordUtil.Login(LoginPage.email, LoginPage.password, dataMap.get("Email"),
		// dataMap.get("Password"), "Entered Login Credentials : Email "
		// +dataMap.get("Email")+ " pwd: "+ dataMap.get("Password") )
		/*
		 * String title = KeywordUtil.getElementText(LoginPage.loginlbl);
		 * System.out.println("Title of the Page " + title); Assert.assertEquals(title,
		 * dataMap.get("Title"));
		 */
	}

	@When("^Enter Email adrees and password$")
	public void enter_Email_adrees_and_password() throws Throwable {

		KeywordUtil.inputText(LoginPage.email, dataMap.get("Email"), LoginPage.emailnm + dataMap.get("Email"));
		KeywordUtil.inputText(LoginPage.password, dataMap.get("Password"),
				LoginPage.passwordnm + dataMap.get("Password"));
	}

	@When("^Click on Login button$")
	public void click_on_Login_button() throws Throwable {
		KeywordUtil.click(LoginPage.loginbtn, "Click on Login button");
	}



	@When("^Click on MailSend option$")
	public void click_on_MailSend_option() throws Throwable {
		KeywordUtil.clickElementFromList(MyAppsPage.allappslink, dataMap.get("myapp"), "Click on Mail Send Link");
		
//		Thread.sleep(8000);
//		
//		getDriver().navigate().to("https://my.dev.500apps.io/#/ms/mailsend/2/0/dashboard/dd/r-dashboard/:block_params/0/0/0/0/0/0/c-b/0");

	}

	@When("^Click on NewsLetter from Dashboard menu$")
	public void click_on_NewsLetter_from_Dashboard_menu() throws Exception {
		KeywordUtil.clickElementFromList(NewslettersPage.dashboardlinks, dataMap.get("dashboardlink"),
				"Click on News letter link");
	}

	@When("^Click on Add Newsletter button$")
	public void click_on_Add_Newsletter_button() throws Throwable {

		KeywordUtil.click(NewslettersPage.addnewsletterbtn, "click on Add news letter button");
	}

	@When("^user click on Image$")
	public void user_click_on_Image() throws InterruptedException {
		KeywordUtil.click(NewslettersPage.imagepic, "click on Image pic");
		Thread.sleep(2500);

	}

	@When("^Click on Submit button$")
	public void click_on_Submit_button() throws Throwable {

		KeywordUtil.click(NewslettersPage.submitbtn, "click on Submit button");
	}

	@When("^Click on OK button$")
	public void click_on_OK_button() throws Throwable {

		KeywordUtil.click(NewslettersPage.okbtn, "click on Ok button");

	}

	@Then("^Verify the newsletter created successfully or not$")
	public void verify_the_newsletter_created_successfully_or_not() throws Throwable {

	}

	@When("^Enter Invalid Email Address and Password$")
	public void enter_Invalid_Email_Address_and_Password() throws Throwable {

		KeywordUtil.inputText(LoginPage.email, "invalidemail", "Enter Inavlid Email address");
		KeywordUtil.inputText(LoginPage.password, "invalidpassword", "Enter invalid Password");
	}

	@Then("^Verify the login successfull$")
	public void verify_the_login_successfull() throws Throwable {

		String title = KeywordUtil.getElementText(NewslettersPage.welcome500apps);
		Assert.assertEquals(title, dataMap.get("welcomemessage"));
	}

	@Then("^Validate the inavlid email and password error message$")
	public void validateInvalidEmailAndPasswordErrormessage() throws Throwable {
		KeywordUtil.isWebElementVisible(LoginPage.toastmsg, "Invalid email and password toast message displayed");
		String actual = KeywordUtil.getElementText(LoginPage.toastmsg);
		Assert.assertEquals(actual, dataMap.get("invalidemailerrormsg"));
	}

	@When("^Click on Logout button$")
	public void Click_on_Logout_button() throws Throwable {
		Thread.sleep(2500);
		KeywordUtil.click(DashBoardPage.leftArrowmenu, "Click on Profile menu");
		Thread.sleep(2500);
		KeywordUtil.click(DashBoardPage.profileMenu, "Click on Profile menu");
		KeywordUtil.clickElementFromList(DashBoardPage.logoutlink, "Logout", "Click on Log Out link");
	}

	// ==========Drips==============

	@When("^Click on Drips from Dashboard menu for drips$")
	public void click_on_Drips_from_Dashboard_menu_for_drips() throws Throwable {
		KeywordUtil.clickElementFromList(DripsPage.dashboardlinks, dataMap.get("dripslink"), "Click on drips link");

	}

	@When("^Click on Add Drips button$")
	public void click_on_Add_drips_button() throws Throwable {
		KeywordUtil.click(DripsPage.adddripsbtn, "click on Add drips button");

	}

	@When("^Enter Name of drips$")
	public void enter_Name_of_drips() throws Throwable {
		KeywordUtil.inputText(DripsPage.nametxt, dataMap.get("dripname") + ranmdom, "Enter the Name of drips");
		Thread.sleep(2000);
	}

	@When("^trigger is selected$")
	public void trigger_is_selected() throws Throwable {
		KeywordUtil.click(DripsPage.trigerselect, "Click on Trigger");
		Thread.sleep(1500);
		KeywordUtil.selectItemByArrowDown(DripsPage.trigerselect, "Selected Trigger option");
		Thread.sleep(1500);
		KeywordUtil.selectByVisibleText(DripsPage.selecttag, "Important Tag", "Select the tag");
		Thread.sleep(1500);
	}

	@When("^Action of drips$")
	public void subject_of_drips() throws Throwable {

		KeywordUtil.click(DripsPage.actionclick, "click on Action button");
		Thread.sleep(2000);

	}

	@When("^user Enter subject for drips$")
	public void user_Enter_subject_for_drips() throws Throwable {
		KeywordUtil.inputText(DripsPage.subjecttxt, dataMap.get("dripSubject") + ranmdom,
				"Enter the Subject Name of drips");
		Thread.sleep(2000);
	}

	@When("^user Enter Sender name for drips$")
	public void user_Enter_Sender_name_for_drips() throws Throwable {
		KeywordUtil.inputText(DripsPage.sendertext, dataMap.get("Sender name") + ranmdom,
				"Enter the Sender Name of drips");
		Thread.sleep(2000);
	}

	@When("^Enter the Body text$")
	public void Enter_the_Body_text() throws Throwable {
		KeywordUtil.inputText(DripsPage.bodytxt, dataMap.get("Sender name") + ranmdom, "Enter the body text");
		Thread.sleep(2000);
	}

	@When("^Clickc on Save button$")
	public void clickc_on_Save_button() throws Throwable {
		KeywordUtil.click(DripsPage.savebtn, "click on Save button");
		Thread.sleep(8000);
	}

	@Then("^Verify the drip created successfully or not$")
	public void verify_the_drip_created_successfully_or_not() throws Throwable {

	}
	// ========================================================================================

	@When("^Click on Templates from Dashboard menu$")
	public void click_on_Templates_from_Dashboard_menu() throws Throwable {
		KeywordUtil.clickElementFromList(TemplatesPage.dashboardlinks, dataMap.get("templatelink"),
				"Click on Templates link");

	}

	@When("^Click on Add Templates button$")
	public void click_on_Add_Templates_button() throws Throwable {
		KeywordUtil.click(TemplatesPage.addtemplatebtn, "click on Add templates button");

	}

	@When("^user click on Image for Template$")
	public void user_click_on_Image_for_Template() throws Throwable {
		KeywordUtil.click(TemplatesPage.imagepic, "click on Image pic for Template");
		Thread.sleep(2500);
	}

	@When("^Subject of Templates$")
	public void subject_of_Templates() throws Throwable {
		KeywordUtil.inputText(TemplatesPage.subjecttxt, dataMap.get("templatesubject"),
				"Enter the Subject of template");

	}

	@When("^Select Category button$")
	public void Select_Category_button() throws Throwable {
		KeywordUtil.click(TemplatesPage.catergory, "Select the Category");
		Thread.sleep(2000);
		KeywordUtil.clickElementFromList(TemplatesPage.categorylist, "Category1",
				"Select the Category from list of options");
		Thread.sleep(2000);
	}

	@When("^Click Submit button for template$")
	public void Click_Submit_button_for_template() throws Throwable {
		KeywordUtil.click(TemplatesPage.submitbtn, "click on Submit button");

	}

	@When("^Click OK button for template$")
	public void Click_OK_button_for_template() throws Throwable {
		KeywordUtil.click(TemplatesPage.okaybtn, "click on Submit button");
	}

	@Then("^Verify the Templates created successfully or not$")
	public void verify_the_Templates_created_successfully_or_not() throws Throwable {

	}

	// ===========================================================================

	@When("^Click on contacts from Dashboard menu for contacts$")
	public void click_on_contacts_from_Dashboard_menu_for_contacts() throws Throwable {
		KeywordUtil.clickElementFromList(ContactsPage.dashboardlinks, dataMap.get("contactlink"),
				"Click on Contacts link");

	}

	@When("^Click on Add contacts button$")
	public void click_on_Add_contacts_button() throws Throwable {
		KeywordUtil.click(ContactsPage.addcontactbtn, "click on Add contacts button");

	}

	@When("^Enter First Name for contacts$")
	public void enter_First_Name_for_contacts() throws Throwable {
		// KeywordUtil.inputText(LoginPage.email, dataMap.get("Email"), "Enter Email
		// address");(reference for static
		KeywordUtil.inputText(ContactsPage.firstname, dataMap.get("First Name") + ranmdom,
				"Enter First Name for contacts");
		enteredContact = KeywordUtil.getElementText(ContactsPage.firstname);

	}

	@When("^Enter Last Name for Contacts$")
	public void enter_Last_Name_for_Contacts() throws Throwable {
		// KeywordUtil.inputText(ContactsPage.lastname, contacts, "Enter Last Name for
		// contacts");
		KeywordUtil.inputText(ContactsPage.lastname, dataMap.get("Last Name") + ranmdom,
				"Enter Last Name for contacts");

	}

	@When("^Enter for EMail ID for contacts$")
	public void enter_for_EMail_ID_for_contacts() throws Throwable {
		// KeywordUtil.inputText(ContactsPage.email, contacts, "Enter EMail for
		// contacts");
		KeywordUtil.inputText(ContactsPage.email, dataMap.get("Email"), "Enter Email for contacts");

	}

	@When("^Enter Phone number$")
	public void enter_Phone_number() throws Throwable {

		KeywordUtil.inputText(ContactsPage.phonenumber, dataMap.get("phone"), "Enter Phone Number for contacts");

	}

	@When("^Click on Save button to save contact details$")
	public void click_on_Save_button_to_save_contact_details() throws Throwable {
		Thread.sleep(2000);
		KeywordUtil.click(ContactsPage.savetbtn, "click on save button");

	}

	@Then("^Validate the contacted inserted successfully$")
	public void IscontactSucessfullMessageDisplayed() throws Throwable {
		String actual = KeywordUtil.getElementText(ContactsPage.toastmsg);
		Assert.assertEquals(actual, dataMap.get("contactsucessfull"));
	}

	@Then("^Validate the successfull message$")
	public void IntegrationSuccessfullmessage() throws Throwable {

		KeywordUtil.isWebElementVisible(IntegrationPage.toastmsg, "validate the integration successfull message");

	}

	@Then("^Verify the contacts created successfully or not$")
	public void verify_the_contacts_created_successfully_or_not() throws Throwable {
		Thread.sleep(5000);
		boolean flag = KeywordUtil.isElementVisibleFromListOfElements(ContactsPage.contactslist, enteredContact, "Validated the contacts list successfully");
		Assert.assertTrue(flag);
	}

	// =====================Integration==================

	@When("^Click on integration from Dashboard menu for integration$")
	public void click_on_intergration_from_Dashboard_menu_for_integration() throws Throwable {
		KeywordUtil.clickElementFromList(IntegrationPage.dashboardlinks, dataMap.get("integrationlink"),
				"Click on Integrations link");

	}

	@When("^User click on Integrations app as Twilio$")
	public void user_click_on_Integrations_app_as_Twilio() throws Throwable {
		Thread.sleep(2000);
		String value = KeywordUtil.getElementText(IntegrationPage.twilioApp);
		System.out.println("value from Above code " + value);
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
		String actualvalue = KeywordUtil.getElementText(IntegrationPage.diabledbtn);
		KeywordUtil.getElementText(IntegrationPage.diabledbtn);
	}

}
