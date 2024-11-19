// Este codigo se explica dentro del los videos 210 al 217
package modelo;

import java.sql.DriverManager;
import java.sql.*;

/*
Esta clase solo realiza la conexion a la base de datos y retorna un clase tipo Connection esta clase de estar contenida 
en la parte de modelo
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
