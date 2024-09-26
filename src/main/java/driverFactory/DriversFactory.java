package driverFactory;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriversFactory {
	private static final Logger logger = LogManager.getLogger(DriversFactory.class);
	WebDriver driver;
	
	public DriversFactory() {
		launchChromebrowser();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void launchChromebrowser() {
		logger.info("Starting ChromeDriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		logger.info("ChromeDriver Started Successfully");
		logger.info("Start of Window Maximize");
		driver.manage().window().maximize();
		logger.info("End of Window Maximize");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
