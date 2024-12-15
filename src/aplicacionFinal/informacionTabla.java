/*
Esta clase muestra la informacion de la tablas que se van eligiendo del combobox
 */
package aplicacionFinal;

import java.util.ArrayList;
import java.sql.*;



public class informacionTabla {
    
   public void informacionTabla(){
              
       
   } 
   
   
   public ArrayList mostrarInfoTablas(String tabla, Connection conexionTabla){
       
       Connection miConexion = conexionTabla;
       
       ArrayList <String> campos = new ArrayList<>();
       
       String consulta = "SELECT * FROM " + tabla;

       try {
           Statement miStatement = miConexion.createStatement();
           
           enviaResultSet = miStatement.executeQuery(consulta);
           
           ResultSetMetaData rsBD = enviaResultSet.getMetaData();
           
           for(int i=1; i<= rsBD.getColumnCount();i++){
               
               campos.add(rsBD.getColumnLabel(i));
               
           }
           
                        
           
           
       } catch (SQLException e) {
           
           System.out.println("Ocurrio un error en la base datos");
       }
       
       return  campos;
       
   }
   
   
   public ResultSet enviarConsultaTabla(){
       
       return enviaResultSet; 
       
   }
    
    
   ResultSet enviaResultSet;
    
}
