package myandr;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement; 
import org.testng.Assert;

//Appium 7.x (8.X) or other issues
import io.appium.java_client.MobileBy;
//Appium 7.x (8.X) or other issues

public class DragDropDemo extends BaseTest {
	
	@Test
	public void DragDropDemoTest() throws MalformedURLException, InterruptedException
	{
        // 1.click constantly until target page
        driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		
		// 2. get source item
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		// 3. set expected drop position
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 619,
			    "endY", 560
			));
		
		Thread.sleep(2000);
		
		// 4. check drop successfully (text on the page)
		String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(result, "Dropped!");
		
		
////		elementId：要拖动的元素的ID。如果元素ID缺失，则必须提供起始坐标（startX 和 startY）。如果同时提供了元素ID和起始坐标，则这些坐标将被视作相对于元素左上角的偏移量。
////		startX：拖动操作的起始X坐标。
////		startY：拖动操作的起始Y坐标。
////		endX：拖动操作结束时的X坐标。这是一个必填参数。
////		endY：拖动操作结束时的Y坐标。这是一个必填参数。
////		speed：执行此手势的速度，以每秒像素数表示。值不能为负。默认值是 2500 * displayDensity。
//		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
//			    "elementId", ((RemoteWebElement) element).getId(),
//			    "endX", 100,
//			    "endY", 100
//			));
	}
}
