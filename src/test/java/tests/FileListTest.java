package tests;

import java.util.ArrayList;
import java.util.Set;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FileListPage;
import pages.LoginPage;
import utils.BaseTest;
import utils.Logger;

public class FileListTest extends BaseTest {
	// private static final org.slf4j.Logger logger = (org.slf4j.Logger)
	// Logger.getLogger();

	@Test
	public void testOpenInNewTab() throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		FileListPage fileListPage = new FileListPage(driver);

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
	}

	/*//Individual test case for preview file
	@Test
    public void testPreviewFile() throws Exception {
    	LoginPage loginPage = new LoginPage(driver);
        
        //enter email
        waitPageToLoad();
        loginPage.enterEmail("datanchrotest@gmail.com"");
        
        //click on continue button
        waitPageToLoad();
        loginPage.clickContinueWithEmail();

        //waitPageToLoad();
        //fetch OTP using headless browser
        //String otp = fetchOTPFromEmail();
        //loginPage.enterOtp(otp);

        //loginPage.enterOtp("123456");
        waitPageToLoad();
        loginPage.clickSubmitButton();

        waitPageToLoad();
        AssertJUnit.assertTrue(driver.getCurrentUrl().contains("Assigment"));
        System.out.println("User successfully logged in");
        
        waitPageToLoad();
       //Verify that the user is successfully logged in
        boolean isLoginSuccessful = loginPage.isLoginSuccessful();
        Assert.assertTrue(isLoginSuccessful, "User login should be successful.");
        

        FileListPage fileListPage = new FileListPage(driver);
        waitPageToLoad();
        fileListPage.clickActionButton();
        waitPageToLoad();
        fileListPage.previewFile();

        Assert.assertTrue(driver.getCurrentUrl().contains("fenixpyre"));
        logger.info("File previewed successfully");
    }*/
	  
	public void waitPageToLoad() throws Exception {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
