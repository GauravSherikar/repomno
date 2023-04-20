package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {

	Logger log;
	WebDriver driver;

	@Test(dataProvider = "getLoginData")
	public void login(String email, String password, String expectedResult) throws IOException, InterruptedException {
		
		log = LogManager.getLogger(LoginTest.class.getName());

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));

		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginOption().click();

		LoginPage loginPage = new LoginPage(driver);
		// loginPage.emailId().sendKeys("g.sherikar016@gmail.com");//hard-coded email id
		// loginPage.emailId().sendKeys(prop.getProperty(email));
		loginPage.emailId().sendKeys(email);
		// loginPage.password().sendKeys("G@aurav2846");//hard-coded password
		// loginPage.password().sendKeys(prop.getProperty(password));
		loginPage.password().sendKeys(password);
		loginPage.loginButton().click();

		
		AccountPage accountPage = new AccountPage(driver);
		String actualResult = null;

		try {
			if (accountPage.successLogin().isDisplayed())
				actualResult = "Successfull";

		} catch (Exception e) {
			actualResult = "Failure";
		}
	}

	@AfterMethod
	public void closure() {

		driver.close();
	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = { { "g.sherikar016@gmail.com", "G@aurav2846", "Successfull" },
				{ "Dumy@gmail.com", "Dumy", "Failure" } };

		return data;

	}

}
