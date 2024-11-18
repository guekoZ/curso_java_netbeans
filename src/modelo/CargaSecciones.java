


package modelo;


import  java.sql.*;
import controlador.*;



public class CargaSecciones {
    
    public CargaSecciones(){
        
        miConexion=new Conexion();
        
        
    }
    
    
    public String ejecutaConsultas(){
        
        Productos miProducto=null;
        Connection accesoBBDD = miConexion.dameConexicon();
        
         Connection accesoBD= miConexion.dameConexicon();
         
         try {
            
             Statement secciones = accesoBBDD.createStatement();
             rs = secciones.executeQuery("SELECT DISTINCT seccion FROM productos");
             
             while (rs.next()) {
                 
                 miProducto= new Productos();
                 miProducto.setSeccion(rs.getString(1));
                 
                 return  miProducto.getSeccion();
                         
                 
             }
             
             rs.close();


             
        } catch (Exception e) {
        }
         
         return miProducto.getSeccion();
         
        
    }
    
    Conexion miConexion;
    public ResultSet rs;
    
}
