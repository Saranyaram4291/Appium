package SDET_Mobile_Activity2.SDET_Mobile_Activity2;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class scrollableActivity {
	
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
  public void f() throws InterruptedException {
	  
	  wait=new WebDriverWait(driver,30);
	  
	  driver.get("https://www.training-support.net/selenium");
	  
	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Selenium']")));
	  
//      TouchAction touchAction = new TouchAction(driver);
//      touchAction.tap(PointOption.point(545, 466))
//                 .perform();
	  
	 // wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Selenium']")));
	  
	 // driver.findElementByXPath("//android.view.View[@text='Selenium']").click();
	  
	
    driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Launch new tabs with the click of a button.\"))")).click();
  }

  @AfterClass
  public void afterClass() {
  }

}
