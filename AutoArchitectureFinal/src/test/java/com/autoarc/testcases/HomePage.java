package com.autoarc.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autoarc.base.TestBase;

public class HomePage extends TestBase{
	
	@Test (priority=1)
	public void appView() throws Exception
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath(object.getProperty("Appview_tablet"))).click();
		
		WebElement el = driver.findElement(By.xpath(object.getProperty("Appview_tablet_status")));
		String status = el.getAttribute("class");
		System.out.println("Status = "+status);
		Assert.assertTrue(status.contains("active"), "Selected View Not Working");
	}
	
	@Test (priority=2)
    public void verifyHomePageBanner() throws Exception {
		Thread.sleep(10000);
        driver.switchTo().frame("framelive"); // PrestaShop demo uses iframe

        WebElement banner = driver.findElement(By.cssSelector(object.getProperty("bannerImage")));
        Assert.assertTrue(banner.isDisplayed(), "Banner is not displayed");

        WebElement ctaButton = driver.findElement(By.cssSelector(object.getProperty("catButton")));
        Assert.assertTrue(ctaButton.isDisplayed(), "CTA Button is not visible");
    }
	
	 @Test (priority=3)
	    public void verifyInvalidSearch() throws Exception {
	    	Thread.sleep(5000);
	        WebElement searchBox = driver.findElement(By.name("s"));
	        searchBox.clear();
	        searchBox.sendKeys("ll");
	        searchBox.submit();
	        Thread.sleep(5000);
	        WebElement noResult = driver.findElement(By.cssSelector(object.getProperty("inValidSearch")));
	        Assert.assertTrue(noResult.isDisplayed(), "No result warning is not displayed");
	    }
	
	@Test (priority=4)
    public void verifyValidSearch() throws Exception {
		Thread.sleep(5000);
        WebElement searchBox = driver.findElement(By.name("s"));
        searchBox.clear();
        searchBox.sendKeys("t-shirt");
        searchBox.submit();
        Thread.sleep(5000);
        WebElement results = driver.findElement(By.cssSelector(object.getProperty("validSearch")));
        Assert.assertTrue(results.isDisplayed(), "Search results are not displayed");
    }

	@Test (priority=5)
    public void productSearch() throws Exception {
		Thread.sleep(5000);
        WebElement searchBox = driver.findElement(By.name("s"));
        searchBox.clear();
        searchBox.sendKeys("t-shirt");
        searchBox.submit();
        Thread.sleep(5000);
        List<WebElement> elements = driver.findElements(By.xpath(object.getProperty("products")));
        System.out.println("Count = "+elements.size());
        if(elements.size() >= 1)
        {
        	for (WebElement element : elements) {
        	    element.click();
        	    break;
        	}
        }
    }
	
	@Test (priority=6)
	public void langCheck() throws Exception
	{
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(By.xpath(object.getProperty("Appview_desk"))).click();
		
		Thread.sleep(5000);
		driver.switchTo().frame("framelive");
		driver.findElement(By.xpath(object.getProperty("langDropdown"))).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(object.getProperty("Deutsch"))).click();
		
		Thread.sleep(5000);
		WebElement el_con = driver.findElement(By.xpath(object.getProperty("ContactUs")));
		String lan = el_con.getText();
		System.out.println("Status = "+lan);
		Assert.assertTrue(lan.equalsIgnoreCase("Kontakt"), "Language Selected Not Working");
	}
}
