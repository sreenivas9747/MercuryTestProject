package com.selenium.testcases.MercuryTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Registration {
	// TestCase 1:-
	// Registering Page: - Registration form would be used for registering a new
	// user
	public void registerTestcase(WebDriver driver) throws InterruptedException {
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("TUserName");
		driver.findElement(By.cssSelector("input[name=lastName]")).sendKeys("TLastName");
		driver.findElement(By.xpath("//input[contains(@name,'phone')]")).sendKeys("0123456789");
		driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("testemail@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("Dublin");
		driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("Ireland");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Dublin");
		driver.findElement(By.name("state")).sendKeys("County Dublin");
		driver.findElement(By.xpath("//input[contains(@name,'postalCode')]")).sendKeys("BT48 7NR");

		// Select the country from the dropdown list
		// Selecting an option by selectByIndex() or selectByValue or
		// selectByVisibleText()
		Select s = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		s.selectByVisibleText("IRELAND");

		driver.findElement(By.id("email")).sendKeys("testUserid");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pwd123");
		driver.findElement(By.name("confirmPassword")).sendKeys("pwd123");
		driver.findElement(By.xpath("//input[@type='image'][@name='register']")).click();

		// sync
		// Thread.sleep(5000);

		// capture the title of registration page and compare with expected title.
		String actTitle = driver.getTitle();
		String ExpectedTitle = "Register: Mercury Tours";

		if (actTitle.equals(ExpectedTitle)) {
			System.out.println("Registration Passed");
		} else {
			System.out.println("Registration Failed");
		}

		// Asserts that two Strings are equal. If they are not, an AssertionError is
		// thrown.
		Assert.assertEquals(actTitle, ExpectedTitle);

	}
}
