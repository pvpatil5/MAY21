package pac_driverMethods;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class DropdownHandling {

public static void main(String[] args) throws Throwable {
  
  //Starting the Server automatically with code
//    AppiumDriverLocalService server=AppiumDriverLocalService.buildDefaultService();
//    server.start();
    
    
    DesiredCapabilities dc = new DesiredCapabilities();
    dc.setCapability("deviceName", "Android Emulator");
    dc.setCapability("automationName", "Appium");
    dc.setCapability("platformName", "Android");
    dc.setCapability("platformVersion", "8.1.0");
    dc.setCapability("noReset", true);
    dc.setCapability("appPackage", "io.appium.android.apis");
    dc.setCapability("appActivity", ".ApiDemos");
    
    URL url = new URL("http://localhost:4723/wd/hub");
    AndroidDriver driver = new AndroidDriver(url,dc);
    
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    Dimension size = driver.manage().window().getSize();
    int ht = size.getHeight();
    int wd = size.getWidth();
    
    //Navigating to View page
    driver.findElementByAccessibilityId("Views").click();
    //Navigating to Control Page
    driver.findElementByAccessibilityId("Controls").click();
   //Navigating to Dark Theme  page
    driver.findElementByAccessibilityId("2. Dark Theme").click();
    
    //entering the data into the textbox    
    driver.findElementById("io.appium.android.apis:id/edit").sendKeys("TestCase");
    
    //Clicking on Radio Button
    driver.findElementByAccessibilityId("RadioButton 1").click();
    
    driver.hideKeyboard();
    
    //Clicking on DropDown
    driver.findElementById("io.appium.android.apis:id/spinner1").click();
 
    
    List<WebElement>planets = driver.findElements(By.xpath("//android.widget.CheckedTextView"));
       
    for(WebElement e : planets) 
	{
	String actual=	e.getText();
	
		if(actual.equals("Saturn")) 
		{
			e.click();
			break;
		}
	}
    
    
    
    
    
    
    
    //Select the Jupiter from DropDown
    //driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Jupiter']")).click();
    
    
    
    Thread.sleep(3000);
    driver.closeApp();
//    server.stop();
    
   
 }

}
