package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import util.WebUtils;

public class OrderHistoryPage extends WebUtils {
	WebUtils u = new WebUtils();
	HomePage homePage = new HomePage();
	ShoppingPage shoppingPage = new ShoppingPage();

	By historyTable = By.id("order-list");
	By rows = By.tagName("tr");
	By cols = By.tagName("td");
	By linkLists = By.xpath( "//table[@id='order-list']//tr/td[1]/a");

	public void verifyInOrderHistory() {
		//get the reference number
		 String orderRefNum = shoppingPage.getOrderReference();

		//click on account
		homePage.clickOnMyAccount();

		//click on Order History
		homePage.clickOnOrderHistory();
		u.implecitWait();

		//verify the order reference is there in the table or not
		u.waitForElementPresent(historyTable, 30);
		List<WebElement> links = WebUtils.driver.findElements(linkLists);
		boolean flag= false;
		for (int row = 0; row < links.size(); row++) {
			if((links.get(row).getText().trim()).equalsIgnoreCase(orderRefNum)) {
				flag=true;
				break;
			}
		}
		Assert.assertTrue(flag, "Order not found in order history.");    	
	}

}
