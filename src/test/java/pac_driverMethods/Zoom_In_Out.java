package pac_driverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Zoom_In_Out {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("noReset", true);
		cap.setCapability("UDID", "d6c768cf9804");
		cap.setCapability("appPackage", "com.davemorrissey.labs.subscaleview.sample");
		cap.setCapability("appActivity", ".MainActivity");
//		cap.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
//		cap.setCapability("appActivity","TouchScreenTestActivity" );

		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver =  new AndroidDriver(url,cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementById("com.davemorrissey.labs.subscaleview.sample:id/basicFeatures").click();

		WebElement image =driver.findElementById("com.davemorrissey.labs.subscaleview.sample:id/imageView");

		driver.zoom(image);
		
		Thread.sleep(3000);
		
		driver.pinch(image);
	}

}
