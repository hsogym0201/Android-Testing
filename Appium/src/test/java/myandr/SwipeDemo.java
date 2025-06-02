package myandr;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.google.common.collect.ImmutableMap;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.RemoteWebElement; 
//import org.testng.Assert;

//Appium 7.x (8.X) or other issues
import io.appium.java_client.MobileBy;
//Appium 7.x (8.X) or other issues

public class SwipeDemo extends BaseTest {
	
	@Test
	public void SwipeDemoTest() throws MalformedURLException, InterruptedException
	{
        // 1.click constantly until target page
        driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		
		// 2. check 1st picture focused
		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"true");
		
		// 3.Swipe
		swipeAction(firstImage, "left");
		
		// 4. check 1st picture unfocused
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"false");
		
////	elementId：要滑动的元素的ID。如果元素ID缺失，则必须提供滑动边界区域。如果同时提供了元素ID和滑动边界区域，则该区域将被忽略。
////	left：滑动边界区域的左边坐标。
////	top：滑动边界区域的顶部坐标。
////	width：滑动边界区域的宽度。
////	height：滑动边界区域的高度。
////	direction：滑动方向。这是一个必填值，可接受的值包括：up、down、left 和 right（不区分大小写）。
////	percent：滑动的大小，以滑动区域大小的百分比表示。有效值必须为大于零的浮点数，范围在0.1到1.0之间，其中1.0表示100%。这是一个必填值。
////	speed：执行此手势的速度，以每秒像素数表示。值不能为负。默认值是 5000 * displayDensity。
//	((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//		    "left", 100, "top", 100, "width", 200, "height", 200,
//		    "direction", "left",
//		    "percent", 0.75
//		));
	}
}
