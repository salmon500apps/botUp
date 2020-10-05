package Pages;

import org.openqa.selenium.By;

public class NewslettersPage {

	
	//public static By createAccount=By.xpath("//a[@id='createAccountSubmit']");
	
	public static By dashboardlinks=By.xpath("//*[@class='nav-item']/a/span");
	public static By addnewsletterbtn=By.xpath("//button[@class='btn btn-primary active']");
	public static By addcustombtn=By.xpath("//button[contains(text(),'Add custom')]");
	public static By imagepic=By.xpath("//div[contains(@class,'row flex-wrap')]//div[1]//div[1]//div[2]//img[1]");
	public static By nametxt=By.xpath("//*[@placeholder='Enter Name']");
	public static By subjecttxt=By.xpath("//*[@placeholder='Enter Subject']");
	public static By submitbtn=By.xpath("//button[contains(@class,'btn submit-button btn-primary')]");
	public static By welcome500apps=By.xpath("//*[@class='col-6 font-weight-bold h4 pt-2 px-0']");
	public static By htmlframe=By.xpath("//*[@allowfullscreen='allowfullscreen']");
	public static By htmlbody=By.xpath("html/body/div[4]/preceding::div[@id='wrapper']");
	public static By okbtn=By.xpath("//*[@id='appup-modal___BV_modal_footer_']/button[2]");
		

}
