package practicetwo;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browsers {
	public WebDriver driver = null;
	private FirefoxProfile firefoxProfile = null;
	private static DesiredCapabilities caps =null;
	private String projectpath = System.getProperty("user.dir");
	
	public Browsers(BrowsersType browserstype) {
		switch(browserstype) {
		case firefox:
			firefoxProfile = new FirefoxProfile();
//			File firebug=new File(projectPath+"/tools/firebug-1.12.1-fx.xpi"); firebug@software.joehewitt.com.xpi
//			File firepath=new File(projectPath+"/tools/firepath-0.9.7-fx.xpi"); FireXPath@pierre.tholence.com.xpi
			try {
				System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
				System.setProperty("webdriver.gecko.driver", projectpath+"/tools/geckodriver.exe");
				firefoxProfile.setPreference("webdriver.accept.untrusted.certs", true);
//				firefoxProfile.addExtension(firebug);
//				firefoxProfile.addExtension(firepath);
//				firefoxProfile.setPreference("extension.firebug.currentVersion", "1.12.1");
//				firefoxProfile.setPreference("network.proxy.type", 0);
//				firefoxProfile.setPreference("network.proxy.http", "10.1.1.0");
//				firefoxProfile.setPreference("network.proxy.http_prot", 3128);
			}catch(Exception e) {
				e.printStackTrace();
			}
			driver = new FirefoxDriver(firefoxProfile);
			driver.manage().window().maximize();
			break;
		case ie:
			System.setProperty("webdriver.ie.driver", projectpath+"/tools/IEDriverServer.exe");
			caps=DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "private");
			caps.setCapability("ignoreZoomSetting", true);
			driver = new InternetExplorerDriver(caps);
			driver.manage().window().maximize();
			break;
		case chrome:
			System.setProperty("webdriver.chrome.driver", projectpath+"/tools/chromedriver.exe");
			caps=DesiredCapabilities.chrome();
			
			caps.setCapability("chrome.switches", Arrays.asList("--start-maximized")); //最大化browser
			//caps.setCapability("chrome.switches", Arrays.asList("--proxy-server=http://your-proxy-domain:4443")); //设置代理
			driver = new ChromeDriver(caps);
			driver.manage().window().maximize();
			break;
		}
	}
}
