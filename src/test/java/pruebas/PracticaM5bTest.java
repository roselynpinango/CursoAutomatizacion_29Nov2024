package pruebas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.AlertPage;

public class PracticaM5bTest {
	String url = "https://demoqa.com/alerts";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup(); // Inicializa y garantiza la compatibilidad
		
		// Hacer zoom in (80%)
		ChromeOptions options = new ChromeOptions();
		double zoom = 0.8;
		options.addArguments("--force-device-scale-factor="+zoom);
		
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void alertaNotificacion() {
		AlertPage pagina = new AlertPage(driver);
		pagina.hacerClicEnNotificacion();
		
		Alert alerta = driver.switchTo().alert();
		alerta.accept(); // Clic en Aceptar de la alerta
	}
}
