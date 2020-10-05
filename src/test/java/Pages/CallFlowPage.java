package Pages;

import java.util.List;

import org.aspectj.weaver.GeneratedReferenceTypeDelegate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import utilities.KeywordUtil;

public class CallFlowPage {

	public static By dashboardlinks=By.xpath("//span[contains(text(),'Call Flows')]");
	public static By addcallflowbtn=By.xpath("//button[contains(text(),'Add Call flow')]");
	public static By callflownametxt=By.xpath("//input[contains(@placeholder,'Enter Name')]");
	public static By callflowdescription=By.xpath("//input[contains(@placeholder,'Enter Description')]");
	public static By texttospeech=By.xpath("//*[@class='nodetitle ui-draggable']/following::label[text()='Text To Speech']");
	public static By texttoconvertvoice=By.xpath("//textarea[@name='tts']");
	public static By ttssavebtn=By.xpath("//div[@class='ui-dialog-buttonset']/button");
	public static By playaudio=By.xpath("//*[@class='nodetitle ui-draggable']/following::label[text()='Play Audio']");
	public static By selectrecorder=By.xpath("//*[@class='ui-dialog-content ui-widget-content']/form/fieldset/div[2]/div/div/select");
	public static By pasavebtn=By.xpath("//div[11]//div[1]//button[1]//span[2]");
	public static By businesshours=By.xpath("//*[@class='ui-widget' and text()='Business Hours']");
	public static By editnode=By.xpath("//div[@id='nodeui']//div[1]//div[1]//div[2]//input[1]");
	public static By timezone=By.xpath("//select[@id='value']");
	public static By fromtime=By.xpath("//input[@name='From-Time']");
	public static By toastmsg=By.xpath("//*[@class='text-muted mb-0']");
	public static By totime=By.xpath("//input[@name='To-Time']");
	public static By businesssavebtn=By.xpath("//div[11]//div[1]//button[1]//span[2]");
	public static By menu=By.xpath("//*[@class='ui-widget' and text()='Menu']");
	public static By selectaudio=By.xpath("//select[@id='Recorded']");
	public static By greetingsmsg=By.xpath("//input[@id='variable']");
	public static By addmenubtn=By.xpath("//button[@id='cases-add']//span[contains(text(),'Add')]");
	public static By inputmenu=By.xpath("//input[contains(@name,'key')]");
	public static By namemenu=By.xpath("//input[contains(@name,'value')]");
	public static By addsave=By.xpath("//div[@class='ui-dialog-buttonset']/button/span[text()='Add']");	
	public static By addmenubtn2=By.xpath("//button[@id='cases-add']//span[@class='ui-button-text'][contains(text(),'Add')]");
	public static By savemenu=By.xpath("//div[11]//div[1]//button[1]//span[2]");
	public static By integrationlink=By.xpath("//span[contains(text(),'Integrations')]");

//	public static By inputmenu2=By.xpath("//*[@name='key']//following::input[2]");
//	public static By namemenu2=By.xpath("//*[@name='key']//following::input[3]");
//	public static By addsave2=By.xpath("//div[@class='ui-dialog-buttonset']/button/span[text()='Add']");
	
	
	public static By voicemail=By.xpath("//*[@class='nodetitle ui-draggable']/following::label[text()='Voicemail']");
	public static By voicerecorder=By.xpath("//div[@id='container0']//select[@id='Recorded']");
	public static By messagevoice=By.xpath("//textarea[@id='Voice-Mail']");
	public static By savevoice=By.xpath("//div[11]//div[1]//button[1]//span[2]");
	public static By frwardcall=By.xpath("//*[@class='nodetitle ui-draggable']/following::label[text()='Forward Call']");
	public static By frwardnumber=By.xpath("//input[@id='fNumber']");
	public static By recordingon=By.xpath("//input[@name='Recording']");
//	public static By frwardsave=By.xpath("//span[contains(text(),'Save')]");
	public static By updatebtn=By.xpath("//button[@class='btn submit-button btn-primary']");
	public static By callflowlist=By.xpath("//*[@class='table b-table border']/tbody/tr/td");
	public static By findme=By.xpath("//*[@class='nodetitle ui-draggable']/following::label[text()='Findme']");
	public static By addfindmebtn=By.xpath("//button[@id='phonegrid-add']//span[@class='ui-button-text'][contains(text(),'Add')]");
	public static By inputfindme=By.xpath("//input[@id='fNumber']");
	public static By recordingonfindme=By.xpath("//input[@name='Recording']");
	public static By ellipsebtn=By.xpath("//*[@class='fal fa-ellipsis-h']/..");
	public static By editbtn=By.xpath("//ul[contains(@class,'dropdown-menu dropdown-menu-right show')]//span[contains(text(),'Edit')]");
	public static By deletebtn=By.xpath("//ul[contains(@class,'dropdown-menu dropdown-menu-right show')]//span[contains(text(),'Delete')]");
	public static By deleteconfirm=By.xpath("//button[contains(@class,'btn btn-danger')]");
	public static By inactivebtn=By.xpath("//*[@class='custom-control custom-switch cursor-pointer']/label");
	public static By gridview=By.xpath("//i[contains(@class,'fas fa-th-large')]");
	public static By listview=By.xpath("//i[contains(@class,'far fa-bars')]");
	

	// join from Text to Speech TO play audio
	public static By startbuttoncursorDrag=By.xpath("//*[@class='contextMenuForNode nodeItem']/div[1]");
	public static By playaudiostart=By.xpath("//*[@class='contextMenuForNode nodeItem']/div[2]");

	
	// join from play audio to buinesshours
	public static By startbuttoncursorDrag1=By.xpath("//*[@class='contextMenuForNode nodeItem']/div[1]"); 
	public static By businesshoursstart=By.xpath("//*[@class='contextMenuForNode nodeItem']/div[2]");
	public static By titlepopup=By.cssSelector("div.ui-widget.ui-dialog-content.ui-widget-content");
	

	
	public static void x() {
		List<WebElement> li = KeywordUtil.getDriver().findElements(titlepopup);
		int size = li.size();
		for (int i = size; i >0;) {
			li.get(i).sendKeys(Keys.TAB);
			break;
		}
	}

	
//	join from Businesss Hours NO TO Voicemail
	
	public static By startbuttoncursorDrag2=By.xpath("//*[@class='contextMenuForNode nodeItem']/div[1]"); 
	public static By voicemailstart=By.xpath("//*[@class='contextMenuForNode nodeItem']/div[3]");
	
	
	// join from buinesshours Yes to menu
	public static By startbuttoncursorDrag3=By.xpath("//*[@class='contextMenuForNode nodeItem']/div[1]"); 
	public static By menustart=By.xpath("//*[@class='contextMenuForNode nodeItem']/div[2]");
	
	// join from Menu NO TO FindMe

	public static By startbuttoncursorDrag5=By.xpath("//*[@class='contextMenuForNode nodeItem']/div[1]"); 
	public static By findmestart=By.xpath("//*[@class='contextMenuForNode nodeItem']/div[3]");


	

	
//	public int getNode() {
////		List<WebElement> li = startbuttoncursorDrag.
//	}





	
	


	




}
