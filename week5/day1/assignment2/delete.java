package week5.day1.assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class delete extends ParentClassServiceNow{
	@Test(priority = 4)
	public void runDeleteMehod() throws InterruptedException {
		// TODO Auto-generated method stub

//		4. Search for the existing incident and navigate into the incident//INC0010027
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();	
		WebElement loginframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(loginframe);
		WebElement existIncidentNum = driver.findElement(By.xpath("//input[@class='form-control']"));
		existIncidentNum.click();
		existIncidentNum.sendKeys("INC0010050", Keys.ENTER);
		Thread.sleep(1000);

		// click All
		driver.findElement(By.xpath("//a[@class='breadcrumb_link']")).click();
		// search with exist incident num
		WebElement existIncidentNum3 = driver.findElement(By.xpath("//input[@class='form-control']"));
		existIncidentNum3.click();
		existIncidentNum3.sendKeys("INC0010050", Keys.ENTER);
		Thread.sleep(1000);
		// click a incident num link
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		Thread.sleep(1000);
		
//		5. Delete the incident
		
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		driver.findElement(By.xpath("(//button[text()='Delete'])[3]")).click();

//		6. Verify the deleted incident
		WebElement existIncidentNum4 = driver.findElement(By.xpath("//input[@class='form-control']"));
		existIncidentNum4.click();
		existIncidentNum4.sendKeys("INC0010050", Keys.ENTER);
		Thread.sleep(1000);
	
	}

	

}
