package com.codenbox.Appium;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollTest extends Base {
	@Test
	public void scrollTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		scrollToElement("WebView");
		//scrollToEnd();
	}
}
