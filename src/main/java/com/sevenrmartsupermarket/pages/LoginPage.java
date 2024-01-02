package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginPage 
{
	WebDriver driver;
	Properties properties=new Properties();
	FileInputStream ip;
	GeneralUtility generalutility;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement userNameElement;
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordElement;
	@FindBy(xpath="//button[contains(text(),'Sign')]")
	WebElement signInElement;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorMessageElement;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		try
		{
			ip=new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void enterUserName(String userName)
	{
		userNameElement.sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
		passwordElement.sendKeys(password);
	}
	
	public void clickSignIn()
	{
		signInElement.click();
	}
	
	public void login()
	{
		String userName=properties.getProperty("username");
		String password=properties.getProperty("password");
		login(userName,password);
	}
	
	public void login(String userName,String password)
	{
		enterUserName(userName);
		enterPassword(password);
		clickSignIn();
	}
	public boolean checkErrorMessage(String expectedErrorMessage)
	{
		generalutility=new GeneralUtility(driver);
		return generalutility.isWordPresent(errorMessageElement, expectedErrorMessage);
	}
}
