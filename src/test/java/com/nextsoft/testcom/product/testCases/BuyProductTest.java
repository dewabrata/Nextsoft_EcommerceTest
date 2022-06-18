package com.nextsoft.testcom.product.testCases;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nextsoft.testcom.product.pages.HomePage;
import com.nextsoft.testcom.product.pages.PopUpDetailPage;
import com.nextsoft.testcom.product.utils.Delay;
import com.nextsoft.testcom.product.utils.ScreenShot;

public class BuyProductTest {

	protected WebDriver driver;
	private JavascriptExecutor jsExe;
	private ScreenShot ss;
	private Delay d;
	

	@BeforeTest
	public void init() {
		System.setProperty("url", "http://automationpractice.com/index.php");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		jsExe = (JavascriptExecutor) driver;
		ss = new ScreenShot(driver);
		d = new Delay(driver);
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
	}

	@BeforeMethod
	public void cekSession() {
		driver.get(System.getProperty("url"));
	}

	@Test(priority = 1)
	public void test_Login_toHomepage() {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.clickSignIn().loginValidUser("rajahutan@gmail.com", "12345").backToHome();
		
		String file = "<img src='file://" + ss.screenShot() + "'height=\"450\" width=\"1017\"/>";
		Reporter.log(file);
		d.delayMS(500);
		
		// verify login success
		assertEquals(home.getCheckLogin(), "Raja Hutan");
	}

	@Test(priority = 2)
	public void test_getProduct_Image_Name_Prize() {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		jsExe.executeScript("window.scrollBy(0, 800)", "");
		
		String file = "<img src='file://" + ss.screenShot() + "'height=\"450\" width=\"1017\"/>";
		Reporter.log(file);
		d.delayMS(500);
		
		// verify image, name, prize of the product list
		assertEquals(home.getCheckImageProduct(), 1, "Image Product ditemukan");
		assertEquals(home.getCheckNameProduct(), 1, "Name Product ditemukan");
		assertEquals(home.getCheckPrizeProduct(), 1, "Prize Product ditemukan");
	}

	@Test(priority = 3)
	public void testCheck_btnQuickView() {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		jsExe.executeScript("window.scrollBy(0, 800)", "");

		// hovering element
		WebElement element = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

		// action
		PopUpDetailPage popUp = home.gotoPopUpDetailPage();
		d.delayMS(3000);
		
		String file = "<img src='file://" + ss.screenShot() + "'height=\"450\" width=\"1017\"/>";
		Reporter.log(file);
		d.delayMS(500);
		
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		while (iterator.hasNext()) {
			String handle = iterator.next();
			if (!handle.contains(parentWindow)) {
				// switch to popup
				driver.switchTo().window(handle);
				
				// verify button quick view
				assertEquals(popUp.getPopUpDetail(), "Faded Short Sleeve T-shirts");
				assertEquals(popUp.getPopUpDetail_product_reference(), "Model demo_1");
				assertEquals(popUp.getPopUpDetail_product_condition(), "Condition New");
				assertEquals(popUp.getPopUpDetail_product_desc(), "Faded short sleeve t-shirt with high neckline. Soft and stretchy material for a comfortable fit. Accessorize with a straw hat and you're ready for summer!");
				assertEquals(popUp.getPopUpDetail_product_prize(), "$16.51");
//				assertEquals(popUp.getPopUpDetail_product_reference(), "Model demo_1");
			}
		}
		// switch back to original window
		driver.switchTo().window(parentWindow);
	}
	
	/*
	@Test(priority = 4)
	public void testCheck_btnMore() {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		jsExe.executeScript("window.scrollBy(0, 800)", "");

		WebElement element = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

		DetailPage detail = home.gotoDetailPage();
		d.delayMS(2000);
		
		String file = "<img src='file://" + ss.screenShot() + "'height=\"450\" width=\"1017\"/>";
		Reporter.log(file);
		d.delayMS(500);
		
		assertEquals(detail.getDetail(), "Faded Short Sleeve T-shirts");
	}

	@Test(priority = 5)
	public void testCheck_btnAddToCart() {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		jsExe.executeScript("window.scrollBy(0, 800)", "");

		WebElement element = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

		CartPage cart = home.gotoCartPage();
		d.delayMS(2000);
		
		String file = "<img src='file://" + ss.screenShot() + "'height=\"450\" width=\"1017\"/>";
		Reporter.log(file);
		d.delayMS(500);
		
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		while (iterator.hasNext()) {
			String handle = iterator.next();
			if (!handle.contains(parentWindow)) {
				driver.switchTo().window(handle);

				// verify button add to cart
				assertEquals(cart.getConfirmationAddToCart(), "Product successfully added to your shopping cart");
			}
		}
		driver.switchTo().window(parentWindow);
	}
	*/
	
}
