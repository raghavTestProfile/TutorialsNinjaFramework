package com.tutorialsninja.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePO {
	
	WebDriver driver;
	
    //Objects
	@FindBy(id = "input-email")
	private WebElement emailTextBox;
	
	@FindBy(id = "input-password")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasswordNoMatchWarning;
	
	public LoginPagePO(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void enterEmailAddress(String email) {
		emailTextBox.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}
	
	public AccountPagePO clickOnLogin() {
		loginBtn.click();
		return new AccountPagePO(driver);
	}
	
	public String IfemailPasswordNoMatchWarningGetText() {
		return emailPasswordNoMatchWarning.getText();
	}
	
	

}
