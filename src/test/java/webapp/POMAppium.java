package webapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class POMAppium {

	@Test
	public void pomAppium() throws MalformedURLException, InterruptedException {
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

		Sample s1 = new Sample(driver);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(s1.getEntername()));
		s1.getEntername().sendKeys("PAvan");

		s1.getLetsShopBtn().click();

		s1.getCartbtn().click();

		String toast=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(toast);


	}

}
