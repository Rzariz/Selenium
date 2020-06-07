import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveOptions {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		WebElement tbox = driver.findElement(By.id("autocomplete"));
		tbox.click();
		tbox.sendKeys("Unit");
		
		/*Wehn sendkeys is not working can use this methos to grab value in textbox or JavascriptExecutor
		 * tbox.sendKeys(Keys.DOWN);
		 * System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); */ 
				
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		String script = " return document.getElementById(\"autocomplete\").value;";
		String t = (String) js.executeScript(script);
		System.out.println("Value  :  " + t);
		
		int j = 0;
		while(!t.equalsIgnoreCase("united arab emirates")){
			j++;
			tbox.sendKeys(Keys.DOWN);
			t = (String) js.executeScript(script);
			System.out.println("Value "+j+ " :  " + t);
			if(j>15) {
				System.out.println("Element Not found");
				break;
			}
		}
		tbox.sendKeys(Keys.ENTER); 		
	}

}
