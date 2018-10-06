package practicethree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ParseProperties {
	private Properties pro= new Properties();
	String value=null;
	
	public ParseProperties(String propertiesPath) {
		this.loadProperties(propertiesPath);
	}

	private void loadProperties(String propertiesPath) {
		// TODO Auto-generated method stub
		try {
			InputStream  in= new FileInputStream(propertiesPath);
			InputStreamReader ins= new InputStreamReader(in);
			BufferedReader br= new BufferedReader(ins);
			pro.load(br);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(String keyname) {
		value =  pro.getProperty(keyname);
		try {
			value = new String(value.getBytes("UTF-8"),"UTF-8");
			
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public void main(String[] args) {
		// F:\eclipse-workspace\practiveDay01\tools
		// String path=new String(System.getProperty("user.dir")+"/tools/test3.properties");
		// System.out.println(path);
		ParseProperties pp=new ParseProperties("F:\\eclipse-workspace\\practiveDay01\\tools\\test3.properties");
		System.out.println(pp.getValue("url"));
	}
}
