package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.base.DataProviders;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class LoginTest extends Base
{
	LoginPage loginPage;
	HomePage homepage;
	@Test(groups = "smoke")
	public void verifyLogin()
	{
		loginPage=new LoginPage(driver);
		homepage=new HomePage(driver);
		
		String expectedProfileName="Admin";
		
		loginPage.login();
		String actualProfileName=homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);
		
	}

	@Test(groups = "regression")
	public void verifyInvalidLogin()
	{
		loginPage=new LoginPage(driver);
		loginPage.login("qa","qa");
		System.out.println();
		boolean actualresult=loginPage.checkErrorMessage("Alert!");
		Assert.assertTrue(actualresult);
	}
	@Test(dataProvider="loginName",dataProviderClass =DataProviders.class)
	public void verifyMultipleLogin(String userName,String password,String profileName)
	{
		loginPage=new LoginPage(driver);
		String actualResult=loginPage.multipleLogin(userName, password, profileName);
		loginPage.login(userName, password);
		String expectedResult=profileName;
		Assert.assertEquals(actualResult, expectedResult);
	}
}
