package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileListPage {
	private WebDriver driver;

	// Selectors
	private By actionButton = By.xpath("//*[@id='fp-sharedlink-table-body-1-1_actions']/div");
	private By openInNewTabButton = By.xpath("//span[contains(text(),'Open in new tab')]");
	private By previewButton = By.xpath("//span[contains(text(),'Preview')]");

	public FileListPage(WebDriver driver) {
		this.driver = driver;
	}

	// 'Action' button click method
	public void clickActionButton() {
		driver.findElement(actionButton).click();
	}

	// 'Open in New tab' button click method
	public void openInNewTab() {
		driver.findElement(openInNewTabButton).click();
	}

	// 'Preview' button click method
	public void previewFile() {
		driver.findElement(previewButton).click();
	}
}
