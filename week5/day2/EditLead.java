package week5.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
///*http://leaftaps.com/opentaps/control/main
//
//* 1	Launch the browser
//* 2	Enter the username
//* 3	Enter the password
//* 4	Click Login
//* 5	Click crm/sfa link
//* 6	Click Leads link
//* 7	Click Find leads
//* 8	Enter first name
//* 9	Click Find leads button
//* 10 Click on first resulting lead
//* 11 Verify title of the page
//* 12 Click Edit
//* 13 Change the company name
//* 14 Click Update
//* 15 Confirm the changed name appears
//* 16 Close the browser (Do not log out)
public class EditLead extends ParentClass {
@Test(priority = 2, dataProvider="sendData")

	public void editLead(String phnNum,String updateCompany) throws InterruptedException {
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phnNum);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(updateCompany);
		driver.findElement(By.name("submitButton")).click();
}
@DataProvider
public String[][] sendData() throws IOException {
	// TODO Auto-generated method stub
	return ReadExcel.readData("CreateLead", "Sheet3");
}
}






