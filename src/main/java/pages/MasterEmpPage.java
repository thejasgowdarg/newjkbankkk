package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class MasterEmpPage extends Base{
	
	@FindBy(xpath = "//a[normalize-space()=\"Masters\"]")
	WebElement masterpageaction;
	
	
	@FindBy(xpath = "//a[normalize-space()=\"Deductee (Employee)\"]")
	WebElement deducteenonempclick;
	
	@FindBy(xpath = "//input[@id=\"ctl00_contentPlaceHolderBody_txtEmployeeName\"]")
	WebElement deducteeempname;
	
	@FindBy(xpath = "//select[@id=\"ctl00_contentPlaceHolderBody_ddlState\"]")
	WebElement state;
	
	@FindBy(xpath = "//input[@id=\"ctl00_contentPlaceHolderBody_txtReferenceNo\"]")
	WebElement refernceno;
	
	@FindBy(xpath = "//input[@id=\"ctl00_contentPlaceHolderBody_dateFromDate\"]")
	WebElement empfromdate;
	
	@FindBy(xpath = "//input[@id=\"ctl00_contentPlaceHolderBody_dateToDate\"]")
	WebElement emptodate;
	
	@FindBy(xpath = "//input[@id=\"ctl00_contentPlaceHolderBody_txtPanReference\"]")
	WebElement pannumber;
	
    @FindBy(xpath = "//input[@id=\"ctl00_contentPlaceHolderBody_btnSave\"]")
    WebElement savebtn;
    
    @FindBy(xpath = "//input[@id=\"ctl00_contentPlaceHolderBody_btnClear\"]")
    WebElement showallbtn;
    
    public MasterEmpPage() {
		PageFactory.initElements(driver, this);
}
public DeductionPage masterempPage(String nm,String st,String refno,String empfrom,String empto,String pno) throws Exception {
	Actions actoin=new Actions(driver);
    actoin.moveToElement(masterpageaction).build().perform();
    deducteenonempclick.click();
    Thread.sleep(3000);
    deducteeempname.sendKeys(nm);
    Thread.sleep(3000);
    state.sendKeys(st);
    Thread.sleep(3000);
    refernceno.sendKeys(refno);
    empfromdate.sendKeys(empfrom);
    Thread.sleep(3000);
    emptodate.sendKeys(empto);
    pannumber.sendKeys(pno);
    Thread.sleep(3000);
    savebtn.click();
    Thread.sleep(2000);
    driver.switchTo().alert().accept();
  	Thread.sleep(2000);
 	driver.switchTo().alert().accept();
 	Thread.sleep(2000);
    JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	 showallbtn.click();
	 Thread.sleep(2000);
     driver.switchTo().alert().accept();
     js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
     Thread.sleep(4000);
	 
	return new DeductionPage();
}
}
