package week5.day2;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
/*http://leaftaps.com/opentaps/control/main

Delete Lead:
1	Launch the browser
2	Enter the username
3	Enter the password
4	Click Login
5	Click crm/sfa link
6	Click Leads link
7	Click Find leads
8	Click on Phone
9	Enter phone number
10	Click find leads button
11	Capture lead ID of First Resulting lead
12	Click First Resulting lead
13	Click Delete
14	Click Find leads
15	Enter captured lead ID
16	Click find leads button
17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
18	Close the browser (Do not log out)
*/
public class DeleteLead extends ParentClass  {
@Test(priority = 5)
	public void deleteLead() throws InterruptedException {
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		System.out.println("Lead ID: " + leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
}
}






