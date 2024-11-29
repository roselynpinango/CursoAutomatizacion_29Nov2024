package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class paginaLogin_1 {
	WebDriver driver;

    // Localizadores
    By emailField = By.id("email");
    By passwordField = By.id("passwd");
    By loginButton = By.id("SubmitLogin");
    By titleForm = By.xpath("//h1[contains(text(),'Authentication')]");

    // Constructor para inicializar WebDriver
    public paginaLogin_1(WebDriver driver) {
        this.driver = driver;
    }

    // Método para ingresar los datos y enviar el formulario de login
    public void ingresarDatos(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // Método para obtener el texto del título del formulario
    public String getTextTitleForm() {
        return driver.findElement(titleForm).getText();
    }

}
