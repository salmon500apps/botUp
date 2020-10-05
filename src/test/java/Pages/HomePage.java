package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	public static By accountList=By.xpath("//a[@id='nav-link-accountList']");
	//public static By accountList=By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]");
	//public static By verifyAccount=By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span");
	public static By verifyAccount=By.xpath("//a[@id='nav-your-amazon']/span/span");
	
	
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

}
