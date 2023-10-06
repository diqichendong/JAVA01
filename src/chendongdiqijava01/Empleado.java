/*
 * Clase Empleado
 */
package chendongdiqijava01;

/**
 *
 * @author Di Qi
 */
public class Empleado {
    
    private String nombre;
    private int sueldo;
    private int sueldoMaximo;

    public Empleado(String nombre, int sueldoMaximo) {
        this.nombre = nombre;
        this.sueldoMaximo = sueldoMaximo;
        this.sueldo = 0;
    }

    public Empleado(String nombre, int suelto, int sueldoMaximo) {
        this.nombre = nombre;
        this.sueldo = suelto;
        this.sueldoMaximo = sueldoMaximo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getSueldoMaximo() {
        return sueldoMaximo;
    }

    public void setSueldoMaximo(int sueldoMaximo) {
        this.sueldoMaximo = sueldoMaximo;
    }

    @Override
    public String toString() {
        return nombre + "*" + sueldo + "*" + sueldoMaximo;
    }
    
    
    
    
}
