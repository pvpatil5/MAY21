package webapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebApp {

	public static void main(String[] args) throws Throwable {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
		cap.setCapability(MobileCapabilityType.UDID, "d6c768cf9804");
		cap.setCapability("noReset", true);
		
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	

		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver =  new AndroidDriver(url,cap);
		
		driver.get("https://facebook.com");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("TYSS");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='m_login_password']")).sendKeys("1234");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='login']")).click();

	}

}
