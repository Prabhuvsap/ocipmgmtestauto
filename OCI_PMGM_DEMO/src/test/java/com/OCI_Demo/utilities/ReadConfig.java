package com.OCI_Demo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		try	
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public String getChromePath()
	{
		String chromePath = pro.getProperty("chromepath");
		return chromePath;
	}
	
	public String getIePath()
	{
		String iePath = pro.getProperty("iepath");
		return iePath;
	}
	public String getFireFoxPath()
	{
		String fireFoxPath = pro.getProperty("firefoxpath");
		return fireFoxPath;
	}
	
	public String getBaseUrl()
	{
		String baseUrl = pro.getProperty("baseURL");
		return baseUrl;
	}
	public String getUsername()
	{
		String userName = pro.getProperty("username");
		return userName;
	}
	
	public String getPassword()
	{
		String passWord = pro.getProperty("password");
		return passWord;
	}
	
	public String getBrowserName()
	{
		String browserName = pro.getProperty("browserName");
		return browserName;
	}
	
}
