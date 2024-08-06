package com.codenbox.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	
	@BeforeClass
    public void configureAppium() throws MalformedURLException {
		Map<String , String> env = new HashMap<String , String>(System.getenv());
		env.put("ANDROID_HOME", "C:\\Users\\ASUS\\AppData\\Local\\Android\\Sdk");
		env.put("JAVA_HOME", "C:\\Program Files\\Java\\jdk-11.0.16.1");
		
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\ASUS\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withTimeout(Duration.ofSeconds(300))
                .build();
        
        service.start();
        
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Automation");
        options.setApp("D:\\code\\appium\\Appium\\src\\resources\\ApiDemos-Debug.Apk");
        
        // Create object for Android driver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
	 public void scrollToEnd() {
    	 //scroll as long as the app has element
   		boolean canScrollMore;
   		do {			
   			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",ImmutableMap.of(
   					"left", 100, "top", 100, "width",200, "height", 200,
   					"direction", "down",
   					"percent",3.0
   					));
   			
   		} while(canScrollMore);
   		
       }
	 
	 public void scrollToElement(String ele) {
		 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"ele\"));"));
			 
	 }

 
      

     
     
     @AfterClass
     public void tearDown() {
    		
 		driver.quit();
 		service.stop();
     }

}