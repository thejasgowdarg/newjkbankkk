package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;
import pages.SearchPage;
import util.utilites;

public class LoginPageTest extends Base {
	
	public LoginPage lgn;
	public utilites util;
	public SearchPage srch;
	public String sheetname="Sheet1";
	
	
	LoginPageTest(){
		super();
		
	}
	@BeforeMethod
	public void setUp() {
		launchBrowser();
		lgn=new LoginPage();
		srch=new SearchPage();
		
	}
	@DataProvider(name = "getExcelTestData")
	public Object[][] getExcelTestData(){
		Object data[][]=util.excelData(sheetname);
		return data;
	}
	@Test(priority = 1,dataProvider = "getExcelTestData")
 public void LoginTest(String username,String password) throws Exception {
		lgn.login(username,password);
		Thread.sleep(2000);
		srch.branches();
		String actualTitle=driver.getTitle();
		String expectedTitle="SaralTDS Web - Home";
		Assert.assertEquals(actualTitle, expectedTitle);
 }
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
