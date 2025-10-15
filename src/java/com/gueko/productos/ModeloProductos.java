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

public class ModeloProductos {

    Connection conexion = null;

    // En el constructor se recibe la conexion que se maneja con el pool de conexiones
    public ModeloProductos(Connection conexion) {
        this.conexion = conexion;

    }

    public List<Productos> getProductos() throws Exception {

        List<Productos> productos = new ArrayList<>();

        Statement miStatement = null;
        ResultSet miResulset = null;

        // Se crea el statement con la  conexion con la base de datos en el constructor
        miStatement = conexion.createStatement();

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

            miConexion = conexion;

            //Creamos la consulta SQL y el Statement
            String sql = "INSERT INTO productos (id_articulo,seccion,nombrearticulo,precio,fecha,importado,paisdeorigen)" + "VALUES(?,?,?,?,?,?,?)";
            miStatement = conexion.prepareStatement(sql);

            // Establecemos los parametros del producto
            miStatement.setInt(1, NuevoProducto.getcArt());
            miStatement.setString(2, NuevoProducto.getSeccion());
            miStatement.setString(3, NuevoProducto.getnArt());
            miStatement.setDouble(4, NuevoProducto.getPrecio());

            // Se tiene que convertir a una formato Date pero de la clase java.sql.date
            java.util.Date utilDate = NuevoProducto.getFecha();
            java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());

            miStatement.setDate(5, fechaConvertida);

            miStatement.setString(6, NuevoProducto.getImportado());
            miStatement.setString(7, NuevoProducto.getpOrig());

            // Ahora se ejecuta el SQL
            miStatement.execute();

        } catch (SQLException e) {

        }

    }

    Productos getProductos(String codigoArticulo) throws SQLException, Exception {

        Productos elProducto = null;

        Connection miConexion = null;

        PreparedStatement miStatement = null;

        ResultSet miResultSet = null;

        String cArticulo = codigoArticulo;

        //----------------------- Establecer la conexion 
        miConexion = conexion;

        // --------------------Crear la sentencia SQL que busque el producto
        String sql = "SELECT * FROM productos WHERE id_articulo = ?";

        //----------------------- Crear consulta preparada
        miStatement = miConexion.prepareStatement(sql);

        // ----------------------Establecer parametros
        miStatement.setString(1, cArticulo);
        
        //------------------------------ Ejecutar consulta
        
        miResultSet= miStatement.executeQuery();
        
        
        //--------------------Obtener los datos de la respuesta
        
        if (miResultSet.next()) {
            
           
            String seccion = miResultSet.getString("seccion");
            String nombreArticulo = miResultSet.getString("nombrearticulo");
            Double precio = miResultSet.getDouble("precio");
            Date fecha = miResultSet.getDate("fecha");
            String importado = miResultSet.getString("importado");
            String paisOrigen = miResultSet.getString("paisdeorigen");

            //Se crea la instancia de la clase productos, en este caso se usa el constructor que tiene mas parametros
            
            elProducto = new Productos(seccion, nombreArticulo, precio, fecha, importado, paisOrigen);
            
            
        }else{
        
            throw  new Exception("No se encontro el producto con el codigo:  " + cArticulo );
        
        }
        

        return elProducto;

    }

    void actualizarProducto(Productos ProductoActualizado) {
        
        
           }

}
