package week5.day1.assignment2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import week5.day2.ReadExcel;

public class Update extends ParentClassServiceNow {
	String incidentNum;

	@Test(priority = 3, dataProvider = "sendData")
	public void runUpdateMethod(String selectState, String SelectUpdate) throws InterruptedException {
		// TODO Auto-generated method stub

//		4. Search for the existing incident and click on the incident//INC0010027
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		WebElement loginframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(loginframe);
		WebElement existIncidentNum = driver.findElement(By.xpath("//input[@class='form-control']"));
		existIncidentNum.click();
		existIncidentNum.sendKeys("INC0010050", Keys.ENTER);
		Thread.sleep(1000);

//		5. Update the incidents with Urgency as High and State as In Progress
		// state
		// click All
		driver.findElement(By.xpath("//a[@class='breadcrumb_link']")).click();
		// search with exist incident num
		WebElement existIncidentNum2 = driver.findElement(By.xpath("//input[@class='form-control']"));
		existIncidentNum2.click();
		existIncidentNum2.sendKeys("INC0010050", Keys.ENTER);
		Thread.sleep(1000);
		// click a incident num link
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		Thread.sleep(1000);
		// urgency
		WebElement urgency = driver.findElement(By.xpath("//select[@name='incident.urgency']"));
		Select drpdwn1 = new Select(urgency);
		drpdwn1.selectByValue(SelectUpdate);
		// state
		WebElement state = driver.findElement(By.xpath("//select[@name='incident.state']"));
		Select drpdwn2 = new Select(state);
		drpdwn2.selectByValue(selectState);

		driver.findElement(By.xpath("//button[text()='Update']")).click();
		Thread.sleep(1000);

		System.out.println("Updated Successfully");

	}

	@DataProvider
	public String[][] sendData() throws IOException {
		// TODO Auto-generated method stub
		return ReadExcel.readData("servicenowexcel", "Sheet3");

	}

}
