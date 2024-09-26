package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driverFactory.DriversFactory;
import pageobjectmodel.EntrataHomePage;
import pageobjectmodel.ScheduleDemoPage;

public class FirstTestCase {
	
	/*
	 * 1.Opened https://www.entrata.com/. 
	 * 2.Verified the https://www.entrata.com/ homepage. 
	 * 3.Accepted all cookies. 
	 * 4.Clicked on the "Schedule Your Demo" button.
	 * 5.Implemented multiple window handling. 
	 * 6.Switched to the "Schedule Your Demo" tab. 
	 * 7.Verified the "Schedule Your Demo" page. 
	 * 8.Filled out the form. 
	 * 9.Verified the visibility of the submit button. 
	 * 10.Verified the validation messages for the First Name and Last Name fields.
	 * 
	 */
	
	WebDriver driver;
	DriversFactory drivers;
	EntrataHomePage entrataHomePage;
	ScheduleDemoPage scheduleDemoPage;

	@BeforeMethod
	public void setup() {
		drivers = new DriversFactory();
		driver = drivers.getDriver();
		driver.get("https://www.entrata.com/");
	}

	@Test(description = "Verify the functionality of the Schedule Your Demo form, including form validation and window handling.")
	public void test() throws InterruptedException {
		entrataHomePage = new EntrataHomePage(driver);
		scheduleDemoPage = new ScheduleDemoPage(driver);

		entrataHomePage.verifyEntrataHomepage();
		entrataHomePage.ClickOnAcceptCookiesButton(); 
		entrataHomePage.ClickOnScheduleYourDemo(); //Clicked on the "Schedule Your Demo" button.
		 
		entrataHomePage.SwitchToNewTab(); //Switched to the "Schedule Your Demo" tab.

		scheduleDemoPage.verifyScheduleDemoPage(); //Verified the "Schedule Your Demo" page. 
		
		scheduleDemoPage.enterFirtsName(); //Filled out the form. 
		scheduleDemoPage.enterLastName(); 
		scheduleDemoPage.enterEmail();
		scheduleDemoPage.enterCompanyName("Test Company");
		scheduleDemoPage.enterPhoneNumber();
		scheduleDemoPage.SelectUnitCountDropDownOption("101 - 200"); 
		scheduleDemoPage.enterJobTitle();
		scheduleDemoPage.selectDemoRequestDropDownOption("a Resident");
		
		scheduleDemoPage.verifyVisibilityOfSubmitButton(); //Verified the visibility of the submit button. 
		
		scheduleDemoPage.verifyMandatoryFieldValidation(); //Verified the validation messages for the First Name and Last Name fields.

	}

	@AfterMethod
	public void tearDown() {
		 driver.quit();
	}

}
