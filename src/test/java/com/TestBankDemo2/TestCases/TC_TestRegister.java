package com.TestBankDemo2.TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBankDemo2.Pages.AccountTypeDetailsPage;
import com.TestBankDemo2.Pages.AddressDetailsPage;
import com.TestBankDemo2.Pages.CongratsMessagePage;
import com.TestBankDemo2.Pages.HomePage;
import com.TestBankDemo2.Pages.PersonalDeatilsPage;
import com.TestBankDemo2.Utilities.XLUtils;

public class TC_TestRegister extends Base {

	
	public static WebDriver driver;
	
	@Test(dataProvider="RegisterData")
	public void tc1(String firstname,String lastName,String email,String mobile
			,String martialStatus,String dOB  ,String addressLine1,String addressLine2,String country,String state,
			String city,String accountType, String accountSubType,String balance ,String transferLimit,String branchCode,String loanDuration,String loanAmount ) throws Exception {

		
            // printing excel row value 		
			System.out.println(firstname + lastName + email + mobile + martialStatus + dOB + addressLine1 + addressLine2
					+ country + state + city + accountType + accountSubType + balance + transferLimit + branchCode
					+ loanDuration + loanAmount);

			//driver = new EdgeDriver();
//			driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			driver.get(baseURL);
//
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// 1.HomePage
			HomePage hm = new HomePage(driver);
			hm.clickRegister();

			
			
			
			Thread.sleep(3000);

			// 2.PersonalDetailsPage
			PersonalDeatilsPage pd = new PersonalDeatilsPage(driver);
			pd.enterFirstname(firstname);
			pd.enterLastName(lastName);
			pd.enterEmail(email);
			pd.enterMobile(mobile);
			pd.enterMartialStatus(martialStatus);
			pd.enterdob("17-09-2002");
			pd.PersonalNxtBtnClick();

			Thread.sleep(3000);

			// 3.AddressDetailsPage
			AddressDetailsPage ad = new AddressDetailsPage(driver);
			ad.enterAddressLine1(addressLine1);
			ad.enterAddressLine2(addressLine2);
			ad.enterCountry(country);
			ad.enterState(state);
			ad.enterCity(city);
			ad.addSubmitBtn();

			Thread.sleep(3000);

			// 4.AccountTypeDetailsPage
			AccountTypeDetailsPage actype = new AccountTypeDetailsPage(driver);

			if (accountType.equalsIgnoreCase("Savings Account")) {
				// 4.1 Saving Account
				actype.selectAccountType(accountType);
				actype.enterActSubType(accountSubType);
				actype.enterBalance(balance);
				actype.enterBrancCode(branchCode);
				actype.enterTransferLimit(transferLimit);
			} else {
				// 4.2 Loan Account
				actype.selectAccountType(accountType);
				actype.enterActSubType(accountSubType);
				actype.enterBrancCode(branchCode);
				actype.enterLDuration(loanDuration);
				actype.enterLAmount(loanAmount);
				actype.clickCalculteBtn();

			}

			Thread.sleep(2000);
			actype.actSubmitBtn();

			Thread.sleep(2000);

			// 5.CongratsMessagePage
			CongratsMessagePage cmp = new CongratsMessagePage(driver);
			cmp.msgBox();
			cmp.clickMsgBt();

			// boolean b=actype.selectByText("Savings Account");
			// System.out.println(b);

			Thread.sleep(3000);
			driver.quit();

		//}

	}
	
	
	
	@DataProvider(name="RegisterData")
	String [][] getData() throws IOException
	{
		String path= System.getProperty("user.dir") + "\\TestData\\ClientRegisterInfo.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String registerdata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				registerdata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return registerdata;
	}

}
