package poo;

public class Main {
    public static void main(String[] args) {
        Persona p = new Persona("Sara",22,"Mexicana");
        Persona e = new Empleado("Azucena",20,"Mexicana",5000);
        p.saludar();
        e.saludar();
    }
}
