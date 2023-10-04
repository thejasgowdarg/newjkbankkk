package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Base;

public class DeductionPage extends Base{
	
	@FindBy(xpath = "//a[text()=\"Form 24Q\"]")
	WebElement formaction;
	
	@FindBy(xpath = "//body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[4]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]")
	WebElement qformaction;
	
	@FindBy(xpath = "//body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[5]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]")
	WebElement deductionpageclick;
	
	@FindBy(xpath = "//input[@id=\"ctl00_contentPlaceHolderBody_txtName\"]")
	WebElement name;
	
	@FindBy(xpath = "//*[@id=\"ctl00_contentPlaceHolderBody_autoCompleteExtender_completionListElem\"]/li")
	WebElement namefinder;
	
	@FindBy(xpath = "//select[@id=\"ctl00_contentPlaceHolderBody_ddlSection\"]")
	WebElement sectiondropdown;
	
	@FindBy(xpath = "//input[@id=\"ctl00_contentPlaceHolderBody_txtAmountOfPayment\"]")
	WebElement amountofpayment;
	
	@FindBy(xpath = "//input[@id=\"ctl00_contentPlaceHolderBody_txtCreditedDate\"]")
	WebElement date;
	
	@FindBy(xpath = "//input[@id=\"ctl00_contentPlaceHolderBody_txtIncomeTaxAmount\"]")
	WebElement tds;
	
	@FindBy(xpath = "//input[@id=\"ctl00_contentPlaceHolderBody_txtTaxDedDate\"]")
	WebElement todate;
	
	@FindBy(xpath = "//input[@id=\"ctl00_contentPlaceHolderBody_btnSave\"]")
 	WebElement savebutton;
	
	@FindBy(xpath = "//input[@id=\"ctl00_contentPlaceHolderBody_btnClear\"]")
	WebElement showallbutton;
	
	 public DeductionPage() {
			PageFactory.initElements(driver, this);
	 }
	 public ChallanPage DeductionPage() throws Exception {
		 Actions actoin=new Actions(driver);
         actoin.moveToElement(formaction).build().perform();
         Thread.sleep(2000);
         actoin.moveToElement(qformaction).build().perform();
         Thread.sleep(2000);
         deductionpageclick.click();
         name.sendKeys("Th");
         Thread.sleep(3000);
         namefinder.click();
         Select sectiondropdown1 = new Select(sectiondropdown);
         sectiondropdown1.selectByVisibleText("92A - Payment of Salaries");
         Thread.sleep(3000);
         amountofpayment.sendKeys("4566");
         date.sendKeys("01/04/2023");
         tds.sendKeys("456");
         todate.click();
         savebutton.click();
         Thread.sleep(3000);
 		driver.switchTo().alert().accept();
 		
 		Thread.sleep(2000);
 		driver.switchTo().alert().accept();
 		Thread.sleep(4000);
 		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 showallbutton.click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(4000);
		 return new ChallanPage();
		 
	 }
}
	
	


