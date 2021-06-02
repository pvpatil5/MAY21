package practice_gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LaunchApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVApiDemosersion", "7.0");
		cap.setCapability("UDID", "d6c768cf9804");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", "");

		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver =  new AndroidDriver(url,cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByAccessibilityId("Views").click();

		Thread.sleep(1000);
		
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Controls\"]").click();

		
		
		
		
		
		

	}

}
