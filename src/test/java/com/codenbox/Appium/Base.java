package com.codenbox.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    // Run Appium server automatically
    @BeforeTest
    public void configureAppium() {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\ASUS\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withTimeout(Duration.ofSeconds(300))
                .build();
        
        service.start();
    }

    @Test
    public void startDriver() throws MalformedURLException {
        // Create capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Automation");
        options.setApp("D:\\code\\appium\\Appium\\src\\resources\\ApiDemos-Debug.Apk");

        // Create object for Android driver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Perform any actions or tests here
        driver.quit();
    }

    @AfterTest
    public void tearDown() {
        if (service != null) {
            service.stop();
        }
    }
}