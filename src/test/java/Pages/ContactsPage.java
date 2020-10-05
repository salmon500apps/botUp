package Pages;

import org.openqa.selenium.By;

public class ContactsPage {

	

	public static By dashboardlinks=By.xpath("//a[@class='nav-link']//span[contains(text(),'Contacts')]");
	public static By addcontactbtn=By.xpath("//button[contains(text(),'Add Contact')]");
	//public static By addcustombtn=By.xpath("//button[contains(text(),'Add custom')]");
	public static By firstname=By.xpath("//form//div//div[1]//fieldset[1]//div[1]//div[1]//input[1]");
	public static By lastname=By.xpath("//div[contains(@class,'hip-form')]//div[2]//fieldset[1]//div[1]//div[1]//input[1]");
	public static By email=By.xpath("//input[contains(@placeholder,'Enter Email')]");
	public static By phonenumber=By.xpath("//input[contains(@placeholder,'Enter Phone Number')]");
	//public static By company=By.xpath("//button[contains(text(),'Add Contact')]");
	//public static By customone=By.xpath("//input[contains(@name,'Custom1')]");
	//public static By customtwo=By.xpath("//input[contains(@name,'Custom2')]");	
	public static By savetbtn=By.xpath("//button[@class='btn submit-button btn-primary']");
	public static By toastmsg=By.xpath("//*[contains(@class,'text-muted mb')]");
	public static By contactslist=By.xpath("//*[@class='table b-table border']/tbody/tr/td");
	

}
