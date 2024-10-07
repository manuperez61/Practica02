package Controlador;

import java.awt.Color;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

public class Controlador {
    
    public static boolean validarNacimiento( GregorianCalendar fechaNacimiento ) {
        
        int año = fechaNacimiento.get(GregorianCalendar.YEAR);            //Fecha de nacimiento correcta y entre 1900 y 2015
        if ( año >= 1900 && año <= 2015 ) {
            return true;
        } else {
            return false;
    }
 
    }
    
    public static boolean validarSueldo ( double sueldo, double sueldoMaximo ) {
        
        if ( sueldo >= 0 && sueldo <= sueldoMaximo ) {                          // Sueldos correctos (números reales) y sueldo debe ser menor que el sueldo máximo
            return true;
        } else {
            return false;
        }
  
    }
    
    public static void error (JLabel lblError, String mensaje)  {
        
        lblError.setText(mensaje);                                         //Cuando salte un error se mostrara con un JLabel rojo
        lblError.setForeground(Color.RED);
        
    }
    
}
