package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;
import pages.MasterEmpPage;
import pages.SearchPage;
import util.utilites;

public class MasterEmpPageTest  extends Base{
	
	public LoginPage lgn ;
	public SearchPage srch;
	public utilites util;
	public MasterEmpPage mpde;
	public String sheetname="Sheet2";
	
	
	MasterEmpPageTest(){
		super();
	}
	@BeforeMethod
	public void SetUp() throws Exception {
		launchBrowser();
		lgn=new LoginPage();
		util=new utilites();
		srch=new SearchPage();
		mpde=new MasterEmpPage();
		lgn.login(prop.getProperty("username"),prop.getProperty("password"));
		srch.branches();
	
	}
	
	@DataProvider(name = "getExcelTestDataemp")
	public Object[][] getExcelTestDataemp(){
		Object data[][]=util.excelData(sheetname);
		return data;
	}
	@Test(priority = 1,dataProvider = "getExcelTestDataemp")
public void masteremp(String name,String state,String referanceno,String employmentfrom,String employmentto,String pan) throws Exception{
	mpde.masterempPage(name,state,referanceno,employmentfrom,employmentto,pan);
	String actualtitle=driver.getTitle();
	String expectedTitle="SaralTDS Web - Masters -> Deductee (Employee)";
	Assert.assertEquals(actualtitle, expectedTitle);
}
@AfterMethod
public void tearDown() {
	driver.close();
}
}
