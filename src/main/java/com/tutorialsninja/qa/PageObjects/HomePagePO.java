package com.tutorialsninja.qa.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePO {

	WebDriver driver;

	// Objects
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountBtn;

	@FindBy(linkText = "Login")
	private WebElement loginBtn;

	@FindBy(linkText = "Register")
	private WebElement registerBtn;

	@FindBy(css = "input[name='search']")
	private WebElement searchTextBox;

	@FindBy(css = "span button")
	private WebElement searchBtn;

	public HomePagePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions

	public void clickOnmyAccountBtn() {
		// myAccountBtn.click();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
	}

	public LoginPagePO clickOnloginBtn() {
		loginBtn.click();
		return new LoginPagePO(driver);
	}

	public RegisterPagePO clickOnRegisterBtn() {
		registerBtn.click();
		return new RegisterPagePO(driver);
	}

	public void Search(String product) {
		searchTextBox.sendKeys(product);
	}

	public SearchPagePO clickSearchBtn() {
		searchBtn.click();
		return new SearchPagePO(driver);
	}

}
