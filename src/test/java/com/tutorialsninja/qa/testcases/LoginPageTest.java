package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.PageObjects.AccountPagePO;
import com.tutorialsninja.qa.PageObjects.HomePagePO;
import com.tutorialsninja.qa.PageObjects.LoginPagePO;
import com.tutorialsninja.qa.base.BaseClass;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginPageTest extends BaseClass {

	public LoginPageTest() throws IOException {
		super();

	}

	public WebDriver driver;
	LoginPagePO loginpagePO;

	@BeforeMethod
	public void setup() {

		driver = initializeBrowser(prop.getProperty("browser"));
		HomePagePO homepagePO = new HomePagePO(driver);

		homepagePO.clickOnmyAccountBtn();
		loginpagePO = homepagePO.clickOnloginBtn();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "validCredentialsSupplier")
	public Object[][] supplyTestData() throws IOException {
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}

	@Test(priority = 1, dataProvider = "validCredentialsSupplier")
	public void loginWithValidCredentials(String email, String password) {

		loginpagePO.enterEmailAddress(email);
		loginpagePO.enterPassword(password);
		AccountPagePO accountpagePO = loginpagePO.clickOnLogin();

		Assert.assertTrue(accountpagePO.verifyIFeditYourAccountInfoOptionIsDisplayed());

	}

	@Test(priority = 2)
	public void loginWithInvalidCredentials() {

		loginpagePO.enterEmailAddress(Utilities.timeStamp());
		loginpagePO.enterPassword(dataprop.getProperty("invalidPassword"));
		loginpagePO.clickOnLogin();

		Assert.assertEquals(loginpagePO.IfemailPasswordNoMatchWarningGetText(),
				dataprop.getProperty("emailPasswordNoMatchWarning"));

	}

	@Test(priority = 3)
	public void loginWithValidEmailInvalidPassword() {

		loginpagePO.enterEmailAddress(prop.getProperty("validEmail"));
		loginpagePO.enterPassword(dataprop.getProperty("invalidPassword"));
		loginpagePO.clickOnLogin();

		Assert.assertEquals(loginpagePO.IfemailPasswordNoMatchWarningGetText(),
				dataprop.getProperty("emailPasswordNoMatchWarning"));

	}

	@Test(priority = 4)
	public void loginWithInvalidEmailValidPassword() {

		loginpagePO.enterEmailAddress(Utilities.timeStamp());
		loginpagePO.enterPassword(prop.getProperty("validPassword"));
		loginpagePO.clickOnLogin();

		Assert.assertEquals(loginpagePO.IfemailPasswordNoMatchWarningGetText(),
				dataprop.getProperty("emailPasswordNoMatchWarning"));

	}

	@Test(priority = 5)
	public void loginWithoutCredentials() {

		loginpagePO.clickOnLogin();

		Assert.assertEquals(loginpagePO.IfemailPasswordNoMatchWarningGetText(),
				dataprop.getProperty("emailPasswordNoMatchWarning"));

	}

}
