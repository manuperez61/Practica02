package Vista;

import Modelo.Empleado;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PanelPrincipal extends JFrame {
    private PanelVer panelVer;
    private PanelAlta panelAlta;                                                //Paneles
    private PanelInformativo panelInformativo;

    private Empleado empleadoInicial;                                           //Empleado inicial

    public PanelPrincipal() {
        setTitle("Gestión de Empleados");
        setSize(400, 200);                                           //Inicialización de ventana
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        crearEmpleados();

        panelVer = new PanelVer(empleadoInicial);
        panelAlta = new PanelAlta(empleadoInicial);                             //Creación de paneles
        panelInformativo = new PanelInformativo();

        JMenuBar menuBar = new JMenuBar();                                      //Creación de la barra
        JMenu menu = new JMenu("Opciones");

        JMenuItem verEmpleados = new JMenuItem("Ver Empleados");
        verEmpleados.addActionListener(e -> mostrarPanel(panelVer));

        JMenuItem altaEmpleado = new JMenuItem("Alta Empleado");
        altaEmpleado.addActionListener(e -> mostrarPanel(panelAlta));      //Crración de secciones dentro de la principal "Opciones"

        JMenuItem acercaDe = new JMenuItem("Acerca de");
        acercaDe.addActionListener(e -> mostrarPanel(panelInformativo));

        menu.add(verEmpleados);
        menu.add(altaEmpleado);                                         //Adición de secciones
        menu.add(acercaDe);

        menuBar.add(menu);                                                    //Adición del menú a la barra
        setJMenuBar(menuBar);

        add(panelVer);                                                      //Panel default
    }

    private void mostrarPanel(JPanel panel) {
        getContentPane().removeAll();                                           //Eliminación de todo lo visible del panel actual
        add(panel);                                                         //Adición del nuevo panel
        revalidate();                                                           
        repaint();                                                              //Actualización de la ventana
    }

    private void crearEmpleados() {
                                                                                //Creación de empleados
        Empleado empleado1 = new Empleado(new GregorianCalendar(2000, 1, 1), 1000.00, 1400.00, "Marketing");
        Empleado empleado2 = new Empleado(new GregorianCalendar(2002, 10, 25), 3500.00, 6000.00, "Ventas");
        Empleado empleado3 = new Empleado(new GregorianCalendar(1999, 3, 9), 2800.00, 4500.00, "Recursos Humanos");
        Empleado empleado4 = new Empleado(new GregorianCalendar(1998, 7, 12), 4000.00, 7000.00, "Finanzas");
        Empleado empleado5 = new Empleado(new GregorianCalendar(2001, 12, 30), 3200.00, 5500.00, "Finanzas");

        empleado1.setSiguiente(empleado2);
        empleado2.setAnterior(empleado1);
        empleado2.setSiguiente(empleado3);
        empleado3.setAnterior(empleado2);
        empleado3.setSiguiente(empleado4);                              //Establecimiento del orden de los empleados
        empleado4.setAnterior(empleado3);
        empleado4.setSiguiente(empleado5);
        empleado5.setAnterior(empleado4);

        empleadoInicial = empleado1;                                            //Empleado inicial
    }

    public static void main(String[] args) {
        PanelPrincipal ventana = new PanelPrincipal();
        ventana.setVisible(true);
    }
}
