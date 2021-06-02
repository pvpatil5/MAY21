package pac_driverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;

public class NetworkConnection {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVApiDemosersion", "7.0");
		cap.setCapability("UDID", "d6c768cf9804");
		cap.setCapability("noReset", true);
		cap.setCapability("appPackage", "com.android.camera");
		cap.setCapability("appActivity", ".Camera" );

		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver =  new AndroidDriver(url,cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.openNotifications();
		
		System.out.println(driver.getConnection());
		
		driver.setConnection(Connection.AIRPLANE);		
		
		System.out.println(driver.getConnection());
			
		driver.setConnection(Connection.WIFI);		
		
		System.out.println(driver.getConnection());
		
		
		
		
		
		
		
		
	}

}
