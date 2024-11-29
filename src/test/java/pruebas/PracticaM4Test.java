package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.HomePage;
import paginas.LoginPage;

public class PracticaM4Test {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	HomePage home;
	LoginPage login;
	
	@BeforeSuite
	public void setUp() {
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void login() {
		home = new HomePage(driver);
		home.clickOnSignIn();
		
		login = new LoginPage(driver);
		login.login("correo01@gmail.com", "1q2w3e7u8i");
		
		/*login.setEmail("correo@gmail.com");
		login.setPassword("1q2w3e4r5t");
		login.clickOnLogin();*/
	}
	
	@Test
	public void searchProduct() {
		home = new HomePage(driver);
		home.setProduct("dress");
		home.clickOnSearch();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
