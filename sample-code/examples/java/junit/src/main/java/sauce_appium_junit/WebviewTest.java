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
import io.appium.java_client.remote.MobileCapabilityType;

public class WebviewTest {

	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		
		File app = new File("/Users/Hsinyi/Library/Developer/Xcode/DerivedData/EsunMobileBank-gmvukxjyiqhyqhadahjafizronhl/Build/Products/Debug-iphonesimulator/玉山銀行.app");
       //  File app = new File( "/Users/Hsinyi/Library/Developer/Xcode/DerivedData/EsunMobileBank-cvipwbwbzeyruyafgtaswyntypji/Build/Products/Debug-iphonesimulator/玉山銀行.app");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
	    capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.6");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
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
		WebElement element =  driver.findElement(By.name("Allow"));
		element.click();
		
		Thread.sleep(3000);
		
		element = driver.findElement(By.name("直接開始體驗"));
		element.click();
		
		element = driver.findElement(By.name("完成"));
		element.click();
		
		element = driver.findElement(By.name("我知道了 !"));
		element.click();
		
		element = driver.findElement(By.name("申辦信用卡"));
		
		System.out.println(element);
		element.click();
		
		element = driver.findElement(By.name("玉山幸運PLUS鈦金卡（限女性申辦）"));
		element.click();
		

	}
}
