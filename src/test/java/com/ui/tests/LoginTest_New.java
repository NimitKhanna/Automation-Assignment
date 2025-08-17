package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pojo.User;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest_New extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Test(description = "verifies with the valid user is login into the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.util.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Cinpok aggra");

	}

	@Test(description = "verifies with the valid user is login into the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.util.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
	public void loginCSVTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Cinpok aggra");

	}

	@Test(description = "verifies with the valid user is login into the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.util.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider")
	public void loginExcelTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Cinpok aggra");

	}

}
