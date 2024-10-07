package Vista;

import Modelo.Empleado;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAlta extends JPanel {
    private JLabel lblError;
    private JTextField fechaNacimientoField, sueldoField, sueldoMaximoField, departamentoField;
    private JButton btnAceptar, btnCancelar;
    private final Empleado empleadoActual;
    
    public PanelAlta(Empleado empleadoInicial) {
        this.empleadoActual = empleadoInicial;

        Ventana();
        
    }

    private void Ventana() {
    
        JPanel panelDatos = new JPanel(new GridLayout(4, 2));           //Distribución de los datos dentro de la ventana
        fechaNacimientoField = new JTextField(10);
        sueldoField = new JTextField(10);                                //Creación de cuadros de texto a rellenar
        sueldoMaximoField = new JTextField(10);
        departamentoField = new JTextField(10);
        
        panelDatos.add(new JLabel("Fecha Nacimiento (YYYY-MM-DD): "));
        panelDatos.add(fechaNacimientoField);
        panelDatos.add(new JLabel("Sueldo: "));                             //Inserción de etiquetas y cuadros de texto
        panelDatos.add(sueldoField);
        panelDatos.add(new JLabel("Sueldo máximo: "));
        panelDatos.add(sueldoMaximoField);
        panelDatos.add(new JLabel("Departamento: "));
        panelDatos.add(departamentoField);

        JPanel panelError = new JPanel();
        lblError = new JLabel("");
        lblError.setForeground(Color.RED);
        
        panelError.add(lblError);
        
        JPanel panelBotones = new JPanel();                                     //Distribución de los botones
        btnCancelar = new JButton("Cancelar");
        btnAceptar = new JButton("Aceptar");                                //Creación de botones
        
        btnAceptar.addActionListener((ActionEvent e) -> {
            darDeAltaEmpleado();
        });

        btnCancelar.addActionListener((ActionEvent e) -> {
            limpiarCampos();
        });
        
        panelBotones.add(btnCancelar);                                      //Adición de botones
        panelBotones.add(btnAceptar);

        this.setLayout(new BorderLayout());
        this.add(panelDatos, BorderLayout.NORTH);               
        this.add(panelError, BorderLayout.CENTER);                //Posicionamiento ventana
        this.add(panelBotones, BorderLayout.SOUTH);
        
        setVisible(true);                                                  //Ventana visible
        
    }
    
    private void darDeAltaEmpleado() {
        try {
            String[] fecha = fechaNacimientoField.getText().split("-");
            int year = Integer.parseInt(fecha[0]);
            int month = Integer.parseInt(fecha[1]) - 1;                         //Creación de fecha de nacimiento con GreogrianCalendar
            int day = Integer.parseInt(fecha[2]);
            GregorianCalendar fechaNacimiento = new GregorianCalendar(year, month, day);

            double sueldo = Double.parseDouble(sueldoField.getText());        //Conversión de sueldo en String a double
            double sueldoMaximo = Double.parseDouble(sueldoMaximoField.getText());

            if (sueldo > sueldoMaximo) {                                        //Validación del sueldo
                lblError.setText("El sueldo no puede ser mayor que el sueldo máximo.");
                return;
            }

            String departamento = departamentoField.getText();                  //Obtención departamento

            Empleado nuevoEmpleado = new Empleado(fechaNacimiento, sueldo, sueldoMaximo, departamento);     //Creación de empleado

            Empleado ultimo = empleadoActual;
            while (ultimo.getSiguiente() != null) {                             //Busqueda del último empleado
                ultimo = ultimo.getSiguiente();
            }
            ultimo.setSiguiente(nuevoEmpleado);                         //Declaración del empleado anterior y el siguiente del nuevo
            nuevoEmpleado.setAnterior(ultimo);

            lblError.setText("Empleado añadido con éxito.");                //Mensaje de éxito
            limpiarCampos();
        } catch (NumberFormatException ex) {
            lblError.setText("Error al añadir el empleado. Verifique los datos.");      //Mensaje de error
        }
    }

    private void limpiarCampos() {
        fechaNacimientoField.setText("");
        sueldoField.setText("");
        sueldoMaximoField.setText("");                                          //Reiniciar los campos al introducir datos
        departamentoField.setText("");
        lblError.setText("");
    }
}

