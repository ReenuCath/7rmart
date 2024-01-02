package com.sevenrmartsupermarket.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenrmartsupermarket.utilities.ExcelRead;

public class ManageDeliveryBoyTest extends Base
{
	ExcelRead excelread=new ExcelRead();
	ManageDeliveryBoyPage managedeliveryboypage;
	LoginPage loginpage;
	
	@Test(groups = "smoke",retryAnalyzer = RetryAnalyzer.class)
	public void verifySaveInformation()
	{
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		loginpage=new LoginPage(driver);
		excelread.setExcelFile("ManageDeliveryBoy", "Information");
		String name=excelread.getCellData(1, 0);
		String email=excelread.getCellData(1, 1);
		String phoneNumber=excelread.getCellData(1, 2);
		String address=excelread.getCellData(1, 3);
		String userName=excelread.getCellData(1, 4);
		String password=excelread.getCellData(1, 5);
		loginpage.login();
		managedeliveryboypage.clickonManageDeliveryBoy();
		managedeliveryboypage.clickonNewButton();
		managedeliveryboypage.enterInformation(name, email, phoneNumber, address, userName, password);
		managedeliveryboypage.clickonSaveButton();
		boolean actualresult=managedeliveryboypage.checkSaveDeliveryBoyAlertMessage("Delivery Boy Details Created Successfully");
		Assert.assertTrue(actualresult);
	}
	@Test(groups = {"smoke","regression"})
	public void verifySearch()
	{
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		loginpage=new LoginPage(driver);
		excelread.setExcelFile("ManageDeliveryBoy", "searchName");
		String searchName=excelread.getCellData(1, 0);
		loginpage.login();
		managedeliveryboypage.clickonManageDeliveryBoy();
		managedeliveryboypage.clickonSearchDeliveryBoy();
		managedeliveryboypage.enterSearchName(searchName);
	    boolean actualresult=managedeliveryboypage.checkSearchDeliveryBoy(searchName);
		Assert.assertTrue(actualresult);
		 
	}
	
	@Test(groups = "regression")
	public void verify_SearchReset()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		excelread.setExcelFile("ManageDeliveryBoy", "searchName");
		String searchName=excelread.getCellData(1, 0);
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickonManageDeliveryBoy();
		managedeliveryboypage.clickonSearchDeliveryBoy();
		managedeliveryboypage.enterSearchName(searchName);
		managedeliveryboypage.resetSearch();
	}
	
	@Test
	public void verify_changeStatus()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickonManageDeliveryBoy();
		managedeliveryboypage.clickonSearchDeliveryBoy();
		managedeliveryboypage.enterSearchName("Jack");
		managedeliveryboypage.changeStatus("Jackgr");
		boolean actualresult=managedeliveryboypage.checkStatusChangeAlertMessage("Delivery Boy Status Changed Successfully");
		Assert.assertTrue(actualresult);
	}
	
	@Test
	public void verify_Password()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		excelread.setExcelFile("ManageDeliveryBoy", "searchName");
		String password=excelread.getCellData(1, 0);
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickonManageDeliveryBoy();
		managedeliveryboypage.clickonSearchDeliveryBoy();
		managedeliveryboypage.enterSearchName("Jack");
		managedeliveryboypage.getPassword("Jackgr");
		boolean actualresult=managedeliveryboypage.checkPassword(password);
		Assert.assertTrue(actualresult);
		
	}
}
