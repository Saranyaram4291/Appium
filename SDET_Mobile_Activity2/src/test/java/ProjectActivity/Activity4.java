package ProjectActivity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity4 {
	
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
	  
	  Thread.sleep(5000);
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("android:id/content")));
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"To-Do List\"))")).click();
	  
	  Thread.sleep(5000);
	 // wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("taskInput")));
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys("test");
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("text(\"test\")")));
	  
	  String result=driver.findElement(MobileBy.AndroidUIAutomator("text(\"test\")")).getText();
	  
	  Assert.assertEquals("test",result);
	  
	  List<MobileElement> ele=driver.findElementsByXPath("//android.view.View/android.view.View[3]/android.view.View[2]");
	  
	  System.out.println("No of elements"+ele.size());
	  
	  driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]").click();
	  
	  
	  
	  
	  

	  
  }
}
