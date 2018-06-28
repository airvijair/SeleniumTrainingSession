package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 2)
	public void HomePageCRMLogoTest() {
		boolean flag = homePage.ValidateCRMLogo();
		Assert.assertTrue(flag);
	
	}
	
	@Test(priority = 1)
	  public void ValidateHomePageTitleTest() {
		String homePageTitle = homePage.VerifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home page title is mismatch");
		
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
