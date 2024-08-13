package com.codenbox.Appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class GeneralStoreTest extends Base {
	@Test
	public void DropdownTest() {
		driver.findElement(By.id("android:id/text1")).click();
	     driver.findElement(AppiumBy.androidUIAutomator(
	             "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Canada\"));"
	         )).click(); 
		
		//driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\'Canada\']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ilham");
		
	}
}
