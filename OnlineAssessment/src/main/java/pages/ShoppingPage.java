package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import util.WebUtils;

public class ShoppingPage extends WebUtils {
	WebUtils u = new WebUtils();
	HomePage homePage = new HomePage();

    By productImgLink = By.xpath("//div[@id='center_column']//a[@class='product_img_link']");
    By addToCart = By.xpath("//button[@name='Submit']/span[text()='Add to cart']");
    By cart = By.xpath("//a[@title='View my shopping cart']");
    By checkOut = By.id("button_order_cart");
    By proceedToCheckOut = By.xpath("//a[@title='Proceed to checkout']");
    By summaryProceedToCheckOut = By.xpath("//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']");
    By processAddress = By.name("processAddress");
    By termsAndServices = By.xpath("//div[@id='uniform-cgv']//input");
    By processShipping = By.name("processCarrier");
    By paymentCheque = By.className("cheque");
    By paymentBank = By.className("bankwire");
    By conformOrder = By.xpath("//button/span[text()='I confirm my order']");
    By actualMessage = By.xpath("//ul[@id='order_step']//following-sibling::p[1]");    
    By frame = By.className("fancybox-iframe");
    By orderReference = By.xpath("//ul[@id='order_step']//following-sibling::div");
    
    String expectedMsg = "Your order on My Store is complete.";
    
    //get the order reference number
    public String getOrderReference() { 
    	String orderReferenceNum = null;
    			
    	u.scrollDownToElement(orderReference);
    	String st = u.getText(orderReference);
    	String[] value = st.split("\\r?\\n");
		for(String s:value) {
			if(s.contains("reference")) {
				orderReferenceNum = s.split("\\s+")[(s.split("\\s+")).length-1].replace(".", "");				
			}
		}
		return orderReferenceNum;
    }

    //verify order successful messageactualMsg
    public void verifySuccessMessage() {
    	Assert.assertTrue(expectedMsg.equalsIgnoreCase(u.getText(actualMessage).trim()), "Unable to place the order");    	
    }
    
  //Click on T-shirt
    public void goToTshirtMenu() {
    	//Click on T-shirt
    	homePage.tShirtTopMenu();
    }
    
    //Click on Terms and Services
    public void clickOnTermsAndServices() {
    	WebUtils.driver.findElement(termsAndServices).click();
    }

    public void orderTshirt(String paymentMethod) throws InterruptedException{
        //Click on T-shirt image
    	u.scrollDownToElement(productImgLink);
    	u.clickOnButton(productImgLink);
    	Thread.sleep(10000);
    	
    	//Switch to frame
    	u.frameSwitch(WebUtils.driver.findElement(frame));
    	
    	//Click on Add to cart
    	u.clickOnButton(addToCart);
    	
    	
    	//click on Proceed to caheckout
    	u.clickOnButton(proceedToCheckOut);
    	u.implecitWait();
    	
    	//click on Summary Proceed to caheckout
    	u.scrollDownToElement(summaryProceedToCheckOut);
    	u.clickOnButton(summaryProceedToCheckOut);
    	u.implecitWait();
    	
    	
    	//click on Address Proceed to caheckout
    	u.scrollDownToElement(processAddress);
    	u.clickOnButton(processAddress);
    	u.implecitWait();
    	
    	//click on Terms and services
    	u.scrollDownToElement(termsAndServices);
    	//u.clickOnButton(termsAndServices);
    	clickOnTermsAndServices();
    	
    	//click on process shipping
    	u.clickOnButton(processShipping);
    	u.implecitWait();
    	
    	if(paymentMethod.equalsIgnoreCase("cheque")) {
    		//click on pay by cheque
    		u.scrollDownToElement(paymentCheque);
    		u.clickOnButton(paymentCheque);
    	} else {
    		//click on pay by bank
    		u.scrollDownToElement(paymentBank);
    		u.clickOnButton(paymentBank);
    	}
    	
    	//click on conform order
    	u.implecitWait();
    	u.scrollDownToElement(conformOrder);
    	u.clickOnButton(conformOrder);
    	u.implecitWait();
    	
    	//switch to default window
    	u.mainWindow();
    }
    
    
}
