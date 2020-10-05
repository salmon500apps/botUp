package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
	
	public static By welcome500appsheader=By.xpath("//div[contains(text(),'Welcome to 500apps')]");
	public static By leftArrowmenu=By.xpath("//*[@class='fal fa-bars nav-link']");
	public static By profileMenu=By.xpath("//*[@class='btn-group b-dropdown dropdown']/button/div/div/div/div");
	public static By logoutlink=By.xpath("//a[@role='menuitem']/span");

	
	public static String welcomeheadernm = "Welcome to 500apps";
	public static String callflowslinknm = "Click on Call Flows";
	public static String Dashboardlinknm = "Click on DashBoard";
	public static String integrationlinknm = "Click on Intergration Link";
	public static String botslinknm = "Click on Bots Link";
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

}
