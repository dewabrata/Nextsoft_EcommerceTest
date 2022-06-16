package com.nextsoft.testcom.product;

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
	
	public String getPopUpDetail() {
		return popUpDetail.getText();
	}
	
}
