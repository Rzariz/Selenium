import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Hp
 *
 */
public class DemoTestCase {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//driver.get("https://www.rahulshettyacademy.com/#/index");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/*Identify Xpath with Parent Child Traverse relationship
		driver.findElement(By.xpath("//nav[@class='main-menu']/div[2]/ul/li[3]/following-sibling::li[4]")).click();
		driver.findElement(By.xpath("//nav[@class='main-menu']/div[2]/ul/li[4]/preceding-sibling::li[2]")).click();
		System.out.println(driver.findElement(By.xpath("//label[@for = 'honda']/parent::fieldset ")).getText());	*/
		
		//using text to identify elements
		driver.findElement(By.xpath("//*[text() = 'Open Window']")).click();
		
		//System.out.println(driver.findElement(By.xpath("//div[contains(@class,'block large-row-spac')]/div[4]/fieldset/legend")).getText());
		
		/* Relative xpath : does not depend on parent node
		driver.findElement(By.xpath("//*[@id=\'username\']")).sendKeys("varsh@gmail.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("x1234567");
		driver.findElement(By.xpath("//*[@id=\'Login\']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id=\'error\']")).getText());	*/
		
		/*Absolute path
		driver.findElement(By.xpath("//div[@class = 'SDkEP']/div[2]/input")).sendKeys("selenium");
		//driver.findElement(By.xpath("//*[@id=\'tsf\']/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1] ")).click();
		driver.findElement(By.xpath("//input[contains(@value,'Google Sear')]")).click();
		//driver.findElement(By.xpath("//div[@class='gb_Xa gb_Fg gb_i gb_Eg gb_Jg gb_Wf']/div[1]/div[1]/a")).click();
		*/
		
		//Alert box
		String str= "Rza";
		driver.findElement(By.id("name")).sendKeys(str);
		driver.findElement(By.cssSelector("#alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());	//Grabbing content in alert
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());	//getting content in Confirm 
		driver.switchTo().alert().dismiss();
		
	}

} 