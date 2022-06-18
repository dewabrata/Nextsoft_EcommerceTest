package com.nextsoft.testcom.product.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage {
	
	protected WebDriver driver;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//h1[@id='cart_title']")
	private WebElement shoppingCart;
	
	public void checkShoppingCartPage() {
		shoppingCart.getText();
	}

}
