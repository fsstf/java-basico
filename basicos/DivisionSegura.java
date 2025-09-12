package basicos;

public class DivisionSegura {
    public static void main(String[] args) {
        try {
            System.out.println(dividir(10,0));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("Fin");
        }
    }
    public static double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por zero");
        }
        return a / b;
    }
}
