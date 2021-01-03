package objectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage {

	// Variables
	private WebDriver driver;
	private String actualPasswordLenghtErrorMsg = "passwd is invalid.";
	private String actualMobileLenghtErrorMsg = "phone_mobile is invalid.";
	private String onePhoneNumberErrorMsg = "You must register at least one phone number.";

	// Locators
	private By firstNameText = By.id("customer_firstname");
	private By lastNameText = By.id("customer_lastname");
	private By emailText = By.id("email");
	private By passwordText = By.id("passwd");
	private By daysList = By.id("days");
	private By monthsList = By.id("months");
	private By yearsList = By.id("years");
	private By addressFNText = By.id("firstname");
	private By addressLNText = By.id("lastname");
	private By companyText = By.id("company");
	private By addressL1Text = By.id("address1");
	private By addressL2Text = By.id("address2");
	private By cityText = By.id("city");
	private By stateList = By.id("id_state");
	private By postCodeText = By.id("postcode");
	private By additionalInfoText = By.id("other");
	private By homePhoneText = By.id("phone");
	private By mobilePhoneText = By.id("phone_mobile");
	private By aliasText = By.id("alias");
	private By registerButton = By.id("submitAccount");
	private By countryValue = By.xpath("//*[@id=\"id_country\"]/option[2]");
	private By errorMsgBox = By.xpath("//*[@class=\"alert alert-danger\"]");
	private By accountInfo = By.className("info-account");
	private By errorMsgContent = By.xpath("//*[@class=\"alert alert-danger\"]/ol/li");
	private By logoutBtn = By.className("logout");

	// Constructor
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	// Keywords
	public void assertGoToNextPage() {
		Assert.assertEquals(true, driver.findElement(registerButton).isDisplayed());
	}

	public void selectUserTitle(int titleId) {
		driver.findElement(By.xpath("//*[@id=\"id_gender" + titleId + "\"]")).click();
	}

	public void enterUserFirstName(String firstName) {
		driver.findElement(firstNameText).sendKeys(firstName);
	}

	public void enterUserLastName(String lastName) {
		driver.findElement(lastNameText).sendKeys(lastName);
	}

	public void AssertUserEmailIsFilled(String email) {
		driver.findElement(emailText).click();
		Assert.assertEquals(email, driver.findElement(emailText).getText());
	}

	public void enterPassword(String password) {
		driver.findElement(passwordText).sendKeys(password);
	}

	public void selectUserBirthDate(int dayId, int monthId, String yearValue) {
		Select listDays = new Select(driver.findElement(daysList));
		listDays.selectByIndex(dayId);
		Select listMonths = new Select(driver.findElement(monthsList));
		listMonths.selectByIndex(monthId);
		Select listYears = new Select(driver.findElement(yearsList));
		listYears.selectByValue(yearValue);
		driver.findElement(yearsList).sendKeys(Keys.TAB);
	}

	public void enterAddressFirstName(String addressFN) {
		driver.findElement(addressFNText).sendKeys(addressFN);
	}

	public void enterAddressLastName(String addressLN) {
		driver.findElement(addressLNText).sendKeys(addressLN);
	}

	public void enterCompanyName(String companyName) {
		driver.findElement(companyText).sendKeys(companyName);
	}

	public void enterAddressLineOne(String addressL1) {
		driver.findElement(addressL1Text).sendKeys(addressL1);
	}

	public void enterAddressLineTwo(String addressL2) {
		driver.findElement(addressL2Text).sendKeys(addressL2);
	}

	public void enterCity(String city) {
		driver.findElement(cityText).sendKeys(city);
	}

	public void selectState(String stateName) {
		Select listState = new Select(driver.findElement(stateList));
		listState.selectByVisibleText(stateName);
	}

	public void enterPostalCode(String postal) {
		driver.findElement(postCodeText).sendKeys(postal);
	}

	public void AssertCountryIsSelected() {
		Assert.assertEquals(true, driver.findElement(countryValue).isSelected());
	}

	public void enterAdditionalInfo(String addInfo) {
		driver.findElement(additionalInfoText).sendKeys(addInfo);
	}

	public void enterHomePhone(String hPhone) {
		driver.findElement(homePhoneText).sendKeys(hPhone);
	}

	public void enterMobilePhone(String mPhone) {
		driver.findElement(mobilePhoneText).sendKeys(mPhone);
	}

	public void enterAlias(String alias) {
		driver.findElement(aliasText).sendKeys(alias);
	}

	public void submitForm() {
		driver.findElement(registerButton).click();
	}

	public void clearEmail() {
		driver.findElement(emailText).clear();
	}

	public void assertRequiredFields() {
		Assert.assertEquals(true, driver.findElement(errorMsgBox).isDisplayed());
	}

	public void assertPasswordLenght() {
		Assert.assertEquals(actualPasswordLenghtErrorMsg, driver.findElement(errorMsgContent).getText());
	}

	public void assertMobilePhoneLenght() {
		Assert.assertEquals(actualMobileLenghtErrorMsg, driver.findElement(errorMsgContent).getText());
	}

	public void assertUserEnteredAtLeastOnePhoneNumber() {
		Assert.assertEquals(onePhoneNumberErrorMsg, driver.findElement(errorMsgContent).getText());
	}

	public void assertThatAccounthasbeenCreated() {
		Assert.assertEquals(true, driver.findElement(accountInfo).isDisplayed());
	}

	public void logoutAfterCreateTheAccount() {
		driver.findElement(logoutBtn).click();
	}

}
