package com.codenbox.Appium;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollTest extends Base {
	@Test
	public void scrollTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));"));
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"WebView\"));"));
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"WebView\")"));
		
	}
}
