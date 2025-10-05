/*
 Este codigo se explica en los videos 251 y 252
 */
package com.gueko.productos;

/**
 *
 * @author gueko
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;

public class ModeloProductos {

    Connection conexion = null;
    
    // En el constructor se recibe la conexion que se maneja con el pool de conexiones
    public ModeloProductos(Connection conexion) {
        this.conexion = conexion;
        
    }
    
    
    
   public List<Productos> getProductos() throws Exception{
    
       List <Productos> productos = new ArrayList<>();
       
       Statement miStatement = null;
       ResultSet miResulset = null;
       
       
       // Se crea el statement con la  conexion con la base de datos en el constructor
       
       miStatement= conexion.createStatement();
       
       // Se ejecuta la sentencia sql
       
       miResulset = miStatement.executeQuery("SELECT * FROM productos");
       
   
       while (miResulset.next()) {

         int id_producto = miResulset.getInt("id_articulo");
         String seccion = miResulset.getString("seccion");
         String nombreArticulo = miResulset.getString("nombrearticulo");
         Double precio = miResulset.getDouble("precio");
         Date fecha = miResulset.getDate("fecha");
         String importado = miResulset.getString("importado");
         String paisOrigen = miResulset.getString("paisdeorigen");
         
         //Se crea la instancia de la clase productos, en este caso se usa el constructor que tiene mas parametros
         
         Productos tempProductos = new Productos(id_producto, seccion, nombreArticulo, precio, fecha, importado, paisOrigen);
         productos.add(tempProductos);
         
                  
         
         

       }
       
       // Retorna  el la lista con los datos de los productos que se consultaron en la consulta SQL
      return productos;
   }

   
   // Es el metodo que inserta los datos nuevos a la base datos
   
    void agregarNuevoProducto(Productos NuevoProducto) {
      
        //Preparamos la cexion
        
        Connection miConexion = null;
        PreparedStatement miStatement = null;
        
        try {
            
            miConexion= conexion;
           
            //Creamos la consulta SQL y el Statement
            
            String sql = "INSERT INTO PRODUCTOS (codigoarticulo, seccion,nombrearticulo,precio,fecha,importado,paisorigen)" + "VALUES(?,?,?,?,?,?,?,?)";
            miStatement= conexion.prepareStatement(sql);
            
            
            // Establecemos los parametros del producto
            
            miStatement.setInt(1, NuevoProducto.getcArt());
            miStatement.setString(2, NuevoProducto.getSeccion());
            miStatement.setString(3, NuevoProducto.getnArt());
            miStatement.setDouble(4, NuevoProducto.getPrecio());
            
            // Se tiene que convertir a una formato Date pero de la clase java.sql.date
            java.util.Date utilDate= NuevoProducto.getFecha();
            java.sql.Date fechaConvertida =  new java.sql.Date(utilDate.getTime());
                       
            miStatement.setDate(5, fechaConvertida);
            
            miStatement.setString(6, NuevoProducto.getImportado());
            miStatement.setString(7, NuevoProducto.getpOrig());
            
            
            // Ahora se ejecuta el SQL
            
            miStatement.execute();
            
        } catch (SQLException e) {
            
            
        }
        
    
    
    }
    
}
