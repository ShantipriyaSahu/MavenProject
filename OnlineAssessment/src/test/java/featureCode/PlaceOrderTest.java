package featureCode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;
import pages.ShoppingPage;
import util.WebUtils;

public class PlaceOrderTest {
	WebUtils ui = new WebUtils();
	LoginPage loginPage  = new LoginPage();
	ShoppingPage shoppingPage =  new ShoppingPage();
	
	
	@Given("^Load Application URL$")
	public void load_Application_URL() throws Throwable {
		//Open the browser and load the URL
	    ui.startSeleniumServerAndBrowser();
	}

	@Given("^Navigate to LogIn Page and enter valid credentials$")
	public void navigate_to_LogIn_Page_and_enter_valid_credentials() {
	    //Login to the application
		loginPage.loginToTheAppl(WebUtils.userName, WebUtils.password);
	}
	
	@When("^Go to T-Shirt menu$")
	public void go_to_T_Shirt_menu() throws Throwable {
	    // Go To T-Shirt menu to order a T-Shirt
		shoppingPage.goToTshirtMenu();
		ui.implecitWait();
	}

	@When("^Order a T-Shirt \"([^\"]*)\"$")
	public void order_a_T_Shirt(String paymentMethod) throws Throwable {
	    // Order a T-Shirt from the website
		shoppingPage.orderTshirt(paymentMethod);
	   
	}

	@Then("^Verify order successfully completed message$")
	public void verify_order_successfully_completed_message() throws Throwable {
	    // verify the success message
		shoppingPage.verifySuccessMessage();	   
	}


}
