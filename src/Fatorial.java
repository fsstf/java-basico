import java.util.Scanner;

public class Fatorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Imgrese un numero: ");
        int numero = sc.nextInt();
        System.out.println("Fatorial de "+ numero +" = "+ factorial(numero));
    }
    public static int factorial(int numero){
        if(numero ==1)
            return 1;
        else
            return numero *factorial(numero -1);
    }
}
