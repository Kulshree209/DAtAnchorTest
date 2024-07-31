package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.BaseTest;
import utils.Logger;
import utils.EmailUtils;

public class LoginwithextractOTP  extends BaseTest {

	@Test
	public void testUserLogin() throws Exception {
		LoginPage loginPage = new LoginPage(driver);

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

	}

	private String fetchOTPFromEmail() {

		// extracting otp

		/*
		 * driver.get("https://mail.google.com/");
		 * 
		 * // Login to the email account
		 * 
		 * wait = new WebDriverWait(driver, 50);
		 * 
		 * // Wait for the email input field and enter the email address WebElement
		 * emailField =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId"
		 * ))); emailField.sendKeys("datanchrotest@gmail.com");
		 * 
		 * // Click the 'Next' button WebElement nextButton =
		 * driver.findElement(By.id("identifierNext")); nextButton.click();
		 * 
		 * try { Thread.sleep(30000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * 
		 * // Wait for the password field and enter the password //WebElement
		 * passwordField =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))
		 * ); //passwordField.sendKeys("TestPassword123");
		 * 
		 * /*
		 * 
		 * 
		 * driver.findElement(By.id("identifierId")).sendKeys("datanchrotest@gmail.com")
		 * ;
		 * 
		 * driver.findElement(By.xpath("//*[@id='identifierNext']")).click();
		 * 
		 * try { Thread.sleep(30000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * //waitForElementToBeVisible(passwordField, 10);
		 * 
		 * wait = new WebDriverWait(driver, 50);
		 * 
		 * //WebElement passwordElement =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//*[contains(text(), 'Enter your password')]")));
		 * 
		 * WebElement passwordElement =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//*[contains(text(), 'Enter your password')]")));
		 * 
		 * passwordElement.click();
		 * driver.findElement(passwordField).sendKeys("TestPassword123");
		 * 
		 * //driver.findElement(By.xpath("//*[contains(text(), 'Enter your password')]")
		 * ).sendKeys("TestPassword123");
		 * 
		 * //driver.findElement(By.xpath("//*[@id='identifierNext']")).click();
		 * 
		 * WebElement nextButtonPassword = driver.findElement(By.id("passwordNext"));
		 * nextButtonPassword.click();
		 * 
		 * try { Thread.sleep(30000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * // Navigate to the email containing the OTP
		 * //driver.findElement(By.id("inbox")).click();
		 * //driver.findElement(By.xpath("//*[contains(text(), 'Passcode')]")).click();
		 * 
		 * // Extract the OTP from the email String otp =
		 * driver.findElement(By.xpath("(//*[contains(text(),'Passcode')])[1]")).getText
		 * (); System.out.println("*********************" +otp+
		 * "*********************");
		 * 
		 */

		// Implement logic to fetch OTP from email using a headless browser
		WebDriver headlessDriver = new HtmlUnitDriver();
		headlessDriver.get("https://mail.google.com/");

		// Login to the email account
		headlessDriver.findElement(By.id("identifierId")).sendKeys("datanchrotest@gmail.com");
		headlessDriver.findElement(By.xpath("//*[@id='identifierNext']")).click();
		headlessDriver.findElement(By.id("password")).sendKeys("TestPassword123");
		// headlessDriver.findElement(By.id("loginButton")).click();
		headlessDriver.findElement(By.xpath("//*[@id='identifierNext']")).click();

		// Navigate to the email containing the OTP
		// headlessDriver.findElement(By.id("inbox")).click();
		headlessDriver.findElement(By.xpath("//*[contains(text(), 'Passcode')]")).click();

		// Extract the OTP from the email
		String otp = headlessDriver.findElement(By.xpath("(//*[contains(text(),'Passcode')])[1]")).getText();
		System.out.println("****" + otp + "***");

		// Close the headless driver
		headlessDriver.quit();

		return otp;
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

