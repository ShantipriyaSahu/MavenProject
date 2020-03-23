package pages;

import org.openqa.selenium.By;

import util.WebUtils;

public class LoginPage extends WebUtils {
    WebUtils u = new WebUtils();

    By signIn = By.className("login");
    By emailAddress = By.id("email");
    By passwoed = By.id("passwd");
    By signInButton = By.id("SubmitLogin");
    

    //Set user name in textbox
    public void setUserName(String strUserName){
    	u.scrollDownToElement(emailAddress);
    	u.enterText(emailAddress, strUserName);
    }

    //Set password in password textbox
    public void setPassword(String strPassword){
    	u.enterText(passwoed, strPassword);
    }

    //Click on login
    public void clickLogin(){
    	u.clickOnButton(signIn);
    }
    
    //Click on login button
    public void clickLoginButton(){
    	u.clickOnButton(signInButton);
    }


    public void loginToTheAppl(String strUserName,String strPasword){
    	//Click on SignIn tab
    	this.clickLogin();
        
    	//Fill user name
        this.setUserName(strUserName);
        
        //Fill password
        this.setPassword(strPasword);
        
        //Click Login button
        this.clickLoginButton();        
    }

}
