package tests;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FileListPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

public class SearchTest extends BaseTest {

	@Test
	public void testSearchFile() throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		// test = extent.createTest("testSearchFile", "Test search functionality");

		// enter email
		waitPageToLoad();
		loginPage.enterEmail("datanchrotest@gmail.com");

		// click on continue button
		waitPageToLoad();
		loginPage.clickContinueWithEmail();

		// waitPageToLoad();
		// fetch OTP using headless browser
		// String otp = fetchOTPFromEmail();
		// loginPage.enterOtp(otp);

		// loginPage.enterOtp("123456");
		waitPageToLoad();
		loginPage.clickSubmitButton();

		waitPageToLoad();
		AssertJUnit.assertTrue(driver.getCurrentUrl().contains("Assigment"));
		System.out.println("User successfully logged in");

		waitPageToLoad();
		// Verify that the user is successfully logged in
		boolean isLoginSuccessful = loginPage.isLoginSuccessful();
		Assert.assertTrue(isLoginSuccessful, "User login should be successful.");

		waitPageToLoad();
		homePage.clickHomeTab();
		waitPageToLoad();
		homePage.searchFile("Document.docx");

		boolean isFileFound = homePage.isSearchResultDisplayed("Document.docx");
		Assert.assertTrue(isFileFound, "Search result should display the expected file.");
	}

	public void waitPageToLoad() throws Exception {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
