/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.DriverManager;
import java.sql.*;

/**
 */


public class Conexion {
    
    Connection miConexion=null;
    
    public Conexion(){
        
        
    }
    
    
    public  Connection dameConexicon(){
        
        
        try {
            
            miConexion = DriverManager.getConnection("jdbc:mariadb://192.168.1.11:3306/prueba","root","normab");
            
        } catch (Exception e) {
        }
        
        return  miConexion;
    }
    
}
