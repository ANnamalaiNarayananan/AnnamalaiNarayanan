package Week2.Day2Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookAssignment {
	public static void main(String[] args) {

		// Set chromedriver
		WebDriverManager.chromedriver().setup();

		// Launch the chrome browser
		WebDriver driver = new ChromeDriver();

		// Load the url
		driver.get(" https://en-gb.facebook.com/");
		System.out.println("THe url entered");

		// Maximise the window
		driver.manage().window().maximize();
		System.out.println("THe wubdiw is maximised");

		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on create new account
		driver.findElement(By.linkText("Create New Account")).click();
		System.out.println("Link create new account is clicked");

		// Enter the first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Annamalai");
		System.out.println("Firstname entered successfully");

		// Enter lastname
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Narayananan");
		System.out.println("The lastname entered successfully");

		// Enter the mobile number
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9384805208");
		System.out.println("THe email entered successfully");

		// Enter the password
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Testleaf@2022!");
		System.out.println("THe password has set successfully");

		// Handle the dropdown
		// Select Day
		WebElement day = driver.findElement(By.name("birthday_day"));

		Select ddselect = new Select(day);
		ddselect.selectByIndex(29);
		System.out.println("Date is selected");

		// selectMonth
		WebElement month = driver.findElement(By.name("birthday_month"));
		Select monthselect = new Select(month);
		monthselect.selectByValue("6");
		System.out.println("THe month is selected");

		// Select year
		WebElement year = driver.findElement(By.name("birthday_year"));
		Select yrselect = new Select(year);
		yrselect.selectByVisibleText("1994");
		System.out.println("THe year is selected");

		// Select female checkbox
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		System.out.println("Female checkbox is selected");

		// CLose the tab
		driver.close();
		System.out.println("The tab is closed");

		// quit the browser
		driver.quit();
		System.out.println("THe browser is closed");

	}

}
