package testPackage;

import org.testng.annotations.Test;
import objectModels.AuthenticationPage;
import objectModels.RegistrationPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class RegisterByEmailTest {
	WebDriver driver;
	AuthenticationPage authentication;
	RegistrationPage registration;

	@Test(priority = 3)
	public void registerWithNewValidEmail() {
		authentication.EnterUserEmailForRegister("ayasalama@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		registration.assertGoToNextPage();
	}

	@Test(priority = 0)
	public void registerWithInvalidEmail() {
		authentication.EnterUserEmailForRegister("ayasalama.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		authentication.assertInvaildEmailForRegister();
	}
	
	@Test(priority = 1)
	public void registerWithRegisteredEmail() {
		authentication.EnterUserEmailForRegister("ayasalama@outlook.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		authentication.assertRegisterWithAnExistingEmail();
	}

	@Test(priority = 2)
	public void registerWithEmptyEmail() {
		authentication.EnterUserEmailForRegister("");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		authentication.assertInvaildEmailForRegister();
	}

	@BeforeMethod
	public void beforeMethod() {
		authentication.NavigateToUrl();
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		authentication = new AuthenticationPage(driver);
		registration = new RegistrationPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
