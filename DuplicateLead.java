package Week2.Day1Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	public static void main(String[] args) {

		// Set the system property
		WebDriverManager.chromedriver().setup();

		// Driver intialisation
		WebDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("http://leaftaps.com/opentaps/control/login");

		// Enter username
		driver.findElement(By.id("username")).sendKeys("Democsr");

		// Enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on login using class locator
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on crmsfa link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// CLick on leads button
		driver.findElement(By.linkText("Leads")).click();

		// Click on create lead
		driver.findElement(By.linkText("Create Lead")).click();

		// Enter company name field using id locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Mphasis");

		// Enter firstname using Id locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Annamalai");

		// Enter lastname using id locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Narayanan");

		// Enter firstname(local) using id locator
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("LocalName");

		// Enter department field
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("QA");

		// Enter description field
		driver.findElement(By.id("createLeadForm_description")).sendKeys("I am software tester");

		// Enter email address
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("Annamalai.sagunthala1994@gmail.com");

		// Select State/Province as NewYork Using Visible Text
		WebElement Stateprovince = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));

		// Select class
		Select dd = new Select(Stateprovince);
		dd.selectByVisibleText("New York");

		// Click on create button
		driver.findElement(By.className("smallSubmit")).click();

		// Get the current url
		// Get the title
		String title = driver.getTitle();
		System.out.println(title);
		
		//Click on duplicate button
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		//Clear the firstname and send new first name
		WebElement Fname = driver.findElement(By.id("createLeadForm_firstName"));
		Fname.clear();
		Fname.sendKeys("AnnamalaiNarayanan");
		
		//Clear the company name and send new company name
		WebElement Company = driver.findElement(By.id("createLeadForm_companyName"));
		Company.clear();
		Company.sendKeys("Expleo");
		
		//Click on create lead button
		driver.findElement(By.className("smallSubmit")).click();

		
		// Get the title of the resulting page
		String title2 = driver.getTitle();
		System.out.println(title2);

	}
}