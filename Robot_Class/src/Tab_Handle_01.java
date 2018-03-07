import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tab_Handle_01 {

	WebDriver driver;

	@BeforeTest
	public void webDriver() throws InterruptedException {

		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.way2testing.com");
		Thread.sleep(4000);
		
	}
	@Test
	public void robotClass() throws AWTException, InterruptedException
	{
		Thread.sleep(4000);
		Robot robot =new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
		
		String main_window=driver.getWindowHandle();
		System.out.println("Parent window ::"+main_window);
		
		Thread.sleep(6000);
		ArrayList<String> ali= new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Total tabs are ::"+ali.size());
		
		driver.switchTo().window(ali.get(0));
		driver.navigate().to("http://www.onlineifsccodebank.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='txtIFSCCode' and @type='text']")).sendKeys("UTIB0003109");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='btnSearch' and @type='submit']")).click();
		Thread.sleep(3000);
		System.out.println("Total tabs are ::"+ali);
		Thread.sleep(3000);
		driver.close();
		
		
	}
	

}
