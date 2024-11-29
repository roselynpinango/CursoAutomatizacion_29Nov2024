package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	// Elementos Web (que van a ser utilizados de la página)
	@FindBy(partialLinkText="Sign")
	WebElement lnkSignIn;
	
	@FindBy(name="search_query")
	WebElement txtBuscador;
	
	@FindBy(css="button[name='submit_search']")
	WebElement btnBuscar;
	
	// Constructor (nos va a permitir invocar a esta clase desde el @Test)
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones que se pueden hacer con los elementos web
	public void clickOnSignIn() {
		lnkSignIn.click();
	}
	
	public void setProduct(String product) {
		txtBuscador.sendKeys(product);
	}
	
	public void clickOnSearch() {
		btnBuscar.click();
	}
}
