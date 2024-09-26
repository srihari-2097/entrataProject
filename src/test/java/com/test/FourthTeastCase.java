package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import driverFactory.DriversFactory;
import pageobjectmodel.EntrataHomePage;
import pageobjectmodel.ResourcesPage;

public class FourthTeastCase {

	/*
	 * 1.Opened https://www.entrata.com/. 
	 * 2.Verified the https://www.entrata.com/ homepage. 
	 * 3.Accepted all cookies. 
	 * 4.MouseHover on Resources 
	 * 5.Click on All resources 
	 * 6.Click on Guides tab 
	 * 7.Verified Download button for all the Guides
	 * 
	 */

	WebDriver driver;
	DriversFactory drivers;
	EntrataHomePage entrataHomePage;
	ResourcesPage resourcesPage;

	@BeforeMethod
	public void setup() {
		drivers = new DriversFactory();
		driver = drivers.getDriver();
		driver.get("https://www.entrata.com/");
	}

	@Test(description = "Verify that all the guides on the Guides page have a 'Download Now' button.")
	public void Test() {
		entrataHomePage = new EntrataHomePage(driver);
		resourcesPage = new ResourcesPage(driver);

		entrataHomePage.verifyEntrataHomepage();
		entrataHomePage.ClickOnAcceptCookiesButton();

		entrataHomePage.MouserOverOnResources(); 
		entrataHomePage.ClickOnAllResources(); // Clicked on All resource

		resourcesPage.clickOnGuide(); // Clicked on Guide Tab
		resourcesPage.verifyDownloadButtonForGides(); // Verified Download button for all the Guides
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
