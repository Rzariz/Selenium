import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class tableDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/18962/pak-vs-sl-1st-test-pakistan-v-sri-lanka-in-uae-2017");
		driver.manage().window().maximize();
		
		
		WebElement table = driver.findElement(By.cssSelector("div[class = 'cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		int rowcount = table.findElements(By.cssSelector("div[class = 'cb-col cb-col-100 cb-scrd-itms']")).size();	//row count of first table
		System.out.println("Rowcount ----"+rowcount);
		int c = table.findElements(By.cssSelector("div[class = 'cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		System.out.println("Value of c ----"+c);   // count of third columns of first table
		int sum=0;
		for(int i=0; i<c-2; i++)
		{
			System.out.println("Runs "+i+" : "+table.findElements(By.cssSelector("div[class = 'cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText());
			String r = table.findElements(By.cssSelector("div[class = 'cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			int runs = Integer.parseInt(r);			// Converting string to integer
			sum = sum +runs;
		}
		System.out.println("Extras : "+table.findElement(By.xpath("//div[text() = 'Extras']/following-sibling::div" )).getText());
		System.out.println("Total : "+table.findElement(By.xpath("//div[text() = 'Total']/following-sibling::div" )).getText());
		
		String x = table.findElement(By.xpath("//div[text() = 'Extras']/following-sibling::div" )).getText();
		int q = Integer.parseInt(x);
		sum = sum + q;
		System.out.println("\nCalculated Sum  :   "+sum);
		String Tot = table.findElement(By.xpath("//div[text() = 'Total']/following-sibling::div" )).getText();
		int Total = Integer.parseInt(Tot);
		if (sum == Total)
			System.out.println("\n---Same value--");
		else
			System.out.println("--Wrong value--");
	}

}
