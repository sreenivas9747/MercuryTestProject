package com.selenium.testcases.MercuryTest;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

//TestCase 2:-
//Open the Mercury Tours Web site (http://newtours.demoaut.com) 
//Mercury Tours Website welcome page opens.
//enter the User Name and Password to Sign-In. 
//The Flight Finder page opens.

public class SignIn {
	public void userLogInTestCase(WebDriver driver) throws InterruptedException {
		driver.findElement(By.linkText("Home")).click();
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.xpath("//input[@name='login']")).click();

		// Sync
		//Thread.sleep(2000);
		// **********Checkpoint to verify that page is loaded and user is logged in
		// successfully**********
		// ***********Check for any Object or Check text***********
		boolean objectDisplayed = driver.findElement(By.xpath("//img[@src = '/images/masts/mast_flightfinder.gif']"))
				.isDisplayed();
		if (objectDisplayed == true) {
			System.out.println("login successful.");
		} else {
			System.out.println("login failed.");
		}

	}

}
