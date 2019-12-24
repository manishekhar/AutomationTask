package Zest.Money;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Assignment_2 extends Methods {
	
	@Test()
	public static void tripAdvisor() throws IOException, InterruptedException {
		startBrowser();   
		launchUrl();         
		Thread.sleep(10000);                   
		WebElement element = driver.findElement(By.xpath("//div[@title='Search']")) ;// Step 2
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		executor = (JavascriptExecutor)driver;    
		executor.executeScript("arguments[0].click();", element);
		driver.findElement(By.xpath("//div[@title='Search']")).click();
		driver.findElement(By.xpath("//input[@id='mainSearch']")).sendKeys("Club Mahindra");
		Thread.sleep(5000);
		List<WebElement>  ele= driver.findElements(By.xpath("//div[@class='main-content']//span"));
		for (int i = 1; i < ele.size(); i++) {
			if (i==1) {
				System.out.println(ele.get(i).getText());
				ele.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);    
		
		   
		executor = (JavascriptExecutor)driver;
		//driver = new ChromeDriver();
		WebElement element2 = driver.findElement(By.xpath("//a[text()='Write a review']"));
		executor.executeScript("arguments[0].scrollIntoView(true);",element2);
		executor.executeScript("arguments[0].click();", element2);
		
		for (String windows : driver.getWindowHandles()) {
			driver.switchTo().window(windows);
			if (driver.getTitle().contains("Write a review - TripAdvisor")) {
				WebElement element3 = driver.findElement(By.xpath("//span[@id='bubble_rating']"));
				while(!element3.getAttribute("class").contains("ui_bubble_rating fl bubble_50")) {
					Actions action = new Actions(driver);
					action.moveToElement(element3).click().build().perform();
				}
	
                }

         }
	}

}
