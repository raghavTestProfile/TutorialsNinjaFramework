package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.PageObjects.AccountPagePO;
import com.tutorialsninja.qa.PageObjects.HomePagePO;
import com.tutorialsninja.qa.PageObjects.RegisterPagePO;
import com.tutorialsninja.qa.base.BaseClass;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterPageTest extends BaseClass {

	public WebDriver driver;
	RegisterPagePO registerpagePO;
	AccountPagePO accountpagePO;

	public RegisterPageTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() {

		driver = initializeBrowser(prop.getProperty("browser"));
		HomePagePO homepagePO = new HomePagePO(driver);

		homepagePO.clickOnmyAccountBtn();
		registerpagePO = homepagePO.clickOnRegisterBtn();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void registerWithMandatoryFields() {

		registerpagePO.enterfname(dataprop.getProperty("firstname"));
		registerpagePO.enterlname(dataprop.getProperty("lastname"));
		registerpagePO.enterEmail(Utilities.timeStamp());
		registerpagePO.entertelephoneNo(dataprop.getProperty("telephoneno"));
		registerpagePO.enterPassword(dataprop.getProperty("password"));
		registerpagePO.confirmPassword(dataprop.getProperty("password"));
		registerpagePO.agreePrivacyPolicy();
		accountpagePO=registerpagePO.clickContinueBtn();
		Assert.assertEquals(accountpagePO.accountCreatedMessage(), dataprop.getProperty("accountCreation"));

	}

	@Test(priority = 2)
	public void registerWithAllFields() {

		registerpagePO.enterfname(dataprop.getProperty("firstname"));
		registerpagePO.enterlname(dataprop.getProperty("lastname"));
		registerpagePO.enterEmail(Utilities.timeStamp());
		registerpagePO.entertelephoneNo(dataprop.getProperty("telephoneno"));
		registerpagePO.enterPassword(dataprop.getProperty("password"));
		registerpagePO.confirmPassword(dataprop.getProperty("password"));
		registerpagePO.agreePrivacyPolicy();

		registerpagePO.clickSubsCheckbox();
		accountpagePO=registerpagePO.clickContinueBtn();

		Assert.assertEquals(accountpagePO.accountCreatedMessage(), dataprop.getProperty("accountCreation"));

	}

	@Test(priority = 3)
	public void verifyResteringWithAlreadyExistingAccount() {

		registerpagePO.enterfname(dataprop.getProperty("firstname"));
		registerpagePO.enterlname(dataprop.getProperty("lastname"));
		registerpagePO.enterEmail(dataprop.getProperty("alreadyUsedEmail"));
		registerpagePO.entertelephoneNo(dataprop.getProperty("telephoneno"));
		registerpagePO.enterPassword(dataprop.getProperty("password"));
		registerpagePO.confirmPassword(dataprop.getProperty("password"));

		registerpagePO.agreePrivacyPolicy();

		registerpagePO.clickContinueBtn();

		Assert.assertEquals(registerpagePO.accountAlreadyCreatedText(),
				dataprop.getProperty("accountAlreadyRegisteredWarning"));

	}

	@Test(priority = 4)
	public void registerWithoutInput() {

		registerpagePO.clickContinueBtn();
		Assert.assertEquals(registerpagePO.accountAlreadyCreatedText(), dataprop.getProperty("privacyPolicyWarning"));

		Assert.assertEquals(registerpagePO.firstNameWarning(), dataprop.getProperty("firstNameWarning"));
		Assert.assertEquals(registerpagePO.lastNameWarning(), dataprop.getProperty("lastNameWarning"));
		Assert.assertEquals(registerpagePO.emailWarning(), dataprop.getProperty("emailInvalidWarning"));
		Assert.assertEquals(registerpagePO.telephoneWarning(), dataprop.getProperty("telephoneWarning"));
		Assert.assertEquals(registerpagePO.passwordWarning(), dataprop.getProperty("passwordWarning"));

	}

}
