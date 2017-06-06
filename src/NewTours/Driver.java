package NewTours;

import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String COMMA_DELIMITER = ",";
		String NEW_LINE_SEPARATOR = "\n";
		String FILE_HEADER = "fName,lName,phone,email,addressLine1,addressLine2,city,state,postalCode,country,userName,password";
		
		
		System.setProperty("webdriver.chrome.driver", "E:\\Java_Programing_New\\NewTours1\\Ref_Lib\\Chrome_Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		
		CreateUser usr1 = new CreateUser("abc","def","1234567890","abc@gmail.com","dfg","ghi","pune","Mah","12345","India","abc123","abc123");
		
		try {
		
			FileWriter fileWriter = new FileWriter("E:\\Java_Programing_New\\NewTours1\\Data\\data.csv");
			fileWriter.append(FILE_HEADER);
			fileWriter.append(NEW_LINE_SEPARATOR);
			driver.findElement(By.name("firstName")).sendKeys(usr1.getfName());
			fileWriter.append(usr1.getfName());
			fileWriter.append(COMMA_DELIMITER);
			driver.findElement(By.name("lastName")).sendKeys(usr1.getlName());
			fileWriter.append(usr1.getlName());
			fileWriter.append(COMMA_DELIMITER);
			driver.findElement(By.name("phone")).sendKeys(usr1.getPhone());
			fileWriter.append(usr1.getPhone());
			fileWriter.append(COMMA_DELIMITER);
			driver.findElement(By.name("userName")).sendKeys(usr1.getEmail());
			fileWriter.append(usr1.getEmail());
			fileWriter.append(COMMA_DELIMITER);
			driver.findElement(By.name("address1")).sendKeys(usr1.getAddressLine1());
			fileWriter.append(usr1.getAddressLine1());
			fileWriter.append(COMMA_DELIMITER);
			driver.findElement(By.name("address2")).sendKeys(usr1.getAddressLine2());
			fileWriter.append(usr1.getAddressLine2());
			fileWriter.append(COMMA_DELIMITER);
			driver.findElement(By.name("city")).sendKeys(usr1.getCity());
			fileWriter.append(usr1.getCity());
			fileWriter.append(COMMA_DELIMITER);
			driver.findElement(	By.name("state")).sendKeys(usr1.getState());
			fileWriter.append(usr1.getState());
			fileWriter.append(COMMA_DELIMITER);
			driver.findElement(By.name("postalCode")).sendKeys(usr1.getPostalCode());
			fileWriter.append(usr1.getPostalCode());
			fileWriter.append(COMMA_DELIMITER);
			Select sel1 = new Select(driver.findElement(By.name("country")));
			sel1.selectByVisibleText("INDIA");
			fileWriter.append(usr1.getCountry());
			fileWriter.append(COMMA_DELIMITER);
			driver.findElement(By.name("email")).sendKeys(usr1.getUserName());
			fileWriter.append(usr1.getUserName());
			fileWriter.append(COMMA_DELIMITER);
			driver.findElement(By.name("password")).sendKeys(usr1.getPassword());
			fileWriter.append(usr1.getPassword());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(NEW_LINE_SEPARATOR);
			driver.findElement(By.name("confirmPassword")).sendKeys(usr1.getPassword());
			
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		driver.findElement(By.name("register")).click();
		driver.quit();
		
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.name("userName")).sendKeys(usr1.getUserName());
		driver.findElement(By.name("password")).sendKeys(usr1.getPassword());
		driver.findElement(By.name("login")).click();
		//driver.close();
		
	}

}
