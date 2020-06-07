import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		
		WebElement fcity = driver.findElement(By.xpath("//input[@placeholder = 'From']"));
		Thread.sleep(1000);
		fcity.click();
		Thread.sleep(1000);
		//fcity.clear();
		//Thread.sleep(1000);
		fcity.sendKeys("mum");
		Thread.sleep(6000);
		fcity.sendKeys(Keys.ARROW_DOWN);
		fcity.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder = 'To']")).click();
		
		WebElement tcity = driver.findElement(By.xpath("//input[@placeholder = 'To']"));
		Thread.sleep(1000);
		tcity.click();
		tcity.sendKeys("AMt");
		Thread.sleep(5000);
		
		for(int i=1; i<4;i++)
		tcity.sendKeys(Keys.ARROW_DOWN);
		tcity.sendKeys(Keys.ENTER);
	}

}
