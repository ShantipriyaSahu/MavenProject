package featureCode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.LoginPage;
import pages.ShoppingPage;
import util.WebUtils;

public class LoginTest {
	WebUtils ui = new WebUtils();
	LoginPage loginPage  = new LoginPage();
	ShoppingPage shoppingPage =  new ShoppingPage();
	
	
	@Given("^User is at the Home Page$")
	public void user_is_at_the_Home_Page() throws Throwable {
		//Open the browser and load the URL
	    ui.startSeleniumServerAndBrowser();
	}

	@Given("^Navigate to LogIn Page$")
	public void navigate_to_LogIn_Page() {
	    //Login to the application
		loginPage.loginToTheAppl(WebUtils.userName, WebUtils.password);
	}

	@Then("^Close Browser$")
	public void close_Browser() throws Throwable {
	    // close browser
	    ui.closeBrowser();
	}
}
