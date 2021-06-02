package webapp;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Sample {
	
	AndroidDriver driver;
	
	@FindBy (id="com.androidsample.generalstore:id/btnLetsShop") //1
	private MobileElement letsShopBtn; //2
	
	
	
	@FindBy (id="com.androidsample.generalstore:id/nameField")
	private MobileElement entername;
	
	@FindBy (id="com.androidsample.generalstore:id/appbar_btn_cart")
	private MobileElement cartbtn;
	
	public MobileElement getLetsShopBtn() {
		return letsShopBtn; 	//3
	}

	public MobileElement getEntername() {
		return entername;
	}

	public MobileElement getCartbtn() {
		return cartbtn;
	}

	public Sample(AndroidDriver driver) //4
	{
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	
	
	
	
	
	
	
	
	
	
}
