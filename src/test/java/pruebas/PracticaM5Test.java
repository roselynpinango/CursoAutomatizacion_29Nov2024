package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.HomePage;
import paginas.LoginPage;
import utilities.DatosExcel;

public class PracticaM5Test {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	HomePage home;
	LoginPage login;
	
	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		
		/* Si queremos ejecutar en modo incognito 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		driver = new ChromeDriver(options);*/
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		home = new HomePage(driver);
	}
	
	@Test(dataProvider="Datos Excel")
	public void login(String email, String password) {
		home.clickOnSignIn();
		
		login = new LoginPage(driver);
		login.setEmail(email);
		login.setPassword(password);
		login.clickOnLogin();
	}
	
	@DataProvider(name="Datos Excel")
	public Object[][] getTestExcelData() throws Exception {
		String nombreRutaArchivo = "..//EducacionIT-74161//Data//Login_Datos.xlsx";
		//MAC o Linux
		//String nombreRutaArchivo = ".\EducacionIT-74161\Data\Login_Datos.xlsx";
		
		String nombreHoja = "Hoja1";
		
		return DatosExcel.leerExcel(nombreRutaArchivo, nombreHoja);
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] getTestData() {
		// Object[][] representa una lista bidimensional de valores (arreglo)
		Object[][] datos = new Object[3][2];
		
		datos[0][0] = "abc@gmail.com";
		datos[0][1] = "43wrw43w";
		
		datos[1][0] = "def@gmail.com";
		datos[1][1] = "34wr543wr";
		
		datos[2][0] = "ghi@gmail.com";
		datos[2][1] = "34r3wrte3ww";
		
		return datos;
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}
