package colecciones;

import poo.Empleado;
import poo.Gerente;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class ColeccionesPOO {
    public static void main(String[] args) {
        Empleado e1= new Empleado("Azucena", "MX", LocalDate.of(2005, 6, 10)
                , new BigDecimal("5000.634"));
        Empleado e2 = new Empleado("Sara", "MX", LocalDate.of(2002, 10, 4)
                , new BigDecimal("7000.504"));
        Empleado e3 = new Empleado("Sara", "USA", LocalDate.of(2004, 9, 21)
                , new BigDecimal("768353.154"));
        Gerente gerente = new Gerente("Mariana", "MX", LocalDate.of(2006, 12, 14)
                , new BigDecimal("84342.234"), new BigDecimal("3425.233"));

        //===== LISTA =====
        List<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(e1);
        listaEmpleados.add(e2);
        listaEmpleados.add(e3);
        listaEmpleados.add(gerente);
        System.out.println("Listas de empleados");
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado);
        }

        //===== SET =====
        Set<String> listaNombres = new HashSet<>();
        for (Empleado empleado : listaEmpleados) {
            listaNombres.add(empleado.getNombre());
        }
        System.out.println("Listas de nombres" + listaNombres);

        //===== MAP ======
        Map<String,Empleado> mapaEmpleados = new HashMap<>();
        for (Empleado empleado : listaEmpleados) {
            mapaEmpleados.put(empleado.getNombre(), empleado);
        }
        System.out.println("Empleados por nombre (Sara): " + mapaEmpleados.get("Sara"));
    }
}
