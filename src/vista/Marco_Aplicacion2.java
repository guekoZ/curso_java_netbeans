/*
 Este codigo esta explicado en los videos 210 al 217 
 */
package vista;

import controlador.ControladorBotonEjecuta;
import controlador.ControladorCargaMenus;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Marco_Aplicacion2 extends JFrame {
    
    // En el constructor se agregan los componentes y se acomandan en el panel principal
    
    public Marco_Aplicacion2() {
        
        setTitle("Consulta BBDD");
        
        setBounds(500, 300, 400, 400);
        
        setLayout(new BorderLayout());
        
        JPanel menus = new JPanel();
        
        menus.setLayout(new FlowLayout());
        
        secciones = new JComboBox();
        
        secciones.setEditable(false);
        
        secciones.addItem("Todos");
        
        paises = new JComboBox();
        
        paises.setEditable(false);
        
        paises.addItem("Todos");
        
        resultado = new JTextArea(4, 50);
        
        resultado.setEditable(false);
        
        add(resultado);
        
        menus.add(secciones);
        
        menus.add(paises);
        
        add(menus, BorderLayout.NORTH);
        
        add(resultado, BorderLayout.CENTER);
        
        JButton botonConsulta = new JButton("Consulta");
        
        add(botonConsulta, BorderLayout.SOUTH);
        
        
        // Se pone a la escucha el boton, lo que permite que se haga la accion correspondiente en la clase ControladorBotonEjecuta
        botonConsulta.addActionListener(new ControladorBotonEjecuta(this));
        
        addWindowListener(new ControladorCargaMenus(this));
        
    }

    // Estos son los elementos que contiene el frame
    public JComboBox secciones;
    public JComboBox paises;
    public JTextArea resultado;
    
}
