package com.selenium.testcases.MercuryTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//TestCase 3:-
//In the Mercury Tours Flight Finder Web page:- 
//Select Type='One Way'. 
//By selecting 'One Way', if you see 'Returning' option  
// fail the test case
public class FlightBookingOneWay {
	
	    // One Way trip 
	public void flightOneWayTestCase(WebDriver driver) {
		// Trip Type
		WebElement oneWaySelected=driver.findElement(By.xpath("//input[@type='radio' and @value='oneway']"));
		//Checking  radio button 'One Way' is Selected or Not. 
		if(oneWaySelected.isSelected()) {
			System.out.println("oneWay option is already selected");
		}else {
			oneWaySelected.click();
			System.out.println("oneWay option is selected");
		}

		// Passengers Count
		Select Passenger = new Select(driver.findElement(By.xpath("//select[@name='passCount']")));
		Passenger.selectByValue("1");

		// Departure From
		Select DeptFrom = new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		DeptFrom.selectByVisibleText("London");
		
		/*
		 * DATE OF DEPARTURE *
		 */
		// Departure Month
		Select fromMonth = new Select(driver.findElement(By.xpath("//select[@name='fromMonth']")));
		fromMonth.selectByIndex(5);

		// Departure Day
		Select fromDay = new Select(driver.findElement(By.xpath("//select[@name='fromDay']")));
		fromDay.selectByVisibleText("10");
		
		// Arriving Day
		Select arriveDay=new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		arriveDay.selectByValue("San Francisco");
		
		//Fail the test, if you see 'Returning' option is available 
		String returning=driver.findElement(By.xpath("//b[contains(text(),'Returning:')]")).getText();
		String expectedRetrun ="Returning:";
		
		System.out.println("Test" + returning);
		
		//Validating actual Vs expected 
		assertEquals((returning).equalsIgnoreCase(expectedRetrun), false);
		

	/*	// Destination
		Select toPort = new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		toPort.selectByValue("New York");
		
		 * DATE OF ARRIVAL *
		 * 		 
		// Arrival Month
		Select toMonth = new Select(driver.findElement(By.xpath("//select[@name='toMonth']")));
		toMonth.selectByVisibleText("February");

		// Arrival Day
		Select toDay = new Select(driver.findElement(By.xpath("//select[@name='toDay']")));
		toDay.selectByVisibleText("15");

		// check first class is selected or not
		WebElement serviceClass = driver.findElement(By.xpath("//input[@name='servClass'][@value='First']"));
		if (serviceClass.isSelected()) {
			System.out.println("First Class is already selected, no change needed");
		} else {
			serviceClass.click();
		}

		// Airline Selection
		Select airline = new Select(driver.findElement(By.xpath("//select[@name='airline']")));
		airline.selectByVisibleText("Blue Skies Airlines");
		driver.findElement(By.xpath("//input[@type='image'][@name='findFlights']")).click();*/
		
		//return driver.findElement(By.xpath("")).toString(); // 
	}	

}
