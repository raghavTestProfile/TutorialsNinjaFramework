package com.tutorialsninja.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPagePO {

	WebDriver driver;

	public RegisterPagePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameTextBox;

	@FindBy(id = "input-lastname")
	private WebElement LastNameTextBox;

	@FindBy(id = "input-email")
	private WebElement emailTextBox;

	@FindBy(id = "input-telephone")
	private WebElement telephoneTextBox;

	@FindBy(id = "input-password")
	private WebElement passwordTextBox;

	@FindBy(id = "input-confirm")
	private WebElement confirmpasswordTextBox;

	@FindBy(css = "input[type='checkbox']")
	private WebElement agreePrivacyPolicy;

	@FindBy(css = "input[type='submit']")
	private WebElement continueBtn;

	@FindBy(css = ".radio-inline:first-child")
	private WebElement subsCheckbox;

	@FindBy(css = ".alert-dismissible")
	private WebElement accountAlreadyCreated;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameValidation;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameValidation;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailInvalidWarning;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;

	public void enterfname(String fname) {
		firstNameTextBox.sendKeys(fname);
	}

	public void enterlname(String lname) {
		LastNameTextBox.sendKeys(lname);
	}

	public void enterEmail(String email) {
		emailTextBox.sendKeys(email);
	}

	public void entertelephoneNo(String tno) {
		telephoneTextBox.sendKeys(tno);
	}

	public void enterPassword(String pswrd) {
		passwordTextBox.sendKeys(pswrd);
	}

	public void confirmPassword(String cpswrd) {
		confirmpasswordTextBox.sendKeys(cpswrd);
	}

	public void agreePrivacyPolicy() {
		agreePrivacyPolicy.click();
	}

	public AccountPagePO clickContinueBtn() {
		continueBtn.click();
		return new AccountPagePO(driver);
	}

	public void clickSubsCheckbox() {
		subsCheckbox.click();
	}

	public String accountAlreadyCreatedText() {
		return accountAlreadyCreated.getText();
	}

	public String firstNameWarning() {
		return firstNameValidation.getText();
	}

	public String lastNameWarning() {
		return lastNameValidation.getText();
	}

	public String emailWarning() {
		return emailInvalidWarning.getText();
	}

	public String telephoneWarning() {
		return telephoneWarning.getText();
	}

	public String passwordWarning() {
		return passwordWarning.getText();
	}

}
