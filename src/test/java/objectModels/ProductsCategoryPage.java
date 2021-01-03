package objectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsCategoryPage {

	// Variables
	private WebDriver driver;
	private String product1URL = "http://automationpractice.com/index.php?id_product=3&controller=product";
	private String product2URL = "http://automationpractice.com/index.php?id_product=1&controller=product";

	// Locators
	private By addToCart = By.name("Submit");
	private By cartShoppping = By.xpath("//*[@class=\"shopping_cart\"]/a");

	// Constructor
	public ProductsCategoryPage(WebDriver driver) {
		this.driver = driver;
	}

	// Keywords

	public void oPenProduct1() {
		driver.navigate().to(product1URL);
		driver.manage().window().maximize();
	}

	public void oPenProduct2() {
		driver.navigate().to(product2URL);
	}

	public void addProductToCart() {
		driver.findElement(addToCart).click();
	}

	public void goToShoppingCart() {
		driver.findElement(cartShoppping).click();
	}

}
