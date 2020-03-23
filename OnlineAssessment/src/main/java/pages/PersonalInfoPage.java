package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;

import util.WebUtils;

public class PersonalInfoPage extends WebUtils {
	WebUtils u = new WebUtils();
	HomePage homePage = new HomePage();
	
	By firstName = By.id("firstname");
	By psw = By.id("old_passwd");
	By submit = By.name("submitIdentity");
	By actualMsg = By.xpath("//div[@id='center_column']//following-sibling::p[1]");
	By logout = By.className("logout");
	
	String expectedMsg = "Your personal information has been successfully updated.";
	public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static String generateMixString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(letterChar.charAt(random.nextInt(letterChar.length())));
		}
		return sb.toString();
	}	
	
	public void verifySuccessMessage() {
	    	Assert.assertTrue(expectedMsg.equalsIgnoreCase(u.getText(actualMsg).trim()), "Unable to place the order");	    	
	    }
	
	public void updatePersonalInfo() {
		u.implecitWait();
		
		//Enter the value to FirstName
		u.enterText(firstName, generateMixString(3));
		
		//Enter Old Password
		u.enterText(psw, WebUtils.password);
		
		//Click on submit button
		u.clickOnButton(submit);
		u.implecitWait();
	}

}
