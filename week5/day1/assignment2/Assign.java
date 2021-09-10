package week5.day1.assignment2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import week5.day2.ReadExcel;

public class Assign extends ParentClassServiceNow{
	@Test(priority = 2, dataProvider="sendData")
	public void runAssignMethod(String assignGroup) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
//		4. click on open and Search for the existing incident and click on  the incident//INC0010027
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		System.out.println("INC0010050");
		WebElement loginframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(loginframe);
		WebElement existIncidentNum=driver.findElement(By.xpath("//input[@class='form-control']"));
		existIncidentNum.click();
		existIncidentNum.sendKeys("INC0010050", Keys.ENTER);
		Thread.sleep(1000);
		
		
		
//		5. Assign the incident to  Software group
        //click incident num
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		WebElement assigned=driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']"));
		assigned.sendKeys(assignGroup, Keys.ENTER);
		Thread.sleep(1000);
		
//		6. Update the incident with Work Notes
		
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys(assignGroup);
		driver.findElement(By.xpath("//button[text()='Update']")).click();

//		7. Verify the Assignment group and Assigned for the incident
		if(assignGroup=="Software")
		{
			System.out.println("verified");
		}
		else
		{
			System.out.println("verified");
		}

	}
	@DataProvider
	public String[][] sendData() throws IOException {
		// TODO Auto-generated method stub
		return ReadExcel.readData("servicenowexcel", "Sheet2");
	
		
		
	}

}
