package myandr;

import java.net.MalformedURLException;
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

public class ScrollDemo extends BaseTest {
	
	@Test
	public void ScrollDemoTest() throws MalformedURLException, InterruptedException
	{
        // 1.click Views
        driver.findElement(MobileBy.AccessibilityId("Views")).click();

        // 2.1 scroll the page until text "WebView" is found (with target)
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
        
        // 2.2 another kind of scrolling without target
		scrollToEndAction();
//		Thread.sleep(2000);
        
////        elementId：要滚动的元素的ID。如果元素ID缺失，则必须提供滚动边界区域。如果同时提供了元素ID和滚动边界区域，则该区域将被忽略。
////        left：滚动边界区域的左边坐标。
////        top：滚动边界区域的顶部坐标。
////        width：滚动边界区域的宽度。
////        height：滚动边界区域的高度。
////        direction：滚动方向。这是一个必填值，可接受的值包括：up、down、left 和 right（不区分大小写）。
////        percent：滚动的大小，以滚动区域大小的百分比表示。有效值必须为大于零的浮点数，其中1.0表示100%。这是一个必填值。
////        speed：执行此手势的速度，以每秒像素数表示。值不能为负。默认值是 5000 * displayDensity。
////        返回值是一个布尔值，如果对象仍然可以在给定方向上滚动，则等于 true。
//        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
//        	    ImmutableMap.of(
//        	        "left", 100, "top", 100, "width", 200, "height", 200,
//        	        "direction", "down",
//        	        "percent", 3.0
//        	    ));

	}

}
