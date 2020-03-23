package featureCode;

import cucumber.api.java.en.Then;
import pages.OrderHistoryPage;
import util.WebUtils;

public class VerifyOrderHistory {
	WebUtils ui = new WebUtils();
	OrderHistoryPage orderHistotyPage = new OrderHistoryPage();
	
	@Then("^Verify orderReference Number in the Order History table$")
	public void verify_orderReference_Number_in_the_Order_History_table() throws Throwable {
	    // check whether the order reference number is there in order history or not
		orderHistotyPage.verifyInOrderHistory();	
	}

	

}
