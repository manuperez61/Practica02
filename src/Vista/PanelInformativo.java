package Vista;

import javax.swing.*;

public class PanelInformativo extends JPanel {
    
    public PanelInformativo() {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));              //BoxLayout para poner los componentes uno debajo del otro
        JLabel label1 = new JLabel("Aplicación de gestión de empleados (1.0)");
        add(label1);
        JLabel label2 = new JLabel("Autor: Manuel Pérez Domínguez");        //Creación y adición de etiquetas
        add(label2);
    }
    
}
