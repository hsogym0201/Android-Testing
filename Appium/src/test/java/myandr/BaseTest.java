package myandr;

//import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
//import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities; //Appium 7.x (8.X) or other issues
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException {
//        // start Appium server
//        service = new AppiumServiceBuilder()
//                .withAppiumJS(new File("C:\\Users\\HJJ9288\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//                .withIPAddress("127.0.0.1")
//                .usingPort(4723)
//                .build();
//        service.start();
        
        // set capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "JAYH03");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2"); // 设置自动化框架名称
//        caps.setCapability("app", "D:\\setupEclipse\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
//        caps.setCapability("chromedriverExecutable", "D:\\setupEclipse\\chromedriver.exe");
        caps.setCapability("app", "D:\\setupEclipse\\Appium\\src\\test\\java\\resources\\General-Store.apk");

        // initialize AndroidDriver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // wait to find elements
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // java version unsupported
	}
	
	// Long Click
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration",2000));
	}
	
	// Scroll constantly
	public void scrollToEndAction()
	{
		boolean canScrollMore;
		do
		{
//			 canScrollMore = (Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
//			 ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down",
//		    "percent", 3.0));  // why fail? more than five arguments?
		 canScrollMore = (Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
				 ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down"));
		 // or try ?
//	     canScrollMore = (Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
//	             new ImmutableMap.Builder<String, Object>()
//	                 .put("left", 100)
//	                 .put("top", 100)
//	                 .put("width", 200)
//	                 .put("height", 200)
//	                 .put("direction", "down")
//	                 .put("percent", 3.0)
//	                 .build());
		}while(canScrollMore);
	}
	
	// Swipe 
	public void swipeAction(WebElement ele,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	
	@AfterClass
	public void tearDown() {
        driver.quit();
        
        // stop Appium server
        // service.stop();
	}

}
