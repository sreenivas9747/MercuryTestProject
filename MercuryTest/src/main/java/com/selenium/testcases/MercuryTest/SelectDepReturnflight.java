package com.selenium.testcases.MercuryTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

//TestCase 5:-
//In the Mercury Tours departure and return flight  Web page:- 
//Select Unified Airlines 363 for both deprature and return flights 
//Click 'Continue' button.

public class SelectDepReturnflight {

	// Departure and Return flight Test
	public void selectDepReturnTestCase(WebDriver driver) {

		// Departure Flight Details
		WebElement DepAirline = driver
				.findElement(By.xpath("//input[contains(@value,'Unified Airlines$363$281$11:24')]"));

		if (DepAirline.isSelected()) {
			System.out.println("Unified Airlines is already selected, no change is requried ");
		} else {
			DepAirline.click();
			System.out.println("Unified Airlines Dept flight is sucessfully selected ");
		}

		// Return Flight Details
		WebElement ReturnAirline = driver
				.findElement(By.xpath("//input[contains(@value,'Unified Airlines$633$303$18:44')]"));
		if (ReturnAirline.isSelected()) {
			System.out.println("Unified Airlines is already selected, no change is requried ");
		} else {
			ReturnAirline.click();
			System.out.println("Unified Airlines Return is sucessfully selected ");
		}

		driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();

		// **********Checkpoint to verify that page is loaded and user is logged in
		// successfully**********
		// ***********Check for any Object or Check text or Check Title***********

		String actText = driver.findElement(By.xpath("//font[contains(text(),'Summary')]")).getText();
		String expeText = "Summary";

		// Validation 
		if (actText.equals(expeText)) {
			System.out.println("Departure&Return flight Validation Test Passed");
		} else {
			System.out.println("Departure&Return flight Validation Test Failed");
		}
		System.out.println(actText);
		System.out.println(expeText);

		// Asserts that two Strings are equal. If they are not, an AssertionError is
		// thrown.
		Assert.assertEquals(actText, expeText);

	}

}
