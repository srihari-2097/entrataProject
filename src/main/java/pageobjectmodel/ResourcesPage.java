package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.List;
import org.openqa.selenium.WebElement;

public class ResourcesPage {
	WebDriver driver;

	public ResourcesPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyResourcePage() {
		String expectedHomePageTitle = "Helpful Resources for the Multifamily Industry";
		String actualHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
	}

	public void clickOnGuide() {
		driver.findElement(By.xpath("//div[text()='Guides']/..")).click();
	}

	public void verifyDownloadButtonForGides() {
		List<WebElement> downloadButtonList = driver.findElements(By.xpath(
				"//div[@data-w-tab='Guides']/div/div[contains(@class,'collection')]/div/div/div[2]/div[2]/a/div[text()='Download Now']"));

		List<WebElement> guideList = driver
				.findElements(By.xpath("//div[@data-w-tab='Guides']/div/div[contains(@class,'collection')]/div/div"));

		Assert.assertEquals(downloadButtonList.size(), guideList.size());
	}

	public void clickOnWebinarsTab() {
		driver.findElement(By.xpath("//div[text()='Webinars']/parent::a")).click();
	}

	public void clickOnWatchNow() {
		WebElement element = driver.findElement(By.xpath("(//div[text()='Watch Now'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
}
