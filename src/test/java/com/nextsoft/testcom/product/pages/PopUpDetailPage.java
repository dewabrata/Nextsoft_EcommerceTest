package com.nextsoft.testcom.product.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopUpDetailPage {
	
	protected WebDriver driver;

	public PopUpDetailPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/h1[1]")
	private WebElement popUpDetail;
	
	@FindBy(xpath = "//span[normalize-space()='demo_1']")
	private WebElement productReference;
	
	@FindBy(xpath = "//label[normalize-space()='Condition']")
	private WebElement productCondition;
	
	@FindBy(xpath = "//p[contains(text(),'Faded short sleeve t-shirt with high neckline. Sof')]")
	private WebElement productDesc;
	
	@FindBy(xpath = "//button[normalize-space()='Tweet']")
	private WebElement shareProduct_tweet;
	
	@FindBy(xpath = "//span[@id='our_price_display']")
	private WebElement productPrize;
	
	@FindBy(xpath = "//i[@class='icon-plus']")
	private WebElement productAdd;
	
	
	public String getPopUpDetail() {
		return popUpDetail.getText();
	}
	public String getPopUpDetail_product_reference() {
		return productReference.getText();
	}
	public String getPopUpDetail_product_condition() {
		return productCondition.getText();
	}
	public String getPopUpDetail_product_desc() {
		return productDesc.getText();
	}
	public String getPopUpDetail_product_prize() {
		return productPrize.getText();
	}
	public void getPopUpDetail_shareProduct_tweet() {
		shareProduct_tweet.click();
	}
	public void getPopUpDetail_productAdd() {
		productAdd.click();
	}
	
	
	
}
