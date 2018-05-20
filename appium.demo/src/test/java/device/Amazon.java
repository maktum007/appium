package device;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Amazon 
{
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException
	{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "7.0");
		capabilities.setCapability("deviceName", "Redmi");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testCal() throws Exception 
	{
		System.out.println("App Launched");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("vintage");
	}

	@AfterClass
	public void teardown() 
	{

		
	}

}
