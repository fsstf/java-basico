package poo;

public class Empleado extends Persona{
    private double sueldo;
    public Empleado(String nombre, int edad, String nacionalidad, double sueldo){
        super(nombre,edad,nacionalidad);
        this.sueldo=sueldo;
    }
    @Override
    public void saludar(){
        System.out.println("Hola mi nombre es "+ getNombre()+ " y mi sueldo es de: "+ sueldo);
    }

}
