package humanity_pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeePage extends BasicPage{

	private By addEmployeeBtn = By.id("act_primary");
	private By inputEl = By.cssSelector("._add_staff_tb tr._ns_row");
	private By saveBtn = By.id("_as_save_multiple");
	private By firstEmp = By.xpath("//*[@id=\"_cd_staff\"]/div[3]/div[2]/table/tbody/tr[2]/td[2]/a");
	private int numberOfEmp = 0;
	public EmployeePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement getAddEmployeeBtn() {
		return this.driver.findElement(addEmployeeBtn);
	}
	
	public List<WebElement> getInputElements() {
		return this.driver.findElements(inputEl);
	}
	
	public WebElement getInputsForRow(WebElement el, By findBy) {
		return el.findElement(findBy);
	}
	public WebElement getSaveBtn() {
		return this.driver.findElement(saveBtn);
	}
	public void addEmploy(String firstName,String lastName,String email) {
		List<WebElement> inputs = this.getInputElements();
		WebElement fNameInput = this.getInputsForRow(inputs.get(numberOfEmp), 
					         By.cssSelector("[placeholder='first name']"));
		WebElement lNameInput = this.getInputsForRow(inputs.get(numberOfEmp), 
		         By.cssSelector("[placeholder='last name']"));

		WebElement emailInput= this.getInputsForRow(inputs.get(numberOfEmp), 
					         By.cssSelector("[placeholder='email@address.com']"));
		
		fNameInput.sendKeys(firstName);
		lNameInput.sendKeys(lastName);
		emailInput.sendKeys(email);
		
		numberOfEmp++;
	}
	
	public void addEmploysXLSX() throws Exception{
		File file = new File("radnici.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		for(int i=1;i<= sheet.getLastRowNum(); i++) {
			String ime = sheet.getRow(i).getCell(0).getStringCellValue();
			String prezime = sheet.getRow(i).getCell(1).getStringCellValue();
			String email = sheet.getRow(i).getCell(2).getStringCellValue();
			addEmploy(ime,prezime,email);
			
		}
		wb.close();
	}
	
	public WebElement firstEmp() {
		return driver.findElement(firstEmp);
	}
	
	
	public boolean employAdded(String email) {
		return this.driver.findElement(By.xpath("//td[contains(text(),'"+ email +"')]")) != null;
	}
}
