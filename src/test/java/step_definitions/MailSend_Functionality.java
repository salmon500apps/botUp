package step_definitions;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Pages.Botup_Integration;
import Pages.CallFlowPage;
import Pages.DashBoardPage;
import Pages.MyAppsPage;
import Pages.NumbersPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import utilities.GlobalUtil;
import utilities.KeywordUtil;
import Pages.IntegrationPage;
import Pages.MediaPage;

@SuppressWarnings("unused")
public class MailSend_Functionality extends KeywordUtil {

	public List<List<String>> data;

	public String actualCallFlowName;
	String ranmdom = KeywordUtil.randomAlphaNumeric(4);

	// ==================Refresh(Background)========================

	@SuppressWarnings("deprecation")
	@Given("^User should refresh the page on every scenario completes for mailsend$")
	public void user_should_refresh_the_page_on_every_scenario_completes_for_mailsend() throws Throwable {
		try {
			refersh();
			// getDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	
	}

	    
	

//	private void refersh() {
//		// TODO Auto-generated method stub
//		
//	}
	public static void refersh() {
		getDriver().navigate().refresh();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// ==================Login========================


	@Given("^User navigates to site for mailsend$")
	public void user_navigates_to_site_for_mailsend(DataTable url) throws Throwable {
	    
		data = url.raw();
		navigateToUrl(data.get(0).get(0));
	    
	}

	@When("^User enter with login details for mailsend$")
	public void user_enter_with_login_details_for_mailsend(DataTable loginData) throws Throwable {
	    
		data = loginData.raw();
		inputText(Pages.LoginPage.email, data.get(0).get(0), Pages.LoginPage.emailnm + ": " + data.get(0).get(0));
		inputText(Pages.LoginPage.password, data.get(0).get(1), Pages.LoginPage.passwordnm + ": " + data.get(0).get(1));

	    
	}

	@When("^User hit the login button for mailsend$")
	public void user_hit_the_login_button_for_mailsend() throws Throwable {
		click(Pages.LoginPage.loginbtn, Pages.LoginPage.loginbtnm);

	    
	}

	@Then("^User Validate the dashboard and check welcome message displayed for mailsend$")
	public void user_Validate_the_dashboard_and_check_welcome_message_displayed_for_mailsend() throws Throwable {
	    
	    
	}



}
