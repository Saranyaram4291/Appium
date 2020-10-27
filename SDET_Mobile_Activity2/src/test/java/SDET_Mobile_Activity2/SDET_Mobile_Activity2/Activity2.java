package SDET_Mobile_Activity2.SDET_Mobile_Activity2;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {
	
	AppiumDriver<MobileElement> driver=null;
	WebDriverWait wait;
	
 
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  
	  DesiredCapabilities caps=new DesiredCapabilities();
	  caps.setCapability("deviceName", "samsung SM-J600G");
      caps.setCapability("deviceId", "3200f02db8c945e5");
      caps.setCapability("platformName", "Android");	
      caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");	
      caps.setCapability("appActivity", ".Calculator");
      caps.setCapability("noReset", true);
      
      URL app=new URL("http://0.0.0.0:4723/wd/hub");
      driver=new AndroidDriver<MobileElement>(app,caps);
	  
  }
  
  @Test
  public void add() {
	  
	  driver.findElementById("com.sec.android.app.popupcalculator:id/bt_05").click();
	  
	  driver.findElementByAccessibilityId("Plus").click();
	  
	  driver.findElementById("com.sec.android.app.popupcalculator:id/bt_09").click();
	  
	  driver.findElementByAccessibilityId("Equal").click();
	  
	  String addValue=driver.findElementByAccessibilityId("Calculator input field").getText();
	  
	  Assert.assertEquals(addValue,"14");
	  
	  
  }
  
  
  @Test
  public void subtract() {
	  
	  driver.findElementById("com.sec.android.app.popupcalculator:id/bt_01").click();
	  
	  driver.findElementById("com.sec.android.app.popupcalculator:id/bt_00").click();
	  
	  driver.findElementByAccessibilityId("Minus").click();
	  
	  driver.findElementById("com.sec.android.app.popupcalculator:id/bt_05").click();
	  
	  driver.findElementByAccessibilityId("Equal").click();
	  
	  String subtractValue=driver.findElementByAccessibilityId("Calculator input field").getText();
	  
	  Assert.assertEquals(subtractValue,"5");
	  
	  
  }
  
  @Test
  public void multiply() {
	  
	  driver.findElementById("com.sec.android.app.popupcalculator:id/bt_05").click();
	  
	 	  driver.findElementByAccessibilityId("Multiplication").click();
	  
	  driver.findElementById("com.sec.android.app.popupcalculator:id/bt_01").click();
	  driver.findElementById("com.sec.android.app.popupcalculator:id/bt_00").click();
	  driver.findElementById("com.sec.android.app.popupcalculator:id/bt_00").click();
	  
	  driver.findElementByAccessibilityId("Equal").click();
	  
	  String multiplyValue=driver.findElementByAccessibilityId("Calculator input field").getText();
	  
	  Assert.assertEquals(multiplyValue,"500");
	  
	  
  }
  
  @Test
  public void division() {
	  
	  driver.findElementById("com.sec.android.app.popupcalculator:id/bt_05").click();
	  driver.findElementById("com.sec.android.app.popupcalculator:id/bt_00").click();
	  
	  driver.findElementByAccessibilityId("Division").click();
	  
	  driver.findElementById("com.sec.android.app.popupcalculator:id/bt_02").click();
	 
	
	  
	  driver.findElementByAccessibilityId("Equal").click();
	  
	  String divisionValue=driver.findElementByAccessibilityId("Calculator input field").getText();
	  
	  Assert.assertEquals(divisionValue,"25");
	  
	  
  }
  
  
  
  
  
  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }

}
