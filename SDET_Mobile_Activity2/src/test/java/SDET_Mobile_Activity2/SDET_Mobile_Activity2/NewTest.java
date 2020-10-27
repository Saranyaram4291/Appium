package SDET_Mobile_Activity2.SDET_Mobile_Activity2;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest {
	
	  AppiumDriver<MobileElement> driver=null;
	  WebDriverWait wait;
  @Test
  public void calcMultiply() {
	  
	  driver.findElementById("com.sec.android.app.popupcalculator:id/bt_08").click();
	  driver.findElementByAccessibilityId("Multiplication").click();
	  driver.findElementById("com.sec.android.app.popupcalculator:id/bt_04").click();
	  driver.findElementByAccessibilityId("Equal").click();
	  String value=driver.findElementByAccessibilityId("Calculator input field").getText();
	  Assert.assertEquals(value,"32");
  }
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	
	  
      DesiredCapabilities caps = new DesiredCapabilities();  	
      caps.setCapability("deviceName", "samsung SM-J600G");
      caps.setCapability("deviceId", "3200f02db8c945e5");
      caps.setCapability("platformName", "Android");	
      caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");	
      caps.setCapability("appActivity", ".Calculator");
      caps.setCapability("noReset", true);
      
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
  	
      driver = new AndroidDriver<MobileElement>(appServer, caps);
	
      wait = new WebDriverWait(driver, 5);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
