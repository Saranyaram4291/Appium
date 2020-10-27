package SDET_Mobile_Activity2.SDET_Mobile_Activity2;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity1 {
	AppiumDriver<MobileElement> driver=null;
	WebDriverWait wait;
	
 
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  
	  DesiredCapabilities caps=new DesiredCapabilities();
	  caps.setCapability("deviceName", "samsung SM-J600G");
      caps.setCapability("deviceId", "3200f02db8c945e5");
      caps.setCapability("platformName", "Android");	
      caps.setCapability("appPackage", "com.android.chrome");	
      caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
      caps.setCapability("noReset", true);
      
      URL app=new URL("http://0.0.0.0:4723/wd/hub");
      driver=new AndroidDriver<MobileElement>(app,caps);
	  
  }
  
  @Test
  public void launchURL() {
	  driver.get("https://www.training-support.net/");
	  
	  wait = new WebDriverWait(driver, 15);
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Training Support']")));
	  
	  String title=driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
	  System.out.println("Page title is"+title);
	  
	  driver.findElementByXPath("//android.view.View[@text='About Us']").click();
	  
	  String newTitle=driver.findElementByXPath("//android.view.View[@text='About Us']").getText();
	  
	  System.out.println("new title is"+newTitle);
	  
	  
	  
	  
	  
  }

  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }

}
