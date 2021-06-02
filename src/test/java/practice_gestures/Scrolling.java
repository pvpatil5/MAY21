package practice_gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Scrolling {

	static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Android Emulator");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("UDID", "d6c768cf9804");
		cap.setCapability("noReset", true);


		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity","ApiDemos" );

		URL url = new URL("http://localhost:4723/wd/hub");

		driver =  new AndroidDriver(url,cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		
		scrollToElement(driver, "text", "Popup Menu");

		WebElement lists=driver.findElementByAccessibilityId("Lists");

		lists.click();
		
		scrollToElement(driver, "text", "	17. Activate items");
		
		
		driver.findElementByAccessibilityId("17. Activate items").click();
		
	}
	
	public static void scrollToElement(AndroidDriver driver,String an,String av)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	}


}
