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

public class Activity2_1 {
 
	AppiumDriver<MobileElement> driver=null;
	WebDriverWait wait;
	
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  
	  DesiredCapabilities caps=new DesiredCapabilities();
	  caps.setCapability("deviceName", "samsung SM-J600G");
      caps.setCapability("deviceId", "3200f02db8c945e5");
      caps.setCapability("platformName", "Android");	
      caps.setCapability("appPackage", "com.samsung.android.messaging");	
      caps.setCapability("appActivity", "com.android.mms.ui.ConversationComposer");
      caps.setCapability("noReset", true);
      
      URL app=new URL("http://0.0.0.0:4723/wd/hub");
      driver=new AndroidDriver<MobileElement>(app,caps);
  }
  
  @Test
  public void f() {
	  
	  driver.findElementByAccessibilityId("Compose new message").click();
	  
	  driver.findElementById("com.samsung.android.messaging:id/recipients_editor_to").sendKeys("9894087081");
	  
	  driver.findElementById("com.samsung.android.messaging:id/recipients_editor_to").click();
	  
	  driver.findElementById("com.samsung.android.messaging:id/message_edit_text").sendKeys("Hello Appium");
	  
	  driver.findElementById("com.samsung.android.messaging:id/message_edit_text").click();
	  
	  driver.findElementByAccessibilityId("SIM card 1 Send").click();
	  
	  String getText=driver.findElementByXPath("//android.widget.TextView[@text='Hello Appium']").getText();
	  
	  Assert.assertEquals("Hello Appium",getText);
  }
  

  @AfterClass
  public void afterClass() {
  }

}
