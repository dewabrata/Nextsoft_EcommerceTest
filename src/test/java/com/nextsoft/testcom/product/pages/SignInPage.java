package com.nextsoft.testcom.product.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	protected WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement password;
	
	@FindBy(xpath = "//span[normalize-space()='Sign in']")
	private WebElement btnSignIn;
	
	public AccountPage loginValidUser(String username,String usrPassword) {
		email.sendKeys(username);
		password.sendKeys(usrPassword);
		btnSignIn.click();
		return PageFactory.initElements(driver, AccountPage.class);
	}
	
}
