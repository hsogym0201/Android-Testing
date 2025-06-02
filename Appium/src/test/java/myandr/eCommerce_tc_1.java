package myandr;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;

public class eCommerce_tc_1 extends BaseTest{
	
	@Test
	public void FillForm() throws InterruptedException 
	{
		// Test Scenarios 1 : Fill the form details and verify Toast error messages displayed
		
		// without filling form and wanna shop
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); // click button and go to shop
        // check toast message (use //xpath tagname since it disappear so quickly that Inspector hard to reach it)
        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast) [1]")).getAttribute("name"); 
        Assert.assertEquals(toastMessage, "Please enter your name");
		
        // start filling form and submit
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("JAYH"); //type user name
		driver.hideKeyboard(); 
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click(); // choose gender
		
		driver.findElement(By.id("android:id/text1")).click(); // get dropdown to choose country
		// scroll the dropdown until text "Argentina" is found
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click(); // select a country
        
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); // click button and go to shop
        Thread.sleep(3000);
	}
}
