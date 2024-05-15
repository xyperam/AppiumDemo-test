package com.codenbox.Appium;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
public class Base {

	@Test
	public void configureAppium() throws MalformedURLException{
		//create capablities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Automation");
		options.setApp("D:\\code\\appium\\Appium\\src\\resources\\ApiDemos-Debug.Apk");
		//create object for android driver
		//AndroidDriver driver = new AndroidDriver(new URL( "http://192.168.160.155:4723"), options);
		AndroidDriver driver = new AndroidDriver(new URL( "http://192.168.160.155:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
		driver.quit();
		
	}
}
