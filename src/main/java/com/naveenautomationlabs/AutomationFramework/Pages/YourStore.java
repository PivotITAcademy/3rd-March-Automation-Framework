package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class YourStore extends TestBase {

	public YourStore() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "ul.list-inline>li:nth-of-type(2) a")
	private WebElement myAccountBtn;

	@FindBy(css = "ul.dropdown-menu li:nth-of-type(2) a")
	private WebElement loginBtn;

	public YourStore clickMyAccountBtn() {
		myAccountBtn.click();
		return new YourStore();
	}

	public AccountLogin clickLoginBtn() {
		loginBtn.click();
		return new AccountLogin();
	}
}
