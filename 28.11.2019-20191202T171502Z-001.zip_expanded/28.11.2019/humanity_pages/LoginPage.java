package humanity_pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasicPage{

	private By email = By.name("email");
	private By password = By.name("password");
	private By loginBtn = By.name("login");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void setEmail(String email) {
		this.driver.findElement(this.email).sendKeys(email);
	}
	
	public void setPassword(String password) {
		this.driver.findElement(this.password).sendKeys(password);
	}
	
	public void LoginXLSX() throws Exception {
		File file = new File("nalog.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
			
		String korisnik = sheet.getRow(1).getCell(0).getStringCellValue();
		String lozinka = sheet.getRow(1).getCell(1).getStringCellValue();
			
		setEmail(korisnik);
		setPassword(lozinka);
		this.clickOnLoginBtn();
			
		
		wb.close();
	}
	
	public void clickOnLoginBtn() {
		this.driver.findElement(this.loginBtn).click();
	}
	
	public void singIn(String email, String password) {
		this.setEmail(email);
		this.setPassword(password);
		this.clickOnLoginBtn();
	}
	
	
}
