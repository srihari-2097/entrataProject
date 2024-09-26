package pageobjectmodel;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SummitPage {
	WebDriver driver;

	public SummitPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifySummitPage() {
		String expectedHomePageTitle = "Entrata Summit 2024 | The Best Week in Multifamily Sept 23-26";
		String actualHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
	}

	public void verifySummitDates(String expectedDate) {
		String actualSummitDate = driver.findElement(By.xpath("//div[@class='summit-dates']")).getText();
		Assert.assertEquals(actualSummitDate, expectedDate);
	}

	public void verifySummitHeading(String expectedHeadline) {
		String actualSummitHeadLine = driver.findElement(By.xpath("//h1[@class='summit-headline']")).getText();
		Assert.assertEquals(actualSummitHeadLine, expectedHeadline);
	}

	public void verifyMainStageSessions(String expected) throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Overview']")).click();
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("(//div[@id='overview']/div/div[2])[1]"));
		String actual = element.getAttribute("id");
		String[] Array = actual.split("-");
		actual = Array[0];
		Assert.assertEquals(actual, expected);
	}

	public void verifyBreakoutSessions(String expected) {
		WebElement element = driver.findElement(By.xpath("(//div[@id='overview']/div/div[2])[2]"));
		String actual = element.getAttribute("id");
		String[] Array = actual.split("-");
		actual = Array[0];
		Assert.assertEquals(actual, expected);
	}

	public void verifyNumberOfDays(String expected) {
		WebElement element = driver.findElement(By.xpath("(//div[@id='overview']/div/div[2])[3]"));
		String actual = element.getAttribute("id");
		String[] Array = actual.split("-");
		actual = Array[0];
		Assert.assertEquals(actual, expected);

	}

	public void verifyKeyNoteGuestAndProfession(Map<String, String> people) throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Keynotes']")).click();
		Thread.sleep(1000);
		for (Map.Entry<String, String> entry : people.entrySet()) {
			String xpath = "//div[@class='keynote-grid-name' and text() ='" + entry.getKey()
					+ "']/following-sibling::div";
			String actulaProfession = driver.findElement(By.xpath(xpath)).getText();

			Assert.assertEquals(actulaProfession.toLowerCase(), entry.getValue().toLowerCase());

		}

	}

}
