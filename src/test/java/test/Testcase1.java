package test;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
//import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;

import pages.LoginPage;

//import com.relevantcodes.extentreports.ExtentReports;

public class Testcase1 {
	
	XSSFWorkbook Wb;
	XSSFSheet sheet;
	WebDriver driver;
	@BeforeMethod
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver","/home/reethacmtecnotr/Downloads/chromedriver");
		//System.setProperty("webdriver.gecko.driver","/home/reethacmtecnotr/Downloads/geckodriver");
		 
		//extent = new ExtentReports("ExtentReport.html",true);
		driver = new ChromeDriver();
		
		driver.get("https://github.com/");
		
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		FileInputStream file = new FileInputStream("TestData.xlsx");
		Wb = new XSSFWorkbook(file);
		sheet= Wb.getSheet("datasheet");
	}
	
	@Test
	public void LoginTest() {
		
		LoginPage obj = new LoginPage(driver);
		obj.login("Username", "Password");
		
	}
	
	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
	}

}
