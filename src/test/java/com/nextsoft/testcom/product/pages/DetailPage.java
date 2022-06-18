package com.nextsoft.testcom.product.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailPage {
	
	protected WebDriver driver;

	public DetailPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//h1[@itemprop='name']")
	private WebElement detail;
	
	public String getDetail() {
		return detail.getText();
	}
	
	
	
	
	
	
}
