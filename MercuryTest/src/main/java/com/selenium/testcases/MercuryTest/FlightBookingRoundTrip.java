package com.selenium.testcases.MercuryTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//TestCase 4:-
//In the Mercury Tours Flight Finder Web page:- 
//Select Type='Round Trip'. 
//By selecting 'Round Trip', should see 'Returning' option  
//Select details from dropdown lists.
//Select 'Business Class' & 'Unified Airlines' from dropdown list.
//Click 'Continue' button.

public class FlightBookingRoundTrip {
	// Round Trip Test
	public void flightRoundTripTestCase(WebDriver driver) {
		// Trip Type
		WebElement roundTrip = driver.findElement(By.xpath("//input[@type='radio' and @value='roundtrip']"));
		// Checking RoundTrip is selected or not
		if (roundTrip.isSelected()) {
			System.out.println("RoundTrip is already selected, no change is requried ");
		} else {
			roundTrip.click();
			System.out.println("RoundTrip is selected ");
		}

		// Passengers Count
		Select Passenger = new Select(driver.findElement(By.xpath("//select[@name='passCount']")));
		Passenger.selectByValue("1");

		// Departure From
		Select DeptFrom = new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		DeptFrom.selectByVisibleText("New York");

		/*
		 * DATE OF DEPARTURE *
		 */
		// Departure Month
		Select fromMonth = new Select(driver.findElement(By.xpath("//select[@name='fromMonth']")));
		fromMonth.selectByIndex(5);

		// Departure Day
		Select fromDay = new Select(driver.findElement(By.xpath("//select[@name='fromDay']")));
		fromDay.selectByVisibleText("5");

		// Destination
		Select toPort = new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		toPort.selectByValue("Seattle");

		/*
		 * DATE OF RETURNING *
		 */
		// Returning Month
		Select toMonth = new Select(driver.findElement(By.xpath("//select[@name='toMonth']")));
		toMonth.selectByVisibleText("June");

		// Returning Day
		Select toDay = new Select(driver.findElement(By.xpath("//select[@name='toDay']")));
		toDay.selectByVisibleText("6");

		// check first class is selected or not
		WebElement FirstClass = driver.findElement(By.xpath("//input[@name='servClass'][@value='Business']"));
		if (FirstClass.isSelected()) {
			System.out.println("Business class is already selected, no change needed");
		} else {
			FirstClass.click();
			System.out.println("Business class is selected");
		}

		// Airline Selection
		Select airline = new Select(driver.findElement(By.xpath("//select[@name='airline']")));
		airline.selectByVisibleText("Unified Airlines");

		// Click Continue button
		driver.findElement(By.xpath("//input[@type='image'][@name='findFlights']")).click();

		// **********Checkpoint to verify that page is loaded and user is logged in
		// successfully**********
		// ***********Check for any Object or Check text***********
		String actualText = driver.findElement(By.xpath("//font[contains(text(),'DEPART')]")).getText();
		String expectedText = "DEPART";

		System.out.println(actualText);
		System.out.println(expectedText);

		if (actualText.equals(expectedText)) {
			System.out.println("FlightBookingRoundTrip Passed");
		} else {
			System.out.println("FlightBookingRoundTrip Failed");
		}

		// Asserts that two Strings are equal. If they are not, an AssertionError is
		// thrown.
		Assert.assertEquals(actualText, expectedText);

	}

}
