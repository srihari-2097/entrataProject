package pageobjectmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import groovyjarjarantlr4.v4.codegen.model.Action;

public class EntrataHomePage {
	WebDriver driver;

	public EntrataHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyEntrataHomepage() {
		String expectedHomePageTitle = "Property Management Software | Entrata";
		String actualHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
	}

	public void ClickOnAcceptCookiesButton() {
		driver.findElement(By.xpath("//a[text()='Accept Cookies']")).click();
	}

	public void ClickOnScheduleYourDemo() {
		WebElement element = driver.findElement(By.xpath("//div[text()='Schedule Your Demo']/parent::a"));
		element.click();
	}

	public void SwitchToNewTab() {
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(windowHandles);
		driver.switchTo().window(tabs.get(1));
	}

	public void ClickSummitLink() {
		WebElement element = driver.findElement(By.xpath("(//a[text()='Summit'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void MouserOverOnProducts() {
		WebElement element = driver.findElement(By.xpath("//div[text()='Products']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void MouserOverOnSolution() {
		WebElement element = driver.findElement(By.xpath("//div[text()='Solutions']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void MouserOverOnResources() {
		WebElement element = driver.findElement(By.xpath("//div[text()='Resources']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void verifyProductPages(Map<String, String> productPageList) throws InterruptedException {
		for (Map.Entry<String, String> entry : productPageList.entrySet()) {
			MouserOverOnProducts();
			Thread.sleep(1000);
			String xpath = "(//a[text()='".concat(entry.getKey()).concat("'])[1]");
			WebElement element = driver.findElement(By.xpath(xpath));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			String actualTest = driver.getTitle();
			Assert.assertEquals(actualTest, entry.getValue());
		}
	}

	public void verifySolutionsPages(Map<String, String> productPageList) throws InterruptedException {
		for (Map.Entry<String, String> entry : productPageList.entrySet()) {
			MouserOverOnSolution();
			Thread.sleep(1000);
			String xpath = "(//a[text()='".concat(entry.getKey()).concat("'])[1]");
			WebElement element = driver.findElement(By.xpath(xpath));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			String actualTest = driver.getTitle();
			Assert.assertEquals(actualTest, entry.getValue());
		}
	}

	public void ClickOnAllResources() {
		WebElement element = driver.findElement(By.xpath("//h3[text()='All Resources']/.."));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

}
