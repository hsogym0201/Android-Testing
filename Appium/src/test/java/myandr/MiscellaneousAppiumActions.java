package myandr;

import java.net.MalformedURLException;
//import java.net.URL;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;

import org.openqa.selenium.WebElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

//java-client 7.x (8.X) or other issues
//import io.appium.java_client.MobileBy;
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//java-client 7.x (8.X) or other issues



public class MiscellaneousAppiumActions extends BaseTest {
	
	@Test
	public void Miscellaneous() throws MalformedURLException
	{
		// 1. use App Package & App Activity go to target page directly
		//how to new Activity(string appPackage, string appActivity)
		// how to get name: adb shell dumpsys window | find "mCurrentFocus"  - Windows
		// get format: appPackage/appActivity
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
//		// for latest Appium version (create +start)
//		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
//				"intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies",
//	    ));
		
//        // now unnecessary to click Preference, Preference Dependency, perform WiFi checkbox choosing
//        driver.findElement(MobileBy.AccessibilityId("Preference")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        
        // 2. portrait to landscape mode
        DeviceRotation landScape = new DeviceRotation(0, 0, 90);
        driver.rotate(landScape);

        // 3. click WiFi settings and check pop-up title
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click(); 
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");	
        
        // 4. set Clipboard and paste text to input box
//        driver.findElement(By.id("android:id/edit")).sendKeys("JAYH WiFi"); // type text
		driver.setClipboardText("JAYH WiFi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
        // 5. key events(enter, back, home) and push button ok/cancel
		driver.pressKey(new KeyEvent(AndroidKey.ENTER)); 
        ((WebElement) driver.findElements(By.className("android.widget.Button")).get(1)).click();  //Inspector tells index with same classname
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
}
