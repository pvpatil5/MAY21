package pac_driverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Notifications {

	public static void main(String[] args) throws Throwable {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVApiDemosersion", "7.0");
		cap.setCapability("UDID", "d6c768cf9804");
		cap.setCapability("noReset", true);
		cap.setCapability("appPackage", "com.bhanu.notificationreminders");
		cap.setCapability("appActivity", ".MainDrawerActivity" );

		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver =  new AndroidDriver(url,cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//driver.findElementById("com.bhanu.notificationreminders:id/invite_friends_close").click();

		driver.findElementById("com.bhanu.notificationreminders:id/txtNewNoteTitle").sendKeys("new notification");

		driver.findElementById("com.bhanu.notificationreminders:id/btnNotify").click();

		Thread.sleep(2000);
		//driver.closeApp();

		driver.openNotifications();

		//driver.findElementById("android:id/notification_main_column").click();

		driver.findElementByAccessibilityId("Read").click();
		

	}

}
