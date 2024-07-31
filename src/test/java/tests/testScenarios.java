package tests;

import java.util.ArrayList;
import java.util.Set;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.FileListPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

public class testScenarios extends BaseTest {
	@Test
	public void testUserLogin() throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		FileListPage fileListPage = new FileListPage(driver);
		HomePage homePage = new HomePage(driver);

		System.out.println("*******Step 1: User Login*********");

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

		System.out.println("*******Step 2: Navigate to the file list*********");
		waitPageToLoad();
		fileListPage.clickActionButton();
		waitPageToLoad();
		fileListPage.openInNewTab();

		waitPageToLoad();
		Assert.assertTrue(driver.getCurrentUrl().contains("enixpyre"));
		logger.info("File opened in new tab successfully in edit mode");

		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(windowHandles);

		driver.switchTo().window(tabs.get(0));

		waitPageToLoad();
		fileListPage.clickActionButton();
		waitPageToLoad();
		fileListPage.previewFile();

		Assert.assertTrue(driver.getCurrentUrl().contains("fenixpyre"));
		logger.info("File previewed successfully");

		System.out.println("*******Step 3: Search*********");
		driver.switchTo().window(tabs.get(0));
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
