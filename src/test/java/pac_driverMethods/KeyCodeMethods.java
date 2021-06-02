package pac_driverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class KeyCodeMethods {

	public static void main(String[] args) throws Throwable {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("UDID", "d6c768cf9804");
		cap.setCapability("noReset", true);
		cap.setCapability("appPackage", "com.android.camera");
		cap.setCapability("appActivity", ".Camera" );

		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver =  new AndroidDriver(url,cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println(driver.isAppInstalled("io.appium.android.apis"));//true

		driver.lockDevice();
		
		System.out.println(driver.isLocked());//true
		
		Thread.sleep(2000);
		driver.unlockDevice();
		
		System.out.println(driver.isLocked());//false
		
		//	driver.pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);

		//		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_UP);
		//		
		//driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		//		
		//		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_MUTE);
		//		
		//		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_MUTE);
		//			
		//		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		//		
		//		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);
		//		
	}

}
