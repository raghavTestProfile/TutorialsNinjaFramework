package com.tutorialsninja.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPagePO {
	

	WebDriver driver;
	
    //Objects
	@FindBy(css= "h2:first-child")
	private WebElement editYourAccountInfoOption;
	
	@FindBy(xpath = "//div[@id='content']//h1")
	private WebElement accountCreationMessage;
	
	
	public AccountPagePO(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyIFeditYourAccountInfoOptionIsDisplayed() {
		return editYourAccountInfoOption.isDisplayed();
	}
	
	public String accountCreatedMessage() {
		return accountCreationMessage.getText();
	}
	

}
