package com.experitest.auto;

//package <set your test package>;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidDemoTest {
	  public static final String USERNAME = "YOUR_USERNAME";
	  public static final String ACCESS_KEY = "YOUR_ACCESS_KEY";
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	 
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    
    @BeforeMethod
    public void setUp() throws MalformedURLException {
    	        dc.setCapability("reportDirectory", reportDirectory);
    	        dc.setCapability("reportFormat", reportFormat);
    	        dc.setCapability("testName", testName);
    	        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
    	        dc.setCapability("testobjectApiKey", "FAED11E078BB400FAC2E6123F6FD89AF");
    	        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.circleci.circlecidemo2");
    	        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
    	        //driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
    	        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testUntitled() {
        //new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.TextView']")));
        driver.findElement(By.xpath("//*[@id='smallLabel']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Home']")));
      
        //driver.findElement(By.xpath("//*[@text='Notifications']")).getAttribute("value");
        driver.findElement(By.xpath("//*[@text='Notifications']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Notifications']")));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}