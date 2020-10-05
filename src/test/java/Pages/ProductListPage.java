package Pages;

import org.openqa.selenium.By;

public class ProductListPage {

	public static  By shopbyDropDown = By.xpath("//select[@id='searchDropdownBox']");
	public static  By searchText = By.xpath("//input[@id='twotabsearchtextbox']");
	//public static  By bookName = By.xpath("//div[@data-index='1']//span//div//div//div//div//div//div//div//div//h2//a//span[text()='The Wish List']");
	//public static  By bookName = By.xpath("//span[@text()='The Alchemist']");
	public static  By bookName = By.xpath("//div[contains(@class,'s-result-list')]//a[contains(@class,'a-link-normal')]/span[text()='The Alchemist']");
	public static  By downPage = By.xpath("//span[@id='pagnPrevString']");
	public static  By nextPage = By.xpath("//span[@id='pagnNextString']");
	//public static  By bookName = By.xpath("//span[@id='pdagDesktopSparkleDescription1']");
	

	
	
}
