package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	// Selectors
	private By emailField = By.name("email");
	private By otpField = By.id("otp");
	private By continueWithEmailButton = By.id("email-btn");
	private By submitButton = By.name("submit");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Method for entering email
	public void enterEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}

	// 'Continue' click method
	public void clickContinueWithEmail() {
		driver.findElement(continueWithEmailButton).click();
	}

	// Method to enter otp
	public void enterOtp(String otp) {
		driver.findElement(otpField).sendKeys(otp);
	}

	// 'Submit' click method
	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
	}

	// This method will check the successful login
	public boolean isLoginSuccessful() {
		return driver.findElement(By.xpath("//p[contains(text(),'Fenixpyre')]")).isDisplayed();
	}
}
