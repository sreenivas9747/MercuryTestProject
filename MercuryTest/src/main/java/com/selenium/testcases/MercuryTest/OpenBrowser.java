package com.selenium.testcases.MercuryTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {
	public static WebDriver driver;

	public OpenBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
	}

	public void chromeBrowser(WebDriver driver) {
		driver.get("http://newtours.demoaut.com/");
		String title = driver.getTitle();
		System.out.println(title);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		OpenBrowser.driver = driver;

	}
}
