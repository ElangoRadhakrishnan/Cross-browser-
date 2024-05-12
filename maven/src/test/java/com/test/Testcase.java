package com.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase {
	

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
	
	@Test
	
	
	public void page() {
		
		String actualtitle=driver.getTitle();
		
		System.out.println(actualtitle);
		
		
	}
	@AfterSuite
	
	public void close() throws IOException, InterruptedException {
		
		 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshot, new File("D:\\Apps\\soft.png"));
   
		Thread.sleep(50);
     	driver.close();
		
	}

}
