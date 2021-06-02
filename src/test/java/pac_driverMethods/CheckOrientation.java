package pac_driverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class CheckOrientation {

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

		//driver.runAppInBackground(20);
		
	
	
		
		
		ScreenOrientation currentoretation = driver.getOrientation();

		System.out.println(currentoretation);

		
		
		Thread.sleep(2000);
		driver.rotate(ScreenOrientation.LANDSCAPE);
		Thread.sleep(2000);
		System.out.println( driver.getOrientation());
		scrollToElement(driver, "text", "Views");
		driver.findElementByAccessibilityId("Views").click();
		scrollToElement(driver, "text", "Drag and Drop");
		driver.findElementByAccessibilityId("Drag and Drop").click();





	}
	public static void scrollToElement(AndroidDriver driver,String an,String av)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	}


}
