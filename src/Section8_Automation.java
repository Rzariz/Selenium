import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Section8_Automation {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Radio button
		
		
		System.out.println("Initially--> "+driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.cssSelector("[id = 'ctl00_mainContent_rbtnl_Trip_0']")).click();
		System.out.println("After click--> "+driver.findElement(By.id("Div1")).getAttribute("style"));
		if( driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5") )
		{
			System.out.println("Calendar is Disabled");
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
		
		
		//from source 
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); //The from dropdown 
		driver.findElement(By.xpath("//a[@value = 'CCJ']")).click();
		Thread.sleep(2000L);
		//driver.findElement(By.xpath("(//a[@value = 'DXB'])[2]")).click(); // using index to click on TO destination
		//Dynamic dropdowns using parent xpath-child xpath (alternative to using index)
		driver.findElement(By.xpath("//div[@id = 'ctl00_mainContent_ddl_destinationStation1_CTNR']// a[@value = 'DXB']")).click();
		
		//Calendar UI
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		// Passengers
		driver.findElement(By.id("divpaxinfo")).click(); // select textbox 
		Thread.sleep(2000L);
		for(int i=0; i<3; i++)
			driver.findElement(By.id("hrefIncAdt")).click();
		driver.findElement(By.id("hrefIncChd")).click();
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println("No.of Passengers : "+driver.findElement(By.id("divpaxinfo")).getText());
		
		//Currency
		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		s.selectByValue("USD");
		s.selectByIndex(1);
		s.selectByVisibleText("AED");			
		
		//Checkbox
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		System.out.println("Checkbox status : "+driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected()); // check whether checkbox is selcted or not
		int c = driver.findElements(By.cssSelector("input[type*='checkbox']")).size(); // count of the checkboxes
		System.out.println("Number of checkbox count : "+c);
		
		//Search button
		driver.findElement(By.xpath("//span[@class='btn-find-flight-home'] //input[@id='ctl00_mainContent_btn_FindFlights']")).click();
		System.out.println("Search button clicked");
		//driver.findElement(By.cssSelector("value='Search'")).click();
		//driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
	}

}
