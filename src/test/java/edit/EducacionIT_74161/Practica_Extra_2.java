package edit.EducacionIT_74161;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;



public class Practica_Extra_2 {

	
	    @Test
	    public void testSuma() {
	        // Precondiciones
	        int a = 2;
	        int b = 3;
	        int expected = 5;

	        // Sumar los números
	        int resultado = a + b;

	        // Verificar que el resultado es el esperado
	        assertEquals(expected, resultado);
	    }

	    @Test
	    public void testDivisionPorCero() {
	        // Precondiciones
	        int a = 2;
	        int b = 0;

	        try {
	            // Intentar hacer la división
	            int resultado = a / b;
	            System.out.print(resultado);
	            // Si llegamos aquí, significa que no se lanzó la excepción
	            fail("Se esperaba una ArithmeticException por división por cero");
	        } catch (ArithmeticException ex) {
	            // Verificar que la excepción lanzada es la correcta
	            assertTrue(ex.getMessage().contains("/ by zero"), "El mensaje de error debería indicar 'división por cero'");
	        }
	    }
}

