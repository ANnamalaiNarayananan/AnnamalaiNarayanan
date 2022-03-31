package Week2.Day2Assignment;

import org.checkerframework.checker.units.qual.Current;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
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

		// CLick on email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		System.out.println("Email link is clicked successfully");

		// Enter email
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("aaa@av.com");
		System.out.println("Email entered successfully");

		// Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		System.out.println("Find leads button clicked");
		Thread.sleep(3000);

		// Capture name of First Resulting lead
		WebElement Fname = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]"));
		String FirstName = Fname.getText();
		System.out.println(FirstName);
		System.out.println("Firstname stored successfully");

		// Click First Resulting lead
		Fname.click();
		System.out.println("First resulting name is selected");

		// Click Duplicate Lead
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		System.out.println("The duplicate lead button is selected");

		// Verify the title as 'Duplicate Lead'
		String CurrentTitle = "Duplicate Lead | opentaps CRM";
		String TitleDup = driver.getTitle();
		if (CurrentTitle.equals(TitleDup)) {
			System.out.println("The title is matched");
		} else {
			System.out.println("The title not matched");
		}

		// Click Create Lead
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		System.out.println("Create lead is clicked successfully");

		// Confirm the duplicated lead name is same as captured name
		Thread.sleep(3000);
		WebElement CaptureTitle = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']"));
		String NewCaptureTitle = CaptureTitle.getText();
		System.out.println(NewCaptureTitle);

		if (FirstName.equals(NewCaptureTitle)) {
			System.out.println("Name matched successfully");
		} else {
			System.out.println("Name doesnt matched");
		}
		
		//Close the browser
		driver.close();

	}
}
