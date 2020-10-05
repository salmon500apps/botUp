package Pages;

import org.openqa.selenium.By;

public class DripsPage {
	

	public static By dashboardlinks=By.xpath("//span[contains(text(),'Drips')]");
	public static By adddripsbtn=By.xpath("//a[contains(@class,'btn btn-primary')]");
	//public static By addcustombtn=By.xpath("//button[contains(text(),'Add custom')]");
	public static By nametxt=By.xpath("//input[contains(@placeholder,'Enter Drip name')]");
	public static By trigerselect=By.xpath("//*[@class='form-group col-md-6']/select");	
	public static By triggeroption=By.xpath("//*[@id='inlineFormCustomSelect']/optgroup/option");	
	public static By selecttag=By.xpath("//*[@class='appup-card-collection']/select");	
	
	
	public static By subjecttxt=By.xpath("//input[contains(@placeholder,'Enter Subject')]");
	public static By sendertext=By.xpath("//input[contains(@placeholder,'Enter Name')]");
	public static By bodytxt=By.xpath("//*[@class='ql-editor ql-blank']");
	public static By actionclick=By.xpath("//body/div/div/div/div/div/div/div/div/div/div/div/div/form/div/div/div/div[1]/p[1]");
	public static By savebtn=By.xpath("//div[@id='ac-email-builder']//div//form//div//button[contains(text(),'Save')]");
	


}
