package week5.day1.assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParentClassServiceNow {
	public ChromeDriver driver;

	@Parameters({"username","password","url","filter"})
	@BeforeMethod
	public void beforeMethod(String username,String password,String url,String filter) throws InterruptedException
	{

//		1. Launch ServiceNow application
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();

		// 1. Go to developer.servicenow.com
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		2. Login with valid credentials (refer the document to create the instance)
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		Thread.sleep(1000);


//		3. Enter Incident in filter navigator and press enter"
		WebElement filterinc = driver.findElement(By.xpath("//input[@id='filter']"));
		filterinc.click();
		filterinc.sendKeys(filter, Keys.ENTER);
		Thread.sleep(1000);

	}
	@AfterMethod
	public void after()
	{
		driver.close();

	}

}
