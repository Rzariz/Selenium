import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//invoke .exe file inorder to invoke chrome brower through chromedriver
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rediff.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		/*driver.get("https:\\yahoo.com");
		driver.navigate().back();*/
		
		/*driver.findElement(By.id("email")).sendKeys("varsha@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("x123456778");
		driver.findElement(By.linkText("Forgotten account?")).click();*/
		
		//Customized xpath and css
		/*driver.findElement(By.xpath("//input[@type='email']")).sendKeys("rza@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("check12345");
		driver.findElement(By.cssSelector("input[value='Log In']")).click();	*/
		
		//using customized css and xpath along with regular expression
		driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("rza_user");
		driver.findElement(By.cssSelector("input#password")).sendKeys("mypass123");
		//driver.findElement(By.cssSelector("input.signinbtn")).click();
		driver.findElement(By.xpath("//input[contains(@class,'signinb')]")).click();
		
		
		//driver.close();
	}
}