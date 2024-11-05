/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.estudiojava;
import java.sql.*;

/**
 *
 * @author gueko
 */
public class dbConection {
    
    static String url= "jdbc:mariadb://192.168.1.11:3306/prueba";
    static String usuario = "root";
    static String pass= "normab";
    
    public static Connection conectar(){
        Connection con =null;
        
        
        try {
           con = DriverManager.getConnection(url,usuario,pass);
           System.out.println("La conexion fue exitosa");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return  con;
    }
    
    
    
}
