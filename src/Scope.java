import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver sel = new ChromeDriver();
		sel.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println("Links count in the page  : "+sel.findElements(By.tagName("a")).size());
		WebElement footerdriver = sel.findElement(By.id("gf-BIG"));
		System.out.println("Link count in footer : "+footerdriver.findElements(By.tagName("a")).size());
		WebElement cell = footerdriver.findElement(By.cssSelector("table.gf-t tbody tr td:nth-child(1) ul"));
		//WebElement cell = footerdriver.findElement(By.xpath("//table[@class = 'gf-t' ]/tbody/tr/td[1]"));
		System.out.println("Link count in footer column : "+cell.findElements(By.tagName("a")).size());
		Actions a = new Actions(sel);
		for( int i=1; i<cell.findElements(By.tagName("a")).size() ; i++)
		{
			WebElement x = cell.findElements(By.tagName("a")).get(i);
			a.moveToElement(x).keyDown(Keys.CONTROL).click().build().perform();
			
			/*String clickonlink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			cell.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);	---- alternate code */
			Thread.sleep(3000L);
		}
		Set<String> ids = sel.getWindowHandles();
		Iterator<String> it = ids.iterator();
		while(it.hasNext())
		{
			String c = it.next();
			sel.switchTo().window(c);
			System.out.println("Title --- "+sel.getTitle());
		}
	}

}
