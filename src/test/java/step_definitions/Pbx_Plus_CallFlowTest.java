package step_definitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Pages.CallFlowPage;
import Pages.DashBoardPage;
import Pages.IntegrationPage;
import Pages.NumbersPage;
import Pages.VoicemailsPage;
import Pages.MediaPage;

import Pages.MyAppsPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

@SuppressWarnings("unused")
public class Pbx_Plus_CallFlowTest extends KeywordUtil {

	public List<List<String>> data;

	public String actualCallFlowName;
	String ranmdom = KeywordUtil.randomAlphaNumeric(4);
	
	
	// ==================Refresh(Background)========================
//	@SuppressWarnings("deprecation")
	@Given("^User should refresh the page on every scenario completes for Pbx module$")
	public void user_should_refresh_the_page_on_every_scenario_completes_for_Pbx_module() throws Throwable {
	    
	
	
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

	// ========================= Login=======================================

	@Given("^User is navigates to site$")
	public void user_is_navigates_to_site(DataTable url) throws Throwable {

		data = url.raw();
		navigateToUrl(data.get(0).get(0));

	}

	@When("^User enter login details$")
	public void user_enter_login_details(DataTable loginData) throws Throwable {
		data = loginData.raw();
		inputText(Pages.LoginPage.email, data.get(0).get(0), Pages.LoginPage.emailnm + ": " + data.get(0).get(0));
		inputText(Pages.LoginPage.password, data.get(0).get(1), Pages.LoginPage.passwordnm + ": " + data.get(0).get(1));

	}

	@When("^I hit the login button$")
	public void i_hit_the_login_button() throws Throwable {

		click(Pages.LoginPage.loginbtn, Pages.LoginPage.loginbtnm);

	}

	@Then("^Validate the dashboard and check welcome message displayed$")
	public void validate_the_dashboard_and_check_welcome_message_displayed() throws Throwable {

		isWebElementVisible(DashBoardPage.welcome500appsheader, DashBoardPage.welcomeheadernm);
	}

	@When("^I Click on PBX plus app from Dash board$")
	public void i_Click_on_PBX_plus_app_from_Dash_board(DataTable applink) throws Throwable {
		data = applink.raw();
		clickElementFromList(MyAppsPage.allappslink, data.get(0).get(0), MyAppsPage.pbxpluslinknm);

		clickElementFromList(CallFlowPage.dashboardlinks, data.get(0).get(1), DashBoardPage.callflowslinknm);
	}

	@When("^I Click on Add Call flow button$")
	public void i_Click_on_Add_Call_flow_button() throws Throwable {
		
		
		Thread.sleep(2000);
		KeywordUtil.clickElementFromList(CallFlowPage.dashboardlinks, "Call Flows", "Click on Call Flow link");

		clickElementUsingActions(CallFlowPage.addcallflowbtn, "click on Add Call Flow button");
//		
//		Thread.sleep(2000);
//		KeywordUtil.clickElementFromList(CallFlowPage.dashboardlinks, "Call Flows", "Click on Call Flow link");
		

	}

	@When("^User enter Call Flow Details$")
	public void user_enter_Call_Flow_Details(DataTable details) throws Throwable {
		data = details.raw();
		inputText(CallFlowPage.callflownametxt, data.get(0).get(0) + ranmdom, "Enter Call FLow Name");
		actualCallFlowName = KeywordUtil.getElementText(CallFlowPage.callflownametxt, "Get Call Flow Name");
		inputText(CallFlowPage.callflowdescription, data.get(0).get(1) + ranmdom, "Enter Call FLow Description");

	}

	@Then("^I Create a CallFlow for Text Speech$")
	public void i_Create_a_CallFlow_for_Text_Speech(DataTable textspeech) throws Throwable {
		data = textspeech.raw();
		switchToFrame(0);
		click(CallFlowPage.texttospeech, "Click on Text To Speech");
		inputText(CallFlowPage.texttoconvertvoice, data.get(0).get(0) + ranmdom, "Enter Text to Convert into Voice");
		Thread.sleep(2000);
		click(CallFlowPage.ttssavebtn, "click on Save button");
		Thread.sleep(2000);
		KeywordUtil.ReleaseFromIFrame();
		switchToFrame(0);
		List<WebElement> li = getDriver().findElements(CallFlowPage.startbuttoncursorDrag);
		DragAndDrop(li.get(0), li.get(1));
		Thread.sleep(2500);
	}

	@When("^I Create a CallFlow for Play Audio$")
	public void i_Create_a_CallFlow_for_Play_Audio(DataTable audio) throws Throwable {
		data = audio.raw();
		click(CallFlowPage.playaudio, "Click on Play Audio");
		selectByVisibleText(CallFlowPage.selectrecorder, data.get(0).get(0), "Select the Media");
		Thread.sleep(1500);
		click(CallFlowPage.pasavebtn, "click on Save button");
		List<WebElement> playaudio = getDriver()
				.findElements(By.xpath("//*[@class='nodedisplaynamestyle nodeLabelbg']"));
		List<WebElement> source = getDriver().findElements(CallFlowPage.playaudiostart);
		List<WebElement> dest = getDriver().findElements(CallFlowPage.startbuttoncursorDrag);

		moveToElementByOffSet(playaudio.get(1));
		Thread.sleep(2000);

		DragAndDrop(source.get(0), dest.get(2));

	}

	@When("^I Create a Call Flow for Business Hours$")
	public void i_Create_a_Call_Flow_for_Business_Hours(DataTable time) throws Throwable {
		data = time.raw();
		Thread.sleep(4500);
		click(CallFlowPage.businesshours, "Click on Business Hours");
		inputText(CallFlowPage.fromtime, data.get(0).get(0), "Enter Text to From Time");
		inputText(CallFlowPage.totime, data.get(0).get(1), "Enter Text to To Time");
		click(CallFlowPage.businesssavebtn, "click on Save button");
		Thread.sleep(2500);
		List<WebElement> businesshours = getDriver()
				.findElements(By.xpath("//*[@class='nodedisplaynamestyle nodeLabelbg']"));
		List<WebElement> source1 = getDriver().findElements(CallFlowPage.businesshoursstart);
		List<WebElement> dest1 = getDriver().findElements(CallFlowPage.startbuttoncursorDrag1);

		moveToElementByOffSet1(businesshours.get(2));
		Thread.sleep(2000);
		DragAndDrop(source1.get(1), dest1.get(3));
		Thread.sleep(3000);

	}

	@When("^I Create a Call Flow for Voice Mail$")
	public void i_Create_a_Call_Flow_for_Voice_Mail(DataTable voice) throws Throwable {
		data = voice.raw();
		click(CallFlowPage.voicemail, "Click on Voicemail");
		selectByVisibleText(CallFlowPage.voicerecorder, data.get(0).get(0), "Select the Media");
		Thread.sleep(1500);
		inputText(CallFlowPage.messagevoice, data.get(0).get(1), "Enter Message TO Voice");
		click(CallFlowPage.savevoice, "click on Save button for Voicemail");
		List<WebElement> voicemail = getDriver()
				.findElements(By.xpath("//*[@class='nodedisplaynamestyle nodeLabelbg']"));
		List<WebElement> source2 = getDriver().findElements(CallFlowPage.voicemailstart);
		List<WebElement> dest2 = getDriver().findElements(CallFlowPage.startbuttoncursorDrag2);

		moveToElementByOffSet2(voicemail.get(0));
		Thread.sleep(2500);
		DragAndDrop(source2.get(0), dest2.get(4));
		Thread.sleep(5000);

	}

	@Then("^I Create a Call Flow For Menu$")
	public void i_Create_a_Call_Flow_For_Menu(DataTable arg1) throws Throwable {
		data = arg1.raw();
		click(CallFlowPage.menu, "click on Menu");
		selectByVisibleText(CallFlowPage.selectaudio, data.get(0).get(0), "Select the Media");
		inputText(CallFlowPage.greetingsmsg, data.get(0).get(1), "Enter Greetings");

		Thread.sleep(2500);
	}

	@When("^I Click on Add Button and Enter the setting details$")
	public void i_Click_on_Add_Button_and_Enter_the_setting_details(DataTable details) throws Throwable {

		for (Map<String, String> menu : details.asMaps(String.class, String.class)) {
			Thread.sleep(1500);
			click(CallFlowPage.addmenubtn, "click on Add Menu button");
			Thread.sleep(1000);
			tab();
			sendData(menu.get("input"));
			// inputText(CallFlowPage.inputmenu, menu.get("input"), "Enter Input " +
			// menu.get("input"));
			Thread.sleep(1000);
			tab();
			sendData(menu.get("name"));
			// inputText(CallFlowPage.namemenu, menu.get("name"), "Enter name " +
			// menu.get("name"));
			Thread.sleep(1000);
			tab();
			PressButton();
			// click(CallFlowPage.addsave, "click on Add Menu button");

		}

	}

	@Then("^User Press the save button$")
	public void user_Press_the_save_button() throws Throwable {
		Thread.sleep(2000);
		click(CallFlowPage.savemenu, "click on Save Menu button");
		Thread.sleep(3000);
		List<WebElement> menu = getDriver().findElements(By.xpath("//*[@class='nodedisplaynamestyle nodeLabelbg']"));
		List<WebElement> source3 = getDriver().findElements(CallFlowPage.menustart);
		List<WebElement> dest3 = getDriver().findElements(CallFlowPage.startbuttoncursorDrag3);

		moveToElementByOffSet3(menu.get(0));
		Thread.sleep(2000);
		DragAndDrop(source3.get(2), dest3.get(5));
		Thread.sleep(3000);
	}

	@When("^I Create a Call flow for Forward Call$")
	public void i_Create_a_Call_flow_for_Forward_Call(DataTable forwardCall) throws Throwable {
		data = forwardCall.raw();
		Thread.sleep(2000);
		click(CallFlowPage.frwardcall, "click on Forward Call");
		inputText(CallFlowPage.frwardnumber, data.get(0).get(0), "Enter Forward Number");
		click(CallFlowPage.recordingon, "click on Recording");
		Thread.sleep(2500);
		tab();
		PressButton();
		Thread.sleep(1000);
		Thread.sleep(3000);
		List<WebElement> forwardcall = getDriver()
				.findElements(By.xpath("//*[@class='nodedisplaynamestyle nodeLabelbg']"));
		List<WebElement> source4 = getDriver().findElements(CallFlowPage.menustart);
		List<WebElement> dest4 = getDriver().findElements(CallFlowPage.startbuttoncursorDrag3);

		moveToElementByOffSet4(forwardcall.get(5));
		Thread.sleep(2000);
		DragAndDrop(source4.get(4), dest4.get(6));
	}

	@When("^I Hit the Save button for entire call flow and valida the successful toast message$")
	public void i_Hit_the_Save_button_for_entire_call_flow_and_valida_the_successful_toast_message(DataTable message)
			throws Throwable {
		data = message.raw();
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		KeywordUtil.click(CallFlowPage.updatebtn, "click on Update button for Call Flow");
		Thread.sleep(2000);
		String actual = KeywordUtil.getElementText(CallFlowPage.toastmsg);
		Assert.assertEquals(actual, data.get(0).get(0));
		Thread.sleep(2000);

		/* Validate the call flow record inserted successfully or nor */
		String expectedCallFlowname = KeywordUtil.getCallFlowName(actualCallFlowName, "get Call Flow name :");
		Assert.assertEquals(actualCallFlowName, expectedCallFlowname);

	}

	/*
	 * Call Flow Edit Functionality
	 */

	@When("^User select the already created callflow and click on Elipsis button$")
	public void user_select_the_already_created_callflow_and_click_on_Elipsis_button() throws Throwable {
		Thread.sleep(2000);
		KeywordUtil.clickElementFromList(CallFlowPage.dashboardlinks, "Call Flows", "Click on Call Flow link");
		Thread.sleep(2000);
		ClickOnFirstElement(CallFlowPage.ellipsebtn, "click on Ellipse Button");

	}

	@When("^Click on Edit button$")
	public void click_on_Edit_button() throws Throwable {
		Thread.sleep(2000);
		click(CallFlowPage.editbtn, "click on Edit Button");
		Thread.sleep(1000);
	}

	@When("^I Click on Find me and Fill the required fields and hit the submit button$")
	public void i_Click_on_Find_me_and_Fill_the_required_fields_and_hit_the_submit_button() throws Throwable {
		KeywordUtil.switchToFrame(0);
		KeywordUtil.click(CallFlowPage.findme, "click on Find Me");
		KeywordUtil.click(CallFlowPage.addfindmebtn, "click on Add Findme button");
		KeywordUtil.inputText(CallFlowPage.inputfindme, "9879879870", "Enter FindMe Number");
		Thread.sleep(2000);
		KeywordUtil.tab();
		KeywordUtil.PressButton();
		Thread.sleep(1500);

		KeywordUtil.click(CallFlowPage.recordingonfindme, "click on Recording");
		Thread.sleep(1500);
		KeywordUtil.tab();
		KeywordUtil.PressButton();
		Thread.sleep(1500);
		// KeywordUtil.switchToFrame(0);
		// List<WebElement> findme =
		// getDriver().findElements(By.xpath("//*[@class='nodedisplaynamestyle
		// nodeLabelbg']"));
		// List<WebElement> source5 =
		// getDriver().findElements(CallFlowPage.findmestart);
		// List<WebElement> dest5 =
		// getDriver().findElements(CallFlowPage.startbuttoncursorDrag5);
		// Thread.sleep(1000);
		// ScrollUp();
		// Thread.sleep(3000);
		// moveToElementByOffSet5(findme.get(6));
		// Thread.sleep(2000);
		// DragAndDrop(source5.get(1), dest5.get(7));
		// Thread.sleep(2000);
		getDriver().switchTo().defaultContent();
		Thread.sleep(1500);
		KeywordUtil.click(CallFlowPage.updatebtn, "click on Update button for Edit Call Flow");
		Thread.sleep(2500);

	}

	@Then("^I Validate the toast message$")
	public void i_Validate_the_toast_message(DataTable arg1) throws Throwable {
		isWebElementVisible(CallFlowPage.toastmsg, "validate the Edit Updated successfull message");

	}

	/*
	 * Call Flow Delete Functionality
	 */

	@When("^Clicks on Delete button for callflow$")
	public void clicks_on_Delete_button() throws Throwable {
		Thread.sleep(2000);
		KeywordUtil.clickElementFromList(CallFlowPage.dashboardlinks, "Call Flows", "Click on Call Flow link");
		Thread.sleep(2000);
		ClickOnFirstElement(CallFlowPage.ellipsebtn, "click on Ellipse Button");
		Thread.sleep(1000);
		click(CallFlowPage.deletebtn, "click on Delete Button");

	}

	@Then("^User clicks on Delete at are you sure pop-up dialog$")
	public void user_clicks_on_Delete_at_are_you_sure_pop_up_dialog() throws Throwable {
		click(CallFlowPage.deleteconfirm, "click on Delete confirm Button");

	}

	@Then("^validate call flow delete toster message$")
	public void user_validates_the_delete_toster_message(DataTable arg1) throws Throwable {
		data = arg1.raw();
		Thread.sleep(2000);
		String actual = KeywordUtil.getElementText(CallFlowPage.toastmsg);
		Assert.assertEquals(actual, data.get(0).get(0));
		Thread.sleep(1000);
		isWebElementVisible(CallFlowPage.toastmsg, "validate the Deleted Call Flow successfull message");

	}

	// ========================= Integration=======================================

	@When("^I Click on Integration link from Dashboard$")
	public void i_Click_on_Integration_link_from_Dashboard(DataTable applink) throws Throwable {
		Thread.sleep(2000);
		KeywordUtil.clickElementFromList(CallFlowPage.dashboardlinks, "Call Flows", "Click on Call Flow link");
		data = applink.raw();

		clickElementFromList(CallFlowPage.integrationlink, data.get(0).get(0), DashBoardPage.integrationlinknm);

	}

	@When("^User click on Integrations app as Twilio for pbx$")
	public void user_click_on_Integrations_app_as_Twilio_for_pbx(DataTable appname) throws Throwable {
		data = appname.raw();
		Thread.sleep(2000);
		String value = getElementText(IntegrationPage.twilioApp);
		System.out.println("value from Above code " + value);
		if (value.contains("Disable")) {
			clickInstallIntegrationsApp(IntegrationPage.twilioApp, "Click on Install button for Twillio app");
			Thread.sleep(4000);
			System.out.println("Before Clicking on Confirm button");
			clickElementUsingActions(IntegrationPage.confirmbtn, "Click on Confirm button");
		}
		Thread.sleep(2000);
		clickInstallIntegrationsApp(IntegrationPage.twilioApp, "Click on Install button for Twillio app");

	}
	
	@When("^I Enter the Account Sid for Twillio for pbx$")
	public void i_Enter_the_Account_Sid_for_Twillio_for_pbx(DataTable sid) throws Throwable {
		data = sid.raw();

		inputText(IntegrationPage.accountsidtxt, data.get(0).get(0), "Enter Account SID number");

	}

	@When("^I Enter the Auth Token for pbx$")
	public void i_Enter_the_Auth_Token_for_pbx(DataTable auth) throws Throwable {
		data = auth.raw();
		inputText(IntegrationPage.auth_key, data.get(0).get(0), "Enter Auth Token Number");

	}

	@When("^I Click on Authentication button for pbx$")
	public void i_Click_on_Authentication_button_for_pbx() throws Throwable {
		click(IntegrationPage.authenticationbtn, "Click on Authentication button");

	}

	@Then("^Validate the successfull message for pbx$")
	public void validate_the_successfull_message_for_pbx(DataTable arg1) throws Throwable {
		isWebElementVisible(IntegrationPage.toastmsg, "validate the integration successfull message");

	}

	@Then("^User validate the disabled button for twillio app for pbx$")
	public void user_validate_the_disabled_button_for_twillio_app_for_pbx() throws Throwable {
		String actualvalue = getElementText(IntegrationPage.diabledbtn);
		getElementText(IntegrationPage.diabledbtn);
	}

	// ================ Inactive/Active & Views ==================

	@When("^Click on Call Flow for Inacitve and Active$")
	public void click_on_Call_Flow_for_Inacitve_and_Active() throws Throwable {
		Thread.sleep(2000);
		clickElementFromList(CallFlowPage.dashboardlinks, "Call Flows", "Click on Call Flow link");

	}

	@When("^Click on Call Flow for Card View$")
	public void click_on_Call_Flow_for_Card_View() throws Throwable {
		Thread.sleep(1000);
		click(CallFlowPage.gridview, "click on Grid View Button");

	}

	@When("^Click on List View$")
	public void click_on_List_View() throws Throwable {
		Thread.sleep(1000);
		click(CallFlowPage.listview, "click on List View Button");

	}

	@When("^Click on Inactive button$")
	public void click_on_Inactive_button() throws Throwable {
		Thread.sleep(3500);
		JSClick(CallFlowPage.inactivebtn, "click on Inactive Button");
		// mouseClickByLocator(CallFlowPage.inactivebtn, 0);

		// ClickOnFirstElement(CallFlowPage.inactivebtn, "click on Inactive Button");
		Thread.sleep(1000);

	}

	@Then("^User Capture the Sucessfull message of Inactive$")
	public void user_Capture_the_Sucessfull_message_of_Inactive() throws Throwable {
		isWebElementVisible(CallFlowPage.toastmsg, "validate the Inactive Status successfull message");
		Thread.sleep(3000);
	}

	@Then("^Click on Active button$")
	public void click_on_Active_button() throws Throwable {
		JSClick(CallFlowPage.inactivebtn, "click on Active Button");
		// ClickOnFirstElement(CallFlowPage.inactivebtn, "click on Active Button");
		Thread.sleep(1000);

	}

	@Then("^Capture the Sucessfull message of Inactive$")
	public void capture_the_Sucessfull_message_of_Inactive() throws Throwable {
		isWebElementVisible(CallFlowPage.toastmsg, "validate the Acctive Status successfull message");

	}

	// ======================== Numbers Functionality====================================

	@When("^User Click on Numbers in Dashboard link$")
	public void user_Click_on_Numbers_in_Dashboard_link() throws Throwable {
		Thread.sleep(2000);
		clickElementFromList(NumbersPage.numberslinks, "Numbers", "Click on Numbers");

	}

	@Then("^clicks on Add Number in numbers$")
	public void clicks_on_Add_Number_in_numbers() throws Throwable {
		clickElementUsingActions(NumbersPage.addnumberbtn, "click on Add Numbers button");
	}

	@Then("^selects provider$")
	public void selects_provider() throws Throwable {

		click(NumbersPage.providerDrp, "Click on Provider Drop Down");
		MoveToclickElementByTextFromList(NumbersPage.numbersDrpValue, "twilio", "Select Provider");
	}

	@Then("^Selects number from phone numbers$")
	public void selects_number_from_phone_numbers() throws Throwable {

		click(NumbersPage.phoneNumDrp, "Click on Phone Drop Down");
		MoveToclickElementByTextFromList(NumbersPage.numbersDrpValuemobile, "+19285827423", "Select Phone Number");
	}

	@Then("^Selects Call Flow ID$")
	public void selects_Call_Flow_ID() throws Throwable {

		click(NumbersPage.callFlowIDDrp, "Click on Call Flow iD Drop Down");
		MoveToclickElementByTextFromList(NumbersPage.numbersDrpValue, "PBXCallFlowEOH4", "Select Call Flow ID");

	}

	@Then("^clicks on Save Button$")
	public void clicks_on_Save_Button() throws Throwable {
		click(NumbersPage.savebtn, "click on Save button for Numbers");

	}

	@Then("^captures the toster message of numbers$")
	public void captures_the_toster_message_of_numbers() throws Throwable {
		isWebElementVisible(NumbersPage.toastmsg, "validate the Numbers Status successfull message");

	}

	// =============================Edit numbers=============================================

	@When("^User select the already created numbers and click on Elipsis button$")
	public void user_select_the_already_created_numbers_and_click_on_Elipsis_button() throws Throwable {

		Thread.sleep(2000);
		KeywordUtil.clickElementFromList(NumbersPage.numberslinks, "Numbers", "Click on Numbers link");
		Thread.sleep(2000);
		ClickOnFirstElement(NumbersPage.ellipsebtn, "click on Ellipse Button");

	}

	@When("^Click on Edit button for numbers$")
	public void click_on_Edit_button_for_numbers() throws Throwable {
		Thread.sleep(2000);
		click(NumbersPage.editbtn, "click on Edit Button");
		Thread.sleep(1000);

	}

	@When("^I select another number hit the save button$")
	public void i_select_another_number_hit_the_save_button() throws Throwable {
		click(NumbersPage.callFlowIDDrp, "Click on Call Flow iD Drop Down");
		Thread.sleep(2000);
		MoveToclickElementByTextFromList(NumbersPage.numbersDrpValue, "Test call flow", "Select Call Flow ID");
		Thread.sleep(2000);
		click(NumbersPage.savebtn, "click on Save button for Numbers");

	}

	@Then("^I Validate the toast message for numbers edit$")
	public void i_Validate_the_toast_message_for_numbers_edit(DataTable arg1) throws Throwable {
		
		isWebElementVisible(NumbersPage.toastmsg, "validate the Edit Numbers Status successfull message");

	}

	// ==========================Export numbers=================================

	@Given("^Clicks on export button for numbers on elipsis button$")
	public void clicks_on_export_button_for_numbers_on_elipsis_button() throws Throwable {
		Thread.sleep(2000);
		clickElementFromList(NumbersPage.numberslinks, "Numbers", "Click on Numbers link");
		Thread.sleep(2000);
		ClickOnFirstElement(NumbersPage.ellipsebtn, "click on Ellipse Button");
		Thread.sleep(1000);
		click(NumbersPage.exportbtn, "click on export Button");
		

	}

	@Then("^validate numbers export toster message$")
	public void validate_numbers_export_toster_message(DataTable arg1) throws Throwable {

		data = arg1.raw();
		Thread.sleep(2000);
		String actual = KeywordUtil.getElementText(NumbersPage.toastmsg);
		Assert.assertEquals(actual, data.get(0).get(0));
		Thread.sleep(1000);
		isWebElementVisible(NumbersPage.toastmsg, "validate the export Call Flow successfull message");
		Thread.sleep(1000);

	}

	// ==========================Delete numbers=================================

	@Given("^Clicks on Delete button for numbers on elipsis button$")
	public void clicks_on_Delete_button_for_numbers_on_elipsis_button() throws Throwable {
		Thread.sleep(2000);
		clickElementFromList(NumbersPage.numberslinks, "Numbers", "Click on Numbers link");
		Thread.sleep(2000);
		ClickOnFirstElement(NumbersPage.ellipsebtn, "click on Ellipse Button");
		Thread.sleep(1000);
		click(NumbersPage.deletebtn, "click on Delete Button");
		Thread.sleep(1000);

	}

	@Then("^User clicks on Delete at are you sure pop-up dialog for numbers$")
	public void user_clicks_on_Delete_at_are_you_sure_pop_up_dialog_for_numbers() throws Throwable {
		
		click(NumbersPage.deleteconfirm, "click on Delete confirm Button");

	}

	@Then("^validate numbers delete toster message$")
	public void validate_numbers_delete_toster_message(DataTable arg1) throws Throwable {

		data = arg1.raw();
		Thread.sleep(2000);
		String actual = KeywordUtil.getElementText(NumbersPage.toastmsg);
		Assert.assertEquals(actual, data.get(0).get(0));
		Thread.sleep(1000);
		isWebElementVisible(NumbersPage.toastmsg, "validate the Deleted Call Flow successfull message");
		Thread.sleep(1000);

	}

	// ========================= Media
	// Functionality==========================================

	@When("^User Click on media in Dashboard link$")
	public void user_Click_on_media_in_Dashboard_link() throws Throwable {

		Thread.sleep(2000);
		clickElementFromList(MediaPage.medialinks, "Media", "Click on Media");

	}

	@Then("^clicks on Add Media in Media$")
	public void clicks_on_Add_Media_in_Media() throws Throwable {
		clickElementUsingActions(MediaPage.addmediabtn, "click on Add Media button");

	}

	@Then("^enter the name of the media$")
	public void enter_the_name_of_the_media() throws Throwable {
		inputText(MediaPage.medianame, "Test Media"+ranmdom, "Enter Media Name");

	}

	@Then("^select media from Browser Desktop$")
	public void select_media_from_Browser_Desktop() throws Throwable {

		JSClick(MediaPage.uploadfile, "Click on Browser button");
		Thread.sleep(1000);
		uploadFile("C:\\upload\\export_file.csv");
		// uploadFilesUsingSendKeys(MediaPage.uploadfile,
		// "C:\\Users\\samue\\Downloads\\export_file (6)", "Select the Mediafile");
		

	}

	@Then("^enter the category$")
	public void enter_the_category() throws Throwable {
		inputText(MediaPage.catergory, "Test catergory", "Enter Catergory Name");

	}

	@Then("^click on Save Button Media$")
	public void click_on_Save_Button_Media() throws Throwable {
		click(MediaPage.savebtn, "click on Save button for Media");

	}

	@Then("^captures the toster message of media$")
	public void captures_the_toster_message_of_media() throws Throwable {

		isWebElementVisible(NumbersPage.toastmsg, "validate the Numbers Status successfull message");

	}
	// =============================Voicemails==================================

	@When("^User Click on Voicemails in Dashboard link$")
	public void user_Click_on_Voicemails_in_Dashboard_link() throws Throwable {
		Thread.sleep(2000);
		clickElementFromList(VoicemailsPage.voicemailslinks, "Voicemails", "Click on Voicemails");

	}

	@Then("^clicks on Play Recording URL$")
	public void clicks_on_Play_Recording_URL() throws Throwable {
		
		PressSpace(VoicemailsPage.playrecord,"Click on Pay Recording");
		Thread.sleep(5500);

	}

	@Then("^download recording$")
	public void download_recording() throws Throwable {

	}

	@Then("^click on ellipse button then delete voicemail$")
	public void click_on_ellipse_button_then_delete_voicemail() throws Throwable {
		ClickOnFirstElement(NumbersPage.ellipsebtn, "click on Ellipse Button");
		Thread.sleep(1000);
		click(NumbersPage.deletebtn, "click on Delete Button");
		Thread.sleep(1000);
		click(NumbersPage.deleteconfirm, "click on Delete confirm Button");
		
	}

	@Then("^click on ellipse button then export voicemail$")
	public void click_on_ellipse_button_then_export_voicemail() throws Throwable {
		ClickOnFirstElement(NumbersPage.ellipsebtn, "click on Ellipse Button");
		Thread.sleep(1000);
		click(NumbersPage.exportbtn, "click on Export Button");
		Thread.sleep(1000);
	}

	@Then("^captures the toster message of voicemails$")
	public void captures_the_toster_message_of_voicemails() throws Throwable {
		isWebElementVisible(NumbersPage.toastmsg, "validate the Numbers Status successfull message");
	}

}
