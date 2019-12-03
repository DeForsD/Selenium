package humanity_pages;


import org.openqa.selenium.*;

public class EditProfilePage extends BasicPage{
//	public By  = By.cssSelector();
	public By edit = By.cssSelector("#_cd_staff > div.right > div.EmployeeTop > a:nth-child(5)");
	public By fileUp = By.id("fileupload");
	public By name = By.id("first_name");
	
	
	public EditProfilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement edit() {
		return driver.findElement(edit);
	}
	
	public WebElement editPicture() {
		return driver.findElement(fileUp);
	}
	
	
	public WebElement editName() {
		return driver.findElement(name);
	}
}
