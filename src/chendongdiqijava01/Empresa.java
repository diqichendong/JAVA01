/*
 * P01 - Introducción
 */
package chendongdiqijava01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Di Qi
 */
public class Empresa {

    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList();
        empleados.add(new Empleado("Di Qi", 10000));
        empleados.add(new Empleado("Antonio", 1200, 5000));
        empleados.add(new Empleado("Belén", 8000));
        empleados.add(new Empleado("Carlos", 1500, 4000));

        gestionEmpleados(empleados);
    }

    /**
     * Gestion de los empleados
     * @param empleados Lista de los empleados
     */
    public static void gestionEmpleados(List<Empleado> empleados) {

        boolean salir = false;

        do {
            int opcion = mostrarMenu();
            Empleado e;

            switch (opcion) {
                // Ver el sueldo de un empleado
                case 1:
                    e = elegirEmpleado(empleados);
                    System.out.println(">>> Sueldo: " + e.getSueldo());
                    break;
                // Ver el nombre de un usuario
                case 2:
                    e = elegirEmpleado(empleados);
                    System.out.println(">>> Nombre: " + e.getNombre());
                    break;
                // Cambiar el nombre de un empleado
                case 3:
                    e = elegirEmpleado(empleados);
                    cambiarNombreEmpleado(empleados, e);
                    break;
                // Establecer el sueldo de un empleado
                case 4:
                    e = elegirEmpleado(empleados);
                    establecerSueldoEmpleado(empleados, e);
                    break;
                // Ver todos los empleados
                case 5:
                    for (Empleado empleado : empleados) {
                        System.out.println(empleado);
                    }
                    break;
                case 6:
                    salir = true;
                    break;
            }

        } while (!salir);
    }

    /**
     * Muestra el menú hasta elegir una opción correcta
     * @return La opción
     */
    public static int mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n------------------- MENÚ -------------------");
            System.out.println("1 - Ver el sueldo de un empleado");
            System.out.println("2 - Ver el nombre de un empleado");
            System.out.println("3 - Cambiar el nombre de un empleado");
            System.out.println("4 - Establecer el sueldo de un empleado");
            System.out.println("5 - Ver todos los empleados");
            System.out.println("6 - Salir");
            System.out.println("--------------------------------------------\n");
            opcion = Terminal.leerEntero();
        } while (opcion <= 0 || opcion > 6);

        return opcion;
    }

    /**
     * Muestra una lista de empleados hasta elegir uno correctamente
     * @param empleados Lista de los empleados
     * @return El empleado elegido
     */
    public static Empleado elegirEmpleado(List<Empleado> empleados) {
        int opcion;

        do {
            System.out.println(" >>> Elige un empleado:");
            for (int i = 0; i < empleados.size(); i++) {
                System.out.println((i + 1) + " - " + empleados.get(i).getNombre());
            }

            opcion = Terminal.leerEntero();

        } while (opcion <= 0 || opcion > empleados.size());

        return empleados.get(opcion - 1);
    }

    /**
     * Cambia el nombre de un empleado
     * @param empleados Lista de empleados
     * @param e Empleado al que se le va a cambiar el nombre
     */
    public static void cambiarNombreEmpleado(List<Empleado> empleados, Empleado e) {
        Scanner sc = new Scanner(System.in, "latin1");

        System.out.println(">>> ¿Cuál será el nuevo nombre?");
        String nuevoNombre = sc.nextLine();
        empleados.get(empleados.indexOf(e)).setNombre(nuevoNombre);
        System.out.println(">>> Se ha cambiado el nombre a '" + nuevoNombre + "'");
    }

    /**
     * Establece el sueldo de un empleado
     * @param empleados Lista de empleados
     * @param e Empleado al que se le va ha establecer el sueldo
     */
    public static void establecerSueldoEmpleado(List<Empleado> empleados, Empleado e) {
        System.out.println(">>> ¿Cuál será el sueldo de este empleado?");

        int nuevoSueldo = Terminal.leerEntero();
        
        while (nuevoSueldo > e.getSueldoMaximo() || nuevoSueldo < 0) {
            System.out.println(">>> El sueldo no puede superar los " + e.getSueldoMaximo() + "€ ni ser negativo");
            nuevoSueldo = Terminal.leerEntero();
        }

        empleados.get(empleados.indexOf(e)).setSueldo(nuevoSueldo);
        System.out.println(">>> El sueldo se ha establecido a " + nuevoSueldo + "€");
    }

}
