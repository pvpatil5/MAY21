package pac_driverMethods;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class LaunchApp_Back {
	public static void main(String[] args) throws Throwable 
	{

		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.usingPort(4723)
				.withLogFile(new File("../AppiumMay2021/Logs1.txt")));

		service.start();	



		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Android Emulator");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.1.0");

		cap.setCapability("noReset", true);
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity",".SplashActivity" );

		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver =  new AndroidDriver(url,cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//	driver.runAppInBackground(10);

		Thread.sleep(2000);
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		
		driver.startActivity("io.appium.android.apis", ".ApiDemos");

		driver.findElementByAccessibilityId("Views").click();

		driver.findElementByAccessibilityId("Drag and Drop").click();

		driver.launchApp();





		service.stop();

	}
}
