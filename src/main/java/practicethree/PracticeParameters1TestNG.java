package practicethree;

import org.testng.annotations.Optional;
import org.testng.annotations.*;

public class PracticeParameters1TestNG {
	
	@Parameters({"TestData"})
	@Test
	public void testParameters1(@Optional("aaa") String testdata) {
		ParseProperties pp= new ParseProperties(System.getProperty("user.dir")+testdata);
		System.out.println(pp.getValue("url"));
		System.out.println(pp.getValue("username"));
		System.out.println(pp.getValue("password"));
	}
}
