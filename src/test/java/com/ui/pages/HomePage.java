package com.ui.pages;

import java.sql.Driver;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), 'Sign in')]");

	public HomePage(Browser chrome, boolean isHeadless) {
		super(chrome, isHeadless); // To call the parent class constructor from child class constructor
		// goToWebSite("http://www.automationpractice.pl/index.php?");
		goToWebSite(JSONUtility.readJson(QA).getUrl());
	}

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		goToWebSite(JSONUtility.readJson(QA).getUrl());
	}

	public LoginPage goToLoginPage() {
		logger.info("Trying to perform click to go to sign in page");

		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

}
