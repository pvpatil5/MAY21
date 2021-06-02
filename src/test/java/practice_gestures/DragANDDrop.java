package practice_gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DragANDDrop {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVApiDemosersion", "7.0");
		cap.setCapability("UDID", "d6c768cf9804");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", ".ApiDemos" );

		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver =  new AndroidDriver(url,cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementByAccessibilityId("Views").click();

		driver.findElementByAccessibilityId("Drag and Drop").click();

		WebElement src = driver.findElementById("io.appium.android.apis:id/drag_dot_1");

		Thread.sleep(2000);

		// = driver.findElementById("	io.appium.android.apis:id/drag_dot_2");

		WebElement dest=	driver.findElementByXPath("//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_3']");
		
		TouchAction ta = new TouchAction(driver);

		ta.longPress(src).waitAction(2000).moveTo(dest).release().perform();



	}

}
