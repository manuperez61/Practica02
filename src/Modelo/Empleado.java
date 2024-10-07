package Modelo;

import java.util.GregorianCalendar;

public class Empleado {

    private static int contadorEmpleados = 0;                                   //Atributos
    private int numeroEmpleado;
    private GregorianCalendar fechaNacimiento;
    private double sueldo;
    private double sueldoMaximo;
    private String puesto;
    private Empleado siguiente;
    private Empleado anterior;
    
    public Empleado(GregorianCalendar fechaNacimiento, double sueldo, double sueldoMaximo, String departamento) {   //Constructor
        this.numeroEmpleado = ++contadorEmpleados;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
        this.sueldoMaximo = sueldoMaximo;
        this.puesto = departamento;
        this.siguiente = null;
        this.anterior = null;
    }

    public static int getContadorEmpleados() {                                  //Métodos Get y Set
        return contadorEmpleados;
    }

    public static void setContadorEmpleados(int contadorEmpleados) {
        Empleado.contadorEmpleados = contadorEmpleados;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getSueldoMaximo() {
        return sueldoMaximo;
    }

    public void setSueldoMaximo(double sueldoMaximo) {
        this.sueldoMaximo = sueldoMaximo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Empleado getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Empleado siguiente) {
        this.siguiente = siguiente;
    }

    public Empleado getAnterior() {
        return anterior;
    }

    public void setAnterior(Empleado anterior) {
        this.anterior = anterior;
    }
    
}
