package webapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class ParallelTesting 
{
	@Test
	@Parameters({"deviceName","platformVersion","UDID","port"})
	public void parallelexecutoon(String deviceName,String platformVersion, String UDID, String port ) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName",deviceName );
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion",platformVersion );
		cap.setCapability("UDID", UDID);
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity",".SplashActivity" );
		cap.setCapability("noReset", true);//to use app without resetting it in automation script
		URL url = new URL("http://localhost:"+port+"/wd/hub");
		AndroidDriver driver =  new AndroidDriver(url,cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Pavan");

		//driver.findElementByXPath("//android.widget.EditText[@text='Let's Shop']").click();;
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		driver.findElementByXPath("//android.widget.TextView[@text='ADD TO CART']").click();


	}










}
