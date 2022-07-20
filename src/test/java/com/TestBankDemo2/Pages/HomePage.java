package com.TestBankDemo2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//1.Declare webdriver 
	WebDriver driver;
	
	//2.Constructor that will be automatically called as soon as the object of the class is created
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements( driver,this);
	}
	
	//3.Locaters
//	By RegisterBtn = By.xpath(".//a[text()='Register']");
	
	@FindBy(xpath=".//a[text()='Register']")
	WebElement RegisterBtn ;
	
	
	//Method to click login button
	public void clickRegister() {
		//driver.findElement(RegisterBtn).click();
		RegisterBtn.click();
	}
	
	
	
}
