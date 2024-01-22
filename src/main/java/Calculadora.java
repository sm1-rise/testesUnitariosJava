public class Calculadora {
    public int soma( int a, int b){
        return a + b;
    }

    public float dividir(int num, int den){
        return (float) num  / den;
    }

    public static void main(String[] args) {
        Calculadora cal = new Calculadora();
        System.out.println(cal.soma(2, 3));
    }
}
