import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class eCommerce {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		WebDriverWait w = new WebDriverWait(driver, 5);
		String[] vegetables = {"Cucumber","Capsicum", "Carrot"};
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	//Implicit wait
		itemsAdded(driver, vegetables, w);	
	}
	public static void itemsAdded(WebDriver driver, String[] vegetables, WebDriverWait w){
			
		int j =0;
		
		List<WebElement> products = driver.findElements(By.cssSelector(".product-name"));
		for(int i=0;i<products.size();i++){
			
			String[] veggie = products.get(i).getText().split("-");//splits 'Cucumber - 1 kg' to veggie[0] = 'Cucumber ' and veggie[1]='1 kg'
			String new_veggie = veggie[0].trim();		//to remove the white spaces eg. 'Cucumber '
			List items = Arrays.asList(vegetables);		//COnverting Array(fixed length;takes less memory) to Arraylist(variable length; takes more memory)
			if(items.contains(new_veggie))	//checks whether fetched vegetable name is present in the arraylist 
			{
				j++;
				driver.findElements(By.xpath("//div[@class = 'product-action']/button")).get(i).click();
				System.out.println("Vegetable added to cart");
				if(j== vegetables.length)
						break;
			}
		}
		driver.findElement(By.xpath("//img[@alt = 'Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));	//EXPLICIT WAIT
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));	//EXPLICIT WAIT
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		driver.findElement(By.xpath("//div[@class='products']/div/button")).click();	
	}
}
