package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.AccountLogin;
import com.naveenautomationlabs.AutomationFramework.Pages.ForgotYourPassword;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.Utils.ExcelUtils;
import com.naveenautomationlabs.AutomationFramework.Utils.Utils;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class AccountLoginTest extends TestBase {

	YourStore yourStore;
	AccountLogin accountLogin;
	ForgotYourPassword forgotYourPassword;

	@BeforeMethod
	public void setUp() {
		intialisation();
		yourStore = new YourStore();
	}
	
	@Test
	public void exampleTest() {
		System.out.println("This is a test");
		Assert.assertTrue(true);
	}

	@Test
	public void validateLoginUsingValidCredentials() {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		forgotYourPassword = accountLogin.clickForgotPassword();
		forgotYourPassword.enterEmail();
		forgotYourPassword.clickContinueBtn();
		Assert.assertEquals(accountLogin.getPasswordResetLinkSuccessMessageText(),
				"An email with a confirmation link has been sent your email address.");
	}

	@Test(dataProvider = "Munni")
	public void loginTest(String username, String password) throws Exception {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		accountLogin.enterEmail(username);
		accountLogin.enterPassword(password);
		accountLogin.clickLoginBtn();
		System.out.println(wd.getTitle());
	}

	@DataProvider(name = "Munni")
	public Object[][] getDataFromExcelSheet() throws Exception {
		logger.info("Data Provider get executed");
		String filePath = "C:\\Users\\Owner\\Desktop\\TestData.xlsx";
		int rowCnt = ExcelUtils.getRowCount(filePath, "Sheet1");
		int ColCnt = ExcelUtils.getCellCount(filePath, "Sheet1", rowCnt);
		String[][] virtualSheet = new String[rowCnt][ColCnt];
		for (int i = 1; i <= rowCnt; i++) {
			for (int j = 0; j < ColCnt; j++) {
				virtualSheet[i - 1][j] = ExcelUtils.getCellData(filePath, "Sheet1", i, j);

			}
		}
		return virtualSheet;

	}

	@AfterMethod
	public void quit() {
		tearDown();
	}
}
