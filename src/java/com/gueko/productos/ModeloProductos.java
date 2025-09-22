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
    
}
