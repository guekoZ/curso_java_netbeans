/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.estudiojava;
import  java.sql.*;

/**
 *
 * @author gueko
 */
public class conectaDB {
    
    public static void main(String[] args) {
        
        try {
            
            // primer paso se crea la conexion
            
            Connection  miConexion= DriverManager.getConnection("jdbc:mariadb://192.168.1.11:3306/prueba","root","normab");
            
            // segundo paso crear el objeto statement
            
            Statement  miStatement = miConexion.createStatement();
            
            // tercer paso ejecutar SQL
            
            ResultSet miResultSet= miStatement.executeQuery("SELECT * FROM productos");
            
            
            // cuarto paso recorrer el ResultSet
            
            while(miResultSet.next()){
                
                System.out.println(miResultSet.getString("id_articulo")+ " "+ miResultSet.getNString("nombrearticulo")+ " " + miResultSet.getNString("precio"));
                
            }
          
            
        } catch (SQLException e) {
            
            System.out.println("Ocurrio un erro en la conexion");
            e.printStackTrace();
        }
        
    }
    
}
