package objectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AuthenticationPage {

	// Constructor
	public AuthenticationPage(WebDriver driver) {
		this.driver = driver;
	}

	// Variables
	private WebDriver driver;
	private String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	private String invalidPasswordLengthMsg = "Invalid password.";
	private String invalidEmailFormatMsg = "Invalid email address.";
	private String emptyEmailMsg = "An email address required.";
	private String emptyPasswordMsg = "Password is required.";
	private String invalidEmailForRegisterMsg = "Invalid email address.";
	private String registeredEmailMsg = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
	private String incorrectEmailOrPwMsg = "Authentication failed.";

	// Locators
	private By emailBoxRegister = By.id("email_create");
	private By emailBoxLogin = By.id("email");
	private By password = By.id("passwd");
	private By errorMsgForLogin = By.xpath("//*[@id=\"center_column\"]//ol/li");
	private By errorMsgForRegister = By.xpath("//*[@id=\"create_account_error\"]/ol/li");

	// Keywords
	public void NavigateToUrl() {
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}

	public void EnterUserEmailForRegister(String newEmail) {
		driver.findElement(emailBoxRegister).sendKeys(newEmail, Keys.ENTER);
	}

	public void assertInvaildEmailForRegister() {
		Assert.assertEquals(invalidEmailForRegisterMsg, driver.findElement(errorMsgForRegister).getText());
	}

	public void assertRegisterWithAnExistingEmail() {
		Assert.assertEquals(registeredEmailMsg, driver.findElement(errorMsgForRegister).getText());
	}
	
	public void Login (String registeredEmail, String userPassword) {
		driver.findElement(emailBoxLogin).sendKeys(registeredEmail, Keys.TAB);
		driver.findElement(password).sendKeys(userPassword, Keys.ENTER);
	}
	public void EnterUserEmailForLogin(String registeredEmail) {
		driver.findElement(emailBoxLogin).sendKeys(registeredEmail, Keys.TAB);
	}

	public void EnterUserPasswordForLogin(String userPassword) {
		driver.findElement(password).sendKeys(userPassword, Keys.ENTER);
	}

	public void assertIncorrectEmailOrPasswordForLogin() {
		Assert.assertEquals(incorrectEmailOrPwMsg, driver.findElement(errorMsgForLogin).getText());
	}

	public void assertEmptyEmailAndPasswordForLogin() {
		Assert.assertEquals(emptyEmailMsg, driver.findElement(errorMsgForLogin).getText());
	}

	public void assertEmptyPasswordForLogin() {
		Assert.assertEquals(emptyPasswordMsg, driver.findElement(errorMsgForLogin).getText());
	}

	public void assertInvalidEmailFormatForLogin() {
		Assert.assertEquals(invalidEmailFormatMsg, driver.findElement(errorMsgForLogin).getText());
	}

	public void assertInvalidPasswordLengthForLogin() {
		Assert.assertEquals(invalidPasswordLengthMsg, driver.findElement(errorMsgForLogin).getText());
	}

}
