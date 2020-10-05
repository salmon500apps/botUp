package Pages;

import org.openqa.selenium.By;

public class ReportsPage {


	public static By dashboardlinks=By.xpath("//*[@class='nav-item']/a/span");
	public static By addnewsletterbtn=By.cssSelector("button.btn.btn-primary.text-nowrap.active");
	public static By addcustombtn=By.xpath("//*[@class='btn btn-secondary px-5 mr-2 mb-2 pb-2']");
	public static By nametxt=By.xpath("//*[@placeholder='Enter Name']");
	public static By subjecttxt=By.xpath("//*[@placeholder='Enter Subject']");
	public static By submitbtn=By.cssSelector("button.btn.submit-button.btn-primary");
	public static By welcome500apps=By.xpath("//*[@class='col-6 font-weight-bold h4 pt-2 px-0']");
		
}
