package com.naveenautomationlabs.AutomationFramework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver wd;
	FileInputStream fileInputStream;
	Properties prop;

	public TestBase() {
		prop=new Properties();
		try {
			fileInputStream = new FileInputStream(
					"F:\\Eclipse Workspaces for Pivot\\3rd September Batch\\AutomationFramework\\src\\main\\java\\com\\naveenautomationlabs\\AutomationFramework\\Config\\Config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void intialisation() {
		String browserName = prop.getProperty("browser");
		switch (browserName) {
		case "chrome":
			wd = WebDriverManager.chromedriver().create();

			break;
		case "Edge":
			wd = WebDriverManager.edgedriver().create();
			break;
		case "Firefox":
			wd = WebDriverManager.firefoxdriver().create();
			break;

		default:
			System.out.println("Not a valid browser name");
			break;
		}

		wd.get(prop.getProperty("URL"));
		wd.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICT_WAIT")), TimeUnit.SECONDS);
		wd.manage().window().maximize();
	}

	public void tearDown() {
		wd.quit();
	}
}
