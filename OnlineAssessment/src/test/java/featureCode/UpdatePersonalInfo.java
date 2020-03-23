package featureCode;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderHistoryPage;
import pages.PersonalInfoPage;
import pages.ShoppingPage;
import util.WebUtils;

public class UpdatePersonalInfo {
	WebUtils ui = new WebUtils();
	LoginPage loginPage  = new LoginPage();
	ShoppingPage shoppingPage =  new ShoppingPage();
	OrderHistoryPage orderHistotyPage = new OrderHistoryPage();
	PersonalInfoPage personalInfo = new PersonalInfoPage();
	HomePage homepage = new HomePage();

	@When("^Go to My Account$")
	public void go_to_My_Account() throws Throwable {
		// Click on My Account
		homepage.clickOnMyAccount();
	}

	@When("^Click on My personal Information$")
	public void click_on_My_personal_Information() throws Throwable {
		// Click on My personal info
		homepage.clickOnPersonalInfo();
	}

	@When("^Update FirstName and save$")
	public void update_FirstName_and_save() throws Throwable {
		//Update FirstName and save
		personalInfo.updatePersonalInfo();
	}

	@Then("^Verify the save success message$")
	public void verify_the_save_success_message() throws Throwable {
		// Verify the save success message
		personalInfo.verifySuccessMessage();
	}

	@Then("^SignOut$")
	public void signout() throws Throwable {
		// signout
		homepage.clickOnSignOut();

	}
}
