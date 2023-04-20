package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {//creating constructor here

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-email")
	WebElement emailId;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	
	
	public WebElement emailId() {
		
		return emailId;
	}
	
	public WebElement password() {
		
		return password;
	}
	
	public WebElement loginButton() {
		
		return loginButton;
	}
}

