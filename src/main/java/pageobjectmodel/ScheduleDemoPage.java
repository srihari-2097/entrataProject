package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ScheduleDemoPage {
	WebDriver driver;

	WebElement firstName;
	WebElement LastName;

	public ScheduleDemoPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyScheduleDemoPage() {
		String expectedHomePageTitle = "Entrata | Property Management the Way It Should Be";
		String actualHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
	}

	public void enterFirtsName() throws InterruptedException {
		firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
		firstName.sendKeys("FirstName");
	}

	public void enterLastName() {
		LastName = driver.findElement(By.id("LastName"));
		LastName.sendKeys("LastName");
	}

	public void enterEmail() {
		driver.findElement(By.xpath("//label[@id='LblEmail']/following-sibling::input")).sendKeys("test@abc.com");
	}

	public void enterCompanyName(String Name) {
		driver.findElement(By.name("Company")).sendKeys(Name);
	}

	public void enterPhoneNumber() {
		WebElement PhoneNumber = driver.findElement(By.xpath("//input[@placeholder='Phone Number']"));
		Actions action = new Actions(driver);
		action.sendKeys(PhoneNumber, "0987654321");
		action.perform();
	}

	public void enterJobTitle() {
		driver.findElement(By.cssSelector("#Title")).sendKeys("SDET");
	}

	// Select drop downs Handling
	public void SelectUnitCountDropDownOption(String Option) {
		WebElement UnitCountDropDown = driver.findElement(By.xpath("//select[contains(@id,'Unit_Count')]"));
		Select select = new Select(UnitCountDropDown);
		select.selectByValue(Option);
	}

	public void selectDemoRequestDropDownOption(String Option) {
		WebElement demoRequestDropDown = driver.findElement(By.xpath("//select[@name='demoRequest']"));
		Select select = new Select(demoRequestDropDown);
		select.selectByVisibleText(Option);
	}

	public void verifyVisibilityOfSubmitButton() {
		WebElement SubmitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		boolean flag = SubmitButton.isDisplayed();
		Assert.assertTrue(flag);
	}

	public void verifyMandatoryFieldValidation() {
		firstName.clear();
		firstName.click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[@id='LblFirstName']/../div[2]/div[2]")).isDisplayed());
		LastName.clear();
		LastName.click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[@id='LblLastName']/../div[2]/div[2]")).isDisplayed());
	}

	public void checkVisibilityOfFirstName() {
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='FirstName']")).isDisplayed());
	}
}
