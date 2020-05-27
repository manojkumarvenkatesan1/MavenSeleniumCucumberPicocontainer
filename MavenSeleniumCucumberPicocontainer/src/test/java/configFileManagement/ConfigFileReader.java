package configFileManagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import webDriverManagement.DriverType;
import webDriverManagement.EnvironmentType;

public class ConfigFileReader {

	private Properties property;
	private static String propertyFilePath="Config\\Configurations.properties";
	
	public ConfigFileReader()
	{
	BufferedReader reader;
	try
	{
		reader=new BufferedReader(new FileReader(propertyFilePath));
		property=new Properties();
		try
		{
			property.load(reader);
			reader.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
		throw new RuntimeException("configuration property file not found "+propertyFilePath);
	}
	}
	
	public String getUrl()
	{
		String url= property.getProperty("url");
		if (url!=null)
		{
			return url;
		}
		else
		{
			throw new RuntimeException("URL not specified in the configuration properties file");
		}
	}
	public long implicitWaitTime()
	{
		String implicitWait= property.getProperty("implicitWait");
		if (implicitWait!=null)
		{
			try {
			return Long.parseLong(implicitWait);
			}
			catch(NumberFormatException e)
			{
				throw new RuntimeException("Not able to parse value : " + implicitWait + " in to Long");
			}
		}
		else
		{
			throw new RuntimeException("implicit Wait time not specified in the configuration properties file");
		}
	}
	public String getDriverPath(){
		 String driverPath = property.getProperty("driverPath");
		 if(driverPath!= null) return driverPath;
		 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
		 }
	public DriverType getBrowser() {
		 String browserName = property.getProperty("browser");
		 if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
		 else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		 else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
		 else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
		 }
	public EnvironmentType getEnvironment() {
		 String environmentName = property.getProperty("environment");
		 if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		 else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
		 else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
		 }
	public Boolean getBrowserWindowSize() {
		 String windowSize = property.getProperty("windowMaximize");
		 if(windowSize != null) return Boolean.valueOf(windowSize);
		 return true;
		 }
}
