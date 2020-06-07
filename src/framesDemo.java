import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class framesDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		System.out.println(driver.findElement(By.tagName("iframe")).getSize()); 	// get the count of frames in webpage
		//WebElement f = driver.findElement(By.cssSelector("iframe.demo-frame"));
		//driver.switchTo().frame(f);		// frames using web element
		driver.switchTo().frame(0); 	//frames using index
		WebElement s = driver.findElement(By.cssSelector("div#draggable"));
		WebElement t = driver.findElement(By.cssSelector("div#droppable"));
		Actions a = new Actions(driver);
		a.dragAndDrop(s, t).build().perform(); 
		driver.switchTo().defaultContent();		//switching out of frame

	}

}
