package Pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;

//import utilities.GlobalUtil;

public class Botup_Integration {

	public static By dashboardlinksDash = By.xpath("//span[contains(text(),'Dashboard')]");

	public static String facebookapp = "facebook_profile1";
	public static String mailgunapp = "mailgun";
	public static String sendgridapp = "sendgrid";

	public static By dashboardlinks = By.xpath("//span[contains(text(),'Integrations')]");
	public static By appHeaderName = By.xpath("//h5[@class='mb-0 mt-3 text-capitalize text-truncate']");

	public static By integrationlink = By.xpath("//span[contains(text(),'Integrations')]");
	public static By twilioApp=By.xpath("//*[@class='card-text']/h5[contains(text(),'twilio')]/following::button[1]");
	public static By confirmbtnin=By.xpath("//*[@class='btn btn-danger']");
	public static By accountsidtxt=By.id("input_email_value");
	public static By deletebtn=By.xpath("//*[@class='btn btn-danger']");
	public static By auth_key=By.id("input_api_key");
	public static By authenticationbtn=By.xpath("//button[@class='btn submit-button btn-primary']");
	public static By diabledbtnin=By.xpath("//button[@class='btn w-100 btn-danger cursor-pointer']");




	public static By facebookApp = By.xpath("//h5[contains(text(),'facebook_profile1')]//following::button[1]");

	public static By mailgunApp = By.xpath("//h5[contains(text(),'" + mailgunapp + "')]//following::button[1]");
	public static By sendgridApp = By.xpath("//h5[contains(text(),'" + sendgridapp + "')]//following::button[1]");

	public static By diabledbtn = By.xpath("//button[@class='btn w-100 btn-danger cursor-pointer']");
	public static By UserIDfb = By.xpath("//input[@id='email']");
	public static By passwordfb = By.xpath("//input[@id='pass']");
	public static By FBLoginbtn = By.xpath("//button[@id='loginbutton']");
	public static By fbcancel = By.xpath("//span[contains(text(),'Cancel')]");
	public static By modalTitlePopup = By.xpath("//*[text()='Are you sure to disable?']");
	public static By cancelbtn = By.xpath("//*[@id='appup-modal___BV_modal_footer_']/button[1]");
	public static By confirmbtn = By.xpath("//*[@id='appup-modal___BV_modal_footer_']/button[2]");
	public static By toastmsg = By.xpath("//*[contains(@class,'text-muted mb')]");
	public static By dashboardlinkbots = By.xpath("//span[contains(text(),'Bots')]");
	public static By addbotbtn = By.xpath("//button[contains(text(),'Add Bot')]");
	public static By flownameDrp = By.xpath("//span[contains(text(),'Please select an option')]");
	public static By flownameDrpedit = By.xpath("//span[contains(text(),'Lead Generation Template')]");
	public static By flowDrpValue = By.xpath("//*[@class='dropdown-menu show']/div/li/a/div/div[2]");
	public static By botnametxt = By.id("input_undefined");
	public static By categorydrp = By.xpath("//*[ @data-vv-as='Category']/div/button");
	public static By Categoryname = By.xpath("//*[ @class='dropdown-menu show']/div/li/a/div/div[2]");
	public static By savebtn = By.xpath("//button[@class='btn submit-button btn-primary']");
	public static By ellipsebtn = By.xpath("//button[@class='btn submit-button btn-primary']");
	public static By editbtn = By.xpath("//button[@class='btn submit-button btn-primary']");
	public static By flowDrpValuetwo = By.xpath("//a[contains(text(),'Business Information Template')]");
	public static By activebtn = By.xpath("//span[contains(text(),'Active')]");
	public static By IsSelect = By.xpath("//span[contains(text(),'active')]");
	public static By Updatebtn = By.xpath("//button[@class='btn submit-button btn-primary']");
	public static By associateddrp = By.cssSelector("span.form-control.custom-select");
	public static By associatename = By.xpath("//*[@class='dropdown-menu show']/div/li/a/div/div[2]	");
	public static By botsellipsebtn = By
			.xpath("//button[@class='btn btn-bg-transparent p-0 btn-lg dropdown-toggle dropdown-toggle-no-caret']");
	public static By botseditbtn = By
			.xpath("//ul[contains(@class,'dropdown-menu dropdown-menu-right show')]//span[contains(text(),'Edit')]");
	public static By botdeletebtn = By
			.xpath("//ul[contains(@class,'dropdown-menu dropdown-menu-right show')]//span[contains(text(),'Delete')]");
	public static By botcnfmdeletebtn = By.xpath("//button[contains(@class,'btn btn-danger')]");
	public static By messagemenu = By.xpath("//*[@class='nodetitle ui-draggable']/following::label[text()='Message']");
	public static By GetPhoneNumber = By.xpath("//label[contains(text(),'Get Phone Number')]");
	public static By textmessage = By.xpath("//textarea[contains(@placeholder,'Please enter your Response')]");
	public static By phonenm = By.xpath("//input[@placeholder='Please enter provider phone number']");
	public static By redirecturlstart = By.xpath("//*[@class='contextMenuForNode nodeItem']/div[2]");
	public static By redirectUrl = By.xpath("//*[@title='Redirect-URL']");
	public static By startbuttoncursormessage = By.xpath("//*[@class='contextMenuForNode nodeItem']/div[1]");
	public static By updatebtnflow = By.xpath("//button[contains(@class,'btn submit-button btn-primary')]");

