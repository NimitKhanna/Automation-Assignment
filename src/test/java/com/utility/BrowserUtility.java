package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		// goToWebSite("http://www.automationpractice.pl/index.php?");
	}

	public BrowserUtility(String browserName) {
		logger.info("Launching browser for" + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());

		}

		else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}

		else {
			logger.error("Invalid browser name....Please select chrome or edge only");
			System.err.print("Invalid browser name......Please select chrome or edge");
		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching browser for" + browserName);

		if (browserName == Browser.CHROME) {

			driver.set(new ChromeDriver());
		}

		else if (browserName == Browser.EDGE) {

			driver.set(new EdgeDriver());
		}

		else if (browserName == Browser.FIREFOX) {

			driver.set(new FirefoxDriver());
		}

	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching browser for" + browserName);

		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old"); // It loads browser in headless mode
				options.addArguments("--window-size=1920,1080");// resolution of browser is in full screen mode
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}
		}

		else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");// It ensures that headless browser does not launch with UI in case
				driver.set(new EdgeDriver(options)); // headless doesn't work

			} else {

				driver.set(new EdgeDriver());

			}
		}

		else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
			} else {
				driver.set(new FirefoxDriver());
			}
		}

	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void clickOn(By locator) {
		logger.info("Finding element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now performing click");
		element.click();// Here return type of locator is By, so we use By in parameter
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now enter text" + textToEnter);
		element.sendKeys(textToEnter);
	}

	public void goToWebSite(String url) {
		logger.info("Visiting the website" + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}

	public void clickUsingJavascript(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now returning the visible text" + element.getText());
		return element.getText();
	}

	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timestamp = format.format(date);
		String path = System.getProperty("user.dir") + "//screenshots//" + name + " - " + timestamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyDirectory(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	

}
