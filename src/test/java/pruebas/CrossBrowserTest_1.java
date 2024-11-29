package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class CrossBrowserTest_1 {
	
	WebDriver driver = null;
	String url="http://www.automationpractice.pl/index.php";
	
	@BeforeMethod
	@Parameters("navegador")
	public void setUp(String navegador) {
		
		if (navegador.equalsIgnoreCase("edge")) {	
			driver=new EdgeDriver();
			
		}	
		else {
			driver=new FirefoxDriver();		
		}			
		driver.manage().window().maximize(); 
		driver.get(url);
		
	}
	
	
	
	@Test
	public void buscarPalabra() {

		WebElement txtBuscador=driver.findElement(By.cssSelector("input[placeholder='Search']"));

		txtBuscador.clear();

		txtBuscador.sendKeys("Blouse");

		txtBuscador.sendKeys(Keys.ENTER);
	}
	
	@AfterMethod
	public void cierreNavegador() {
		
		driver.close();
		
	}
	
}

