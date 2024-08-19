package com.codenbox.Appium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class HybridTest extends Base{
	@Test
	public void doHybrid() throws InterruptedException {
		driver.findElement(By.id("android:id/text1")).click();
	     driver.findElement(AppiumBy.androidUIAutomator(
	             "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Argentina\"));"
	         )).click(); 
		
		//driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\'Canada\']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ilham");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\'com.androidsample.generalstore:id/btnLetsShop\']")).click();
		
		//find air jordan 9
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Air Jordan 9 Retro\"));"
				));
		//select air jordan 9
		// Mendapatkan daftar semua elemen dengan ID "productName"
		List<WebElement> products = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));

		// Mendapatkan daftar semua tombol "Add to Cart" yang sesuai dengan ID "productAddCart"
		List<WebElement> addToCartButtons = driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));

		// Menghitung jumlah produk yang ditemukan
		int count = products.size();

		for(int i = 0; i < count; i++) {
		    // Mendapatkan nama produk dari elemen dalam list
		    String productName = products.get(i).getText();
		    
		    // Memeriksa apakah nama produk cocok dengan "Air Jordan 9 Retro"
		    if(productName.equalsIgnoreCase("Air Jordan 9 Retro")) {
		        // Mengklik tombol "Add to Cart" yang sesuai dengan produk tersebut
		        addToCartButtons.get(i).click();
		    }
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(7001);
		
		//type in google search
		Set<String> contextNames = driver.getContextHandles();
		
		for(String contextName : contextNames) {
			System.out.print(contextName); //prints something like native_APP
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		Thread.sleep(20001);
		driver.findElement(By.name("q")).sendKeys("test");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(20001);
		driver.context("NATIVE_APP");
		
		

	}
}
