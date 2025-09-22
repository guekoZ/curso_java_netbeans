/*
Este video codigo, aunque no es el mismo del video, se puede ver en el 250
Este codigo lo investigue en la pagina de maridb y di con este resultado para crear un pool de conexiones con jdbc de mariadb
Ademas, en la pagina (https://www.youtube.com/watch?v=K_lw3SuPExM&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=258) pude hacer el codigo que
esta aqui aunque no tuve que cambiar las clases que se utilizan
 */
package com.gueko.productos;

import java.sql.SQLException;
import org.mariadb.jdbc.MariaDbPoolDataSource;
import java.sql.Connection;

public final class ConectionPool {
    
public MariaDbPoolDataSource pool;
   
    public ConectionPool(){
        
            
       }
    
    
        // Aqui se instancia la clase para crear el pool de conexiones
        // Se agregregan todos los parametro de configuraciones en el string que se le pasa como parametro
    
    public MariaDbPoolDataSource getInstance(){
        
        if(pool == null){
            try {
                pool= new MariaDbPoolDataSource("jdbc:mariadb://192.168.1.11:3306/prueba?user=root&password=normab&maxPoolSize=10&minPoolSize=3&maxIdleTime=1000");
             return pool;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }else{
         return pool;
        }
    return null;
      
        
    }
   
  public Connection getConnection() throws SQLException{
  
     Connection conexion =  null;
             
             conexion= getInstance().getConnection();
             return conexion;
  
  }  

}
