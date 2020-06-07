import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class tableSort {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("table[id = 'sortableTable'] thead tr th:nth-child(2) ")).click(); 	//makes list descending
		//driver.findElement(By.cssSelector("table[id = 'sortableTable'] thead tr th:nth-child(2) ")).click(); 	//makes list ascending
		
		List<WebElement> c = driver.findElements(By.cssSelector("table[id = 'sortableTable'] tbody tr td:nth-child(2) "));
		ArrayList<String> orglist = new ArrayList<String>();
		for(int i=0; i<c.size(); i++) 
			orglist.add(driver.findElements(By.cssSelector("table[id = 'sortableTable'] tbody tr td:nth-child(2) ")).get(i).getText()) ;
		System.out.println("\nOrginal List   :    "+orglist);
		
		
		ArrayList<String> copylist = new ArrayList<String>();
		for(int i=0; i<orglist.size(); i++) 
			copylist.add(orglist.get(i));
				
		Collections.sort(copylist);		//ascends the array
		Collections.reverse(copylist);	//descends the array
		
		System.out.println("\n Sorted List in descending: "+copylist);
		//System.out.println("\nSorted List in ascending: "+copylist);
		Assert.assertTrue(orglist.equals(copylist));
	}

}
