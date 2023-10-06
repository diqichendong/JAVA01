/*
 * Clase Terminal
 */
package chendongdiqijava01;

import java.util.Scanner;

/**
 *
 * @author Di Qi
 */
public class Terminal {
    
    /**
     * Lee por pantalla un número entero
     * @return El número entero
     */
    public static int leerEntero() {
        Scanner sc = new Scanner(System.in);
        int entero = -1;
        boolean encontrado = false;
        
        while (!encontrado) {
            try {
                entero = sc.nextInt();
                encontrado = true;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(">>> No se ha introducido un número entero");
            }
        }

        return entero;
    }
}
