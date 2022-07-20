package com.TestBankDemo2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressDetailsPage {

	//1.WebDriver Declare
		WebDriver driver;
		 
		//2.ctor
		public AddressDetailsPage(WebDriver driver) {
			this.driver = driver;
		}
		
		//3.Locaters
		By addLine1 =By.id("addressLine1");
		By addLine2=By.id("addressLine2");
		By country =By.xpath("//select[@id='country']");
		By state =By.id("state");
		By city=By.id("city");
		By AddsubmitBtn =By.xpath("//input[@type='submit']");
	
		
		
		//4.Methods to enter Personal Detail	
		public void enterAddressLine1(String adl1) {
			driver.findElement(addLine1).sendKeys(adl1);
		}


		public void enterAddressLine2(String adl2) {
			driver.findElement(addLine2).sendKeys(adl2);
		}
		
		public void enterCountry(String ctry) {
			driver.findElement(country).sendKeys(ctry);
		}
		
		public void enterState(String ste) {
			driver.findElement(state).sendKeys(ste);
		}
		
		public void enterCity(String cty) {
			driver.findElement(city).sendKeys(cty);
		}
		
		
		public void addSubmitBtn() {
			driver.findElement(AddsubmitBtn).click();
		}

		
	
}
