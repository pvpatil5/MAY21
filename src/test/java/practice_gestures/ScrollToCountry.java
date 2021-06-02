package practice_gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class ScrollToCountry {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVApiDemosersion", "7.0");
		cap.setCapability("UDID", "d6c768cf9804");
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity", ".SplashActivity");

		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver =  new AndroidDriver(url,cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		
		scrollToElement(driver, "text", "India");
	
		Thread.sleep(1000);
		
		driver.findElementByXPath("//android.widget.TextView[@text='India']").click();
		
		
		Thread.sleep(3000);
		service.stop();
	}
	public static void scrollToElement(AndroidDriver driver,String an,String av)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	}

}
