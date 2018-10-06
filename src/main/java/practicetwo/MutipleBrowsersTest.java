package practicetwo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class MutipleBrowsersTest {
	private WebDriver webdriver=null;
	private Browsers browsers=null;
	
	
	@BeforeMethod(groups="browsers")
	public  void inital() {
		browsers=new Browsers(BrowsersType.firefox); 
		webdriver=browsers.driver;
	}
	
	@Test(groups="submodule1")
	public void submodule1() {
		webdriver.get("http://www.baidu.com");
		System.out.println("test submodule1   ---  test  baidu----");
	}
	
	@Test(groups="submodule2")
	public void submodule2() {
		webdriver.get("http://www.bing.com");
		System.out.println("test submodule1   ---  test  bing----");
	}
	
	@Test(groups="submodule3")
	public void submodule3() {
		webdriver.get("http://www.so.com");
		System.out.println("test submodule1   ---  test  so----");
	}
	
	@Test(groups="submodule4")
	public void submodule4() {
		webdriver.get("http://www.alipay.com");
		System.out.println("test submodule1   ---  test  alipay----");
	}
	
	@AfterMethod(groups="browsers")
	public void release() {
		webdriver.quit();
	}
}
	