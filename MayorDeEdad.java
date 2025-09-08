import java.util.Scanner;

public class MayorDeEdad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su edad: ");
        int edad = sc.nextInt();
        if(edad>=18){
            System.out.println("Mayor de edad");
        } else {
            System.out.println("Menor de edad");
        }
        sc.close();
    }
}
