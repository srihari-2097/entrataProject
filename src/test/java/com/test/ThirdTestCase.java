package com.test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import driverFactory.DriversFactory;
import pageobjectmodel.EntrataHomePage;

public class ThirdTestCase {

	/*
	 * 1.Opened https://www.entrata.com/. 
	 * 2.Verified the https://www.entrata.com/ homepage. 
	 * 3.Accepted all cookies. 
	 * 4.Opened multiple pages in Product sections and verified 
	 * 5.Opened multiple pages in Solution sections and verified
	 * 
	 */

	WebDriver driver;
	DriversFactory drivers;
	EntrataHomePage entrataHomePage;

	Map<String, String> ProductPageList = new HashMap<>();
	Map<String, String> SolutionsPageList = new HashMap<>();

	@BeforeMethod
	public void setup() {
		drivers = new DriversFactory();
		driver = drivers.getDriver();
		driver.get("https://www.entrata.com/");
	}

	@Test(description = "Verify that the application correctly navigates to multiple pages and ensures each page is opened successfully.")
	public void Test() throws InterruptedException {
		entrataHomePage = new EntrataHomePage(driver);

		ProductPageList.put("Access Connect", "Entrata Access Control | Smart Home Solutions for your Properties");
		ProductPageList.put("Message Center", "Message Center by Entrata | Property Communication Software");
		ProductPageList.put("Digital Marketing Bundle", "Digital Marketing Services for Real Estate Properties");
		ProductPageList.put("ResidentVerify", "ResidentVerify by Entrata | Applicant Screening done right.");
		ProductPageList.put("General Accounting",
				"General Accounting by Entrata | Accounting tools and financial reporting");
		ProductPageList.put("Sales Tax Audits", "Sales Tax Audits for Property Management Companies");

		SolutionsPageList.put("Multifamily", "Multifamily Property Management Software | Entrata");
		SolutionsPageList.put("Training Services",
				"Entrata Onboarding and Training Services | Let our experts take of everything.");

		entrataHomePage.verifyEntrataHomepage();
		entrataHomePage.ClickOnAcceptCookiesButton();
		entrataHomePage.verifyProductPages(ProductPageList); // Opened multiple pages in Product sections and verified
		entrataHomePage.verifySolutionsPages(SolutionsPageList); // Opened multiple pages in Solution sections and  verified
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
