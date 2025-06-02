package myandr;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.appium.java_client.MobileBy;

public class eCommerce_tc_3 extends BaseTest{
	@Test
	public void TotalAmount() throws InterruptedException 
	{
        // ************ neglect (pre-condition Scenarios 1)  start ************
        // start filling form and submit
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("JAYH"); //type user name
		driver.hideKeyboard(); 
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click(); // choose gender
		
		driver.findElement(By.id("android:id/text1")).click(); // get dropdown to choose country
		// scroll the dropdown until text "Argentina" is found
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click(); // select a country
        
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); // click button and go to shop
        // ************ neglect (pre-condition Scenarios 1)  end ************
        
        
        // Test Scenarios 4.1 : check if the total Amount displayed in cart page without problem (sum)
        ((WebElement)driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0)).click();
        ((WebElement)driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0)).click();
        // still get(0), since the selected button will be removed
//		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
//		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        //driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART']) [1]")).click(); // other ways

    	// go to the cart page
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();	
		Thread.sleep(3000);
    	// Wait until next page is loaded, since they are using the same id of Jordan 6 Rings (synchroniżation issues)
    	WebDriverWait wait =new WebDriverWait(driver, 5);
    	// WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5)); // version issue, unable
    	wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),
    			"text" , "Cart")); // until next page title is cart
  
    	// then to check the total amount in cart page
    	// get and add all prices
    	List<WebElement> productPrices =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
    	int count = productPrices.size();
    	double totalSum =0;
    	for(int i =0; i< count; i++){
    		String amountString =productPrices.get(i).getText();
    		Double price = Double.parseDouble(amountString.substring(1)); // remove first char $160.97
      		// Double price = getFormattedAmount(amountString);
    		totalSum = totalSum + price;  
    	}
    	// check if sum is equal to total amount displayed in cart page
    	String displaySum =driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
    	Double displayFormattedSum = Double.parseDouble(displaySum.substring(1)); // remove first char $160.97
    	Assert.assertEquals(totalSum, displayFormattedSum);
    	
    	
    	// Test Scenarios 4.2 : check (long Press termsOfConditions), (send email checkbox), (final purchase button)
    	WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
    	longPressAction(ele);
    	// click the close button in the pop-up
    	driver.findElement(By.id("android:id/button1")).click();
    	// choose
    	driver.findElement(By.className("android.widget.CheckBox")).click();
    	// driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
    	
    	// click final purchase button
    	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
    	Thread.sleep(3000);
    	
	}
}
