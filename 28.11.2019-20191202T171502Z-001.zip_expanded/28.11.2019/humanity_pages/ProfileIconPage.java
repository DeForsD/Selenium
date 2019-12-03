package humanity_pages;

import org.openqa.selenium.*;

public class ProfileIconPage extends BasicPage{
	private By dropD = By.cssSelector("#wrap_us_menu > i");
	private By profHref = By.cssSelector("#userm > div > a:nth-child(3)");
	private By settingHref = By.cssSelector("#userm > div > a:nth-child(5)");
	private By AvHref = By.cssSelector("#userm > div > a:nth-child(7)");
	private By logOutHref = By.cssSelector("#userm > div > a:nth-child(13)");
	private By version = By.cssSelector("#humanityAppVersion > b");
	
	public ProfileIconPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement profileDrop() {
		return super.driver.findElement(dropD);
	}
	
	public WebElement profileHref() {
		profileDrop().click();
		return super.driver.findElement(this.profHref);
	}
	
	public WebElement settings() {
		profileDrop().click();
		return super.driver.findElement(this.settingHref);
	}
	
	public WebElement avaibility() {
		profileDrop().click();
		return super.driver.findElement(AvHref);
	}
	
	public WebElement logout() {
		profileDrop().click();
		return super.driver.findElement(this.logOutHref);
	}
	
	public String version() {
		return driver.findElement(this.version).getText();
	}
}
