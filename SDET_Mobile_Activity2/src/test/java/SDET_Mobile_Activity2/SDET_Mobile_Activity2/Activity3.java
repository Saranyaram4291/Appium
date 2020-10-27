package SDET_Mobile_Activity2.SDET_Mobile_Activity2;

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
      caps.setCapability("appPackage", "com.samsung.android.contacts");	
      caps.setCapability("appActivity", ".contactslist.PeopleActivity");
      caps.setCapability("noReset", true);
      
      URL app=new URL("http://0.0.0.0:4723/wd/hub");
      driver=new AndroidDriver<MobileElement>(app,caps);
      
  }

  @Test
  public void createContact() {
	  
	  wait=new WebDriverWait(driver,30);
	  driver.findElementByAccessibilityId("Create contact").click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.samsung.android.contacts:id/nameEdit")));
	  
	  driver.findElementById("com.samsung.android.contacts:id/nameEdit").sendKeys("Aaditya Verma1");
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout").click();
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.EditText").sendKeys("999148292");
	  
	  driver.findElementById("com.samsung.android.contacts:id/smallLabel").click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.samsung.android.contacts:id/display_name_card_header_container")));
	  
	  MobileElement ele=driver.findElementById("com.samsung.android.contacts:id/display_name_card_header_container");
	  Assert.assertTrue(ele.isDisplayed());
	  
  }
  
  @AfterClass
  public void afterClass() {
  }

}
