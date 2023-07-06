package com.naveenautomationlabs.AutomationFramework.Pages;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class MyWishList extends TestBase {

	// get the WebElement From the Table
	public WebElement getCellElementFromTable(MyWishListTable colum, String modelName) {
		int columnIndex = getIndexOfColumn(colum);
		if (columnIndex < 0) {
			throw new NoSuchElementException();
		}
		List<WebElement> rowsWebElement = wd.findElements(By.cssSelector("div.table-responsive table.table tbody tr"));
		for (int i = 0; i < rowsWebElement.size(); i++) {
			List<WebElement> cells = rowsWebElement.get(i).findElements(By.cssSelector("td"));
			if (cells.get(2).getText().equals(modelName)) {
				return cells.get(columnIndex);
			}
		}

		return null;
	}

	// Find the index of column that we are interested in
	private int getIndexOfColumn(MyWishListTable columnName) {
		List<WebElement> headers = wd.findElements(By.cssSelector("table.table thead tr td"));
		for (WebElement headerElement : headers) {
			if (headerElement.getText().equals(columnName.value)) {
				return headers.indexOf(headerElement);
			}
		}

		return -1;
	}

	// Created a Structure of my Webtable
	public enum MyWishListTable {

		IMAGE("Image"), 
		PRODUCT_NAME("Product Name"), 
		MODEL("Model"), STOCK("Stock"),
		UNIT_PRICE("Unit Price"),
		ACTION("Action");

		String value;

		private MyWishListTable(String value) {
			this.value = value;
		}

		public String getTableHeaderValue() {
			return value;
		}
	}

}
