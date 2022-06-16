package com.nextsoft.testcom.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	protected WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	private WebElement signIn;

	
	@FindBy(xpath =  "//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered']//img[@title='Faded Short Sleeve T-shirts']")
	private WebElement checkImageProduct;
	
	@FindBy(xpath =  "//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered']//a[@title='Faded Short Sleeve T-shirts'][normalize-space()='Faded Short Sleeve T-shirts']")
	private WebElement checkNameProduct;
	
	@FindBy(xpath =  "//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered']//div[@class='left-block']//div[@class='content_price']")
	private WebElement checkPrizeProduct;
	
	@FindBy(xpath =  "//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered']//span[contains(text(),'Quick view')]")
	private WebElement btnQuickView;
	
	@FindBy(xpath =  "//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered']//span[contains(text(),'Quick view')]")
	private WebElement btnMore;
	
	public SignInPage clickSignIn() {
		signIn.click();
		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
		return signInPage;
	}

	
	
	public int getCheckImageProduct() {
		int check=0; 
		if(checkImageProduct!=null) {
			check=1;
		}
		return check;
	}
	
	public int getCheckNameProduct() {
		int check=0; 
		if(checkNameProduct!=null) {
			check=1;
		}
		return check;
	}
	
	public int getCheckPrizeProduct() {
		int check=0; 
		if(checkPrizeProduct!=null) {
			check=1;
		}
		return check;
	}
}
