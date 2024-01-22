import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;


public class CalculadoraTest {

    Calculadora cal = new Calculadora();
    @Test
    public void testeSomar(){
        Assertions.assertTrue(cal.soma(2 ,6) == 5);
        Assertions.assertEquals(5, cal.soma(2,1));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Teste1", "Teste2"})
    public void testeStrings(String param){
        System.out.println(param);
        Assertions.assertNotNull(param);
    }

    @ParameterizedTest
    @CsvSource (value = {
            "6,2,3",
            "6,-2,-3",
            "5, 2 ,2.5"
    })
    public  void deveDividirCorretamente(int num, int den, double res){
        float resultado = cal.dividir(num, den);
        Assertions.assertEquals(res, resultado);

    }
}
