package myandr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.appium.java_client.MobileBy;

public class eCommerce_tc_2 extends BaseTest{
	
	@Test
	public void AddCart() throws InterruptedException 
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
        
        
		// Test Scenarios 2 : Find the item by scrolling and add it to cart
        // scroll until text "Jordan 6 Rings" is found
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
        
        // find "Jordan 6 Rings" respective add button
        // get the count (current page may has several add button with same Id)
        int productCount =	driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
    	for(int i =0;i<productCount;i++){
    		String productName =((WebElement)driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i)).getText();
    		// java will fail to recognize, so use WebElement to change type
    		// String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
    		if(productName.equalsIgnoreCase("Jordan 6 Rings")){
    			((WebElement) driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i)).click();
    			// java will fail to recognize, so use WebElement to change type
    			// driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
    		}
    	}
    	
    	// Test Scenarios 3 : check if the item added can be displayed in cart page
    	// go to the cart page
    	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    	
    	// Wait until next page is loaded, since they are using the same id of Jordan 6 Rings (synchroniżation issues)
      	//如果没有适当的等待，测试脚本可能会在页面或元素完全加载之前就尝试进行操作，这可能导致测试失败。
     	//通过显式等待，可以确保测试脚本在继续之前等待必要的元素加载完成，从而避免同步问题
    	WebDriverWait wait =new WebDriverWait(driver, 5);
    	// WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5)); // version issue, unable
    	wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),
    			"text" , "Cart")); // until next page title is cart
    	
    	// then to check the item added successfully
    	String lastPageProduct = ((WebElement) driver.findElement(By.id("com.androidsample.generalstore:id/productName"))).getText();
    	// String lastPageProduct =driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
    	Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
    	
    	Thread.sleep(3000);
	}
}
