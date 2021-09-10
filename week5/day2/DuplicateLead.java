package week5.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
/*http://leaftaps.com/opentaps/control/main

1	Launch the browser
2	Enter the username
3	Enter the password
4	Click Login
5	Click crm/sfa link
6	Click Leads link
7	Click Find leads----------------
8	Click on Email
9	Enter Email
10	Click find leads button
11	Capture name of First Resulting lead
12	Click First Resulting lead
13	Click Duplicate Lead
14	Verify the title as 'Duplicate Lead'
15	Click Create Lead
16	Confirm the duplicated lead name is same as captured name
17	Close the browser (Do not log out)

*/
public class DuplicateLead extends ParentClass  {
	@Test(priority = 3, dataProvider="sendData")
	public void duplicateLead(String phnNum) throws InterruptedException {
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phnNum);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.name("submitButton")).click();
}
	@DataProvider
	public String[][] sendData() throws IOException {
		// TODO Auto-generated method stub
		return ReadExcel.readData("CreateLead", "Sheet2");
	
		
		
	}
}






