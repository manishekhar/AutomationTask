package Zest.Money;

import java.io.IOException;

import org.testng.annotations.Test;

public class Assignment_1 extends Methods
{
	@Test()
	public static void comparePriceBetweenAmazonFlipkart() throws IOException, Throwable
	{      
		String amz = getDataAmazon(); 
		System.out.println(amz);    
		
    	String flip = getDataFlipKart();  
    	System.out.println(flip);
    	comparePrice(amz,flip);
	}  

}
