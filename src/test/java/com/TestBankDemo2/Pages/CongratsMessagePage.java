package com.TestBankDemo2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CongratsMessagePage {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public CongratsMessagePage(WebDriver driver) {
		this.driver = driver;
	}

	//Locators
	By msgText = By.xpath("//div[@id='swal2-html-container']");

	By okbtn = By.xpath("//button[normalize-space()='OK']");

	//Methods
	public void msgBox() {
		String msgg = driver.findElement(msgText).getText();
		String accNo = msgg
				.replaceAll("Your Account has been successfully Created Your ID is:67 Account Number is:", " ").trim();
		System.out.println("your Account number is :" + accNo);
	}

	public void clickMsgBt() {
		driver.findElement(okbtn).click();
	}

}
