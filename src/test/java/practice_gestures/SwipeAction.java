package practice_gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class SwipeAction {
	static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("UDID", "d6c768cf9804");
		cap.setCapability("noReset", true);


		cap.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
		cap.setCapability("appActivity","TouchScreenTestActivity" );

		URL url = new URL("http://localhost:4723/wd/hub");

		driver =  new AndroidDriver(url,cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Dimension size = driver.manage().window().getSize();
		int ht=size.getHeight();
		int wd= size.getWidth();
		//		System.out.println("Height of phone is="+ht);
		//		System.out.println("Width of phone is="+wd);

		/*
		 * Swipe action horizontallay
		 */


		driver.swipe((int)(wd*0.1),(int) (ht*0.8),(int) (wd*0.9), (int)(ht*0.8), 500);

		driver.swipe((int)(wd*0.1),(int) (ht*0.2),(int) (wd*0.9), (int)(ht*0.2), 500);

		driver.swipe((int)(wd*0.1),(int) (ht*0.5),(int) (wd*0.9), (int)(ht*0.5), 500);


		driver.swipe((int)(wd*0.1),(int) (ht*0.2),(int) (wd*0.1), (int)(ht*0.8), 500);

		driver.swipe((int)(wd*0.5),(int) (ht*0.2),(int) (wd*0.5), (int)(ht*0.8), 500);

		driver.swipe((int)(wd*0.9),(int) (ht*0.2),(int) (wd*0.9), (int)(ht*0.8), 500);




		/**
		 * Swipe verticallay
		 */

		//		driver.swipe((wd/4),150,(wd/2),1500,500);
		//
		//
		//		driver.swipe((int) 490.3, 201, 490, 1585, 500);
		//		
		//		driver.swipe(76, 961, 1007, 925, 1000);


	}

	public int getHeight() {
		Dimension size = driver.manage().window().getSize();
		return size.getHeight();
	}

	public int getWidth() {
		Dimension size = driver.manage().window().getSize();
		return size.getWidth();
	}

	
	public void swipeRighttoleft(int startx, int starty, int endx, int endy) 
	{
		driver.swipe(startx, starty, endx, endy, 500);
	}



}
