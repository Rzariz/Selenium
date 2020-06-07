import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class globalVariable {

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		//creating file object
		FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\Introduction\\src\\data.properties");
		//tell about file object to properties object
		prop.load(fis);
		System.out.println( prop.getProperty("browser") );
		//to change the value from code
		prop.setProperty("browser", "Firefo");
		System.out.println( prop.getProperty("browser") );
		
		//to write back to the properties file
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Hp\\eclipse-workspace\\Introduction\\src\\data.properties");
		prop.store(fos, null);
		
		
		
	}

}
