import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1.select checkbox
		WebElement cb = driver.findElement(By.id("checkBoxOption3"));
		cb.click();		
		
		//2.Grab the label of the selected checkbox
		WebElement text = driver.findElement(By.xpath("//input[@id = 'checkBoxOption3']/parent::label" ));
		String label_text = text.getText();
		System.out.println("Label of the checkbox ----"+label_text);
			
		//3. Select an option in dropdown. Here option to select should come from step 2
		String val_cb = cb.getAttribute("value");
		System.out.println("Value of the checkbox----"+val_cb);
		WebElement drop = driver.findElement(By.xpath("//select[@id = 'dropdown-class-example']"));
		Select s = new Select(drop);
		//s.selectByVisibleText(label_text);
		s.selectByValue(val_cb);
		
		//4. enter the step 2 grabbed label text in editbox
		driver.findElement(By.id("name")).sendKeys(label_text);
		
		//5. click on alert and verify if text grabbed from step 2 is present in the popup message/
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		String x = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if(x.contains(label_text))
			System.out.println("Text present in Alert box");
		else
			System.out.println("Fail");	
	}
}
