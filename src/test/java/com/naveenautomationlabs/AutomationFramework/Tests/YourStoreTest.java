package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.AccountLogin;
import com.naveenautomationlabs.AutomationFramework.Pages.MyAccount;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class YourStoreTest extends TestBase {

	YourStore yourStore;
	AccountLogin accountLogin;
	MyAccount myAccount;

	@BeforeMethod
	public void setUp() {
		intialisation();
		yourStore = new YourStore();
	}

	@Test
	public void validateLoginUsingValidCredentials() {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.loginToPortal();
		Assert.assertEquals(myAccount.getMyAccountText(), "My Account");
	}

	@Test
	public void testFailure() {
		Assert.assertEquals("Munni", "Munni");
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
