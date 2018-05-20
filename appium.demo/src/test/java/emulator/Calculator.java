package emulator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class Calculator 
{
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException
	{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "6.0.1");
		capabilities.setCapability("deviceName", "Emulator");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testCal() throws Exception 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='4']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='×']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='=']")).click();
		String result=driver.findElement(By.id("com.android.calculator2:id/result")).getText();
		System.out.println("The ouput is "+result);
	}

	@AfterClass
	public void teardown() 
	{

		driver.quit();
	}
}
