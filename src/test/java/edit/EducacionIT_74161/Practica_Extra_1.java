package edit.EducacionIT_74161;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Practica_Extra_1 {
	@Test
	public void testSeleniumExample() {
		WebDriver driver = null;
		String URL="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
        
		By searchqueryLocator=By.cssSelector("input[placeholder='Search']");
		
        try {

			driver= new EdgeDriver();		
			driver.get(URL);
			driver.manage().window().maximize();

			WebElement txtBuscador=driver.findElement(searchqueryLocator);
			txtBuscador.clear();
			txtBuscador.sendKeys("Blouse");
			txtBuscador.sendKeys(Keys.ENTER);


		} catch (Exception e) {

			//e.printStackTrace();
			System.out.println("Error: "+e.getMessage());
			// Rethrow the exception so the test fails
            throw e;


		} finally {

			if (driver != null) {
				driver.close();
			}
		}
	}

}
