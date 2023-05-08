package pkg1;

	import java.time.Duration;


	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import io.github.bonigarcia.wdm.WebDriverManager;
	
	
	public class MyWeb {
		
	
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://he.aliexpress.com/?gatewayAdapt=glo2isr");
		
		       
				
				//Waiting 30 sec between the opening the search window
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
				
			   //Step 2: searching "Iphone 12 pro" on the search button and click search
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cl-item-phones .cate-name a"))).click();
				driver.findElement(By.cssSelector("#search-key")).sendKeys("Iphone 12 pro");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class=\"search-button\"]"))).click();
				
				//Step 3: print all the search results prices without the coin icon and ","
				//Step 4: print all the prices that not passing 5,000 and write a test if the price low than 5,000 the test pass
				//and if the price is high 5,000 the test failed
				
				
			boolean areAllPricesBelow5000 = true;
			 java.util.List<WebElement> lst = driver.findElements(By.cssSelector("[class^=manhattan--price--]"));
			 for(WebElement curr : lst) {
				 String str = curr.getText().replace("₪","").replace(",","");
				 System.out.println(str);		
				 Double d = 0.0;
				 try {
					 d = Double.parseDouble(curr.getText().replace("₪","").replace(",",""));
					 //System.out.println("currSt=" + curr.getText());
				 }
				 catch(Exception e) {
					 System.out.println("there was a parse exception with: "+curr.getText().replace("₪","").replace(",","") );
				 }
				 
				
				 int currPrice = 0;
						 try {
							 currPrice = Integer.parseInt(str.split("\\.")[0]);
						 }
						 catch(Exception e) {
							 System.out.println("there was a parse exception with: "+str.split("\\.")[0] );
						 }
				 if(currPrice<=5000)
		{
			System.out.println("price is OK "+ currPrice);
		}
				 else {
					areAllPricesBelow5000 = false;
				 }
			 }
				 
					if(areAllPricesBelow5000==true)
					{
						System.out.println("---------\nTEST PASSED");
					}
					else {
						System.out.println("----------\nTEST FAILED");
					}
		
				//driver.findElements(By.cssSelector("[class^=manhattan--price--]"));
				//System.out.println(curr.getText().replace("₪","").replace(",",""));
					//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-spm-id=\"a2g0o.productlist.0.i5.1e13toMLtoMLAz\"] ul li"))).click();
					//driver.findElement(By.cssSelector(".cl-item-phones .cate-name a")).click();
					//[data-spm-anchor-id="a2g0o.productlist.0.0"]
			//=================================================================================

	}

}
