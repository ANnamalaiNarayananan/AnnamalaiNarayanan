package Week2.Day2Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ACME {
	public static void main(String[] args) {
		// WebDriver setup
		WebDriverManager.chromedriver().setup();

		// Launch the browser
		WebDriver driver = new ChromeDriver();

		// Load URL
		driver.get("https://acme-test.uipath.com/login");
		System.out.println("The url is launched successfully");

		// Enter email
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com");
		System.out.println("Email entered successfully");

		// Enter password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");
		System.out.println("Password entered successfully");

		// Click login button
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		System.out.println("Login button clicked successfully");

		// Get the title of the page and print
		String TitlePage = driver.getTitle();
		System.out.println("The title of the page is " + TitlePage);

		// Click on Log Out
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		System.out.println("THe logout button is clicked successfully");

		// Close the browser
		driver.close();
		System.out.println("The browser closed successfully");

	}

}
