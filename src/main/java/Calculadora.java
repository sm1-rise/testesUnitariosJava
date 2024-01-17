public class Calculadora {
    public int soma( int a, int b){
        return a + b;
    }

    public static void main(String[] args) {
        Calculadora cal = new Calculadora();
        System.out.println(cal.soma(2, 3));
    }
}
