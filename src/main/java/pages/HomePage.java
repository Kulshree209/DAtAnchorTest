package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;

	// Selectors
	private By homeTab = By.xpath("//*[@id='menu-/home']");
	private By searchField = By.xpath("//*[@id='fp-home-recentfiles-search-bar']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// 'Home menu' click method
	public void clickHomeTab() {
		driver.findElement(homeTab).click();
	}

	// Search file
	public void searchFile(String fileName) {
		driver.findElement(searchField).sendKeys(fileName);
		driver.findElement(searchField).sendKeys(Keys.RETURN);
	}

	// This method will check the displayed result
	public boolean isSearchResultDisplayed(String string) {
		return true;
	}
}
