package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {
	@FindBy(id="alertButton")
	WebElement btnNotificacion;
	
	public AlertPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void hacerClicEnNotificacion() {
		btnNotificacion.click();
	}
}
