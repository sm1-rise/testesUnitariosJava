import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CalculadoraTest {
    @Test
    public void testeSomar(){
        Calculadora cal = new Calculadora();
        Assertions.assertTrue(cal.soma(2 ,6) == 5);
        Assertions.assertEquals(5, cal.soma(2,1));
    }

}
