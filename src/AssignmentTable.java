import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//print count of rows and columns
		System.out.println("Row Count : "+driver .findElements(By.cssSelector("#product tbody tr")).size());
		int rc = driver .findElements(By.cssSelector("#product tbody tr")).size();
		System.out.println("Column Count : "+driver .findElements(By.cssSelector("#product tbody tr th")).size());
		//print the 2nd row
		for(int i=0; i<rc; i++)
			System.out.println("Second row ---"+driver .findElements(By.cssSelector("#product tbody tr:nth-child(3)")).get(i).getText());
		
		//CODE
		/*WebElement table=driver.findElement(By.id("product"));
		List<WebElement> secondrow= table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
		System.out.println(secondrow.get(2).getText());	*/		
	}

}
