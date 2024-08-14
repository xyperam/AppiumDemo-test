package com.codenbox.Appium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class GeneralStoreTest extends Base {
	@Test (enabled = false)
	public void DropdownTest() {
		driver.findElement(By.id("android:id/text1")).click();
	     driver.findElement(AppiumBy.androidUIAutomator(
	             "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Indonesia\"));"
	         )).click(); 
		
		//driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\'Canada\']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ilham");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\'com.androidsample.generalstore:id/btnLetsShop\']")).click();
	}
	@Test
	public void ToastMsgTest() {
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\'com.androidsample.generalstore:id/btnLetsShop\']")).click();
		String toastMsg = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		Assert.assertEquals(toastMsg, "Please enter your name");
		
	}
}
