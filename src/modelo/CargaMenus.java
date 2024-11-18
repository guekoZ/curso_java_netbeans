


package modelo;


import  java.sql.*;




public class CargaMenus {
    
    public CargaMenus(){
        
        miConexion=new Conexion();
        
        
    }
    
    
    public String ejecutaConsultas(){
        
        Productos miProducto=null;
        Connection accesoBBDD = miConexion.dameConexicon();
        
         Connection accesoBD= miConexion.dameConexicon();
         
         try {
            
             Statement secciones = accesoBBDD.createStatement();
              Statement paises = accesoBBDD.createStatement();
             
             rs = secciones.executeQuery("SELECT DISTINCT seccion FROM productos");
             rs2 = paises.executeQuery("SELECT DISTINCT paisdeorigen FROM productos");
             
            // while (rs.next()) {
                 
                 
                 miProducto= new Productos();
                 miProducto.setSeccion(rs.getString(1));
                 
                 miProducto.setpOrigen(rs2.getString(1));
                 
               //  return  miProducto.getSeccion();
                       
                 
             //}
             
             rs.close();
             rs2.close();
             
             accesoBBDD.close();


             
        } catch (Exception e) {
        }
         
         return miProducto.getSeccion();
         
        
    }
    
    public Conexion miConexion;
    public ResultSet rs;
    public ResultSet rs2;
    
}
