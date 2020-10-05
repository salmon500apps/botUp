package Pages;


import java.util.List;

import org.aspectj.weaver.GeneratedReferenceTypeDelegate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import utilities.KeywordUtil;

public class NumbersPage {
	public static By numberslinks=By.xpath("//span[contains(text(),'Numbers')]");
	public static By addnumberbtn=By.xpath("//button[@class='btn btn-primary text-nowrap active']");
	public static By numbersDrpValue=By.xpath("//*[@class='dropdown-menu show']");
	public static By numbersDrpValuemobile=By.xpath("//*[@class='dropdown-menu show']/div/li/a");
	public static By providerDrp=By.xpath("//label[text()='Provider']/following::button[1]");
	public static By callFlowIDDrp=By.xpath("//label[text()='Call Flow Id']/following::button[1]");
	public static By phoneNumDrp=By.xpath("//label[text()='Phone Number']/following::button[1]");
	
	
	public static By numberdrp=By.xpath("//ul[contains(@class,'dropdown-menu show')]//div[contains(@class,'scrollbar')]");
	public static By callflowid=By.xpath("//div[contains(@class,'col-md-12 my-width')]//div//div[2]//fieldset[1]//div[1]//div[1]//div[1]//button[1]//span[1]");
	public static By savebtn=By.xpath("//button[contains(@class,'btn submit-button btn-primary')]");
	public static By toastmsg=By.xpath("//*[@class='text-muted mb-0']");
	public static By ellipsebtn=By.xpath("//*[@class='fal fa-ellipsis-h']/..");
	public static By editbtn=By.xpath("//ul[contains(@class,'dropdown-menu dropdown-menu-right show')]//span[contains(text(),'Edit')]");
	public static By deletebtn=By.xpath("//ul[contains(@class,'dropdown-menu dropdown-menu-right show')]//span[contains(text(),'Delete')]");
	public static By deleteconfirm=By.xpath("//button[contains(@class,'btn btn-danger')]");
	public static By exportbtn=By.xpath("//span[contains(text(),'Export')]");



	
}
