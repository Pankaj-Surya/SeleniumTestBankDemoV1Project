package com.TestBankDemo2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	//1.Declare webdriver 
	WebDriver driver;
	
	//2.Constructor that will be automatically called as soon as the object of the class is created
	public HomePage(WebDriver driver) {
		this.driver= driver;
	}
	
	//3.Locaters
	By RegisterBtn = By.xpath(".//a[text()='Register']");
	
	//Method to click login button
	public void clickRegister() {
		driver.findElement(RegisterBtn).click();
	}
	
	
	
}
