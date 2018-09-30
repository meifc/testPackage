package practiveDay01;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchChrome {
	private static WebDriver chromewb = null;
	private static DesiredCapabilities caps = null;
	private String projectPath=System.getProperty("user.dir");
	
	@BeforeClass
	public void startChrome() {
		System.setProperty("webdriver.chrome.driver", projectPath+"/tools/chromedriver.exe");
		caps=DesiredCapabilities.chrome();
		
		caps.setCapability("chrome.switches", Arrays.asList("--start-maximized")); //最大化browser
		//caps.setCapability("chrome.switches", Arrays.asList("--proxy-server=http://your-proxy-domain:4443")); //设置代理
		chromewb = new ChromeDriver(caps);
	}
	
	@Test
	public void searchONBaidu() {
		chromewb.get("http://www.baidu.com");
		

		
	}
	
	@AfterClass
	public void releaseIEDriver() {
		
		chromewb.quit();
	}
}
