package com.selenium.testcases.MercuryTest;

import org.openqa.selenium.WebDriver;

import com.selenium.testcases.MercuryTest.OpenBrowser;
//This test is for automation of Mercury tours Website.
//Function are being created for each functionality

//*********Steps**************
//Create Maven Project
//Add Maven dependencies in pom.xml :-selenium, testng, webdrivermanager, selenium-chrome-driver
//Add package and class
//Define class variables driver
//Set System property for Chrome Driver
//Create Driver
//Open Browser
//Navigate
//Register
//Login
//FindFlights onewayTrip or roundTrip

public class App {
	public static void main(String[] args) {
		OpenBrowser browser = new OpenBrowser();
		WebDriver driver = browser.getDriver();
		browser.chromeBrowser(driver);

		// Test Case Registration
		/*
		 * Registration register = new Registration(); try {
		 * register.registerTestcase(driver); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */

		// Test Case SignIn
		SignIn signIn = new SignIn();
		try {
			signIn.userLogInTestCase(driver);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		 //Test Case OneWayTrip Flights 
		//FlightBookingOneWay flightBooking = new FlightBookingOneWay(); 
		//flightBooking.flightOneWayTestCase(driver);
		 

		// Test Case RoundTrip Flights
		FlightBookingRoundTrip flightBookingRoundTrip = new FlightBookingRoundTrip();
		flightBookingRoundTrip.flightRoundTripTestCase(driver);

		// Test Case Departure and Return flight
		SelectDepReturnflight flightDeptReturnTrip = new SelectDepReturnflight();
		flightDeptReturnTrip.selectDepReturnTestCase(driver);
	}
}
