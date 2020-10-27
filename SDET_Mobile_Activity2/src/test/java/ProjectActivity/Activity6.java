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

public class Activity6 {
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
  public void f() throws InterruptedException {
	  
	  wait=new WebDriverWait(driver,30);
	  
	  driver.get("https://www.training-support.net/selenium");
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("android:id/content")));
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Popups\"))")).click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("text(\"Sign In\")")));
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Sign In\")")).click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"username\")")));
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("admin");
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("password");
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
	  
	  String result=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Welcome Back, admin\")")).getText();
	  
	  Assert.assertEquals("Welcome Back, admin",result);
	  
	  
	  
  }

  
  @Test
  public void f1() throws InterruptedException {
	  
	  wait=new WebDriverWait(driver,30);
	  
	  driver.get("https://www.training-support.net/selenium");
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("android:id/content")));
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Popups\"))")).click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("text(\"Sign In\")")));
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Sign In\")")).click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"username\")")));
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("admin1");
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("password1");
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
	  
	  String result=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Invalid Credentials\")")).getText();
	  
	  Assert.assertEquals("Invalid Credentials",result);
	  
	  
	  
  }

  
  
  @AfterClass
  public void afterClass() {
  }

}
