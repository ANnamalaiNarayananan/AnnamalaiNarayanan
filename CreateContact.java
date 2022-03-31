package Week2.Day2Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
	public static void main(String[] args) {
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

		// Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		System.out.println("Contact link is clicked successfully");

		// Click on Create Contact
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		System.out.println("Create contacts link clicked successfully");

		// Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys("Annasag");
		System.out.println("Firstname entered successfully");

		// Enter LastName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys("Vijay");
		System.out.println("Lastname entered successfully");

		// Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("Quality");
		System.out.println("Department entered successfully");

		// Enter Description Field Using any Locator of your choice
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Testing the field");
		System.out.println("Description entered successfully");

		// Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.xpath("//input[@id='createContactForm_primaryEmail']")).sendKeys("Testmail94@gmail.com");
		System.out.println("Email entered successfully");

		// Select State/Province as NewYork Using Visible Text
		WebElement Stateprovince = driver.findElement(By.xpath("//select[@name='generalStateProvinceGeoId']"));
		Select spselect = new Select(Stateprovince);
		spselect.selectByVisibleText("New York");
		System.out.println("Stateprovince entered successfully");

		// Click on Create Contact
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		System.out.println("create contact link is clicked successfully");

		// Click on edit button
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		System.out.println("Edit button is clicked successfully");

		// Clear the Description Field using .clear
		WebElement description = driver.findElement(By.xpath("//textarea[@id='updateContactForm_description']"));
		description.clear();
		System.out.println("The text is cleared successfully");

		// Fill ImportantNote Field with Any text
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Test field");
		System.out.println("The importantnote field is entered with text successfully");

		// Click on update button using Xpath locator
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		System.out.println("update button is clicked");

		// Get the Title of Resulting Page.
		String title = driver.getTitle();
		System.out.println("The title is " + title);

		// close the browser
		driver.close();

		// quit the browser
		driver.quit();

	}

}
