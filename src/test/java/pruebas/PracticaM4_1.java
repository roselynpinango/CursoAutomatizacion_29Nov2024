package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.paginaLogin_1;

public class PracticaM4_1 {
	WebDriver driver;
    paginaLogin_1 login;

    // URL de la página de login
    String URL = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";


    @BeforeSuite
    public void setUp() {
        // Configuración de Driver y apertura de la página

        driver = new EdgeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

        // Inicializamos el objeto de la página
        login = new paginaLogin_1(driver);
    }

    @AfterSuite
    public void cierreNavegador() {
        // Cerrar el navegador
        driver.quit();
    }

    @Test
    public void irRegistroLogin() {
        // Usamos el objeto de la página para ingresar las credenciales y enviar el formulario
        login.ingresarDatos("test1@gmail.com", "ABCD");

        // Verificamos el texto del título del formulario después del login
        Assert.assertEquals(login.getTextTitleForm(), "AUTHENTICATION");
    }


}
