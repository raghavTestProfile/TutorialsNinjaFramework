package com.tutorialsninja.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPagePO {
	
	WebDriver driver;
	
	@FindBy(css = "h4 a")
	private WebElement productSearch;
	
	@FindBy(xpath = "//div[@id='content']//p[2]")
	private WebElement noProductFound;
	
	public SearchPagePO (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String productSearch() {

		return productSearch.getText();
	}
	
	public String noProductFound() {
		return noProductFound.getText();
	}

}
