package practicetwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.*;

public class BrowsersTest {
	private WebDriver dirver;
//	private APIObject testlinkapi;
	private String casename;
	
	@BeforeClass
	public void beforeClass() {
		Browsers browsers=new Browsers(BrowsersType.firefox);
		dirver=browsers.driver;
	}
	
	@Test
	public void start() {
		casename= "test 163.mail";
		System.out.println("****Start  atuo  test casename is"+casename+" ******** ");
		dirver.get("https://mail.163.com/");	
		  
		dirver.findElement(By.xpath("//input[@name='email']")).clear(); 
		dirver.findElement(By.xpath("//input[@name='email']")).sendKeys("meifctest");
		dirver.findElement(By.xpath("//input[@name='password']")).sendKeys("meifctest123"); 
		dirver.findElement(By.xpath("//a[@id='dologin']")).click();  
		
		Assert.assertEquals(dirver.findElement(By.xpath("//*[@id='_mail_tabitem_0_42text']")).isDisplayed(), true);
//		Assert.assertEquals(true, true);
		
	}
}
