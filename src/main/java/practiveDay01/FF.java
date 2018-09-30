package practiveDay01;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

import org.testng.annotations.Test;

public class FF {
	private  WebDriver ffwb = null;
	
	private String projectPath=System.getProperty("user.dir");
	
	@Test
	public void startFF() {
	
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver", projectPath+"/tools/geckodriver.exe");
		
		
		
		try {

			ffwb = new FirefoxDriver();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		ffwb.get("http://www.baidu.com");

	}
	
	
	
	@AfterClass
	public void releaseIEDriver() {
		ffwb.close();
		ffwb.quit();
	}
}
