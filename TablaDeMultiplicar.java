import java.util.Scanner;

public class TablaDeMultiplicar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int numero = sc.nextInt();
        System.out.println("TABLA DEL "+ numero);
        for (int i = 1; i < 21; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i) );
        }
    }
}
