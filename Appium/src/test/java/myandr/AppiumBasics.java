package myandr;

import java.net.MalformedURLException;
//import java.net.URL;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.testng.Assert;

//java-client 7.x (8.X) or other issues
import io.appium.java_client.MobileBy;
//import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement; 
//java-client 7.x (8.X) or other issues
//import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumBasics extends BaseTest {
	
	@Test
	public void WifiSettingsName() throws MalformedURLException
	{
  		// inheritance class BaseClass configureAppium();
//      // start Appium server
//	  AppiumDriverLocalService service = new AppiumServiceBuilder()
//              .withAppiumJS(new File("C:\\Users\\HJJ9288\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//              .withIPAddress("127.0.0.1")
//              .usingPort(4723)
//              .build();
//      service.start();
//      // set capabilities
//      DesiredCapabilities caps = new DesiredCapabilities();
//      caps.setCapability("deviceName", "JAYH03");
//      caps.setCapability("platformName", "Android");
//      caps.setCapability("automationName", "UiAutomator2"); // 设置自动化框架名称
//      caps.setCapability("app", "D:\\setupEclipse\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
//      // initialize AndroidDriver
//      AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
		
		// Locator: 
		// driver.findElement(By.) (Xpath, id, classname)
		// driver.findElement(MobileBy./AppiumBy)(accessibilityId, androidUIAutomator, classname better)    

        // 1.click Preference 
        driver.findElement(MobileBy.AccessibilityId("Preference")).click();
        // driver.findElements(AppiumBy.className("android.widget.Button")).click();
        
        // 2.click Preference dependency 
        // (xpath format: //tagName [@attribute='value'])
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        
        // 3.perform WiFi checkbox choosing
        driver.findElement(By.id("android:id/checkbox")).click();
        
        // 4.click WiFi settings and check pop-up title
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click(); // rank 2nd element with same tag
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");	
        
        // 5.click WiFi settings input box and type, then push button ok/cancel
        driver.findElement(By.id("android:id/edit")).sendKeys("JAYH WiFi"); // type text
        // java fail to recognize, use WebElement change type
        ((WebElement) driver.findElements(By.className("android.widget.Button")).get(1)).click();  //Inspector tells index with same classname
        //  driver.findElements(MobileBy.className("android.widget.Button")).click();
        
        
        // inheritance class BaseClass tearDown();
//        driver.quit();
//        
//        // stop Appium server
//         service.stop();
	}

}
