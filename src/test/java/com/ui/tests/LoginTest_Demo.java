package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ui.pages.LoginPage;
import com.ui.pages.MyAccountPage;
import com.utility.BrowserUtility;

public class LoginTest_Demo {

	@Test(description = "verifies with the valid user is login into the application", groups = {"e2e","sanity"})
	public  void loginTest() {
		
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("http://www.automationpractice.pl/index.php?");
		WebElement signInButton=wd.findElement(By.xpath("//a[contains(text(), 'Sign in')]"));
		signInButton.click();
		
		 By emailTextBoxLocator = By.id("email"); WebElement
		 emailtextBoxWebElement=wd.findElement(emailTextBoxLocator);
		 emailtextBoxWebElement.sendKeys("cinipok701@efpaper.com");
		  
		  By passwordTextBoxLocator = By.id("passwd"); WebElement
		 passwordtextBoxWebElement=wd.findElement(passwordTextBoxLocator);
		 passwordtextBoxWebElement.sendKeys("Password");
		  
		  By submitLoginButtonLocator = By.id("SubmitLogin"); WebElement
		  submitLoginButtonWebElement=wd.findElement(submitLoginButtonLocator);
		  submitLoginButtonWebElement.click();
		  
		  MyAccountPage myAccountPage = new MyAccountPage(wd);
		  Assert.assertEquals(myAccountPage.getUserName(), "Cinpok aggra");
		 
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", signInButton);
		 */
		/*
		 * LoginPage loginPage = new LoginPage(driver);
		 * loginPage.doLoginWith("cinipok701@efpaper.com", "Password");
		 */
	}

}
