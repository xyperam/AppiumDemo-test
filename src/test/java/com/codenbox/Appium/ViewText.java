package com.codenbox.Appium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
//Validate text 
public class ViewText extends Base{
	@Test
	public void ViewTextTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Buttons']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='Normal']")).click();
		
		String normalBtn = driver.findElement(By.id("io.appium.android.apis:id/button_normal")).getText();
		Assert.assertEquals(normalBtn, "Normal");
		
	}

}
