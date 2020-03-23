package pages;

import org.openqa.selenium.By;

import util.WebUtils;

public class HomePage extends WebUtils{
	WebUtils u = new WebUtils();

	By account=By.className("account");
	By topMenuTshirt = By.xpath("(//a[text()='T-shirts'])[2]");
	By orderHistory = By.xpath("//div[@id='center_column']//a[@title='Orders']");
	By personalInfo = By.xpath("//a[@title='Information']");
	By SignOut = By.className("logout");

	//click on my account
	public void clickOnMyAccount() {
		u.clickOnButton(account);
	}

	//click on T-Shirt
	public void tShirtTopMenu() {
		u.clickOnButton(topMenuTshirt);
	}

	//click on T-Shirt
	public void clickOnOrderHistory() {
		u.clickOnButton(orderHistory);
	}

	//click on my account
	public void clickOnPersonalInfo() {
		u.scrollDownToElement(personalInfo);
		u.clickOnButton(personalInfo);
	}

	//click on SignOut
	public void clickOnSignOut() {
		u.clickOnButton(SignOut);
	}

	//

}
