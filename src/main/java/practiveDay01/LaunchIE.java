package practiveDay01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
//import org.snipecode.reg.Regutil;

public class LaunchIE {
	private static WebDriver iewb = null;
	private static DesiredCapabilities caps = null;
	private String projectPath=System.getProperty("user.dir");
	
	@BeforeClass
	public void startIE() {
		System.setProperty("webdriver.ie.driver", projectPath+"/tools/IEDriverServer.exe");
		caps=DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "private");
		caps.setCapability("ignoreZoomSetting", true);
		iewb = new InternetExplorerDriver(caps);
	}
	
	@Test
	public void searchONBaidu() {
		iewb.get("http://www.baidu.com");
		
		//ie不信任网址时我们需要添加
		//iewb.get("javascript:document.getElementById('overridelink').click();"); 
		System.out.println(iewb.getWindowHandle());
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void releaseIEDriver() {
		iewb.close();
		iewb.quit();
	}
		
}
