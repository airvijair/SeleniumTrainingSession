package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[@type='button'][contains(text(),'Sign Up')]")
	WebElement sigUpBtn;

	@FindBy(xpath="//a[@href='https://www.freecrm.com/index.html']//img[@class='img-responsive']")
	WebElement crmLogo;
	
	
	//Initializing the Page Factory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Creating method for the Action
	
	public String validateLoingPageTile() {
		return driver.getTitle();
		
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
		
	}
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}

}