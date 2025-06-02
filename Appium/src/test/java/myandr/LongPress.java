package myandr;

import java.net.MalformedURLException;
import org.testng.annotations.Test;

//import com.google.common.collect.ImmutableMap;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.RemoteWebElement; 
import org.testng.Assert;

//Appium 7.x (8.X) or other issues
import io.appium.java_client.MobileBy;
//java-client 7.x (8.X) or other issues

public class LongPress extends BaseTest {
	
	@Test
	public void LongPressGesture() throws MalformedURLException, InterruptedException
	{
        // 1.click constantly until target page
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
		
		// 2. find People Names and use executeScript to longClick
		WebElement ele=	driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
//		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
//				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),
//						"duration", 2000)); //ms unit
//		//inheritance class BaseClass LongPressAction()
		longPressAction(ele);
		
		// 3. check LongClick pop-up title 
		String menuText = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(menuText, "Sample Menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
	}

}
