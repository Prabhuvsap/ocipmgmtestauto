package com.OCI_Demo.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.OCI_Demo.utilities.*;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	
	public String baseURL =  readConfig.getBaseUrl();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setUp()
	{
		logger = Logger.getLogger("Demo");
		PropertyConfigurator.configure("log4j.properties");
		
		if(readConfig.getBrowserName().equalsIgnoreCase("Chrome"))
		{
		
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		else if(readConfig.getBrowserName().equalsIgnoreCase("IE"))
		{
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + readConfig.getIePath());
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		else if(readConfig.getBrowserName().equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + readConfig.getFireFoxPath());
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		logger.info("Driver is closed");
	}
}
