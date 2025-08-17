package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver wd = new ChromeDriver();// Launch a browser window/browser session is created

		BrowserUtility browserUtility = new BrowserUtility(wd);
		browserUtility.goToWebSite("http://www.automationpractice.pl/index.php?");
		browserUtility.maximizeWindow();

		By signInLinkLocator = By.xpath("//a[contains(text(),\"Sign in\")]");
		browserUtility.clickOn(signInLinkLocator);
		
		  
		  By emailTextBoxLocator = By.id("email");
		  browserUtility.enterText(emailTextBoxLocator, "cinipok701@efpaper.com");
		  
		  By passwordTextBoxLocator = By.id("passwd");
		  browserUtility.enterText(passwordTextBoxLocator, "Password");
		  
		  By submitLoginButtonLocator = By.id("SubmitLogin");
		  browserUtility.clickOn(submitLoginButtonLocator);
		 

		/*
		 * wd.get("http://www.automationpractice.pl/index.php?");// go to the website
		 * //maximize the browser window wd.manage().window().maximize(); By
		 * signInLinkLocator=By.xpath("//a[contains(text(),\"Sign in\")]"); WebElement
		 * signInLinkWebElement = wd.findElement(signInLinkLocator);
		 * signInLinkWebElement.click();
		 * 
		 * By emailTextBoxLocator = By.id("email"); WebElement
		 * emailtextBoxWebElement=wd.findElement(emailTextBoxLocator);
		 * emailtextBoxWebElement.sendKeys("cinipok701@efpaper.com");
		 * 
		 * By passwordTextBoxLocator = By.id("passwd"); WebElement
		 * passwordtextBoxWebElement=wd.findElement(passwordTextBoxLocator);
		 * passwordtextBoxWebElement.sendKeys("Password");
		 * 
		 * By submitLoginButtonLocator = By.id("SubmitLogin"); WebElement
		 * submitLoginButtonWebElement=wd.findElement(submitLoginButtonLocator);
		 * submitLoginButtonWebElement.click();
		 */

	}

}
