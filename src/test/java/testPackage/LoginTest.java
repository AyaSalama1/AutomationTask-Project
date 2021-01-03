package testPackage;

import org.testng.annotations.Test;

import objectModels.AuthenticationPage;
import objectModels.RegistrationPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class LoginTest {
	WebDriver driver;
	AuthenticationPage authentication;
	RegistrationPage registration;

	@Test(priority = 7)
	public void loginWithCorrectEmailAndPassword() {
		authentication.EnterUserEmailForLogin("ayasalama@outlook.com");
		authentication.EnterUserPasswordForLogin("123456");
	}

	@Test(priority = 0)
	public void LoginWithIncorrectEmail() {
		authentication.EnterUserEmailForLogin("ayasalama@outlook.eg");
		authentication.EnterUserPasswordForLogin("123456");
	}

	@Test(priority = 1)
	public void LoginWithIncorrectPassword() {
		authentication.EnterUserEmailForLogin("ayasalama@outlook.com");
		authentication.EnterUserPasswordForLogin("12345");
	}

	@Test(priority = 2)
	public void LoginWithEmptyEmailAndPassword() {
		authentication.EnterUserEmailForLogin("");
		authentication.EnterUserPasswordForLogin("");
	}

	@Test(priority = 3)
	public void LoginWithEmptyEmail() {
		authentication.EnterUserEmailForLogin("");
		authentication.EnterUserPasswordForLogin("123456");
	}

	@Test(priority = 4)
	public void LoginWithEmptyPassword() {
		authentication.EnterUserEmailForLogin("ayasalama@outlook.com");
		authentication.EnterUserPasswordForLogin("");
	}

	@Test(priority = 5)
	public void LoginWithInvalidEmailFormat() {
		authentication.EnterUserEmailForLogin("ayasalama@gmail");
		authentication.EnterUserPasswordForLogin("123456");
	}

	@Test(priority = 6)
	public void LoginWithInvalidPasswordLength() {
		authentication.EnterUserEmailForLogin("ayasalama@outlook.com");
		authentication.EnterUserPasswordForLogin("123");
	}

	@BeforeMethod
	public void beforeMethod() {
		authentication.NavigateToUrl();
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		authentication = new AuthenticationPage(driver);
		registration = new RegistrationPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
