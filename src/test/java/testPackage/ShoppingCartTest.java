package testPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import objectModels.ProductsCategoryPage;
import objectModels.RegistrationPage;
import objectModels.AuthenticationPage;
import objectModels.CartCheckoutPage;

public class ShoppingCartTest {
	WebDriver driver;
	ProductsCategoryPage productCategory;
	CartCheckoutPage cartCheckout;
	AuthenticationPage authentication;
	RegistrationPage registration;

	@Test(priority = 0)
	public void AddSingleProductAddToCart() {
		productCategory.oPenProduct1();
		cartCheckout.wait(10);
		productCategory.addProductToCart();
		driver.navigate().refresh();
		productCategory.goToShoppingCart();
		cartCheckout.assertThattheaddedProductIsSameCount();
	}

	@Test(priority = 13)
	public void AddMultipleProductAddToCart() {
		productCategory.oPenProduct1();
		cartCheckout.wait(10);
		productCategory.addProductToCart();
		driver.navigate().refresh();
		productCategory.goToShoppingCart();
		productCategory.oPenProduct2();
		cartCheckout.wait(10);
		productCategory.addProductToCart();
		driver.navigate().refresh();
		productCategory.goToShoppingCart();
		cartCheckout.assertThattheaddedProductsAreSameCount("2");
	}

	@Test(priority = 7)
	public void editQuantityByIncrease() {
		productCategory.oPenProduct1();
		cartCheckout.wait(10);
		productCategory.addProductToCart();
		driver.navigate().refresh();
		productCategory.goToShoppingCart();
		cartCheckout.increaseProductQuantity(2);
		driver.navigate().refresh();
		cartCheckout.wait(10);
		cartCheckout.assertThattheaddedProductsAreSameCount("3");
	}

	@Test(priority = 9)
	public void editQuantityBydecrease() {
		productCategory.oPenProduct1();
		cartCheckout.wait(10);
		productCategory.addProductToCart();
		driver.navigate().refresh();
		productCategory.goToShoppingCart();
		cartCheckout.increaseProductQuantity(3);
		driver.navigate().refresh();
		cartCheckout.decreaseProductQuantity(1);
		driver.navigate().refresh();
		cartCheckout.wait(10);
		cartCheckout.assertThattheaddedProductsAreSameCount("3");
	}

	@Test(priority = 4)
	public void guestCheckout() {
		productCategory.oPenProduct2();
		cartCheckout.wait(10);
		productCategory.addProductToCart();
		driver.navigate().refresh();
		productCategory.goToShoppingCart();
		cartCheckout.pressOnProceedToCheckoutButton1();
		cartCheckout.wait(15);
		cartCheckout.assertUserIsGuest();
	}

	@Test(priority = 5, groups = { "RegisteredCheckOut" })
	public void registeredUserCheckOut() {
		productCategory.oPenProduct2();
		cartCheckout.wait(10);
		productCategory.addProductToCart();
		driver.navigate().refresh();
		productCategory.goToShoppingCart();
		cartCheckout.pressOnProceedToCheckoutButton1();
		cartCheckout.wait(15);
		cartCheckout.assertUserAddressIsDisplayed();
	}

	@Test(priority = 6, groups = { "RegisteredCheckOut" })
	public void checkTheAvailableShippingOptions() {
		productCategory.oPenProduct2();
		cartCheckout.wait(10);
		productCategory.addProductToCart();
		driver.navigate().refresh();
		productCategory.goToShoppingCart();
		cartCheckout.pressOnProceedToCheckoutButton1();
		cartCheckout.wait(10);
		cartCheckout.pressOnProceedToCheckoutButton2();
		cartCheckout.wait(10);
		cartCheckout.assertAddressOptionScreen();
	}

	@Test(priority = 8, groups = { "RegisteredCheckOut" })
	public void checkoutWithAcceptingTerms() {
		productCategory.oPenProduct2();
		cartCheckout.wait(10);
		productCategory.addProductToCart();
		driver.navigate().refresh();
		productCategory.goToShoppingCart();
		cartCheckout.pressOnProceedToCheckoutButton1();
		cartCheckout.wait(10);
		cartCheckout.pressOnProceedToCheckoutButton2();
		cartCheckout.wait(10);
		cartCheckout.checkTermsCheckbox();
		cartCheckout.pressOnProceedToCheckoutButton2();
		cartCheckout.assertPaymentScreen();
	}

