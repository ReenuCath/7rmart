package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sevenrmartsupermarket.utilities.GeneralUtility;


public class PushNotificationPage
{
	WebDriver driver;
	Properties properties=new Properties();
	FileInputStream ip;
	GeneralUtility generalutility;
	
	
	
	@FindBy(xpath="//p[text()='Push Notifications']")
	WebElement pushNotificationLinkElement;
	@FindBy(xpath="//input[@id='title']")
	WebElement titleElement;
	@FindBy(xpath="//input[@id='description']")
	WebElement descriptionElement;
	@FindBy(xpath="//button[@name='create']")
	WebElement sendElement;
	@FindBy(xpath="//h5[text()='Alert!']")
	WebElement pushNotificationMessageElement;
	@FindBy(xpath="//a[text()='Reset']")
	WebElement resetElement;
	
	public PushNotificationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonPushNotification()
	{
		pushNotificationLinkElement.click();
	}
	public void enterTitle(String title)
	{
		titleElement.sendKeys(title);
	}
	
	public void enterDescription(String description)
	{
		descriptionElement.sendKeys(description);
	}
	
	public void clicksend()
	{
		
		sendElement.click();
	}
	
	public void sendNotification(String title,String description)
	{
		enterTitle(title);
		enterDescription(description);
		clicksend();
	}
	public boolean checkpushNotificationMessage(String expectedMessage)
	{
		generalutility=new GeneralUtility(driver);
		return generalutility.isWordPresent(pushNotificationMessageElement, expectedMessage);
	}
	public void clickReset()
	{
		resetElement.click();
	}
	
	
}
