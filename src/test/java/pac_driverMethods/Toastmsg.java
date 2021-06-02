package pac_driverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Toastmsg {
	public static void main(String[] args) throws Throwable {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity",".SplashActivity" );
		cap.setCapability("noReset", true);//to use app without resetting it in automation script
		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver =  new AndroidDriver(url,cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		//
		//		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

		String toast=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(toast);

	}
}
