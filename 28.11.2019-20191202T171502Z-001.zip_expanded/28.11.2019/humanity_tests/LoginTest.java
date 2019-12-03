package humanity_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import humanity_pages.*;

//bx!t3GpjeKu@Z2!

public class LoginTest extends BasicTest {

	private String baseUrl = "https://www.humanity.com/";

	@Test(priority = 0)
	public void basicLogin() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(2000);
		
		HomePage hp = new HomePage(driver);
		hp.getLoginBtn().click();
		Thread.sleep(2000);
		
		LoginPage lg = new LoginPage(driver);
		lg.LoginXLSX();
		Thread.sleep(2000);
		
		TitlePage tp = new TitlePage(driver);
		
		Assert.assertTrue(tp.getPageTitle().contains("Dashboard"));
	}
	
	@Test(priority = 1)
	public void dashboardTest() throws InterruptedException {
		
		
		DashboardPage dp = new DashboardPage(driver);
		System.out.print("dashboardTest" + dp.getNavLinks().size());
		Assert.assertTrue(dp.getNavLinks().size() > 0);
	}
	

	@Test(priority = 2)
	public void addEmployeeTest() throws Exception {
		driver.get("https://sdn1.humanity.com/app/dashboard/");
		Thread.sleep(2000);
		
		DashboardPage dp = new DashboardPage(driver);
		System.out.print("addEmployeeTest" + dp.getNavLinks().size());
		dp.getNavLinks().get(5).click(); // Staff link
		Thread.sleep(2000);

		EmployeePage ep = new EmployeePage(driver);
		ep.getAddEmployeeBtn().click();
		Thread.sleep(2000);
		
		ep.addEmploysXLSX();
		
		ep.getSaveBtn().click();
		Thread.sleep(2000);
		
		dp.getNavLinks().get(5).click(); 
		
//		Assert.assertTrue(ep.employAdded("233343232332@email.com"));
//		Assert.assertTrue(ep.employAdded("ewd34334@email.com"));
//		Assert.assertTrue(ep.employAdded("09238732k32m@email.com"));
		
	}
	
	@Test(priority = 3)
	public void opetProfileSettings() throws Exception{
		ProfileIconPage pip = new ProfileIconPage(driver);
		pip.settings().click();
		Thread.sleep(1000);
		
	}
	
}
