package Pages;

import org.openqa.selenium.By;

public class TemplatesPage {
	

	public static By dashboardlinks=By.xpath("//span[contains(text(),'Templates')]");
	public static By addtemplatebtn=By.xpath("//button[contains(text(),'Add Template')]");
	public static By addcustombtn=By.xpath("//button[contains(text(),'Add custom')]");
	public static By imagepic=By.xpath("//div[contains(@class,'row flex-wrap')]//div[1]//div[1]//div[2]//img[1]");
	public static By nametxt=By.xpath("//input[contains(@placeholder,'Enter Name')]");
	public static By subjecttxt=By.xpath("//input[contains(@name,'subject')]");
	public static By catergory=By.xpath("//*[@class='btn btn-outline-transparent dropdown-toggle']");
	public static By categorylist=By.xpath("//*[@class='dropdown-menu show']/div/li/a");
	
	public static By submitbtn=By.xpath("//button[contains(text(),'submit')]");
	public static By okaybtn=By.xpath("//button[contains(text(),'OK')]");
	public static By welcome500apps=By.xpath("//*[@class='col-6 font-weight-bold h4 pt-2 px-0']");


}
