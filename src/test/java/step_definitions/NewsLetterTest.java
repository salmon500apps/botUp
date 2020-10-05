/*package step_definitions;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.NewslettersPage;
import Pages.LoginPage;
import Pages.MyAppsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

public class NewsLetterTest extends KeywordUtil {

	@SuppressWarnings("rawtypes")
	static Class thisClass = NewsLetterTest.class;
	static String testCaseID = thisClass.getSimpleName();

	public WebDriver driver;

	public static HashMap<String, String> dataMap = new HashMap<String, String>();
	String newsletter = "testing" + KeywordUtil.getCurrentDateTime();

	@Given("^Read the test data  \"([^\"]*)\" from Excel file$")
	public void read_the_test_data_from_Excel_file(String arg1) {
		try {
			dataMap = ExcelDataUtil.getTestDataWithTestCaseID("newsletter", arg1);

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
		String title = KeywordUtil.getElementText(LoginPage.loginlbl);
		System.out.println("Title of the Page " + title);
		Assert.assertEquals(title, dataMap.get("Title"));

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

	@Then("^User should see home text in Url$")
	public void user_should_see_home_text_in_Url() throws Throwable {
		if (driver.getCurrentUrl().contains("home")) {
			System.out.println("Login Success");
		} else {
			System.out.println("Login Fail");
		}
	}

	@When("^Click on MailSend option$")
	public void click_on_MailSend_option() throws Throwable {
		KeywordUtil.clickElementFromList(MyAppsPage.allappslink, dataMap.get("myapp"), "Click on Mail Send Link");
	}

	@When("^Click on NewsLetter from Dashboard menu$")
	public void click_on_NewsLetter_from_Dashboard_menu() throws Throwable {
		KeywordUtil.clickElementFromList(NewslettersPage.dashboardlinks, dataMap.get("dashboardlink"),
				"Click on News letter link");
	}

	@When("^Click on Add Newsletter button$")
	public void click_on_Add_Newsletter_button() throws Throwable {
		KeywordUtil.click(NewslettersPage.addnewsletterbtn, "click on Add news letter button");
	}

	@When("^Click on Add Cutom button$")
	public void click_on_Add_Cutom_button() throws Throwable {
		KeywordUtil.click(NewslettersPage.addcustombtn, "click on Add Custom button");
	}

	@When("^Enter Name of News Letter$")
	public void enter_Name_of_News_Letter() throws Throwable {

		KeywordUtil.inputText(NewslettersPage.nametxt, newsletter, "Enter the Name of news letter");
	}

	@When("^Subject of News letter$")
	public void subject_of_News_letter() throws Throwable {
		KeywordUtil.inputText(NewslettersPage.subjecttxt, dataMap.get("Subject"), "Enter the Subject of news letter");

	}

	@When("^Click on Submit button$")
	public void click_on_Submit_button() throws Throwable {
		// KeywordUtil.switchToFrame(NewslettersPage.htmlframe);
		// KeywordUtil.dragAndDrop();
		KeywordUtil.click(NewslettersPage.submitbtn, "click on Submit button");
	}

	@When("^Click on OK button$")
	public void click_on_OK_button() throws Throwable {
		KeywordUtil.click(NewslettersPage.okbtn, "click on Submit button");

	}

	@Then("^Verify the newsletter created successfully or not$")
	public void verify_the_newsletter_created_successfully_or_not() throws Throwable {

	}

	@When("^Enter Invalid Email Address and Password$")
	public void enter_Invalid_Email_Address_and_Password() throws Throwable {

		KeywordUtil.inputText(LoginPage.email, "test", "Enter Inavlid Email address");
		KeywordUtil.inputText(LoginPage.password, "test", "Enter invalid Password");
	}

	@Then("^Verify the login successfull$")
	public void verify_the_login_successfull() throws Throwable {

		String title = KeywordUtil.getElementText(NewslettersPage.welcome500apps);
		Assert.assertEquals(title, dataMap.get("welcomemessage"));
	}

}
*/