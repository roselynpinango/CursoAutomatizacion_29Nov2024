package edit.EducacionIT_74161;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticaM2Test {
	String url = "http://www.automationpractice.pl";
	
	@Test
	public void registrarUsuario() {
		// (1) Definir qué navegador queremos usar
		WebDriver driver = new EdgeDriver();
		
		// (2) Abrir el navegador en la página de prueba
		//driver.get(url);
		driver.navigate().to(url);
		
		//(16) Maximizar el navegador
		driver.manage().window().maximize();
		
		// (3) Hacer clic en 'Sign in'
		WebElement lnkSign = driver.findElement(By.partialLinkText("Sign"));
		lnkSign.click();
		
		// (4) Escribir el correo electronico
		WebElement txtEmail = driver.findElement(By.cssSelector("#email_create"));
		txtEmail.sendKeys("correo6nov" + Math.random()  +"@gmail.com");
		
		// (5) Hacer clic en el botón 'Create an Account'
		WebElement btnCreate = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
		btnCreate.click();
		
		//driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		
		// Necesitamos agregar una espera de X tiempo o hasta que el radio button cargue
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(30));
		espera.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		// (6) Seleccionar el título (Sr. o Sra.)
		WebElement radTitulo = driver.findElement(By.id("id_gender1"));
		radTitulo.click();
		
		// (7) Escribir el nombre
		WebElement txtNombre = driver.findElement(By.name("customer_firstname"));
		txtNombre.sendKeys("Arturo");
		
		// (8) Escribir el apellido
		WebElement txtApellido = driver.findElement(By.cssSelector("#customer_lastname"));
		txtApellido.sendKeys("Lopez");
		
		// (9) Limpiar el valor del correo electronico
		WebElement txtEmailForm = driver.findElement(By.id("email"));
		txtEmailForm.clear();
		
		// (10) Escribir un nuevo valor de correo electronico
		txtEmailForm.sendKeys("correoModificado06nov"+Math.random()+"@gmail.com");
		
		// (11) Escribir la contraseña
		
		WebElement txtPasswordForm=driver.findElement(By.name("passwd"));
		txtPasswordForm.clear();
		txtPasswordForm.sendKeys("123456");
		
		// (12) Seleccionar la fecha de nacimiento (día-mes-año)
		
	    Select drpDaysForm=new Select(driver.findElement(By.id("days")));
	    drpDaysForm.selectByValue("11");
	    
	    Select drpMonthsForm=new Select(driver.findElement(By.id("months")));
	    drpMonthsForm.selectByValue("4");
	    
	    Select drpYearsForm=new Select(driver.findElement(By.id("years")));
	    drpYearsForm.selectByValue("1990");
		
		
		// (13) Hacer clic en el checkbox
	    
	     WebElement chkNewsletter=driver.findElement(By.name("newsletter"));
	     chkNewsletter.click();
		
		// (14) Hacer clic en el boton 'Register'
	     
	     WebElement btnRegister=driver.findElement(By.id("submitAccount"));
	     btnRegister.click();
	     
	     // (15) Cerrar el navegador
	     
	     driver.quit();
		
	}
}
