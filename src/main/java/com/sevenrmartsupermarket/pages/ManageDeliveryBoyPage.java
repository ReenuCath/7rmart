package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;


public class ManageDeliveryBoyPage 
{
	WebDriver driver;
	Properties properties=new Properties();
	FileInputStream ip;
	GeneralUtility generalutility;
	JavascriptExecutor js;
	PageUtility pageutility;

	
	@FindBy(xpath="//p[text()='Manage Delivery Boy']")
	WebElement ManageDeliveryBoyElement;
	@FindBy(xpath="(//i[@class='fas fa-edit'])[1]")
	WebElement newDeliveryBoyElement;
	@FindBy(xpath="//input[@id='name']")
	WebElement nameElement;
	@FindBy(xpath="//input[@id='email']")
	WebElement emailElement;
	@FindBy(xpath="//input[@id='phone']")
	WebElement phoneNumberElement;
	@FindBy(xpath="//textarea[@id='address']")
	WebElement addressElement;
	@FindBy(xpath="//input[@id='username']")
	WebElement userNameElement;
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordElement;
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveElement;
	@FindBy(xpath="(//div[contains(string(),' Delivery Boy Details Created Successfully ')])[5]")
	WebElement saveDeliveryBoyMessageElement;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchElement;
	@FindBy(xpath="//table//tbody//tr//td[1]")
	List<WebElement> searchDeliveryBoyNameElement;
	@FindBy(xpath="(//div[contains(string(),' Delivery Boy Status Changed Successfully ')])[5]")
	WebElement ChangeStatusMessageElement;
	@FindBy(xpath="//table//tbody//tr//td[1]")
	List<WebElement> tableNameElement;
	@FindBy(xpath="//input[@id='un']")
	WebElement namesearchElement;
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchButtonElement;
	@FindBy(xpath="//a[text()='Reset']")
	WebElement resetSearchElement;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[2]//span")
	WebElement passwordTextElement;
	@FindBy(xpath ="//table//tbody//tr//td[5]")
	List<WebElement> tableUserNames;
	
	
	public ManageDeliveryBoyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickonManageDeliveryBoy()
	{
		ManageDeliveryBoyElement.click();
	}
	public void clickonNewButton()
	{
		newDeliveryBoyElement.click();
	}
	public void enterInformation(String name,String email,String phoneNumber,String address,String userName,String password)
	{
		
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneNumberElement.sendKeys(phoneNumber);
		addressElement.sendKeys(address);
		userNameElement.sendKeys(userName);
		passwordElement.sendKeys(password);
		
	}
	public void clickonSaveButton()
	{
		pageutility=new PageUtility(driver);
		pageutility.scrollIntoElementView(passwordElement);
		pageutility.scrollAndClick(saveElement);
		
	}
	public boolean checkSaveDeliveryBoyAlertMessage(String expectedMessage)
	{
		generalutility=new GeneralUtility(driver);
		return generalutility.isWordPresent(saveDeliveryBoyMessageElement,expectedMessage);
	}
	
	public void clickonSearchDeliveryBoy()
	{
		searchElement.click();
		
	}
	public void enterSearchName(String searchName)
	{
		namesearchElement.sendKeys(searchName);
		searchButtonElement.click();
	}

	public boolean checkSearchDeliveryBoy(String deliveryBoyName) 
	{
	  generalutility=new GeneralUtility(driver); 
	  List<String> deliveryBoyNameList=new ArrayList<String>();
	  deliveryBoyNameList= generalutility.getTextOfElements(searchDeliveryBoyNameElement);
	  System.out.println("size="+deliveryBoyNameList.size());	  
      int index;
      for(index=0;index<deliveryBoyNameList.size();index++)
      	{
      		if(!deliveryBoyName.equals(deliveryBoyNameList.get(index)) && index%2==0)
      		{
      			System.out.println("deliveryBoyName is "+deliveryBoyName+" element is"+deliveryBoyNameList.get(index));
      			return false;
      		}
      	}
	  	return true;
	 }
	 
	public void resetSearch()
	{
		resetSearchElement.click();
	}
	
	
	public void changeStatus(String deliveryBoyUserName)
	{
		pageutility=new PageUtility(driver);
		generalutility=new GeneralUtility(driver);
		pageutility.scrollIntoElementView(searchButtonElement);
		List<String> names=new ArrayList<String>();
		names=generalutility.getTextOfElements(tableUserNames);  
		System.out.print("names= "+names);
        int index;
        for(index=0;index<names.size();index++)
        {
        	if(deliveryBoyUserName.equals(names.get(index)))
        	{
        		index++;
        		break;
        	}
        }
        System.out.println("Index"+index);
        if(index==1)
        {
        	System.out.println("Index 1 is printing");
        	WebElement status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+index+"]//td[6]"));
            pageutility.scrollAndClick(status);
        }
        else
        {
        	index=index+1;
        	System.out.println("Index"+index+ "is printing");
        	WebElement status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+index+"]//td[6]"));
        	pageutility.scrollAndClick(status);
        }
        
	}
	public boolean checkStatusChangeAlertMessage(String expectedMessage)
	{
		generalutility=new GeneralUtility(driver);
		return generalutility.isWordPresent(ChangeStatusMessageElement,expectedMessage);
	}

	public void getPassword(String deliveryBoyUserName) 
	{
		pageutility=new PageUtility(driver);
		generalutility=new GeneralUtility(driver);
		pageutility.scrollIntoElementView(searchButtonElement);
		List<String> names=new ArrayList<String>();
		names=generalutility.getTextOfElements(tableUserNames);  
		System.out.print("names= "+names);
        int index;
        for(index=0;index<names.size();index++)
        {
        	if(deliveryBoyUserName.equals(names.get(index)))
        	{
        		index++;
        		break;
        	}
        }
        System.out.println("Index"+index);
        System.out.println("getPassword");
        if(index==1)
        {
        	System.out.println("Index 1 is printing");
        	WebElement passwordDropDown=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+index+"]//td[7]"));
            pageutility.scrollAndClick(passwordDropDown);
            WebElement password=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(index++)+"]//span"));
            String passwordText=password.getText();
            System.out.println("password is :"+passwordText);
            
        }
        else
        {
        	index=index+1;
        	System.out.println("Index"+index+ "is printing");
        	WebElement passwordDropDown=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+index+"]//td[7]"));
        	pageutility.scrollAndClick(passwordDropDown);
        	index++;
            WebElement password=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+index+"]//span"));
            String passwordText=password.getText();
            System.out.println("password is :"+passwordText);
        }
	}
	public boolean checkPassword(String expectedMessage)
	{
		generalutility=new GeneralUtility(driver);
		return generalutility.isWordPresent(passwordTextElement,expectedMessage);
	}
}
	

