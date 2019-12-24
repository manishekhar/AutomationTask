package Zest.Money;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Methods
{
	public static WebDriver driver;	

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





 public static String getDataAmazon() throws IOException
 {
	 startBrowser();
	 driver.manage().window().maximize();
	 driver.get(getPropertyValue("AmazonUrl"));
	 driver.findElement(By.xpath(getPropertyValue("amazonSearch"))).sendKeys("iPhone XR (64GB) - Yellow");
	 driver.findElement(By.xpath(getPropertyValue("amazonSearchSubmit"))).click();
	 String priceAmz = driver.findElement(By.xpath(getPropertyValue("piceAmazon"))).getText();
	 System.out.println("The Price in Amazon is "+priceAmz);
	 return priceAmz;
	 
 }
 public static String  launchUrl() throws IOException{
	 
	 driver.manage().window().maximize();
	 driver.get(getPropertyValue("TripAdvisorUrl"));
	return null;
	 
 }
 
 public static String getDataFlipKart() throws IOException, InterruptedException
 {
	 startBrowser();
	 driver.manage().window().maximize();  
	 driver.get(getPropertyValue("FlipKartUrl"));
	 try {
		 driver.findElement(By.xpath(getPropertyValue("fkartCloseBtn"))).click();
	 }
	 catch (Exception e) {
		 e.printStackTrace();
	}  
	 driver.findElement(By.xpath(getPropertyValue("flipkartSearch"))).sendKeys("iPhone XR (64GB) - Yellow");
	 driver.findElement(By.xpath(getPropertyValue("flipkartSub"))).click();
	 Thread.sleep(5000);
	 String priceFlip = driver.findElement(By.xpath(getPropertyValue("priceFlip"))).getText();
	 priceFlip = priceFlip.replace("₹","");
	 System.out.println("The Price in Flipkart is "+priceFlip); 
	 return priceFlip;
 }
 
 	public static String removeSpecialchar(String str1) {
 		String string1="";
 		 for(int i=0;i<str1.length();i++)
 		   {
 		   int ch = (int)str1.charAt(i);
 		   if(ch<=57 && ch>=48)   // 0 is represented as 48    and    9 is represented as 57 in ASCII
 		   {
 		   string1=string1+str1.charAt(i);   // concatenation of number
 		   } 
 		   }
 		
 		return string1;
 	}
   
   public static void comparePrice(String priceAmz , String priceFlip )
   {	 
	   priceAmz = removeSpecialchar(priceAmz);
	   priceFlip =removeSpecialchar(priceFlip);
	
	   if(Integer.parseInt(priceFlip) > Integer.parseInt(priceAmz)) {
		   
		   System.out.println("The price of Amazon"+priceAmz+"is Lesser than"+priceFlip);
	   }
	   else {
		   System.out.println("The price of FlipKart"+priceFlip+"is Lesser than"+priceAmz);
	   }
   }

}
