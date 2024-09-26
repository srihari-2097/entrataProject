package com.test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import driverFactory.DriversFactory;
import pageobjectmodel.EntrataHomePage;
import pageobjectmodel.SummitPage;

public class SecondTestCase {

	/*
	 * 1.Opened https://www.entrata.com/. 
	 * 2.Verified the https://www.entrata.com/ homepage.
	 *  3.Accepted all cookies. 
	 *  4.Clicked on the SummitLink. 
	 *  5.Implemented multiple window handling.
	 *  6.Switched to the "Summit Page" tab. 
	 *  7.Verified the "Summit" page.
	 *  8.Verified Summit date and Heading 
	 *  9.Verified Summit overview details.
	 *  10.Verified Guests and their Professions in Keynote Section.
	 * 
	 */

	WebDriver driver;
	DriversFactory drivers;
	EntrataHomePage entrataHomePage;
	SummitPage summitPage;

	// Declaring excepted data
	String expectedEventDates = "SEPT. 23-26";
	String expectedEventHeading = "THE BEST WEEK IN MULTIFAMILY";
	String expectedNumberOfMainStageSessions = "11";
	String expectedNumberOfBreakoutSessions = "24";
	String expectedNumberOfDays = "03";

	Map<String, String> people = new HashMap<>();

	@BeforeMethod
	public void setup() {
		drivers = new DriversFactory();
		driver = drivers.getDriver();
		driver.get("https://www.entrata.com/");
	}

	@Test(description = "Verify the functionality of the Summit page and check dynamic data such as the Date, Summit heading, number of sessions, guest list, and their respective professions.")
	public void Test() throws InterruptedException {
		// Declaring excepted data
		people.put("Katie Ledecky", "U.S. Olympian & World Champion Swimmer");
		people.put("Jerry Seinfeld", "Comedian");
		people.put("Nick Saban", "Legendary College Football Coach");
		people.put("Lupe Fiasco", "Rapper & Producer");
		people.put("Yara Shahidi", "Actor, Producer, & Change Agent");

		entrataHomePage = new EntrataHomePage(driver);
		summitPage = new SummitPage(driver);

		entrataHomePage.verifyEntrataHomepage(); // Verified Home page
		entrataHomePage.ClickOnAcceptCookiesButton();

		entrataHomePage.ClickSummitLink(); // Click on Summit link on Home page
		entrataHomePage.SwitchToNewTab(); // Switch to Summit page tab

		summitPage.verifySummitPage(); // Verified Summit page
		summitPage.verifySummitDates(expectedEventDates); // Verified Summit date
		summitPage.verifySummitHeading(expectedEventHeading); // Verified Summit title

		summitPage.verifyMainStageSessions(expectedNumberOfMainStageSessions); // Verified MainStageSessions number
		summitPage.verifyBreakoutSessions(expectedNumberOfBreakoutSessions); // Verified BreakoutSessions number
		summitPage.verifyNumberOfDays(expectedNumberOfDays); // Verified Days number
		summitPage.verifyKeyNoteGuestAndProfession(people); // Verified Guest name with their professions
	}

	@AfterMethod
	public void testDown() {
		driver.quit();
	}
}
