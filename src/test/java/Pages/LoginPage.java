package Pages;

import org.openqa.selenium.By;
public class LoginPage {

	
	//public static By createAccount=By.xpath("//a[@id='createAccountSubmit']");
	public static By loginlbl = By.xpath("//*[@class='title']/h1");
	public static By email=By.name("email");
	public static  By password = By.name("password");
	//public static  By continueButton = By.xpath("//input[@aria-labelledby='continue-announce']");
	public static  By loginbtn = By.xpath("//button[@type='submit']");
	public static By toastmsg=By.xpath("//*[contains(@class,'text-muted mb')]");
	
	
	//Name of the Objects
	public static String loginlblnm = "Login Lable";
	public static String emailnm = "Enter Email";
	public static String passwordnm = "Enter Password";
	public static String loginbtnm = "Click Login button";
	
	
//	public static void Login(String email, String password, String logstep) {
//		KeywordUtil.inputText(email, email, logstep);
//		KeywordUtil.inputText(password, email, logstep);
//	}
	
	
}
