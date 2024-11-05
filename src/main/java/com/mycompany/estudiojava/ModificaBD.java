/*
 Este codigo explica como conectar a una base de datos y hacer updates, insertar y borrar. Esta explicado en el video 204
 */
package main.java.com.mycompany.estudiojava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ModificaBD {
    
    public static void main(String[] args) {
        
        try {
            
            // primer paso se crea la conexion
            
            Connection  miConexion= DriverManager.getConnection("jdbc:mariadb://192.168.1.11:3306/prueba","root","normab");
            
            // segundo paso crear el objeto statement
            
            Statement  miStatement = miConexion.createStatement();
            
            String instruccionSQL = "UPDATE productos SET precio = precio*2 WHERE id_articulo = 15 ";
            
            // tercer paso ejecutar SQL
            
          miStatement.executeUpdate(instruccionSQL);
          
            System.out.println("Datos actualizados correctamente)");
            
         
            
          
          
            
        } catch (SQLException e) {
            
            System.out.println("Ocurrio un erro en la conexion");
            e.printStackTrace();
        }
        
    }
    
    
}
