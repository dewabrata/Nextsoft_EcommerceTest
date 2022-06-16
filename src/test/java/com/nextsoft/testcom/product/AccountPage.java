package com.nextsoft.testcom.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	protected WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//img[@alt='My Store']")
	private WebElement mainMenu;
	
	public HomePage backToHome() {
		mainMenu.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
}
