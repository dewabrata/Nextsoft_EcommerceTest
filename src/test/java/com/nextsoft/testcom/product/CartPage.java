package com.nextsoft.testcom.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	protected WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//span[@title='Continue shopping']//span[1]")
	private WebElement continueShopping;
	
	@FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
	private WebElement proceedToCheck;
	
	@FindBy(xpath = "//img[@class='layer_cart_img img-responsive']")
	private WebElement cartPhoto;
	
	@FindBy(xpath = "//span[@id='layer_cart_product_title']")
	private WebElement productTitle;
	
	
	public HomePage backToHome() {
		continueShopping.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public ShoppingCartPage goToShoppingCart() {
		proceedToCheck.click();
		return PageFactory.initElements(driver, ShoppingCartPage.class);
	}
	
	public int getCheckPhoto() {
		int check = 0;
		if (cartPhoto != null) {
			check = 1;
		}
		return check;
	}
	
	public void getProductTitle() {
		productTitle.getText();
	}
}
	

