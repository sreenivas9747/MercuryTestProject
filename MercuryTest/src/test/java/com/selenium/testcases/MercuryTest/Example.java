package com.selenium.testcases.MercuryTest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;

public class Example {
	public static WebDriver driver = null;

	@BeforeSuite
	public void SetupTest() {
		OpenBrowser browser = new OpenBrowser();
		driver = browser.getDriver();
		browser.chromeBrowser(driver);
	}

	@Test
	public void RegTestNG() {
		// Test Case Registration
		Registration register = new Registration();
		try {
			register.registerTestcase(driver);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void SignInTestNG() {
		// Test Case SignIn
		SignIn signIn = new SignIn();
		try {
			signIn.userLogInTestCase(driver);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void OneWayTestNG() {
		// Test Case OneWayTrip Flights
		FlightBookingOneWay flightOneWayTestCase = new FlightBookingOneWay();
		// return flightOneWayTestCase.flightOneWayTestCase(driver);
		flightOneWayTestCase.flightOneWayTestCase(driver);
	}

	@Test
	public void RoundTripTestNG() {
		// Test Case RoundTrip Flights
		FlightBookingRoundTrip flightBookingRoundTrip = new FlightBookingRoundTrip();
		flightBookingRoundTrip.flightRoundTripTestCase(driver);
	}

	@Test
	public void DeptRetnTestNG() {
		// Test Case Departure and Return flight
		SelectDepReturnflight flightDeptReturnTrip = new SelectDepReturnflight();
		flightDeptReturnTrip.selectDepReturnTestCase(driver);
	}

	@AfterSuite
	public void CloseTestNG() {
		//Quit the browser
		driver.quit();

	}
}