	public static By documentlinks = By.xpath("//span[contains(text(),'Documents')]");
	public static By adddocumentbtn = By.xpath("//button[contains(@class,'btn btn-primary text-nowrap active')]");
	public static By documentname = By.xpath("//*[@placeholder='Enter Name']");
	public static By flowname = By.xpath("//input[@placeholder='Enter Name']");
	public static By documentsavebtn = By.xpath("//button[contains(@class,'btn submit-button btn-primary')]");
	public static By uploadfile = By.xpath("//*[@class='custom-file b-form-file']/input");
	public static By docdeletebtn = By
			.xpath("//ul[contains(@class,'dropdown-menu dropdown-menu-right show')]//span[contains(text(),'Delete')]");
	public static By docdeletecnfm = By.xpath("//button[@class='btn btn-danger']");
	public static By docellipsebtn = By
			.xpath("//button[@class='btn btn-bg-transparent p-0 btn-lg dropdown-toggle dropdown-toggle-no-caret']");

	public static By flowlinks = By.xpath("//span[contains(text(),'Flows')]");
	public static By addflow = By.xpath("//button[contains(@class,'btn btn-primary text-nowrap active')]");
	public static By defaultflow = By.xpath("//h6[contains(text(),'Business Information Template')]");
	public static By flowsavebtn = By.xpath("//button[contains(@class,'btn submit-button btn-primary')]");
	public static By flowellipsebtn = By
			.xpath("//button[@class='btn btn-bg-transparent p-0 btn-lg dropdown-toggle dropdown-toggle-no-caret']");
	public static By contactlinks = By.xpath("//a[@class='nav-link']//span[contains(text(),'Contacts')]");
	
}

/*	public static WebElement find(By locator) {
		return GlobalUtil.getDriver().findElement(locator);

	}

	

	public static WebElement createdtwoNodeDrogAble(String delaytitle) {
		return find(By.xpath("//td[@title='" + delaytitle+ "']//ancestor::table[@class='nodeTable']//following-sibling::div//descendant::div[@class='circleChrome'][contains(@style,'rgb(210, 255, 1);')]"));
	}
	public static WebElement createdDelayDropAble(String delaytitle) {
		System.out.println("//td[@title='" + delaytitle+ "']//ancestor::table[@class='nodeTable']//following-sibling::div//descendant::div[@class='circleChrome'][contains(@style,'rgb(255, 126, 0);')]");
		return find(By.xpath("//td[@title='" + delaytitle+ "']//ancestor::table[@class='nodeTable']//following-sibling::div//descendant::div[@class='circleChrome'][contains(@style,'rgb(255, 126, 0);')]"));
	}
	public static Actions action() {
		return new Actions(GlobalUtil.getDriver());
	}


	
	public static void dragNDrop(WebElement from, WebElement to) {
		action().moveToElement(from).clickAndHold().moveToElement(to).release(to).build().perform();
		System.out.println("Action Performed");
	}


}
*/