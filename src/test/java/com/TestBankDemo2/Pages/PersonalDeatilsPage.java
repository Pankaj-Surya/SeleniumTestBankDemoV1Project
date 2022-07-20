package com.TestBankDemo2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDeatilsPage {

	
	//1.WebDriver Declare
	WebDriver driver;
	 
	//2.ctor
	public PersonalDeatilsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3.Locaters
	By firstName = By.id("firstName");
	By lastName=By.id("lastName");
	By email =By.id("email");
	By mobile = By.id("mobile");
	By MartialStatus=By.id("MaritalStatus");
	By dob =By.id("dob");
	By pdNxtBtn = By.cssSelector(".mb-3.text-center>input[value='next']");
	
	
	//4.Methods to enter Personal Detail	
	public void enterFirstname(String fname) {
		driver.findElement(firstName).sendKeys(fname);
	}


	public void enterLastName(String lname) {
		driver.findElement(lastName).sendKeys(lname);
	}
	
	public void enterEmail(String eml) {
		driver.findElement(email).sendKeys(eml);
	}
	
	public void enterMobile(String eml) {
		driver.findElement(mobile).sendKeys(eml);
	}
	
	public void enterMartialStatus(String ms) {
		driver.findElement(MartialStatus).sendKeys(ms);
	}
	
	public void enterdob(String dofb) {
		driver.findElement(dob).sendKeys(dofb);
	}
	
	public void PersonalNxtBtnClick() {
		driver.findElement(pdNxtBtn).click();
	}

	
	
}
