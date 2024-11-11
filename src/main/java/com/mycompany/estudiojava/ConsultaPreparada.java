/* Este codigo se explica en el video 205 y explica como hacer las  consultas preparadas
 */
package main.java.com.mycompany.estudiojava;

import java.sql.*;


public class ConsultaPreparada {
    
    public static void main(String[] args) {
        
        try {
            // primer paso se crea la conexion
            
            Connection  miConexion= DriverManager.getConnection("jdbc:mariadb://192.168.1.11:3306/prueba","root","normab");
            
            //Preparar la consulta 
            
            PreparedStatement miSentencia = miConexion.prepareStatement("SELECT nombrearticulo, seccion, paisdeorigen FROM productos WHERE seccion=? AND paisdeorigen=?");
            
            // Establecer los parametros de consulta 
            
            miSentencia.setString(1, "deportes");
            miSentencia.setString(2, "usa");
            
            // Cuarto paso ejecutar y recorrer la consulta
            
            ResultSet rs= miSentencia.executeQuery();
            
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                
            }
            rs.close();
            
            // Se puede reutilizar el codigo cambiando nada mas los parametros en miSetencia.setString()
            
            
            System.out.println("Ejecucion de la segunda consulta ");

            miSentencia.setString(1, "ceramica");
            miSentencia.setString(2, "china");
            
            rs= miSentencia.executeQuery();
                 
                                  
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                
            }
            rs.close();
        } catch (SQLException ex) {
            
            System.out.println("La conexion no tuvo exito");
            ex.printStackTrace();
        }
        
    }
    
}
