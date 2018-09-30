package practiveDay01;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchFirefox {
	private  WebDriver ffwb = null;
	private FirefoxProfile firefoxProfile =null;
	private String projectPath=System.getProperty("user.dir");
	
	@BeforeClass
	public void startFF() {
	
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver", projectPath+"/tools/geckodriver.exe");
		
		//File firebug=new File(projectPath+"/tools/firebug-1.12.1-fx.xpi");
		//File firepath=new File(projectPath+"/tools/firepath-0.9.7-fx.xpi");
		firefoxProfile = new FirefoxProfile(); 
		try {
			//firefoxProfile.addExtension(firebug);
			//firefoxProfile.addExtension(firepath);
			
			firefoxProfile.setPreference("webdriver.accept.untrusted.certs", true);
			
			//firefoxProfile.setPreference("extension.firebug.currentVersion", "1.12.1");
			
			firefoxProfile.setPreference("network.proxy.type", 0);
			firefoxProfile.setPreference("network.proxy.http", "10.1.1.0");
			firefoxProfile.setPreference("network.proxy.http_prot", 3128);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ffwb = new FirefoxDriver(firefoxProfile);
	}
	
	@Test
	public void searchONBaidu() {
		ffwb.get("http://www.baidu.com");
		
		//ie不信任网址时我们需要添加
		//iewb.get("javascript:document.getElementById('overridelink').click();"); 
		//System.out.println(ffwb.getWindowHandle());

	}
	
	@AfterClass
	public void releaseIEDriver() {
		ffwb.close();
		ffwb.quit();
	}
}
