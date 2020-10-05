package step_definitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Pages.Botup_Integration;
import Pages.CallFlowPage;
import Pages.DashBoardPage;
import Pages.MyAppsPage;
import Pages.NumbersPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import utilities.GlobalUtil;
import utilities.KeywordUtil;
import Pages.IntegrationPage;
import Pages.MediaPage;

@SuppressWarnings("unused")
public class Botup_Functionality extends KeywordUtil {

	public List<List<String>> data;

	public String actualCallFlowName;
	String ranmdom = KeywordUtil.randomAlphaNumeric(4);

	// ==================Refresh(Background)========================
	@SuppressWarnings("deprecation")
	@Given("^User should refresh the page on every scenario completes$")
	public void user_should_refresh_the_page_on_every_scenario_completes() throws Throwable {
	    
	
	
		try {
			refersh();
			// getDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	
	}


	
//	private void refersh() {
//		// TODO Auto-generated method stub
//		
//	}
	
	public static void refersh() {
		getDriver().navigate().refresh();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	// ==================Login========================

	@Given("^User navigates to site$")
	public void user_navigates_to_site(DataTable url) throws Throwable {

		data = url.raw();
		navigateToUrl(data.get(0).get(0));

	}

	@When("^User enter with login details$")
	public void user_enter_with_login_details(DataTable loginData) throws Throwable {
		data = loginData.raw();
		inputText(Pages.LoginPage.email, data.get(0).get(0), Pages.LoginPage.emailnm + ": " + data.get(0).get(0));
		inputText(Pages.LoginPage.password, data.get(0).get(1), Pages.LoginPage.passwordnm + ": " + data.get(0).get(1));

	}

	@When("^User hit the login button$")
	public void user_hit_the_login_button() throws Throwable {

		click(Pages.LoginPage.loginbtn, Pages.LoginPage.loginbtnm);

	}

	@Then("^User Validate the dashboard and check welcome message displayed$")
	public void user_Validate_the_dashboard_and_check_welcome_message_displayed() throws Throwable {

		isWebElementVisible(DashBoardPage.welcome500appsheader, DashBoardPage.welcomeheadernm);
	}

	@When("^I Click on Botup app from Dashboard$")
	public void i_Click_on_Botup_app_from_Dashboard(DataTable applink) throws Throwable {
		data = applink.raw();
		clickElementFromList(MyAppsPage.allappslink, data.get(0).get(0), MyAppsPage.botuplinknm);

		clickElementFromList(Botup_Integration.dashboardlinksDash, data.get(0).get(1), DashBoardPage.Dashboardlinknm);
	}

	// ========================= Integration for Facebook=======================================

	@When("^User Click on Integration link from Dashboard$")
	public void user_Click_on_Integration_link_from_Dashboard(DataTable applink) throws Throwable {
		Thread.sleep(2000);
		KeywordUtil.clickElementFromList(Botup_Integration.dashboardlinks, "Integration", "Click on Intergration link");
		data = applink.raw();

		clickElementFromList(Botup_Integration.integrationlink, data.get(0).get(0), DashBoardPage.integrationlinknm);

	}

	@When("^User click on Integrations app as Facebook for Botup$")
	public void user_click_on_Integrations_app_as_Facebook_for_Botup(DataTable appname) throws Throwable {
		data = appname.raw();
		Thread.sleep(2000);
		String value = getElementText(Botup_Integration.facebookApp);
		System.out.println("value from Above code " + value);
		if (value.contains("Disable")) {
			clickInstallIntegrationsApp(Botup_Integration.facebookApp, "Click on Install button for Facebook app");
			Thread.sleep(4000);
			System.out.println("Before Clicking on Confirm button");
			clickElementUsingActions(Botup_Integration.confirmbtn, "Click on Confirm button");
		}
		Thread.sleep(2000);
		clickInstallIntegrationsApp(Botup_Integration.facebookApp, "Click on Install button for Facebook app");

	}

	@When("^I Enter the User ID for Facebook for Botup$")
	public void i_Enter_the_User_ID_for_Facebook_for_Botup(DataTable sid) throws Throwable {
		data = sid.raw();
		Thread.sleep(4000);
		System.out.println("================================Testing===============================================");
		System.out.println("===============================================================================");
		System.out.println("=================================Testing==============================================");
		String title = getDriver().getTitle();
		System.out.println("Title of the window - " + title);
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		System.out.println("===============================================================================");
		// switchToWindowTitle("Log in to Facebook | Facebook");
		inputText(Botup_Integration.UserIDfb, data.get(0).get(0), "Enter User ID for Facebook");

	}

	@When("^I Enter the Password for Facebook$")
	public void i_Enter_the_Password_for_Facebook(DataTable auth) throws Throwable {
		data = auth.raw();
		inputText(Botup_Integration.passwordfb, data.get(0).get(0), "Enter Password for Facebook");

	}

	@When("^I Click on Login button for Facebook$")
	public void i_Click_on_Login_button_for_Facebook() throws Throwable {
		click(Botup_Integration.FBLoginbtn, "Click on Facebook Login button");
		Thread.sleep(5000);
		escape();
		Thread.sleep(3500);

	}

	@Then("^Validate the successfull message for Facebook$")
	public void validate_the_successfull_message_for_Facebook(DataTable arg1) throws Throwable {
		// isWebElementVisible(Botup_Integration.toastmsg, "validate the integration
		// successfull message");
		// Thread.sleep(2500);
		click(Botup_Integration.fbcancel, "Click on Facebook Cancel button");

	}

	@Then("^User validate the disabled button for Facebook app for Botup$")
	public void user_validate_the_disabled_button_for_Facebook_app_for_Botup() throws Throwable {
		Thread.sleep(3500);

		String actualvalue = getElementText(Botup_Integration.diabledbtn);
		getElementText(Botup_Integration.diabledbtn);
	}
	
	
	
	// ========================= Integration for Twilio=======================================

		@When("^I Click on Integration link from Dashboard for Botup$")
		public void i_Click_on_Integration_link_from_Dashboard_for_Botup(DataTable applink) throws Throwable {
			Thread.sleep(1000);
			data = applink.raw();

			clickElementFromList(Botup_Integration.integrationlink, data.get(0).get(0), DashBoardPage.integrationlinknm);

		}

		@When("^User click on Integrations app as Twilio for Botup$")
		public void user_click_on_Integrations_app_as_Twilio_for_Botup(DataTable appname) throws Throwable {
			data = appname.raw();
			Thread.sleep(4000);
			String value = getElementText(Botup_Integration.twilioApp);
			System.out.println("value from Above code " + value);
			if (value.contains("Disable")) {
				clickInstallIntegrationsApp(Botup_Integration.twilioApp, "Click on Install button for Twillio app");
				Thread.sleep(4000);
				System.out.println("Before Clicking on Confirm button");
				clickElementUsingActions(Botup_Integration.confirmbtnin, "Click on Confirm button");
			}
			Thread.sleep(2000);
			clickInstallIntegrationsApp(Botup_Integration.twilioApp, "Click on Install button for Twillio app");

		}

		@When("^I Enter the Account Sid for Twillio for Botup$")
		public void i_Enter_the_Account_Sid_for_Twillio_for_Botup(DataTable sid) throws Throwable {
			data = sid.raw();

			inputText(Botup_Integration.accountsidtxt, data.get(0).get(0), "Enter Account SID number");

		}

		@When("^I Enter the Auth Token for Botup$")
		public void i_Enter_the_Auth_Token_for_Botup(DataTable auth) throws Throwable {
			data = auth.raw();
			inputText(Botup_Integration.auth_key, data.get(0).get(0), "Enter Auth Token Number");

		}

		@When("^I Click on Authentication button for Botup$")
		public void i_Click_on_Authentication_button_for_Botup() throws Throwable {
			click(Botup_Integration.authenticationbtn, "Click on Authentication button");

		}

		@Then("^Validate the successfull message for Botup$")
		public void validate_the_successfull_message_for_Botup(DataTable arg1) throws Throwable {
			isWebElementVisible(Botup_Integration.toastmsg, "validate the integration successfull message");

		}

		@Then("^User validate the disabled button for twillio app for Botup$")
		public void user_validate_the_disabled_button_for_twillio_app_for_Botup() throws Throwable {
			String actualvalue = getElementText(Botup_Integration.diabledbtn);
			getElementText(Botup_Integration.diabledbtnin);
		}



	// ===============================Bots====================================

	@When("^User Click on Bots link from Dashboard$")
	public void user_Click_on_Bots_link_from_Dashboard(DataTable applink) throws Throwable {
		Thread.sleep(2000);
		KeywordUtil.waitForVisible(Botup_Integration.dashboardlinkbots);
		KeywordUtil.clickElementFromList(Botup_Integration.dashboardlinkbots, "Bots", "Click on Bots link");
		data = applink.raw();

		clickElementFromList(Botup_Integration.dashboardlinkbots, data.get(0).get(0), DashBoardPage.botslinknm);
	}

	@Then("^click on Add Bot button$")
	public void click_on_Add_Bot_button() throws Throwable {
		clickElementUsingActions(Botup_Integration.addbotbtn, "click on Add Bot button");

	}

	@Then("^Select Flow Name for Bot$")
	public void select_Flow_Name_for_Bot() throws Throwable {
		click(Botup_Integration.flownameDrp, "Click on Flow Name Drop Down");
		MoveToclickElementByTextFromList(Botup_Integration.flowDrpValue, "Lead Generation Template",
				"Select Flow Name");

	}

	@Then("^Enter Name for Bot$")
	public void enter_Name_for_Bot() throws Throwable {
		Thread.sleep(1500);
		inputText(Botup_Integration.botnametxt, "Test Bot", "Enter Name for Bot");

	}

	@Then("^Select Category for Bot$")
	public void select_Category_for_Bot() throws Throwable {
		Thread.sleep(1500);
		click(Botup_Integration.categorydrp, "Click on the Category");
		MoveToclickElementByTextFromList(Botup_Integration.Categoryname, "twilio", "Select twilio");

	}

	@Then("^Select for Associlated with for Bot$")
	public void select_for_Associlated_with_for_Bot() throws Throwable {
		mouseClickByLocator(Botup_Integration.associateddrp, 3);
		// click(Botup_Integration.associateddrp, "Click on the Associated");
		MoveToclickElementByTextFromList(Botup_Integration.associatename, "+12184525648", "Select Twilio number");

	}

	@Then("^click on Save button for Bot$")
	public void click_on_Save_button_for_Bot() throws Throwable {
		click(Botup_Integration.savebtn, "click on Save button for Bots");

	}

	@Then("^User Validate the toster message for bots$")
	public void user_Validate_the_toster_message_for_bots() throws Throwable {
		isWebElementVisible(Botup_Integration.toastmsg, "validate the Bots Status successfull message");

	}

	@When("^User select the already created Bots and click on Elipsis button For Edit$")
	public void user_select_the_already_created_Bots_and_click_on_Elipsis_button_For_Edit() throws Throwable {

		Thread.sleep(2000);
		ClickOnFirstElement(Botup_Integration.botsellipsebtn, "click on Ellipse Button");

	}

	@When("^Click on Edit button for Bots$")
	public void click_on_Edit_button_for_Bots() throws Throwable {
		Thread.sleep(2000);
		click(Botup_Integration.botseditbtn, "click on Edit Button");
		Thread.sleep(1000);

	}

	@When("^I select another Bots and hit the save button$")
	public void i_select_another_Bots_and_hit_the_save_button() throws Throwable {
		Thread.sleep(2000);
		click(Botup_Integration.flownameDrpedit, "Click on Flow Name Drop Down");
		MoveToclickElementByTextFromList(Botup_Integration.flowDrpValue, "Business Information Template",
				"Select Another Flow Name");
		Thread.sleep(1500);
		inputText(Botup_Integration.botnametxt, "Test Another Bot", "Enter Another Name for Bot");
		Thread.sleep(1500);
		click(Botup_Integration.categorydrp, "Click on the Category");
		MoveToclickElementByTextFromList(Botup_Integration.Categoryname, "twilio", "Select Twilio");
		mouseClickByLocator(Botup_Integration.associateddrp, 3);
		// click(Botup_Integration.associateddrp, "Click on the Associated");
		MoveToclickElementByTextFromList(Botup_Integration.associatename, "+12184525648", "Select Number");

		Thread.sleep(2000);
		click(Botup_Integration.savebtn, "click on Save button for Bots Update");
	}

	@Then("^I Validate the toast message for Bots edit$")
	public void i_Validate_the_toast_message_for_Bots_edit() throws Throwable {
		isWebElementVisible(Botup_Integration.toastmsg, "validate the Bots Status successfull message");

	}

	@When("^User select the already created Bots and click on Elipsis button For InActive Status$")
	public void user_select_the_already_created_Bots_and_click_on_Elipsis_button_For_InActive_Status()
			throws Throwable {

		Thread.sleep(2000);
		ClickOnFirstElement(Botup_Integration.botsellipsebtn, "click on Ellipse Button");

	}

	@When("^Click on Active button for Bots for Inactive$")
	public void click_on_Active_button_for_Bots_for_Inactive() throws Throwable {
		Thread.sleep(2000);
		click(Botup_Integration.activebtn, "click on Active Button");

	}

	@When("^I select IsActive as Inactive Bots and hit the Update button$")
	public void i_select_IsActive_as_Inactive_Bots_and_hit_the_Update_button() throws Throwable {
		Thread.sleep(2000);
		click(Botup_Integration.IsSelect, "click on IsSelect Button");
		Thread.sleep(2000);
		click(Botup_Integration.Updatebtn, "click on Update Button");

	}

	@Then("^I Validate the toast message for Bots InActive$")
	public void i_Validate_the_toast_message_for_Bots_InActive() throws Throwable {
		isWebElementVisible(Botup_Integration.toastmsg, "validate the Bots Status successfull message");
	}

	@When("^User select the already created Bots and click on Elipsis button For Is Active status$")
	public void user_select_the_already_created_Bots_and_click_on_Elipsis_button_For_Is_Active_status()
			throws Throwable {
		Thread.sleep(2000);
		ClickOnFirstElement(Botup_Integration.botsellipsebtn, "click on Ellipse Button");

	}

	@When("^Click on Active button for Bots$")
	public void click_on_Active_button_for_Bots() throws Throwable {
		Thread.sleep(2000);
		click(Botup_Integration.activebtn, "click on Active Button");

	}

	@When("^I select IsActive Bots and hit the Update button$")
	public void i_select_IsActive_Bots_and_hit_the_Update_button() throws Throwable {
		Thread.sleep(2000);
		click(Botup_Integration.IsSelect, "click on IsSelect Button");
		Thread.sleep(2000);
		click(Botup_Integration.Updatebtn, "click on Update Button");

	}

	@Then("^I Validate the toast message for Bots IsActive$")
	public void i_Validate_the_toast_message_for_Bots_IsActive() throws Throwable {
		isWebElementVisible(Botup_Integration.toastmsg, "validate the Bots Status successfull message");

	}

	@When("^User select the already created Bots and click on Elipsis button For Delete$")
	public void user_select_the_already_created_Bots_and_click_on_Elipsis_button_For_Delete() throws Throwable {

		Thread.sleep(2000);
		ClickOnFirstElement(Botup_Integration.botsellipsebtn, "click on Ellipse Button");
	}

	@When("^Click on Delete button for Bots$")
	public void click_on_Delete_button_for_Bots() throws Throwable {
		Thread.sleep(2000);
		click(Botup_Integration.botdeletebtn, "click on Delete Button");
		Thread.sleep(1500);
		click(Botup_Integration.botcnfmdeletebtn, "click on confirm Delete Button");

	}

	@Then("^I Validate the toast message for Bots Delete$")
	public void i_Validate_the_toast_message_for_Bots_Delete() throws Throwable {
		isWebElementVisible(Botup_Integration.toastmsg, "validate the Bots Status successfull message");

	}

	// ==================== Documents Functionality===================================

	@When("^User Click on Document in Dashboard link$")
	public void user_Click_on_Document_in_Dashboard_link() throws Throwable {

		Thread.sleep(2000);
		KeywordUtil.waitForVisible(Botup_Integration.documentlinks);
		clickElementFromList(Botup_Integration.documentlinks, "Documents", "Click on Documents");

	}

	@Then("^clicks on Add Document in Documents$")
	public void clicks_on_Add_Document_in_Documents() throws Throwable {
		clickElementUsingActions(Botup_Integration.adddocumentbtn, "click on Add Document button");

	}

	@Then("^enter the name of the Document$")
	public void enter_the_name_of_the_Document() throws Throwable {
		inputText(Botup_Integration.documentname, "Test Document", "Enter Document Name");

	}

	@Then("^select Document from Browser Desktop$")
	public void select_Document_from_Browser_Desktop() throws Throwable {

		JSClick(Botup_Integration.uploadfile, "Click on Browser button");
		Thread.sleep(1000);
		uploadFile("C:\\upload\\export_file.csv");
		// uploadFilesUsingSendKeys(MediaPage.uploadfile,
		// "C:\\Users\\samue\\Downloads\\export_file (6)", "Select the Mediafile");

	}

	@Then("^click on Save Button Document$")
	public void click_on_Save_Button_Document() throws Throwable {
		click(Botup_Integration.documentsavebtn, "click on Save button for Document");

	}

	@Then("^captures the toster message of Document$")
	public void captures_the_toster_message_of_Document() throws Throwable {

		isWebElementVisible(Botup_Integration.toastmsg, "validate the Document Added successfull message");

	}

	@When("^User select the already created Document and click on Elipsis button For Delete$")
	public void user_select_the_already_created_Document_and_click_on_Elipsis_button_For_Delete() throws Throwable {

		Thread.sleep(2000);
		ClickOnFirstElement(Botup_Integration.docellipsebtn, "click on Ellipse Button");

	}

	@When("^Click on Delete button for Document$")
	public void click_on_Delete_button_for_Document() throws Throwable {

		click(Botup_Integration.docdeletebtn, "click on Delete Button");
		Thread.sleep(1000);
		click(Botup_Integration.docdeletecnfm, "click on Confirm Button");

	}

	@Then("^captures the Delete toster message of Document$")
	public void captures_the_Delete_toster_message_of_Document() throws Throwable {
		Thread.sleep(1000);

		isWebElementVisible(Botup_Integration.toastmsg, "validate the Document Added successfull message");
	}

	// ====================Flow Functionality===================================
	@When("^User Click on Flows in Dashboard link$")
	public void user_Click_on_Flows_in_Dashboard_link() throws Throwable {

		Thread.sleep(2000);
		KeywordUtil.waitForVisible(Botup_Integration.flowlinks);
		clickElementFromList(Botup_Integration.flowlinks, "Flows", "Click on Flows");

	}

	@Then("^User Click on Add Flow$")
	public void user_Click_on_Add_Flow() throws Throwable {
		Thread.sleep(1000);

		clickElementUsingActions(Botup_Integration.addflow, "click on Add Add Flow button");

	}

	@Then("^User Select Default Template$")
	public void user_Select_Default_Template() throws Throwable {
		clickElementUsingActions(Botup_Integration.defaultflow, "click on Default Flow button");

	}

	@Then("^User Clicks on Save Flow button$")
	public void user_Clicks_on_Save_Flow_button() throws Throwable {
		Thread.sleep(2500);
		click(Botup_Integration.flowsavebtn, "click on Save button for Flow");

	}

	@Then("^captures the toster message of Flow$")
	public void captures_the_toster_message_of_Flow() throws Throwable {

		isWebElementVisible(Botup_Integration.toastmsg, "validate the Document Added successfull message");

	}

	@When("^User select the already created Flow and click on Elipsis button For Edit$")
	public void user_select_the_already_created_Flow_and_click_on_Elipsis_button_For_Edit() throws Throwable {

		Thread.sleep(2000);
		ClickOnFirstElement(Botup_Integration.flowellipsebtn, "click on Ellipse Button");

	}

	@When("^Click on Edit button for Flow$")
	public void click_on_Edit_button_for_Flow() throws Throwable {
		Thread.sleep(1000);
		click(Botup_Integration.botseditbtn, "click on Edit Button");
		Thread.sleep(3500);
		
		
		

	}

	@When("^I select another Flow and hit the save button$")
	public void i_select_another_Flow_and_hit_the_save_button(DataTable Message) throws Throwable {

		data = Message.raw();
		inputText(Botup_Integration.flowname, " Edit Test Flow", "Enter Flow Name");

		Thread.sleep(1000);

		switchToFrame(0);
		click(Botup_Integration.messagemenu, "Click on Message Menu");
		inputText(Botup_Integration.textmessage, data.get(0).get(0) + ranmdom, "Enter Text Message");
		Thread.sleep(1000);
		tab();
		PressButton();
		Thread.sleep(500);
		
/*		List<WebElement> message = getDriver()
				.findElements(By.xpath("//*[@class='nodedisplaynamestyle nodeLabelbg']"));
		List<WebElement> source6 = getDriver().findElements(Botup_Integration.redirecturlstart);
		List<WebElement> dest6 = getDriver().findElements(Botup_Integration.startbuttoncursormessage);

		moveToElementByOffSet6(message.get(5));
		Thread.sleep(2500);
		DragAndDrop(source6.get(2), dest6.get(6));
		Thread.sleep(2500);
		*/
		
		getDriver().switchTo().defaultContent();
		Thread.sleep(1000);
		KeywordUtil.click(Botup_Integration.updatebtnflow, "click on Update button for Flow");
		Thread.sleep(2000);

	}
	

	@Then("^I Validate the toast message for Flow edit$")
	public void i_Validate_the_toast_message_for_Flow_edit() throws Throwable {
		isWebElementVisible(Botup_Integration.toastmsg, "validate the Flow Status successfull message");

	}

	@When("^User select the already created Flow and click on Elipsis button For Delete$")
	public void user_select_the_already_created_Flow_and_click_on_Elipsis_button_For_Delete() throws Throwable {

		Thread.sleep(2000);
		ClickOnFirstElement(Botup_Integration.botsellipsebtn, "click on Ellipse Button");
	}

	@When("^Click on Delete button for Flow$")
	public void click_on_Delete_button_for_Flow() throws Throwable {
		Thread.sleep(2000);
		click(Botup_Integration.botdeletebtn, "click on Delete Button");
		Thread.sleep(1500);
		click(Botup_Integration.botcnfmdeletebtn, "click on confirm Delete Button");

	}

	@Then("^I Validate the toast message for Flow Delete$")
	public void i_Validate_the_toast_message_for_Flow_Delete() throws Throwable {
		isWebElementVisible(Botup_Integration.toastmsg, "validate the Bots Status successfull message");

	}

	// ================= Contacts Functionality===========================

	@When("^User Click on Contacts in Dashboard link$")
	public void user_Click_on_Contacts_in_Dashboard_link() throws Throwable {

		Thread.sleep(2000);
		KeywordUtil.waitForVisible(Botup_Integration.contactlinks);
		clickElementFromList(Botup_Integration.contactlinks, "Contacts", "Click on Contacts");

	}

}
