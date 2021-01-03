package testPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import objectModels.RegistrationPage;
import objectModels.AuthenticationPage;

public class FullRegisterationTest {
	WebDriver driver;
	AuthenticationPage authentication;
	RegistrationPage registration;
	private String email1 = "ayasm1@outlook.com";
	private String email2 = "ayasm2@outlook.com";
	private String email3 = "ayasm3@outlook.com";
	private String email4 = "ayasm4@outlook.com";
	private String email5 = "ayasm4@outlook.com";

	@Test(priority = 0, groups = { "RegistrEmail_1" })
	public void registerNewAccountWithEnteringAllInfo() {
		registration.selectUserTitle(2);
		registration.enterUserFirstName("Aya");
		registration.enterUserLastName("Mohamed");
		registration.enterPassword("123456");
		registration.selectUserBirthDate(19, 4, "1992");
		registration.enterAddressFirstName("A");
		registration.enterAddressLastName("S");
		registration.enterCompanyName("Test");
		registration.enterAddressLineOne("NewYork St001");
		registration.enterAddressLineTwo("In front Of Gas Station");
		registration.enterCity("NY");
		registration.selectState("New York");
		registration.enterPostalCode("00000");
		registration.AssertCountryIsSelected();
		registration.enterAdditionalInfo("Additional Information");
		registration.enterHomePhone("022893897493749");
		registration.enterMobilePhone("01000000000");
		registration.enterAlias("Cairo");
		registration.submitForm();
		registration.assertThatAccounthasbeenCreated();
	}

	@Test(priority = 1, groups = { "RegistrEmail_2" })
	public void registerNewAccountWithEnteringRequiredDataOnly() {
		registration.enterUserFirstName("Aya");
		registration.enterUserLastName("Mohamed");
		registration.enterPassword("123456");
		registration.enterAddressFirstName("A");
		registration.enterAddressLastName("S");
		registration.enterAddressLineOne("NewYork St001");
		registration.enterCity("NY");
		registration.selectState("New York");
		registration.enterPostalCode("00000");
		registration.AssertCountryIsSelected();
		registration.enterMobilePhone("01000000000");
		registration.enterAlias("Cairo");
		registration.submitForm();
		registration.assertThatAccounthasbeenCreated();
	}

	@Test(priority = 2, groups = { "RegistrEmail_3" })
	public void registerNewAccountWithEnteringAllRequiredInforAndSomeOptional() {
		registration.selectUserTitle(2);
		registration.enterUserFirstName("Aya");
		registration.enterUserLastName("Mohamed");
		registration.enterPassword("123456");
		registration.selectUserBirthDate(19, 4, "1992");
		registration.enterAddressFirstName("A");
		registration.enterAddressLastName("S");
		registration.enterAddressLineOne("NewYork St001");
		registration.enterCity("NY");
		registration.selectState("New York");
		registration.enterPostalCode("00000");
		registration.enterAdditionalInfo("Additional Information");
		registration.enterMobilePhone("01000000000");
		registration.enterAlias("Cairo");
		registration.submitForm();
		registration.assertThatAccounthasbeenCreated();
	}

	@Test(priority = 3, groups = { "RegistrEmail_4" })
	public void registerNewAccountWithEnteringAllOptionalDataOnly() {
		registration.selectUserTitle(2);
		registration.selectUserBirthDate(19, 4, "1992");
		registration.enterCompanyName("Test");
		registration.enterAddressLineTwo("In front Of Gas Station");
		registration.enterCity("NY");
		registration.selectState("New York");
		registration.enterPostalCode("00000");
		registration.AssertCountryIsSelected();
		registration.enterAdditionalInfo("Additional Information");
		registration.submitForm();
		registration.assertRequiredFields();
	}

	@Test(priority = 5, groups = { "RegistrEmail_5" })
	public void assertUserMustRegisterWithAtLeastOnePhoneNumber() {
		registration.enterUserFirstName("Aya");
		registration.enterUserLastName("Mohamed");
		registration.enterPassword("123456");
		registration.enterAddressFirstName("A");
		registration.enterAddressLastName("S");
		registration.enterAddressLineOne("NewYork St001");
		registration.enterCity("NY");
		registration.selectState("New York");
		registration.enterPostalCode("00000");
		registration.enterAlias("Cairo");
		registration.submitForm();
		registration.assertUserEnteredAtLeastOnePhoneNumber();
	}

	@Test(priority = 6, groups = { "RegistrEmail_5" })
	public void assertPasswordLenght() {
		registration.enterUserFirstName("Aya");
		registration.enterUserLastName("Mohamed");
		registration.enterPassword("123");
		registration.enterAddressFirstName("A");
		registration.enterAddressLastName("S");
		registration.enterAddressLineOne("NewYork St001");
		registration.enterCity("NY");
		registration.selectState("New York");
		registration.enterPostalCode("00000");
		registration.enterMobilePhone("01000000000");
		registration.enterAlias("Cairo");
		registration.submitForm();
		registration.assertPasswordLenght();
	}
	@Test(priority = 7, groups = { "RegistrEmail_5" })
	public void assertMobileNumberLenght() {
		registration.enterUserFirstName("Aya");
		registration.enterUserLastName("Mohamed");
		registration.enterPassword("123456");
		registration.enterAddressFirstName("A");
		registration.enterAddressLastName("S");
		registration.enterAddressLineOne("NewYork St001");
		registration.enterCity("NY");
		registration.selectState("New York");
		registration.enterPostalCode("00000");
		registration.enterMobilePhone("01000");
		registration.enterAlias("Cairo");
		registration.submitForm();
		registration.assertMobilePhoneLenght();
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

	@BeforeMethod(onlyForGroups = { "RegistrEmail_1" })
	public void beforeMethod1() {
		authentication.NavigateToUrl();
		authentication.EnterUserEmailForRegister(email1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod(onlyForGroups = { "RegistrEmail_2" })
	public void beforeMethod2() {
		registration.logoutAfterCreateTheAccount();
		authentication.EnterUserEmailForRegister(email2);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod(onlyForGroups = { "RegistrEmail_3" })
	public void beforeMethod3() {
		registration.logoutAfterCreateTheAccount();
		authentication.EnterUserEmailForRegister(email3);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod(onlyForGroups = { "RegistrEmail_4" })
	public void beforeMethod4() {
		registration.logoutAfterCreateTheAccount();
		authentication.EnterUserEmailForRegister(email4);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod(onlyForGroups = { "RegistrEmail_5" })
	public void beforeMethod5() {
		authentication.NavigateToUrl();
		authentication.EnterUserEmailForRegister(email5);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
