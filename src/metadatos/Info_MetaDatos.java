/*Este video se explica en el video 222 y explica como se pueden obtener los Metadatos que la base datos o tablas
 */
package metadatos;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 */
public class Info_MetaDatos {
    
    public static void main(String[] args) {
        
        mostrarInfo_BBDD();
        
        
    }
    
    static void mostrarInfo_BBDD(){
        
        Connection miConexion= null;
        
        try {
            
            // Se crea la conexion a la base de datos
             miConexion = DriverManager.getConnection("jdbc:mariadb://192.168.1.11:3306/prueba","root","normab");
             
             // Obtenemos informacion de la BBDD
             DatabaseMetaData datosBBDD = miConexion.getMetaData();
             
             // Mostramos la informacion de la BBDD
             
             System.out.println("Gestor de BBDD "+ datosBBDD.getDatabaseProductName());
             System.out.println("Version del Gestor"+ datosBBDD.getDatabaseProductVersion());
             System.out.println("Nombre del driver "+ datosBBDD.getDriverName());
             System.out.println("Nombre del driver "+ datosBBDD.getDriverVersion());
             
             
             
            
        } catch (SQLException e) {
            
        }finally{
            try {
                miConexion.close();
                try {
                    miConexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Info_MetaDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Info_MetaDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
        
        
    }
    
}
