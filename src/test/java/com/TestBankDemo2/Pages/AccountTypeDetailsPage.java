package com.TestBankDemo2.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AccountTypeDetailsPage {

	// 1.WebDriver Declare
	WebDriver driver;

	// 2.ctor
	public AccountTypeDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3.Locaters
	By accountType = By.id("AccountType");

	// 3.1 Saving Account Details
	By accountSubType = By.xpath("//select[@id='AccountSubType']");
	By balance = By.id("balance");
	By transferlimit = By.id("transferLimit");
	By branchcode = By.id("branchCode");

	// 3.2 Loan Account Details
	By laccountSubType = By.xpath("//select[@id='AccountSubType");
	By lbranchCode = By.id("branchCode");
	By lloanDuration = By.id("loanDuration");
	By lloanAmount = By.id("loanAmount");
	By lcalculateBtn = By.xpath("//input[@value='Calculate']");
	
	By actSubmitBtn =By.xpath("//input[@value='Submit']");

	// 4.Methods to enter Account Detail
	public void selectAccountType(String actype) {
		Select drpActType = new Select(driver.findElement(accountType));
		drpActType.selectByVisibleText(actype);

		
		   switch(actype) {
		      case "Savings Account":
		    	  
		    	  drpActType.selectByVisibleText("Savings Account");
		    	  System.out.println("Saving From Switch");  
			      break;
		      case "Loan Account":
		    	  drpActType.selectByVisibleText("Loan Account");
		    	  System.out.println("Loan From Switch");
		          break;
		      default:
			       System.out.println("Please enter valid Account Type");    
		           break;
		   }
		
		
		
//		String actTypeVar = actype;
		// Get all the options of the dropdown
//		List<WebElement> actOptionsAll = drpActType.getOptions();
//
//		WebElement q;
//		for (int i = 1; i < actOptionsAll.size(); i++) {
//
//			q = actOptionsAll.get(i);
//			System.out.println(q.getText());
		
		    //case 1: actype =savings act and dropdown q.getText()=savings
                     // if --> true
			         //          return
			//case 2: actype =loan act and dropdown q.getText()=savings
			         //if --> false  -loop-1 --> else run return
			         
			
			
//		  if(q.getText().trim().equalsIgnoreCase(actype)) {
//				System.out.println("I am saving");
//		  }
			
		   
//		}

	}

//	public Boolean selectByText( String choice ) throws InterruptedException {
//	    WebElement dropDown = driver.findElement(accountType); 
//	    dropDown.click();
//	    Select drpActType = new Select(driver.findElement(accountType));
//	    List<WebElement> allOptions = dropDown.findElements(By.xpath(".//option"));
//	    int i=0;
//	    
//	    System.out.println("Loop start here");
//	    for ( WebElement we: allOptions) { 
//	        dropDown.sendKeys( Keys.DOWN ); //simulate visual movement
//	         System.out.println(we.getText()+" Loop-"+ i++);
//	        Thread.sleep(250);       
//	        if ( we.getText().contains( choice ) ) {
//	        	drpActType.selectByVisibleText(we.getText());
//	        return true;
//	        }
//	    }
//		return false;
//	}
	
	
	
//	public void checkAccountType() {
//		
//	}
//	
	
	

	public void enterActSubType(String actSubType) {
		driver.findElement(accountSubType).sendKeys(actSubType);
	}

	public void enterBalance(String blnce) {
		driver.findElement(balance).sendKeys(blnce);
	}

	public void enterTransferLimit(String trnsflmt) {
		driver.findElement(transferlimit).sendKeys(trnsflmt);
	}

	public void enterBrancCode(String bcode) {
		driver.findElement(branchcode).sendKeys(bcode);
	}
	

//	public void addSubmitBtn() {
//		driver.findElement(AddsubmitBtn).click();
//	}
	
	
	public void enterLActSubType(String lactSubType) {
		driver.findElement(laccountSubType).sendKeys(lactSubType);
	}

	public void enterLBranchCode(String lbranchcode) {
		driver.findElement(lbranchCode).sendKeys(lbranchcode);
	}

	public void enterLDuration(String ldurabtion) {
		driver.findElement(lloanDuration).sendKeys(ldurabtion);
	}

	public void enterLAmount(String lamount) {
		driver.findElement(lloanAmount).sendKeys(lamount);
	}

	public void clickCalculteBtn() {
		driver.findElement(lcalculateBtn).click();
	}
	
	public void actSubmitBtn() throws InterruptedException {
		//Thread.sleep(1000);
		Actions actions = new Actions(driver);
		//perform a mouse click on the search button
		actions.click(driver.findElement(actSubmitBtn)).build().perform();
		
	}

}
