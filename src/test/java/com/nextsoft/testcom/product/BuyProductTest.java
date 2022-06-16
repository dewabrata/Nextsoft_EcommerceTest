package com.nextsoft.testcom.product;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class BuyProductTest {

	protected WebDriver driver;
	private JavascriptExecutor jsExe;
	
	@BeforeTest
	public void init() {
		System.setProperty("url", "http://automationpractice.com/index.php");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		jsExe = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
	}
	
	@BeforeMethod
	public void cekSession() {
		driver.get(System.getProperty("url"));
	}
	
	@Test(priority = 1)
	public void testLogin_usernameValid_passwordValid() {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.clickSignIn().loginValidUser("rajahutan@gmail.com", "12345").backToHome();
		
		jsExe.executeScript("window.scrollBy(0, 800)", "");
		
	}
}
