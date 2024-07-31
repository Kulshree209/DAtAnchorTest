package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.reporters.TestHTMLReporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class BaseTest {
	protected WebDriver driver;
	protected ExtentReports extent;
	protected ExtentTest test;
	protected WebDriverWait wait;

	protected static final Logger logger = Logger.getLogger(BaseTest.class.getName());

	@BeforeSuite
	public void setup() {
		/*
		 * ExtentReporter htmlReporter = new ExtentHtmlReporter("extent.html"); 
		 * extent = new ExtentReports(); 
		 * extent.attachReporter(htmlReporter);
		 */
		logger.info("Extent report setup complete.");
	}

	@BeforeTest
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
		driver = new ChromeDriver();

		// Maximize the browser window
		driver.manage().window().maximize();
		logger.info("Browser maximized.");

		// Navigate to the URL
		driver.get("https://fenixshare.anchormydata.com/fenixpyre/s/669ff2910e5caf9f73cd28ea/QA%2520Assigment");

		logger.info("Navigated to the test URL.");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			takeScreenshot(result.getName());
		}
		driver.quit();
	}

	@AfterTest
	public void tearDownQ() {
		driver.quit();
	}

	@AfterSuite
	public void tearDownSuite() {
		// extent.flush();
		driver.quit();
	}

	private void takeScreenshot(String testName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(srcFile.toPath(), Paths.get("screenshots", testName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void waitForElementToBeVisible(By locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
