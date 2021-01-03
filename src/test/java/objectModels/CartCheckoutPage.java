package objectModels;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartCheckoutPage {

	// Variables
	private WebDriver driver;
	private String emptyCartTextMsg = "Your shopping cart is empty.";
	private String paymentByCheckTextMsg = "You have chosen to pay by check. Here is a short summary of your order:";
	private String paymentByBankWireTextMsg = "You have chosen to pay by bank wire. Here is a short summary of your order:";
	private String orderConfirmationTextMsg = "Your order on My Store is complete.";
	// Locators
	private By deleteFromCart = By.className("icon-trash");
	private By summaryProduct = By.id("summary_products_quantity");
	private By proceedToCheckoutBtn1 = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");
	private By proceedToCheckoutBtn2 = By.xpath("//*[@id=\"center_column\"]//button");
	private By loginBtn = By.id("SubmitLogin");
	private By deliveryAddress = By.xpath("//*[@id=\"address_delivery\"]//h3");
	private By checkboxForTerms = By.id("uniform-cgv");
	private By termsIsNoteSelected = By.xpath("//*[@id=\"order\"]/div[2]/div");
	private By closeTermsErrorMsg = By.xpath("//*[@id=\"order\"]/div[2]/div/div/a");
	private By payByBank = By.className("bankwire");
	private By payByCheck = By.className("cheque");
	private By plusIcon = By.className("icon-plus");
	private By minusIcon = By.className("icon-minus");
	private By cartIsEmpty = By.xpath("//*[@id=\"center_column\"]/p");
	private By confirmPaymentMethodMsg = By.xpath("//*[@class=\"cheque-indent\"]/strong");
	private By confirmOrderBtn = By.xpath("//*[@id=\"cart_navigation\"]//button");
	private By orderConfirmationMsg = By.xpath("//*[@id=\"center_column\"]//p/strong");

	//// *[@id="center_column"]/p[2]/a[1]
	// Constructor

	public CartCheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	// Keywords
	public void increaseProductQuantity(int q) {
		for (int i = 0; i < q; i++) {
			driver.findElement(plusIcon).click();
		}
	}

	public void decreaseProductQuantity(int q) {
		for (int i = 0; i < q; i++) {
			driver.findElement(minusIcon).click();
		}
	}

	public void deleteTheProductFromCart() {
		driver.findElement(deleteFromCart).click();
	}

	public void wait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void assertThattheaddedProductIsSameCount() {
		assertEquals("1 Product", driver.findElement(summaryProduct).getText());
	}

	public void assertThattheaddedProductsAreSameCount(String count) {
		assertEquals("" + count + " Products", driver.findElement(summaryProduct).getText());
	}

	public void assertThatCartIsEmpty() {
		assertEquals(emptyCartTextMsg, driver.findElement(cartIsEmpty).getText());
	}

	public void pressOnProceedToCheckoutButton1() {
		driver.findElement(proceedToCheckoutBtn1).click();
	}

	public void pressOnProceedToCheckoutButton2() {
		driver.findElement(proceedToCheckoutBtn2).click();
	}

	public void assertUserIsGuest() {
		assertEquals(true, driver.findElement(loginBtn).isDisplayed());
	}

	public void assertUserAddressIsDisplayed() {
		assertEquals(true, driver.findElement(deliveryAddress).isDisplayed());
	}

	public void checkTermsCheckbox() {
		driver.findElement(checkboxForTerms).click();
	}

	public void payByCheck() {
		driver.findElement(payByCheck).click();
	}

	public void assertPaymentByCheck() {
		assertEquals(paymentByCheckTextMsg, driver.findElement(confirmPaymentMethodMsg).getText());
	}

	public void payByBankWire() {
		driver.findElement(payByBank).click();
	}

	public void assertPaymentByBank() {
		assertEquals(paymentByBankWireTextMsg, driver.findElement(confirmPaymentMethodMsg).getText());
	}

	public void assertAddressOptionScreen() {
		assertEquals(false, driver.findElement(checkboxForTerms).isSelected());
	}

	public void assertPaymentScreen() {
		assertEquals(true, driver.findElement(payByBank).isDisplayed());
	}

	public void assertPaymentMethods() {
		assertEquals(true, driver.findElement(payByBank).isDisplayed());
		assertEquals(true, driver.findElement(payByCheck).isDisplayed());
	}

	public void confirmOrder() {
		driver.findElement(confirmOrderBtn).click();
	}

	public void assertOrderConfirmation() {
		assertEquals(orderConfirmationTextMsg, driver.findElement(orderConfirmationMsg).getText());
	}

	public void assertItemsIsNotSelectedMsg() {
		assertEquals(true, driver.findElement(termsIsNoteSelected).isDisplayed());
	}

	public void closeTermsErrorMsg() {
		driver.findElement(closeTermsErrorMsg).click();
	}
}
