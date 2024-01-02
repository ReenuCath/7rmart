package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotificationPage;
import com.sevenrmartsupermarket.utilities.ExcelRead;


public class PushNotificationTest extends Base
{
	
	ExcelRead excelread=new ExcelRead();
	PushNotificationPage pushnotificationpage;
	LoginPage loginpage;
	
	@Test
	public void verifyExcelData()
	{
		pushnotificationpage=new PushNotificationPage(driver);
		excelread.setExcelFile("PushNotification", "Notification");
		String data=excelread.getCellData(1, 1);
		System.out.println(data);
	}
	
	@Test
	public void verifyPushNotificationAlertessage()
	{
		pushnotificationpage=new PushNotificationPage(driver);
		loginpage=new LoginPage(driver);
		excelread.setExcelFile("PushNotification", "Notification");
		String title=excelread.getCellData(1, 0);
		String description=excelread.getCellData(1, 1);
		loginpage.login();
		pushnotificationpage.clickonPushNotification();
		pushnotificationpage.enterTitle(title);
		pushnotificationpage.enterDescription(description);
		pushnotificationpage.clicksend();
		//ScreenShot screenshot=new ScreenShot();
		//screenshot.takeScreenShot(driver,"Reenu");
		boolean actualresult=pushnotificationpage.checkpushNotificationMessage("fv");
		Assert.assertTrue(actualresult);
	}
	
	@Test
	public void verifyResetButton()
	{
		pushnotificationpage=new PushNotificationPage(driver);
		loginpage=new LoginPage(driver);
		excelread.setExcelFile("PushNotification", "Notification");
		String title=excelread.getCellData(1, 0);
		String description=excelread.getCellData(1, 1);
		loginpage.login();
		pushnotificationpage.clickonPushNotification();
		pushnotificationpage.enterTitle(title);
		pushnotificationpage.enterDescription(description);
		pushnotificationpage.clickReset();
	}
}
;