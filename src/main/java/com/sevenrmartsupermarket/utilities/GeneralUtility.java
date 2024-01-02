package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralUtility 
{
	WebDriver driver;

	public GeneralUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getTableName()
	{
		return driver.getTitle();
	}
	
	public String get_Attribute(WebElement element,String attribute)
	{
		return element.getAttribute(attribute);
	}
	
	public String get_property(WebElement element,String css)
	{
	return element.getCssValue(css);	
	}
	
	public boolean is_Displayed(WebElement element) 
	{
		return element.isDisplayed();
	}
	
	public String getTextofElement(WebElement element)
	{
		return element.getText();
	}
	
	public boolean isWordPresent(WebElement element,String expectedWord)
	{
		String data=element.getText();
		return data.contains(expectedWord);
	}
	
	public List<String> getTextOfElements(List<WebElement> elements)
	{
		List<String> data=new ArrayList<String>();
		for(WebElement element:elements)
		{  
			data.add(element.getText());
		}  		
		return data;
	}
}
