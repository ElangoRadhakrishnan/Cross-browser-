package com.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	
	public static WebDriverWait wait;
	
	public String browsername="edge";
	
	public static String url="https://www.saucedemo.com/v1/";
	
	
	
	@BeforeSuite
	
	public void setupbrowser() {
		
		
		
		
		if (browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			 
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			
			
		}
		
		else if(browsername.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			
		}
		
		else if(browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			
		}

		else if(browsername.equals("safari")) {
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			
		
		}	
		
		else if(browsername.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			
	
		
		}	
		
		
	}
	
	
	@AfterSuite
	
	public void close() {
		//driver.close();
		//driver.quit();
	}

}
