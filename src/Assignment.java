import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		
		
		/*driver.get("https://the-internet.herokuapp.com/nested_frames");//---->assignment 5 -- handling frames using Selenium
		//System.out.println(driver.findElement(By.tagName("frameset")).getSize());
		WebElement frame_top = driver.findElement(By.name("frame-top"));
		driver.switchTo().frame(frame_top);
		WebElement frame_mid = driver.findElement(By.xpath("//frame[@name = 'frame-middle']"));
		driver.switchTo().frame(frame_mid);
		System.out.println("Frame text : "+driver.findElement(By.id("content")).getText());	*/
		
		/*driver.get("https://the-internet.herokuapp.com/windows");	//	---->assignment 4 -- Multiple window
		driver.findElement(By.cssSelector("div.example a")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String p = it.next();
		String c = it.next();
		
		driver.switchTo().window(c);
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());
		
		driver.switchTo().window(p);
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());		*/
		
		/*driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");		---->assignment 3     -- Explicit wait
		WebDriverWait w = new WebDriverWait(driver, 6);
		driver.findElement(By.xpath("//*[text() = 'Click to load get data via Ajax!']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
		//w.until(ExpectedConditions.elementToBeClickable(By.id("results")));
		System.out.println("Result : "+driver.findElement(By.id("results")).getText());
		*/
				
		
		/*driver.get("https://www.cleartrip.com/");					---->assignment 2
		//This Practice Assignment helps you to get hands free on Dropdown handling using Select and Edit boxes, links & button selections. 
		//Select from location 
		WebElement src = driver.findElement(By.id("FromTag"));
		src.click();
		src.sendKeys("New yo");
		Thread.sleep(3000L);
		src.sendKeys(Keys.ENTER);
		//select to location
		WebElement dest = driver.findElement(By.id("ToTag"));
		dest.click();
		dest.sendKeys("Dubai");
		Thread.sleep(3000L);
		dest.sendKeys(Keys.ENTER);
		//select current date
		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		//select the adults, children and infants
		Select adul = new Select(driver.findElement(By.id("Adults")));
		adul.selectByValue("3");
		Select chil = new Select(driver.findElement(By.id("Childrens")));
		chil.selectByIndex(4);
		Select inf = new Select(driver.findElement(By.id("Infants")));
		inf.selectByVisibleText("2");
		//click on more option
		driver.findElement(By.id("MoreOptionsLink")).click();
		//select the airline
			//driver.findElement(By.id("AirlineAutocomplete")).click();
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Emirates");
		driver.findElement(By.id("SearchBtn")).click();
		//Printing error message because the current date in site is an old date
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());		*/
				
		//driver.get("https://rahulshettyacademy.com/AutomationPractice/");				 ---->assignment 1
			/*WebElement box = driver.findElement(By.id("checkBoxOption1"));
		box.click();
		Assert.assertTrue(box.isSelected());
		System.out.println(box.isSelected());
		box.click(); // uncheck the checkbox
			//Assert.assertFalse(box.isSelected());
			//System.out.println(box.isSelected());
		System.out.println(driver.findElements(By.cssSelector("input[type *= checkbox]")).size()); 	*/
		
	}

}
