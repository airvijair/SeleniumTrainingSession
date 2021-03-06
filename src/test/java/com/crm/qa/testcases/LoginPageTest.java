package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.HomePage;


public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage  homePage;
	

	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
		public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String title = loginPage.validateLoingPageTile();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	}
		@Test(priority = 2)
		public void CRMLogoTest() {
			boolean flag = loginPage.validateCRMImage();
			Assert.assertTrue(flag);
		}
		@Test(priority = 3)
		public void LoginTest() throws InterruptedException {
			Thread.sleep(3000);
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			
		}
	
		
				
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
		
		
	}

