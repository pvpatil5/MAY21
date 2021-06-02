package practice_gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class IOSLAunchApp {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "iPhone");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "IOS");
		cap.setCapability("platformVersion", "12");
		cap.setCapability("UDID", "d6c768cf9804");
		/**
		 * If the application is not installed
		 */
		cap.setCapability("app", "path of application");
	
		/**
		 * If application is installed
		 */
		cap.setCapability("bundleId","");
		
		
		
		URL url = new URL("http://localhost:4723/wd/hub");
		
		IOSDriver driver =  new IOSDriver(url,cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

	}

}
