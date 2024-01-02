package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class HomePage 
{
	WebDriver driver;
	Properties properties=new Properties();
	FileInputStream ip;
	GeneralUtility generalutility;
	
	@FindBy(xpath="//a[@class='d-block']")
	WebElement profileNameElement;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProfileName()
	{
		generalutility=new GeneralUtility(driver);
		String profileNametext=generalutility.getTextofElement(profileNameElement);
		return profileNametext;
	}
}
