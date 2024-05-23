package com.codenbox.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
public class LongPress extends Base {
	@Test
	public void longPressTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'Expandable Lists\']")).click();
		
		driver.findElement(By.id("android:id/text1")).click(); 
		//long click gesture
		WebElement longele = driver.findElement(By.xpath("//android.widget.TextView[@text=\'People Names\']"));
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) longele ).getId()),"duration",2000);
		//Thread.sleep(2000);
		WebElement samplemenu = driver.findElement(By.id("android:id/title"));
		String Peopletext = samplemenu.getText();
		Assert.assertEquals(Peopletext, "Sample menu");
		
		boolean display = samplemenu.isDisplayed();
		Assert.assertTrue(display);
		
	}

}
