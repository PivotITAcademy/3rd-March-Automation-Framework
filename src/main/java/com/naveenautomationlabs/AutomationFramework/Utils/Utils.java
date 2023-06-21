package com.naveenautomationlabs.AutomationFramework.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class Utils extends TestBase {

	
	public static void takeScreenShot() {
		String timeStamp=new SimpleDateFormat("dd/mm/YYYY HH:mm:ss").format(new Date());
		System.out.println(timeStamp);

	}

}