	@Test(priority = 10, groups = { "RegisteredCheckOut" })
	public void checkoutWithNotAcceptingTerms() {
		productCategory.oPenProduct2();
		cartCheckout.wait(10);
		productCategory.addProductToCart();
		driver.navigate().refresh();
		productCategory.goToShoppingCart();
		cartCheckout.pressOnProceedToCheckoutButton1();
		cartCheckout.wait(10);
		cartCheckout.pressOnProceedToCheckoutButton2();
		cartCheckout.wait(10);
		cartCheckout.pressOnProceedToCheckoutButton2();
		cartCheckout.assertItemsIsNotSelectedMsg();
		cartCheckout.closeTermsErrorMsg();
	}
	@Test(priority = 11, groups = { "RegisteredCheckOut" })
	public void checkTheAvailablePaymentMethods() {
		productCategory.oPenProduct1();
		cartCheckout.wait(10);
		productCategory.addProductToCart();
		driver.navigate().refresh();
		productCategory.goToShoppingCart();
		cartCheckout.pressOnProceedToCheckoutButton1();
		cartCheckout.wait(10);
		cartCheckout.pressOnProceedToCheckoutButton2();
		cartCheckout.wait(10);
		cartCheckout.checkTermsCheckbox();
		cartCheckout.pressOnProceedToCheckoutButton2();
		cartCheckout.assertPaymentMethods();
	}
	
	@Test(priority = 12, groups = { "RegisteredCheckOut" })
	public void checkPayByCheck() {
		productCategory.oPenProduct2();
		cartCheckout.wait(10);
		productCategory.addProductToCart();
		driver.navigate().refresh();
		productCategory.goToShoppingCart();
		cartCheckout.pressOnProceedToCheckoutButton1();
		cartCheckout.wait(10);
		cartCheckout.pressOnProceedToCheckoutButton2();
		cartCheckout.wait(10);
		cartCheckout.checkTermsCheckbox();
		cartCheckout.pressOnProceedToCheckoutButton2();
		cartCheckout.payByCheck();
		cartCheckout.assertPaymentByCheck();
	}
	
	@Test(priority = 14, groups = { "RegisteredCheckOut" })
	public void checkPayByBankWire() {
		productCategory.oPenProduct1();
		cartCheckout.wait(10);
		productCategory.addProductToCart();
		driver.navigate().refresh();
		productCategory.goToShoppingCart();
		cartCheckout.pressOnProceedToCheckoutButton1();
		cartCheckout.wait(10);
		cartCheckout.pressOnProceedToCheckoutButton2();
		cartCheckout.wait(10);
		cartCheckout.checkTermsCheckbox();
		cartCheckout.pressOnProceedToCheckoutButton2();
		cartCheckout.payByBankWire();
		cartCheckout.assertPaymentByBank();
	}
	@Test(priority = 15, groups = { "RegisteredCheckOut" })
	public void checkPaymentConfirmation() {
		productCategory.oPenProduct2();
		cartCheckout.wait(10);
		productCategory.addProductToCart();
		driver.navigate().refresh();
		productCategory.goToShoppingCart();
		cartCheckout.pressOnProceedToCheckoutButton1();
		cartCheckout.wait(10);
		cartCheckout.pressOnProceedToCheckoutButton2();
		cartCheckout.wait(10);
		cartCheckout.checkTermsCheckbox();
		cartCheckout.pressOnProceedToCheckoutButton2();
		cartCheckout.payByBankWire();
		cartCheckout.confirmOrder();
		cartCheckout.assertOrderConfirmation();
	}

	@Test(priority = 16)
	public void removeProductFromCart() {
		productCategory.oPenProduct1();
		cartCheckout.wait(10);
		productCategory.addProductToCart();
		driver.navigate().refresh();
		productCategory.goToShoppingCart();
		cartCheckout.deleteTheProductFromCart();
		cartCheckout.wait(10);
		cartCheckout.assertThatCartIsEmpty();
	}

	@BeforeMethod(onlyForGroups = { "RegisteredCheckOut" })
	public void beforeMethod() {
		authentication.NavigateToUrl();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		authentication.Login("ayasm1@outlook.com", "123456");
	}

	@AfterMethod(onlyForGroups = { "RegisteredCheckOut" })
	public void afterMethod() {
		registration.logoutAfterCreateTheAccount();
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		productCategory = new ProductsCategoryPage(driver);
		cartCheckout = new CartCheckoutPage(driver);
		authentication = new AuthenticationPage(driver);
		registration = new RegistrationPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
