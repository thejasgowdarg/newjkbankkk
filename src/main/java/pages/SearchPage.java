package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class SearchPage extends Base{
	
	@FindBy(xpath = "//input[@id=\"txtSearch\"]")
	WebElement search;
	
	@FindBy(xpath = "//input[@id=\"imgSearch\"]")
	WebElement searchbranchno;
	
	@FindBy(xpath = "//option[@value=\"729\"]")
	WebElement branchclick;
	
	@FindBy(id = "btnSelect")
	WebElement clickselectbtn;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
		
	}
	public MasterEmpPage branches() throws Exception {
		search.sendKeys("1256");
		Thread.sleep(2000);
		searchbranchno.click();
		branchclick.click();
		Thread.sleep(4000);
		clickselectbtn.click();
		return new MasterEmpPage();
		
	}		

}
