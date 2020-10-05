package step_definitions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Pages.CallFlowPage;
import Pages.ContactsPage;
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


@SuppressWarnings("unused")
public class PBXplusTest extends KeywordUtil {
	
	@SuppressWarnings("rawtypes")
	static Class thisClass = PBXplusTest.class;
	static String testCaseID = thisClass.getSimpleName();

	public WebDriver driver;
public String actualCallFlowName;
	
	public static HashMap<String, String> dataMap = new HashMap<String, String>();
	String ranmdom = KeywordUtil.randomAlphaNumeric(4);
	
	

	@Given("^Read the test data  \"([^\"]*)\" from Excel file for PBXplus$")
	public void read_the_test_data_from_Excel_file_for_PBXplus(String arg1) {
		try {

			dataMap = ExcelDataUtil.getTestDataWithTestCaseID("PBXplus", arg1);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

	@When("^Navigates to the url for PBXplus$")
	public void navigates_to_the_url_for_PBXplus() throws Throwable {

		try {
			navigateToUrl(dataMap.get("URL"));

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Verify the title of the Login Page for PBXplus$")
	public void verify_the_title_of_the_Login_Page_for_PBXplus() throws Throwable {

		// KeywordUtil.Login(LoginPage.email, LoginPage.password, dataMap.get("Email"),
		// dataMap.get("Password"), "Entered Login Credentials : Email "
		// +dataMap.get("Email")+ " pwd: "+ dataMap.get("Password") )
		/*
		 * String title = KeywordUtil.getElementText(LoginPage.loginlbl);
		 * System.out.println("Title of the Page " + title); Assert.assertEquals(title,
		 * dataMap.get("Title"));
		 */
	}

	@When("^Enter Email adrees and password for PBXplus$")
	public void enter_Email_adrees_and_password() throws Throwable {

		KeywordUtil.inputText(LoginPage.email, dataMap.get("Email"), LoginPage.emailnm + dataMap.get("Email"));
		KeywordUtil.inputText(LoginPage.password, dataMap.get("Password"),
				LoginPage.passwordnm + dataMap.get("Password"));
	}

	@When("^Click on Login button for PBXplus$")
	public void click_on_Login_button_for_PBXplus() throws Throwable {
		KeywordUtil.click(LoginPage.loginbtn, "Click on Login button");
	}

		@When("^User click on Pbx Plus link$")
	public void user_click_on_Pbx_Plus_link() throws Throwable {
		KeywordUtil.clickElementFromList(MyAppsPage.allappslink, dataMap.get("myapp"), "Click on PBXplus");


	}

	@When("^User Click on Call Flow link in Dashboard$")
	public void user_Click_on_Call_Flow_link_in_Dashboard() throws Throwable {
		KeywordUtil.clickElementFromList(CallFlowPage.dashboardlinks, dataMap.get("callflowlink"),
				"Click on Call Flow link");
	

	}

	@Then("^User Click on Add Call Flow button$")
	public void user_Click_on_Add_Call_Flow_button() throws Throwable {
		Thread.sleep(2000);
		KeywordUtil.clickElementUsingActions(CallFlowPage.addcallflowbtn, "click on Add Call Flow button");


	}

	@Then("^Enter Call FLow Name$")
	public void enter_Call_FLow_Name() throws Throwable {
		Thread.sleep(4000);
		KeywordUtil.inputText(CallFlowPage.callflownametxt, dataMap.get("Call_Flows_Name") + ranmdom, "Enter Call FLow Name");
		actualCallFlowName = KeywordUtil.getElementText(CallFlowPage.callflownametxt, "Get Call Flow name: ");


	}

	@Then("^Enter Description$")
	public void enter_Description() throws Throwable {
		
		Thread.sleep(2000);
		
		KeywordUtil.inputText(CallFlowPage.callflowdescription, dataMap.get("Description") + ranmdom, "Enter Call FLow Description");
	}

	@When("^Click on Text to speech in Iframe in Call Flow$")
	public void click_on_Text_to_speech_in_Iframe_in_Call_Flow() throws Throwable {
		Thread.sleep(2000);
		KeywordUtil.switchToFrame(0);
		KeywordUtil.click(CallFlowPage.texttospeech, "Click on Text To Speech");
	
	}
	
	@Then("^Enter Text to convert into voice$")
	public void enter_Text_to_convert_into_voice() throws Throwable {
		Thread.sleep(3000);
		KeywordUtil.inputText(CallFlowPage.texttoconvertvoice, dataMap.get("Text_to_Voice") + ranmdom, "Enter Text to Convert into Voice");
	}

	

	@Then("^Click on Save button for Text to Speech$")
	public void click_on_Save_button_for_Text_to_Speech() throws Throwable {
		Thread.sleep(2000);
		KeywordUtil.click(CallFlowPage.ttssavebtn, "click on Save button");
		Thread.sleep(2000);
         KeywordUtil.ReleaseFromIFrame();

	}

	@Then("^Join Nodes from Start to Text to Speech$")
	public void join_Nodes_from_Start_to_Text_to_Speech() throws Throwable {
		Thread.sleep(2000);
		KeywordUtil.switchToFrame(0);
		List<WebElement> li = getDriver().findElements(CallFlowPage.startbuttoncursorDrag);
		
		KeywordUtil.DragAndDrop(li.get(0), li.get(1));
		
		Thread.sleep(3000);

		
	}

	@Then("^User Click on Play Audio$")
	public void user_Click_on_Play_Audio() throws Throwable {
//		KeywordUtil.switchToFrame(0);
		KeywordUtil.click(CallFlowPage.playaudio,"Click on Play Audio");

	}

	@Then("^Select recorder Audio from drop-down$")
	public void select_recorder_Audio_from_drop_down() throws Throwable {
//		KeywordUtil.click(CallFlowPage.selectrecorder, "Click on Select Recorder");
		KeywordUtil.selectByVisibleText(CallFlowPage.selectrecorder, "Media1", "Select the Media");
		Thread.sleep(1500);
	

	}

	@Then("^CLikc on Save button in Play Audio$")
	public void clikc_on_Save_button_in_Play_Audio() throws Throwable {
		KeywordUtil.click(CallFlowPage.pasavebtn, "click on Save button");


	}

	@Then("^Join Nodes from Text to Speech to Play Audio$")
	public void join_Nodes_from_Text_to_Speech_to_Play_Audio() throws Throwable {

		Thread.sleep(3000);
		List<WebElement> playaudio = getDriver().findElements(By.xpath("//*[@class='nodedisplaynamestyle nodeLabelbg']"));
		List<WebElement> source = getDriver().findElements(CallFlowPage.playaudiostart);
		List<WebElement> dest = getDriver().findElements(CallFlowPage.startbuttoncursorDrag);
		
		KeywordUtil.moveToElementByOffSet(playaudio.get(1));
		Thread.sleep(2000);
//		KeywordUtil.moveToElementByOffSet(playaudio.get(0));
		
		KeywordUtil.DragAndDrop(source.get(0), dest.get(2));
		Thread.sleep(3000);

	}

	@Then("^Click on Buiness Hours$")
	public void click_on_Buiness_Hours() throws Throwable {
		Thread.sleep(4000);
		KeywordUtil.click(CallFlowPage.businesshours, "Click on Business Hours");

		

	

	}
	
	@Then("^Select time zone under settings$")
	public void select_time_zone_under_settings() throws Throwable {
		/*KeywordUtil.click(CallFlowPage.timezone, "Click on Select Timezone");
		Thread.sleep(1500);
		KeywordUtil.selectByVisibleText(CallFlowPage.timezone, "TimeZone", "Select the TimeZone");
		Thread.sleep(1500);*/
	

	}

	@Then("^Enter From-Time and To-Time$")
	public void enter_From_Time_and_To_Time() throws Throwable {
		Thread.sleep(1500);
		/*KeywordUtil.inputText(CallFlowPage.fromtime, dataMap.get("From_Time") + randomstring, "Enter Text to From Time");
		KeywordUtil.inputText(CallFlowPage.totime, dataMap.get("To_Time") + randomstring, "Enter Text to To Time");
*/
		KeywordUtil.inputText(CallFlowPage.fromtime, "10:10", "Enter Text to From Time");
		KeywordUtil.inputText(CallFlowPage.totime,"18:00", "Enter Text to To Time");

		

	}

	@Then("^Click on Save Button for Business Hours$")
	public void click_on_Save_Button_for_Business_Hours() throws Throwable {
		KeywordUtil.click(CallFlowPage.businesssavebtn, "click on Save button");


	}

	@Then("^User Join Play Audio to Buiness Hours node$")
	public void user_Join_Play_Audio_to_Buiness_Hours_node() throws Throwable {
		/*Thread.sleep(3000);
		List<WebElement> playaudio = getDriver().findElements(By.xpath("//*[@class='nodedisplaynamestyle nodeLabelbg']"));
		List<WebElement> source = getDriver().findElements(CallFlowPage.playaudiostart);
		List<WebElement> dest = getDriver().findElements(CallFlowPage.startbuttoncursorDrag);
		
		KeywordUtil.moveToElementByOffSet(playaudio.get(1));
		Thread.sleep(2000);
//		KeywordUtil.moveToElementByOffSet(playaudio.get(0));
		
		KeywordUtil.DragAndDrop(source.get(0), dest.get(2));
		Thread.sleep(3000);*/

		//=========================
		
		Thread.sleep(3000);
		List<WebElement> businesshours = getDriver().findElements(By.xpath("//*[@class='nodedisplaynamestyle nodeLabelbg']"));
		List<WebElement> source1 = getDriver().findElements(CallFlowPage.businesshoursstart);
		List<WebElement> dest1 = getDriver().findElements(CallFlowPage.startbuttoncursorDrag1);
		
		KeywordUtil.moveToElementByOffSet1(businesshours.get(2));
		Thread.sleep(2000);
//		KeywordUtil.moveToElementByOffSet(playaudio.get(0));
		
		KeywordUtil.DragAndDrop(source1.get(1), dest1.get(3));
		Thread.sleep(3000);

		}
	
	

@When("^User Click on Voicemail in Iframe$")
public void user_Click_on_Voicemail_in_Iframe() throws Throwable {
	KeywordUtil.click(CallFlowPage.voicemail,"Click on Voicemail");

    
}

@Then("^User Select Record Audio in Voicemail$")
public void user_Select_Record_Audio_in_Voicemail() throws Throwable {
	KeywordUtil.selectByVisibleText(CallFlowPage.voicerecorder, "Media1", "Select the Media");
	Thread.sleep(1500);
    
    
}

@Then("^Enter Message for voicemail$")
public void enter_Message_for_voicemail() throws Throwable {
    
	Thread.sleep(1500);
	KeywordUtil.inputText(CallFlowPage.messagevoice, "Please call in Working Hours", "Enter Message TO Voice");

    
}

@Then("^Click on Save button in Voicemail for iframe$")
public void click_on_Save_button_in_Voicemail_for_iframe() throws Throwable {
	Thread.sleep(1000);
	KeywordUtil.click(CallFlowPage.savevoice, "click on Save button for Voicemail");

    
    
}

@Then("^Join Nodes from Busineeshours No TO Voicemail$")
public void join_Nodes_from_Busineeshours_No_TO_Voicemail() throws Throwable {	
	

	Thread.sleep(3500);
	List<WebElement> voicemail = getDriver().findElements(By.xpath("//*[@class='nodedisplaynamestyle nodeLabelbg']"));
	List<WebElement> source2 = getDriver().findElements(CallFlowPage.voicemailstart);
	List<WebElement> dest2 = getDriver().findElements(CallFlowPage.startbuttoncursorDrag2);
	
	KeywordUtil.moveToElementByOffSet2(voicemail.get(0));
	Thread.sleep(2500);
//	KeywordUtil.moveToElementByOffSet(playaudio.get(0));
	
	KeywordUtil.DragAndDrop(source2.get(0), dest2.get(4));
	Thread.sleep(3000);

    
    
}


	
	
	
	


	@When("^User Click on Menu in Iframe$")
	public void user_Click_on_Menu_in_Iframe() throws Throwable {
		Thread.sleep(4000);		
//		KeywordUtil.clickElementBasedOnText("Menu","Click on Menu");
		KeywordUtil.click(CallFlowPage.menu, "click on Menu");



	}


	@Then("^User Select Record Audio$")
	public void user_Select_Record_Audio() throws Throwable {
//		KeywordUtil.click(CallFlowPage.selectaudio, "Click on Select Recorder");
//		Thread.sleep(1500);
//		KeywordUtil.selectByVisibleText(CallFlowPage.selectaudio, "Media", "Select the Media");
		Thread.sleep(1500);		
		KeywordUtil.selectByVisibleText(CallFlowPage.selectaudio, "Media1", "Select the Media");

	

	}

	@Then("^User Enter Greetings Message$")
	public void user_Enter_Greetings_Message() throws Throwable {
		Thread.sleep(1500);
		KeywordUtil.inputText(CallFlowPage.greetingsmsg, "Hello Greetings", "Enter Greetings");


	}


	@Then("^User clicks on add button for extension$")
	public void User_clicks_on_add_button_for_extension() throws Throwable {
		Thread.sleep(3000);
		KeywordUtil.click(CallFlowPage.addmenubtn, "click on Add Menu button");


	}

	@Then("^Enter Input valueone$")
	public void enter_Input_valueone() throws Throwable {
		Thread.sleep(1000);
//		KeywordUtil.inputText(CallFlowPage.inputmenu, dataMap.get("Input_Menu") + randomstring, "Enter Input Value");
		KeywordUtil.inputText(CallFlowPage.inputmenu,"1", "Enter Input Value");



	}

	@Then("^Enter Name textone$")
	public void enter_Name_textone() throws Throwable {
		Thread.sleep(1000);
//		KeywordUtil.inputText(CallFlowPage.namemenu, dataMap.get("Name_Menu") + randomstring, "Enter Name of Menu");
		KeywordUtil.inputText(CallFlowPage.namemenu,"Yes", "Enter Name of Menu");



	}

	@Then("^Click on Add button for one$")
	public void click_on_Add_button_for_one() throws Throwable {
		Thread.sleep(1000);
		KeywordUtil.click(CallFlowPage.addsave, "click on Add Menu button");


	}

	@Then("^User clicks on add button for extension two$")
	public void User_clicks_on_add_button_for_extension_two() throws Throwable {
		Thread.sleep(2000);
		KeywordUtil.click(CallFlowPage.addmenubtn2, "click on Add Menu button for second Extension");


	}

	@Then("^Enter Input valuetwo$")
	public void enter_Input_valuetwo() throws Throwable {
//		Thread.sleep(3000);
//		CallFlowPage.x();
		Thread.sleep(5000);
		KeywordUtil.tab();
		KeywordUtil.sendData("2");
		
		
//		KeywordUtil.inputText(CallFlowPage.inputmenu, dataMap.get("Input_Menu") + randomstring, "Enter Input Value");
		//KeywordUtil.inputText(CallFlowPage.inputmenu2,"2", "Enter Input Value Two");

	}


	
	@Then("^Enter Name texttwo$")
	public void enter_Name_texttwo() throws Throwable {
		Thread.sleep(1500);
		KeywordUtil.tab();
		KeywordUtil.sendData("NO");
		
//		KeywordUtil.inputText(CallFlowPage.namemenu, dataMap.get("Name_Menu") + randomstring, "Enter Name of Menu");
		//KeywordUtil.inputText(CallFlowPage.namemenu2,"No", "Enter Name of Menu Two");



	}

	@Then("^Click on Add button for extension two$")
	public void click_on_Add_button_for_extension_two() throws Throwable {
		Thread.sleep(1500);
		KeywordUtil.tab();
		KeywordUtil.PressButton();
//		KeywordUtil.click(CallFlowPage.addsave2, "click on save Menu button for two");

	}
	@Then("^Click on Save button in Menu frame$")
	public void click_on_Save_button_in_Menu_frame() throws Throwable {
		Thread.sleep(3500);
		KeywordUtil.click(CallFlowPage.savemenu, "click on Save Menu button");


	}



	@Then("^Join the node from Business hours Yes to Menu$")
	public void join_the_node_from_Business_hours_Yes_to_Menu() throws Throwable {
		
		Thread.sleep(3000);
		List<WebElement> menu = getDriver().findElements(By.xpath("//*[@class='nodedisplaynamestyle nodeLabelbg']"));
		List<WebElement> source3 = getDriver().findElements(CallFlowPage.menustart);
		List<WebElement> dest3 = getDriver().findElements(CallFlowPage.startbuttoncursorDrag3);
		
		KeywordUtil.moveToElementByOffSet3(menu.get(0));
		Thread.sleep(2000);
//		KeywordUtil.moveToElementByOffSet(playaudio.get(0));
		
		KeywordUtil.DragAndDrop(source3.get(2), dest3.get(5));
		Thread.sleep(3000);

		}


	

	@When("^Click on Forward call$")
	public void click_on_Forward_call() throws Throwable {
//		KeywordUtil.switchToFrame(0);
//		KeywordUtil.clickElementBasedOnText("Forward Call","Click on Forward Call");
		Thread.sleep(3500);
		KeywordUtil.click(CallFlowPage.frwardcall, "click on Forward Call");



	}


	@Then("^Enter number in Forward call$")
	public void enter_number_in_Forward_call() throws Throwable {
		KeywordUtil.inputText(CallFlowPage.frwardnumber, "9876543210", "Enter Forward Number");


	}

	@Then("^Click on Recording$")
	public void click_on_Recording() throws Throwable {
		KeywordUtil.click(CallFlowPage.recordingon, "click on Recording");

	}

	@Then("^click on Save button on Forward Call$")
	public void click_on_Save_button_on_Forward_Call() throws Throwable {
		
		Thread.sleep(2500);
		KeywordUtil.tab();
		KeywordUtil.PressButton();
		Thread.sleep(1000);

//		KeywordUtil.click(CallFlowPage.frwardsave, "click on Save Button");


	}

	@Then("^Join Menu one to Forward call$")
	public void join_Menu_one_to_Forward_call() throws Throwable {
		
		Thread.sleep(3000);
		List<WebElement> forwardcall = getDriver().findElements(By.xpath("//*[@class='nodedisplaynamestyle nodeLabelbg']"));
		List<WebElement> source4 = getDriver().findElements(CallFlowPage.menustart);
		List<WebElement> dest4 = getDriver().findElements(CallFlowPage.startbuttoncursorDrag3);
		
		KeywordUtil.moveToElementByOffSet4(forwardcall.get(5));
		Thread.sleep(2000);
//		KeywordUtil.moveToElementByOffSet(playaudio.get(0));
		
		KeywordUtil.DragAndDrop(source4.get(4), dest4.get(6));
		Thread.sleep(3000);

		}
	
	@Then("^Click on Update button for Call FLow$")
	public void click_on_Update_button_for_Call_FLow() throws Throwable {
		
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);		
		KeywordUtil.click(CallFlowPage.updatebtn, "click on Update button for Call Flow");
		Thread.sleep(3000);

	    
	}
	
	@Then("^Validate the successfull message as Call Flow is Created$")
	public void validate_the_successfull_message_as_Call_Flow_is_Created() throws Throwable {
		Thread.sleep(2000);	
		String actual = KeywordUtil.getElementText(CallFlowPage.toastmsg);
		Assert.assertEquals(actual, dataMap.get("callflowsucessfull"));		
		Thread.sleep(1000);			
		KeywordUtil.isWebElementVisible(CallFlowPage.toastmsg, "validate the Call Flow Created successfull message");
	}
		

@Then("^Validate the Record Of Created Call is Inserted$")
public void validate_the_Record_Of_Created_Call_is_Inserted() throws Throwable {	
	Thread.sleep(2000);
	String expectedCallFlowname = KeywordUtil.getCallFlowName(actualCallFlowName, "get Call Flow name :");
	Assert.assertEquals(actualCallFlowName, expectedCallFlowname);
		}
	
//=================Edit Functionality===========================
@When("^User Click on Ellipse button$")
public void user_Click_on_Ellipse_button() throws Throwable {
	Thread.sleep(2500);
	KeywordUtil.ClickOnFirstElement(CallFlowPage.ellipsebtn, "click on Ellipse Button");

    
}

@When("^Clicks on Edit button$")
public void clicks_on_Edit_button() throws Throwable {
	KeywordUtil.click(CallFlowPage.editbtn, "click on Edit Button");
    
}

@Then("^Click on Findme$")
public void click_on_Findme() throws Throwable {
	Thread.sleep(3500);
	KeywordUtil.switchToFrame(0);
	KeywordUtil.click(CallFlowPage.findme, "click on Find Me");


    
}

@Then("^click on Add button for Find me Forward$")
public void click_on_Add_button_for_Find_me_Forward() throws Throwable {
	Thread.sleep(3000);
	KeywordUtil.click(CallFlowPage.addfindmebtn, "click on Add Findme button");

    
}

@Then("^User Enter Number for FindMe$")
public void user_Enter_Number_for_FindMe() throws Throwable {
	Thread.sleep(1000);
	KeywordUtil.inputText(CallFlowPage.inputfindme,"9879879870", "Enter FindMe Number");

    
}

@Then("^Clicks on Add Button$")
public void clicks_on_Add_Button() throws Throwable {
	Thread.sleep(1500);
	KeywordUtil.tab();
	KeywordUtil.PressButton();


    
}

@Then("^User Clicks on Record on for FindMe$")
public void user_Clicks_on_Record_on_for_FindMe() throws Throwable {
	Thread.sleep(1500);

	KeywordUtil.click(CallFlowPage.recordingonfindme, "click on Recording");


    
}

@Then("^User clicks on Save Button for FindMe$")
public void user_clicks_on_Save_Button_for_FindMe() throws Throwable {
//	KeywordUtil.click(CallFlowPage.savemenu, "click on Save Menu button");
	Thread.sleep(1500);
	KeywordUtil.tab();
	KeywordUtil.PressButton();
}

@Then("^User Joins from Menu TWO TO FindME$")
public void user_Joins_from_Menu_TWO_TO_FindME() throws Throwable {
	
	Thread.sleep(3500);
	List<WebElement> findme = getDriver().findElements(By.xpath("//*[@class='nodedisplaynamestyle nodeLabelbg']"));
	List<WebElement> source5 = getDriver().findElements(CallFlowPage.findmestart);
	List<WebElement> dest5 = getDriver().findElements(CallFlowPage.startbuttoncursorDrag5);
	
	KeywordUtil.moveToElementByOffSet5(findme.get(6));
	Thread.sleep(2000);
//	KeywordUtil.moveToElementByOffSet(playaudio.get(0));
	
	KeywordUtil.DragAndDrop(source5.get(1), dest5.get(7));
	Thread.sleep(2000);

	}





   

@Then("^User Click on Update button for Edit Functionality$")
public void user_Click_on_Update_button_for_Edit_Functionality() throws Throwable {
	
	getDriver().switchTo().defaultContent();
	Thread.sleep(3000);		
	KeywordUtil.click(CallFlowPage.updatebtn, "click on Update button for Edit Call Flow");
	Thread.sleep(3000);
    
}

@Then("^Validate the successfull message as Call Flow is Updated$")
public void validate_the_successfull_message_as_Call_Flow_is_Updated() throws Throwable {
	
	Thread.sleep(2000);	
	String actual = KeywordUtil.getElementText(CallFlowPage.toastmsg);
	Assert.assertEquals(actual, dataMap.get("callflowedit"));		
	Thread.sleep(1000);			
	KeywordUtil.isWebElementVisible(CallFlowPage.toastmsg, "validate the Edit Call Flow Inserted successfull message");
}
    
    

@Then("^Validate the Record Of Edit Call Flow is Inserted$")
public void validate_the_Record_Of_Edit_Call_Flow_is_Inserted() throws Throwable {
	Thread.sleep(3500);
	String expectedCallFlowname = KeywordUtil.getCallFlowName(actualCallFlowName, "get Call Flow name :");
	Assert.assertEquals(actualCallFlowName, expectedCallFlowname);
  
}

//=================Delete Functionality===========================


@When("^User Click on Ellipse for to Delete$")
public void user_Click_on_Ellipse_for_to_Delete() throws Throwable {
	KeywordUtil.click(CallFlowPage.ellipsebtn, "click on Ellipse Button for to Delete");

    
    
}

@When("^Clicks on Delete button$")
public void clicks_on_Delete_button() throws Throwable {
	KeywordUtil.click(CallFlowPage.deletebtn, "click on Delete Button");

    
    
}

@Then("^User clicks on Delete at are you sure pop-up$")
public void user_clicks_on_Delete_at_are_you_sure_pop_up() throws Throwable {
	KeywordUtil.click(CallFlowPage.deleteconfirm, "click on Delete confirm Button");

    
    
}

@Then("^User validates the delete toster message$")
public void user_validates_the_delete_toster_message() throws Throwable {
	Thread.sleep(2000);	
	String actual = KeywordUtil.getElementText(CallFlowPage.toastmsg);
	Assert.assertEquals(actual, dataMap.get("callflowdeleted"));		
	Thread.sleep(1000);			
	KeywordUtil.isWebElementVisible(CallFlowPage.toastmsg, "validate the Deleted Call Flow successfull message");
    
}


// =====================Integration==================

@When("^Click on integration from Dashboard menu for integration in PBXplus$")
public void click_on_intergration_from_Dashboard_menu_for_integratio_in_PBXplusn() throws Throwable {
	Thread.sleep(2500);
	KeywordUtil.clickElementFromList(IntegrationPage.dashboardlinks, dataMap.get("integrationlink"),
			"Click on Integrations link");

}

@When("^User click on Integrations app as Twilio in PBXplus$")
public void user_click_on_Integrations_app_as_Twilio_in_PBXplus() throws Throwable {
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

@When("^I Enter the Account Sid for Twillio in PBXplus$")
public void i_Enter_the_Account_Sid_for_Twillio_in_PBXplus() throws Throwable {
	KeywordUtil.inputText(IntegrationPage.accountsidtxt, dataMap.get("twillio_ACCOUNT_SID"),
			"Enter the Account Sid ID :" + dataMap.get("twillio_ACCOUNT_SID"));

}

@When("^I Enter the Auth Token in PBXplus$")
public void i_Enter_the_Auth_Token_in_PBXplus() throws Throwable {

	KeywordUtil.inputText(IntegrationPage.auth_key, dataMap.get("twillio_AUTH_TOKEN"),
			"Enter the Auth key :" + dataMap.get("twillio_AUTH_TOKEN"));
}

@When("^I Click on Authentication button in PBXplus$")
public void i_Click_on_Authentication_button_in_PBXplus() throws Throwable {

	KeywordUtil.click(IntegrationPage.authenticationbtn, "Click on Authentication button");
}



@Then("^Validate the successfull message in PBXplus$")
public void validate_the_successfull_message_in_PBXplus() throws Throwable {
	KeywordUtil.isWebElementVisible(IntegrationPage.toastmsg, "validate the integration successfull message");

	
}

@Then("^User validate the disabled button for twillio app in PBXplus$")
public void user_validate_the_disabled_button_for_twillio_app_in_PBXplus() throws Throwable {
	String actualvalue = KeywordUtil.getElementText(IntegrationPage.diabledbtn);
	KeywordUtil.getElementText(IntegrationPage.diabledbtn);
}



	}



