package sauce_appium_junit;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.appium.page_object.ios.TestAppScreenSimple;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class RealDeviceTest {

	private IOSDriver driver;
	
	@Before
	public void setUp() throws Exception {
         File app = new File( "/Users/Hsinyi/Library/Developer/Xcode/DerivedData/EsunMobileBank-gmvukxjyiqhyqhadahjafizronhl/Build/Products/Debug-iphoneos/玉山銀行.app");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Cyndi's iPhone+");
	    capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.6.4");
	    capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "tw.com.ESunbank.mobilebanking.ch.release");
	 //   capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, "50");
	    capabilities.setCapability(IOSMobileCapabilityType.SHOW_XCODE_LOG, true);
	    capabilities.setCapability(IOSMobileCapabilityType.PLATFORM, "iPhone 7 Plus");
	    capabilities.setCapability("xcodeSigningId","iPhone Developer");
	    capabilities.setCapability("udid","d652c7b113f9097904810ec59d5c9c5552c61147");
	    capabilities.setCapability("xcodeOrgId", "9UZJX5DLZT");
	    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	    
	 
	    driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	   
		System.out.println(driver.getPageSource());
		//PageFactory.initElements(new AppiumFieldDecorator(driver), uiTestApp);
			
		
	}
	
	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}
	
	@Test
	public void findByElementsTest() throws InterruptedException {
		Thread.sleep(6000);
		
		WebElement element =  driver.findElement(By.name("允許"));
		element.click();
		
		Thread.sleep(9000);
		
		element = driver.findElement(By.name("id"));
		element.sendKeys("H200811341");

		element = driver.findElement(By.name("chid"));
		element.click();
		
		element = driver.findElement(By.name("userName"));
		element.sendKeys("xxxx");
		
		element = driver.findElement(By.name("userPassword"));
		element.sendKeys("xxxx");
		
		element = driver.findElement(By.name("VerificationCode"));
		element.sendKeys("12345");
		driver.hideKeyboard();
		element = driver.findElement(By.name("登入"));
		element.click();
	
		
	}
	
	
}
