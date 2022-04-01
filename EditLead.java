package Week2.Day2Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
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

		// Enter first name
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item']//input[@name='firstName']"))
				.sendKeys("Sangavi");
		System.out.println("Firstname entered successfully");

		// Click on find leads link
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		System.out.println("Findleads link is clicked successfully");

		// Click on first resulting lead
		Thread.sleep(10000);
		WebElement ResultingLead = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		String LeadId = ResultingLead.getText();
		System.out.println("The lead id is " + LeadId);
		ResultingLead.click();

		// Verify title of the page
		String CurrentTitle = "View Lead | opentaps CRM";
		String Title = driver.getTitle();
		System.out.println(Title);

		if (CurrentTitle.equals(Title)) {
			System.out.println("The title is matching");
		} else {
			System.out.println("The title is not matching");
		}

		// Click edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		System.out.println("Edit button is clicked");

		// Change the company name
		WebElement CompanyName = driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']"));
		CompanyName.clear();
		System.out.println("THe company name is cleared");
		
		String ComName="System";
		CompanyName.sendKeys(ComName);
		System.out.println("The company name changed");
		
		//Click Update
		driver.findElement(By.xpath("//input[@Value='Update']")).click();
		System.out.println("Update button is clicked");
		
		//Confirm the changed name appears
		WebElement ChangedCompanyName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
		String NewChangedCom=ChangedCompanyName.getText();
		System.out.println(NewChangedCom);
		
		if(ComName.equals(NewChangedCom))
		{
			System.out.println("THe company name changed is matching");
		}
		else
		{
			System.out.println("The company name changed is not matching");
		}
		
		//close the browser
		driver.close();
	}
}
