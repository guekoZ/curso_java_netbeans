/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.estudiojava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Aplicacion_Consulta {

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        JFrame mimarco = new Marco_Aplicacion();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mimarco.setVisible(true);

    }

}

class Marco_Aplicacion extends JFrame {

    public Marco_Aplicacion() {

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
        
        botonConsulta.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
              ejecutaConsulta();
                
            }
        
        
        
        });
        
        
        

        add(botonConsulta, BorderLayout.SOUTH);
        
        
        
        try {
            
      // Se realiza la conexion a la base datos
            
           miConexion= DriverManager.getConnection("jdbc:mariadb://192.168.1.11:3306/prueba","root","normab");
            
            Statement  misentecia = miConexion.createStatement(); 
            
            
            
            
            //--------------------------------------- Se cargan los datos del JComboBox llamado secciones
            
            String cunsulta = "SELECT DISTINCT seccion FROM productos";
            
            ResultSet rs = misentecia.executeQuery(cunsulta);
            
            
            while (rs.next()) {
                
                secciones.addItem(rs.getString(1));
            }
            rs.close();
            
            
            
            
            //----------------------- Se cargan los datos del segundo JComboBox llamado paises
            
          cunsulta = "SELECT DISTINCT paisdeorigen FROM productos";
            
            rs = misentecia.executeQuery(cunsulta);
            
            
            while (rs.next()) {
                
                paises.addItem(rs.getString(1));
            }
            rs.close();
            
            
        }catch(Exception e){
            
            
        }
            

    }
    
    private void ejecutaConsulta (){
        
        ResultSet rs = null;
        
        try {
            
            String seccion=(String)secciones.getSelectedItem();
            
            enviaConsultaSeccion=  miConexion.prepareStatement(consultaSeccion);
            
            enviaConsultaSeccion.setString(1, seccion);
            
            rs= enviaConsultaSeccion.executeQuery();
            
            
            
        } catch (Exception e) {
            
        }
        
        try {
            while (rs.next()) {
              
                resultado.append(rs.getString(1));
                resultado.append(",  ");
                
                 resultado.append(rs.getString(2));
                resultado.append(",  ");
                
                 resultado.append(rs.getString(3));
                resultado.append(",  ");
                
                 resultado.append(rs.getString(4));
                resultado.append(",  ");
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Marco_Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private Connection miConexion;
    private PreparedStatement enviaConsultaSeccion;
    
    private final String consultaSeccion = "SELECT nombrearticulo, seccion, precio FROM productos WHERE seccion=?";

    private JComboBox secciones;

    private JComboBox paises;

    private JTextArea resultado;

}
