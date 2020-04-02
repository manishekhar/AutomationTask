package Zest.Money;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class Methods
{
	public static WebDriver driver;
	/* 1. Laptop
	 * 2. Kurti
	 * 3. Tshirt
	 * 4. Shirt
	 * 5. Mens Jeans
	 * 6. Womens Jeans
	 * 7. Mens Shoes
	 * 8. Womens Shoes
	 * 9. Mobile
	 * 10.Television
	 * 11. ac
	 * 12. Fridge
	 * 13. Gyser
	 * 14. Ladies Top
	 * 15. Bra
	 * 16. Panty
	 * 17. Nighty
	 * 18. Cooler
	 * 19.  
	 */
	public String productName = "Mens Jeans";

	public static String getPropertyValue(String Key) throws IOException
	{
		Properties OR;
		File f1;
		FileInputStream file;
		OR = new Properties();
		f1 = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\Zest\\Money\\Object.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		return OR.getProperty(Key);

	}
	
	

public static void startBrowser(){
		
		System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")
				+ "\\Drivers\\chromedriver.exe")); 
		driver = new ChromeDriver();
	}




 public void getDataAmazon() throws IOException, InterruptedException
 {
	 startBrowser();
	 driver.manage().window().maximize();
	 driver.get(getPropertyValue("AmazonUrl"));
	 driver.findElement(By.id("nav-link-accountList")).click();
	 driver.findElement(By.id("ap_email")).sendKeys("manishekhar947@gmail.com");
	 driver.findElement(By.id("continue")).click();
	 driver.findElement(By.id("ap_password")).sendKeys("Mani@6746");
	 driver.findElement(By.id("signInSubmit")).click();
	 driver.findElement(By.id("continue")).click();
	 Thread.sleep(20000);
	 driver.findElement(By.xpath(getPropertyValue("amazonSearch"))).sendKeys(productName);
	 driver.findElement(By.xpath(getPropertyValue("amazonSearchSubmit"))).click();
	 if(productName.equalsIgnoreCase("Laptop"))
	 {
		 Laptop();
	 }
	 else if(productName.equalsIgnoreCase("Kurti"))
	 {
		 Kurti();
	 }
	 else if(productName.equalsIgnoreCase("Tshirt"))
	 {
		 Tshirt(); 
	  }
	 else if(productName.equalsIgnoreCase("Shirt"))
	 {
		 Shirt();
	 }
	 else if(productName.equalsIgnoreCase("Mens Jeans"))
	 {
		 Mens_Jeans();
	 }
	 else
	 {
		 System.out.println("New Item Has been Added");
	 }
}

 


public void Laptop()
{
	List<WebElement> element = driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span"));
	 for(int i=1; i<=element.size();i++)
	 {
		 String itemName = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div["+i+"]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")).getText();
		 System.out.println(itemName);
	 }
}

public void Kurti() 
{
	List<WebElement> element = driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div/div/span/div/div/div[3]/h2/a/span"));		 for(int i=1; i<=element.size();i++)
	 {
		 String itemName = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div["+i+"]/div/span/div/div/div[3]/h2/a/span")).getText();
		 System.out.println(itemName);
	 }
}

public void Tshirt()
{
	List<WebElement> element = driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div/div/span/div/div/div[3]/h2/a/span"));		 for(int i=1; i<=element.size();i++)
	 {
		 String itemName = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div["+i+"]/div/span/div/div/div[3]/h2/a/span")).getText();
		 System.out.println(itemName);
	 }
}

public void Shirt()
{
	List<WebElement> element = driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div/div/span/div/div/div[3]/h2/a/span"));		 for(int i=1; i<=element.size();i++)
	 {
		 String itemName = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div["+i+"]/div/span/div/div/div[3]/h2/a/span")).getText();
		 System.out.println(itemName);
	 }
}


public void Mens_Jeans()
{
	driver.findElement(By.xpath("//*[@id=\"p_89/Ben Martin\"]/span/a/span")).click();
	 List<WebElement> element = driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div/div/span/div/div/div[3]/h2/a/span"));		 for(int i=1; i<=element.size();i++)
	 {
		 String itemName = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div["+i+"]/div/span/div/div/div[3]/h2/a/span")).getText();
		 System.out.println(itemName);
	 }
}

















































}
