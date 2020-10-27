package ProjectActivity;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	AppiumDriver<MobileElement> driver=null;
	WebDriverWait wait;
	
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  
	  DesiredCapabilities caps=new DesiredCapabilities();
	  caps.setCapability("deviceName", "samsung SM-J600G");
      caps.setCapability("deviceId", "3200f02db8c945e5");
      caps.setCapability("platformName", "Android");	
      caps.setCapability("appPackage", "com.google.android.keep");	
      caps.setCapability("appActivity", ".activities.BrowseActivity");
      caps.setCapability("noReset", true);
      
      URL app=new URL("http://0.0.0.0:4723/wd/hub");
      driver=new AndroidDriver<MobileElement>(app,caps);
  }
  
  @Test
  public void f() throws InterruptedException {
	  
	  driver.findElementByAccessibilityId("New text note").click();
	  
	  driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Add title1");
	  
	  driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Test desc1");
  
	  driver.findElementByAccessibilityId("Single-column view").click();
	  
	  driver.findElementById("com.google.android.keep:id/time_spinner").click();
	  
	  Thread.sleep(3000);
	 // wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("text(\"Afternoon\")")));
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Afternoon\")")).click();
	  
	  driver.findElementById("com.google.android.keep:id/save").click();
	  
	  driver.findElementByAccessibilityId("Open navigation drawer").click();
	  
	  
	 String result=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Test desc1\")")).getText();
		 
	Assert.assertEquals(result,"Test desc1");
	  
	  
  }
  @AfterClass
  public void afterClass() {
  }

}
