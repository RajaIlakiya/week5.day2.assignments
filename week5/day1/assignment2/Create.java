package week5.day1.assignment2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import week5.day2.ReadExcel;

public class Create extends ParentClassServiceNow{
	@Test(priority = 1, dataProvider="sendData" )

	public void runCreateMethod(String Caller,String ShortDesc) throws InterruptedException {
		// TODO Auto-generated method stub


//		4. Click on Create new option and fill the manadatory fields
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		Thread.sleep(1000);
		WebElement newIncident = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(newIncident);
		
		  //fill the manadatory fields
		String createIncidentNum=driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Newly created incident number: " + createIncidentNum);
		String incidentNum=createIncidentNum;
		System.out.println(incidentNum);
		//caller
		driver.findElement(By.xpath("//input[@id='sys_display.incident.caller_id']")).sendKeys(Caller);
		Thread.sleep(1000);
		//short description
		driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys(ShortDesc);
		//submit
        driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();


//		5. Verify the newly created incident ( copy the incident number and paste it in search field and enter then verify the instance number created or not)

		WebElement checkIncidentNum=driver.findElement(By.xpath("//input[@class='form-control']"));
		checkIncidentNum.click();
		checkIncidentNum.sendKeys(createIncidentNum, Keys.ENTER);
		//Verify the newly created incident
		String verifyIncidentNum=driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		System.out.println(verifyIncidentNum);
		if(createIncidentNum.equals(verifyIncidentNum))
		System.out.println("Successfully created with same number");
		else
			System.out.println("Not created with same number");

			
		
	}
	@DataProvider
	public String[][] sendData() throws IOException {
		// TODO Auto-generated method stub
		return ReadExcel.readData("servicenowexcel", "Sheet1");
	
		
		
	}
	

}
