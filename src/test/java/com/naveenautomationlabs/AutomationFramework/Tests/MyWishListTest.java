package com.naveenautomationlabs.AutomationFramework.Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.AccountLogin;
import com.naveenautomationlabs.AutomationFramework.Pages.ForgotYourPassword;
import com.naveenautomationlabs.AutomationFramework.Pages.MyAccount;
import com.naveenautomationlabs.AutomationFramework.Pages.MyWishList;
import com.naveenautomationlabs.AutomationFramework.Pages.MyWishList.MyWishListTable;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;



public class MyWishListTest extends TestBase {

	YourStore yourStore;
	AccountLogin accountLogin;
	ForgotYourPassword forgotYourPassword;
	MyWishList mwlist;

	@BeforeMethod
	public void setUp() {
		intialisation();
		yourStore = new YourStore();
		yourStore.clickMyAccountBtn();
		AccountLogin loginPg = yourStore.clickLoginBtn();
		MyAccount myAccount = loginPg.loginToPortal();
		mwlist = myAccount.clickWishListBtn();

	}
	
	@Test
	public void test2() {
		Assert.assertEquals(false, false)
	}


	@Test(enabled = false)
	public void test1() {
		WebElement element = mwlist.getCellElementFromTable(MyWishListTable.STOCK, "Product 15");
		System.out.println(element.getText());
	}
}
