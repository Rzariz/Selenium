import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class fluentWaitTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("div#start button")).click();
		
		WebElement text =  driver.findElement(By.cssSelector("div#finish h4"));
		
		Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		/*In explicit wait this is done using ExpectedConditions.visibilityOfelementlocated() 
		since this is fluent wait we need to write customised wait method */
		 WebElement foo = w.until(new Function<WebDriver, WebElement>() {
			 public WebElement apply(WebDriver driver) {
				  if(text.isDisplayed())
					  return text;
				  else
					  return null;
		     }
		 });
		 System.out.println(text.isDisplayed());
	}
}
