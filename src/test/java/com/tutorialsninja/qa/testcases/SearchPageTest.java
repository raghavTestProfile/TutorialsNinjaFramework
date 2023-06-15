package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.PageObjects.HomePagePO;
import com.tutorialsninja.qa.PageObjects.SearchPagePO;
import com.tutorialsninja.qa.base.BaseClass;

public class SearchPageTest extends BaseClass {

	public SearchPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;
	SearchPagePO searchpagePO;

	@BeforeMethod
	public void setup() {

		driver = initializeBrowser(prop.getProperty("browser"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void SearchWithValidProduct() {

		HomePagePO homepagePO = new HomePagePO(driver);

		homepagePO.Search(dataprop.getProperty("validProductName"));
		searchpagePO = homepagePO.clickSearchBtn();

		Assert.assertEquals(searchpagePO.productSearch(), dataprop.getProperty("validProductName"));

	}

	@Test(priority = 2)
	public void SearchWithInValidProduct() {
		HomePagePO homepagePO = new HomePagePO(driver);
		
		homepagePO.Search(dataprop.getProperty("InvalidProductName"));
		searchpagePO=homepagePO.clickSearchBtn();

		Assert.assertEquals(searchpagePO.noProductFound(), dataprop.getProperty("noProductWarning"));
	}

	@Test(priority = 3)
	public void SearchWithoutAnyProduct() {

		HomePagePO homepagePO = new HomePagePO(driver);
		SearchPagePO searchpagePO = new SearchPagePO(driver);
		searchpagePO=homepagePO.clickSearchBtn();
		Assert.assertEquals(searchpagePO.noProductFound(), dataprop.getProperty("noProductWarning"));
	}

}
