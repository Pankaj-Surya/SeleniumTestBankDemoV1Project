package com.TestBankDemo2.TestCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.TestBankDemo2.Pages.AccountTypeDetailsPage;
import com.TestBankDemo2.Pages.AddressDetailsPage;
import com.TestBankDemo2.Pages.CongratsMessagePage;
import com.TestBankDemo2.Pages.HomePage;
import com.TestBankDemo2.Pages.PersonalDeatilsPage;
import com.TestBankDemo2.Utilities.ReadConfig;
import com.TestBankDemo2.Utilities.XLUtils;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
 

	
	//1
	public static WebDriver driver;
	
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeTest
	public  void setup(String br) throws Exception {
	
		logger = LogManager.getLogger("Base");
		System.out.println(baseURL);
		logger.info("for info only");
		logger.fatal("fatal msg");

		logger.debug("for debug");
		logger.error("error message");
		logger.warn("warning message");
		
		if(br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");							
			driver = new ChromeDriver();
		}else if(br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(br.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.msedge.driver", ".\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}		
		driver.manage().window().maximize();
		//driver.get(baseURL);
       //System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Demos\\Selenium Practi\\TesBankDemos\\TestBanDemo2\\TestBankDemo2\\Drivers\\geckodriver.exe");	

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	
	
	}
	
	@AfterTest
	public void teardown() {	
		driver.quit();
	}

	
	
	
}
