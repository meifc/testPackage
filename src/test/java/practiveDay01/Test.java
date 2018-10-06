package practiveDay01;

import practicethree.ParseProperties;

public class Test {
	
	public void main() {
		
		String path=new String(System.getProperty("user.dir")+"/tools/test3.properties");
		System.out.println(path);
		ParseProperties pp=new ParseProperties(path);
		System.out.println(pp.getValue("url"));
		//ParseProperties propo =new ParseProperties();
		
	}

}
