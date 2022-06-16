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
	
	public SignInPage clickSignIn() {
		signIn.click();
		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
		return signInPage;
	}
}
