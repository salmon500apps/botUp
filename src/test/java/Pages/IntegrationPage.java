package Pages;

import org.openqa.selenium.By;

public class IntegrationPage {

	public static String twilioapp ="twilio";
	public static String mailgunapp ="mailgun";
	public static String sendgridapp ="sendgrid";
	

	public static By dashboardlinks=By.xpath("//span[contains(text(),'Integrations')]");
	public static By appHeaderName=By.xpath("//h5[@class='mb-0 mt-3 text-capitalize text-truncate']");
	
	public static By twilioApp=By.xpath("//h5[contains(text(),'"+twilioapp+"')]//following::button[1]");
	public static By mailgunApp=By.xpath("//h5[contains(text(),'"+mailgunapp+"')]//following::button[1]");
	public static By sendgridApp=By.xpath("//h5[contains(text(),'"+sendgridapp+"')]//following::button[1]");
	
	public static By diabledbtn=By.xpath("//button[@class='btn w-100 btn-danger cursor-pointer']");
	public static By accountsidtxt=By.id("input_email_value");
	public static By auth_key=By.id("input_api_key");
	public static By authenticationbtn=By.xpath("//button[@class='btn submit-button btn-primary']");
	public static By modalTitlePopup=By.xpath("//*[text()='Are you sure to disable?']");
	public static By cancelbtn=By.xpath("//*[@id='appup-modal___BV_modal_footer_']/button[1]");
	public static By confirmbtn=By.xpath("//*[@id='appup-modal___BV_modal_footer_']/button[2]");
	public static By toastmsg=By.xpath("//*[contains(@class,'text-muted mb')]");
	
	
	
	

	
	
	

}
