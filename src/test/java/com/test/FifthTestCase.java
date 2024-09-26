package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driverFactory.DriversFactory;
import pageobjectmodel.EntrataHomePage;
import pageobjectmodel.ResourcesPage;
import pageobjectmodel.ScheduleDemoPage;

public class FifthTestCase {

	/*
	 * 1.Opened https://www.entrata.com/. 
	 * 2.Verified the https://www.entrata.com/ homepage. 
	 * 3.Accepted all cookies. 
	 * 4.MouseHover on Resources 
	 * 5.Click on All resources 
	 * 6.Click on Webinars tab 
	 * 7.Click on watch now button for one of Webinars 
	 * 8.Registration page opened and verified
	 * 
	 */
	
	WebDriver driver;
	DriversFactory drivers;
	EntrataHomePage entrataHomePage;
	ResourcesPage resourcesPage;
	ScheduleDemoPage scheduleDemoPage;

	@BeforeMethod
	public void setup() {
		drivers = new DriversFactory();
		driver = drivers.getDriver();
		driver.get("https://www.entrata.com/");
	}

	@Test(description = "Verify that a user is not able to watch the webinar if they are not registered.")
	public void Test() {
		entrataHomePage = new EntrataHomePage(driver);
		resourcesPage = new ResourcesPage(driver);
		scheduleDemoPage = new ScheduleDemoPage(driver);

		entrataHomePage.verifyEntrataHomepage();
		entrataHomePage.ClickOnAcceptCookiesButton();

		entrataHomePage.MouserOverOnResources();
		entrataHomePage.ClickOnAllResources(); // Clicked on All resource

		resourcesPage.verifyResourcePage(); // Verified All resource page
		resourcesPage.clickOnWebinarsTab(); // Clicked on Webinars tab
		resourcesPage.clickOnWatchNow(); // Clicked on Watch now button
		entrataHomePage.SwitchToNewTab(); // Switched new tab
		scheduleDemoPage.checkVisibilityOfFirstName(); // Verified Registration form

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
