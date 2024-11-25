// Este codigo se explica el video 218 y trata sobre los procedimientos almacenados si parametros
package procAlmacenado;

import  java.sql.*;

public class ConsultaPaises {
   
    public static void main(String[] args) {
        
        try {
           Connection miConexion = DriverManager.getConnection("jdbc:mariadb://192.168.1.11:3306/prueba","root","normab");
           CallableStatement miSentencia = miConexion.prepareCall("{call muestra_paises}");
           
           ResultSet rs= miSentencia.executeQuery();
           
           while(rs.next()){

               System.out.println(rs.getString(1) + "" + rs.getString(3));
               
           }
           rs.close();
          
        } catch (Exception e) {
        }
        
    }
    
    
}
