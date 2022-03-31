package Week2.Day2Assignment;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// WebDriver setup
		WebDriverManager.chromedriver().setup();

		// Launch the browser
		WebDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("http://leaftaps.com/opentaps/control/login");
		System.out.println("The url launched");

		// Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("Democsr");
		System.out.println("Username entered successfully");

		driver.findElement(By.id("password")).sendKeys("crmsfa");
		System.out.println("password entered successfully");

		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		System.out.println("Logged in successfully");

		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		System.out.println("CRM/SFA link clicked successfully");

		// Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		System.out.println("Leads link is clicked successfully");

		// Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		System.out.println("Find leads link is clicked successfully");

		// Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		System.out.println("The phone link is clicked successfully");

		// Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9876543210");
		System.out.println("The phone number entered successfully");

		Thread.sleep(3000);

		// Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		System.out.println("Find leads button clicked successfully");

		Thread.sleep(3000);
		// Capture lead ID of First Resulting lead
		WebElement resultingleadid = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		System.out.println("THe resulting first lead id is clicked");

		String id = resultingleadid.getText();
		System.out.println(id);

		// Click First Resulting lead
		resultingleadid.click();
		System.out.println("Lead is clicked successfully");

		// Click Delete
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		System.out.println("Delete button is clicked successfully");

		// CLick on find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		System.out.println("Find leads button is clicked");

		// Enter captured lead id
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(id);

		// Click on find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		// Verify message "No records to display" in the Lead List. This message
		// confirms the successful deletion
		WebElement errormessage = driver.findElement(By.xpath("//div[@class='x-paging-info']"));
		Thread.sleep(3000);
		String displaymessage = errormessage.getText();
		System.out.println(displaymessage);

		// Close the browser (Do not log out)
		driver.close();

	}
}