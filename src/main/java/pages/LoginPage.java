package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Base;

public class LoginPage extends Base{
	
	
	@FindBy(id = "ddlFinYear")
	WebElement financialyear;
	
	@FindBy(id = "txtUsername")
	WebElement username;
	
	@FindBy(id = "txtPassword")
	WebElement password;
	
	@FindBy(id = "btnLogin")
	WebElement loginbtn;
	


public LoginPage() {
	PageFactory.initElements(driver, this);
	
	
}
public SearchPage login(String un,String pw) {
	financialyear.sendKeys("2023-24");
//	Select fn=new Select(financialyear);
//	fn.selectByVisibleText("2023-24");
	username.sendKeys(un);
	password.sendKeys(pw);
	loginbtn.click();
	
	return new SearchPage();
}

}
