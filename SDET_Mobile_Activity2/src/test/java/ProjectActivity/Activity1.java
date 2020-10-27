package ProjectActivity;

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
import org.testng.Assert;
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
      caps.setCapability("appPackage", "com.google.android.apps.tasks");	
      caps.setCapability("appActivity", ".ui.TaskListsActivity");
      caps.setCapability("noReset", true);
      
      URL app=new URL("http://0.0.0.0:4723/wd/hub");
      driver=new AndroidDriver<MobileElement>(app,caps);
  }
  
  @Test
  public void f() {
	  
	  wait=new WebDriverWait(driver,30);
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Create new task")));
	  
	  driver.findElementByAccessibilityId("Create new task").click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
	  
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Tasks");
	  
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text='Complete Activity with Google Tasks']")));
	  String result=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Complete Activity with Google Tasks']")).getText();
	  
	  Assert.assertEquals("Complete Activity with Google Tasks",result);
	  
	  driver.findElementByAccessibilityId("Create new task").click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
	  
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Keep");
	  
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text='Complete Activity with Google Keep']")));
	  String result1=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Complete Activity with Google Keep']")).getText();
	  
	  Assert.assertEquals("Complete Activity with Google Keep",result1);
	  
	  
	  driver.findElementByAccessibilityId("Create new task").click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
	  
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete the second Activity Google Keep");
	  
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text='Complete the second Activity Google Keep']")));
	  
	  
	  String result2=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Complete the second Activity Google Keep']")).getText();
	  
	  Assert.assertEquals("Complete the second Activity Google Keep",result2);
	  
	  
	  
  }

  @AfterClass
  public void afterClass() {
  }

}
