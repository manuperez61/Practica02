package Vista;

import Modelo.Empleado;

import javax.swing.*;
import java.awt.*;

public class PanelVer extends JPanel {
    
    private JTextField numeroEmpleadoField, fechaNacimientoField, sueldoField, departamentoField;       
    private JButton btnPrimero, btnSiguiente, btnAnterior, btnUltimo;           //Cuadros de texto y botones
    private Empleado empleadoActual;

    public PanelVer(Empleado empleadoInicial) {
        this.empleadoActual = empleadoInicial;
        Ventana();
    }
    
    private void Ventana() {
    
        JPanel panelDatos = new JPanel(new GridLayout(4, 2));         //Distribución de los datos dentro de la ventana
        numeroEmpleadoField = new JTextField(10);
        fechaNacimientoField = new JTextField(10);                       //Creación de cuadros de texto a rellenar
        sueldoField = new JTextField(10);
        departamentoField = new JTextField(10);

        numeroEmpleadoField.setEditable(false);
        fechaNacimientoField.setEditable(false);                              //Evita modificar los datos
        sueldoField.setEditable(false);
        departamentoField.setEditable(false);
        
        panelDatos.add(new JLabel("Número de empleado: "));
        panelDatos.add(numeroEmpleadoField);
        panelDatos.add(new JLabel("Fecha de Nacimiento: "));               //Inserción de etiquetas y cuadros de texto
        panelDatos.add(fechaNacimientoField);
        panelDatos.add(new JLabel("Sueldo: "));
        panelDatos.add(sueldoField);
        panelDatos.add(new JLabel("Departamento: "));
        panelDatos.add(departamentoField);

        JPanel panelBotones = new JPanel();                                     //Distribución de los botones
        btnPrimero = new JButton("Primero");
        btnSiguiente = new JButton("Siguiente");
        btnAnterior = new JButton("Anterior");                             //Creación de botones
        btnUltimo = new JButton("Último");
        
        btnPrimero.addActionListener(e -> mostrarPrimero());                    //Asginación de funcionalidades a los botones
        btnAnterior.addActionListener(e -> mostrarAnterior());
        btnSiguiente.addActionListener(e -> mostrarSiguiente());
        btnUltimo.addActionListener(e -> mostrarUltimo());

        panelBotones.add(btnPrimero);
        panelBotones.add(btnAnterior);                                     //Adición de botones
        panelBotones.add(btnSiguiente);
        panelBotones.add(btnUltimo);

        this.setLayout(new BorderLayout());
        this.add(panelDatos, BorderLayout.NORTH);               //Posicionamiento ventana
        this.add(panelBotones, BorderLayout.SOUTH);
        
        setVisible(true);                                                  //Ventana visible
        
        mostrarEmpleado(empleadoActual);                                // Mostrar el primer empleado al iniciar
        
    }

    private void mostrarEmpleado(Empleado empleado) {                           //Mostrar datos del empleado en los campos
        if (empleado != null) {
            numeroEmpleadoField.setText(String.valueOf(empleado.getNumeroEmpleado()));
            fechaNacimientoField.setText(empleado.getFechaNacimiento().getTime().toString());
            sueldoField.setText(String.valueOf(empleado.getSueldo()));
            departamentoField.setText(empleado.getPuesto());
        }
    }

    private void mostrarPrimero() {                                             //Mostrar primer empleado
        while (empleadoActual.getAnterior() != null) {
            empleadoActual = empleadoActual.getAnterior();
        }
        mostrarEmpleado(empleadoActual);
    }

    private void mostrarSiguiente() {                                           //Mostrar siguiente empleado
        if (empleadoActual.getSiguiente() != null) {
            empleadoActual = empleadoActual.getSiguiente();
            mostrarEmpleado(empleadoActual);
        }
    }

    private void mostrarAnterior() {                                            //Mostrar empleado anterior
        if (empleadoActual.getAnterior() != null) {
            empleadoActual = empleadoActual.getAnterior();
            mostrarEmpleado(empleadoActual);
        }
    }

    private void mostrarUltimo() {                                              //Mostrar último empleado
        while (empleadoActual.getSiguiente() != null) {
            empleadoActual = empleadoActual.getSiguiente();
        }
        mostrarEmpleado(empleadoActual);
    }
}

