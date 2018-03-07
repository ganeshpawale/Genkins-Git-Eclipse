import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Upload_File_Using_Robot_Class {

	WebDriver driver=null;
	@Test
	public void Uploadfile() throws AWTException
	{
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//input[@id='imagesrc' and @type='file']")).click();
		
		Robot robot= new Robot();//using robot class
		
		robot.delay(3000);//same thread.sleep method
		
		//copy this current path
		StringSelection copy= new StringSelection("E:\\Java sel\\Robot class\\blank file for upload.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copy,null);
		
		robot.delay(3000);
		//paste this path into location 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.delay(3000);
		//release key before press
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.delay(3000);
		//hit enter button for submit
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("Demo....");
		
	}
}
