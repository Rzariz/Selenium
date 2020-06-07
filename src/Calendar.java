import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".fsw_inputBox.dates.inactiveWidget ")).click();
		
		while( ! driver.findElement(By.cssSelector("[class='DayPicker'] [class='DayPicker-Caption']")).getText().contains("July") )
			driver.findElement(By.cssSelector(".DayPicker-NavButton.DayPicker-NavButton--next")).click();
		
		List<WebElement> dates= driver.findElements(By.cssSelector("div.DayPicker-Day"));
		int count = dates.size();
		int j=1;
		for(int i=1; i <count; i++)
		{
			j++;
			String s = driver.findElements(By.cssSelector("div.DayPicker-Day")).get(i).getText();
			if(s.equalsIgnoreCase("30"))
			{
				driver.findElements(By.cssSelector("div.DayPicker-Day")).get(i).click();
				System.out.println("Test ----- 2");
				break;
			}
		}
		System.out.println("Count ----- "+j);
	}
}
