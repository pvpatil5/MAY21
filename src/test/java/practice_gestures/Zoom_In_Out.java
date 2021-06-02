package practice_gestures;

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


		Dimension size = driver.manage().window().getSize();

		int ht=size.getHeight();
		int wd= size.getWidth();
		
		
		TouchAction finger1 = new TouchAction(driver);
		finger1.press((int)(wd*0.5), (int)(ht*0.4)).moveTo((int)(wd*0.5),(int)(ht*0.1));
		
		TouchAction finger2 = new TouchAction(driver);
		finger2.press((int)(wd*0.5), (int)(ht*0.6)).moveTo((int)(wd*0.5),(int)(ht*0.8));
		
		MultiTouchAction action = new MultiTouchAction(driver);
		action.add(finger1).add(finger2).perform();
		
		Thread.sleep(3000);
		
		TouchAction finger3= new  TouchAction(driver);
		finger3.press((int)( wd*0.5), (int)(ht*0.2)).moveTo((int)(wd*0.5),(int)(ht*0.5));
		
		TouchAction finger4= new  TouchAction(driver);
		finger4.press((int)( wd*0.5), (int)(ht*0.8)).moveTo((int)(wd*0.5),(int)(ht*0.5));

		MultiTouchAction action1 = new MultiTouchAction(driver);
		action1.add(finger3).add(finger4).perform();

	}

}
