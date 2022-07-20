package Demos;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBank1 {

	public static void main(String[] args) throws InterruptedException, Exception {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  
			driver.get("http://localhost:4200/");
		  
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.findElement(By.xpath(".//a[text()='Register']")).click();
		  

		// Excel Reading

		// 1.filinputstream
		// 2.workbook
		// 3.sheet
		// 4.row

		// for(row: 1----> row.size())
		// {
		// 5. row[i].col[0] //firstname
		// row[i].col[1] //lastname
		// row[i].col[2]
		// }
			


//File file = new File("E:\\Selenium\\Demos\\Selenium Practi\\TesBankDemos\\TestBanDemo2\\TestBankDemo2\\TestData\\ClientRegisterInfo.xlsx"); 
//FileInputStream fis = new FileInputStream(file);


// if file is .xlsx type, use XSSFWorkbook and file is of .xls type, then use HSSFWorkbook

//
//XSSFWorkbook wb = new XSSFWorkbook(fis);
//
//
//XSSFSheet ws = wb.getSheet("Sheet1");
//
//
//XSSFRow row = ws.getRow(1);
//
//
//XSSFCell cell = row.getCell(0);
//
//
//String UN = cell.getStringCellValue();
//
//
//System.out.println(UN);
//
//
//wb.close();
			
			
			
			
			File fi = new File(
					"E:\\Selenium\\Demos\\Selenium Practi\\TesBankDemos\\TestBankDemo\\TestData\\ClientRegisterInfo.xlsx");
			FileInputStream fis = new FileInputStream(fi);

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet("Sheet1");

		
			  // 2. Get multiple cell values
			  
			  int rowCount = ws.getLastRowNum(); // 4
			  
			  for (int i = 1; i <= rowCount; i++) { 
			  String fn =ws.getRow(i).getCell(0).getStringCellValue();
			  String ln =ws.getRow(i).getCell(1).getStringCellValue();
			  String email =ws.getRow(i).getCell(2).getStringCellValue();
			  double mobile =ws.getRow(i).getCell(3).getNumericCellValue();
			  String ms =ws.getRow(i).getCell(4).getStringCellValue();
			  double dob =ws.getRow(i).getCell(5).getNumericCellValue();
			  
			  
			
			  
			  
			  
			  
			  
				driver.findElement(By.id("firstName")).sendKeys(fn);
				driver.findElement(By.id("lastName")).sendKeys(ln);
				driver.findElement(By.id("email")).sendKeys(email);
				driver.findElement(By.id("mobile")).sendKeys(String.valueOf(mobile));

				// driver.findElement(By.id("MaritalStatus")).sendKeys("Single");
				Select drpMS = new Select(driver.findElement(By.id("MaritalStatus")));
				drpMS.selectByVisibleText(ms);

				driver.findElement(By.id("dob")).sendKeys(String.valueOf(dob));
				Thread.sleep(3000);
				driver.findElement(By.cssSelector(".mb-3.text-center>input[value='next']")).click();
				Thread.sleep(1000);
		
			  
		
			  System.out.println("Test :" + i); 
//			  driver.quit(); 
			  }
			  	  
		  

	  
		  
		
	

	

	
	}
	
}
