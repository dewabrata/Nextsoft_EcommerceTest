package com.nextsoft.testcom.product.utils;

import org.openqa.selenium.WebDriver;

public class Delay {
	
	protected WebDriver driver;

	public Delay(WebDriver driver) {
		this.driver = driver;
	}
	
	public void delayMS(int inInt) {
		try {
			Thread.sleep(inInt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
