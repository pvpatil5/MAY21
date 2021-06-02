package practice_gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.internal.ApacheHttpClient;
import org.openqa.selenium.remote.internal.HttpClientFactory;

import io.appium.java_client.MobileCommand;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AppiumCommandExecutor;

public class TapOnelement {
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException 
	{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("UDID", "d6c768cf9804");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", "ApiDemos");

		int con_timeout = 1200000;
		int soc_timeout = 90000;
		ApacheHttpClient.Factory clientFactory = new ApacheHttpClient.Factory(new
		HttpClientFactory(con_timeout, soc_timeout));
		AppiumCommandExecutor executor = new AppiumCommandExecutor(MobileCommand.commandRepository, new URL("http://localhost:4723/wd/hub"), clientFactory);
			
		URL url = new URL("http://localhost:4723/wd/hub");

		driver =  new AndroidDriver(url,cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		MobileElement content = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Content\"]"));
		
		taponElement(content);
		
		tapbyCoordinates(277, 1037);
			
		//AppiumCommandExecutor executor = new AppiumCommandExecutor(MobileCommand.commandRepository, new URL("http://localhost:4723/wd/hub"));
	}
	
	public static void taponElement(WebElement element) {
		driver.tap(1,element,500);
	}
	
	public static void tapbyCoordinates(int x,int y) {
		driver.tap(1, x, y, 500);
	}
	
	
	

}
