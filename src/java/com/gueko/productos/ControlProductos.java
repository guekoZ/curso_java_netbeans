/*
 Este codigo se explica en el video 252
 */
package com.gueko.productos;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gueko
 */
@WebServlet(name = "ControlProductos", urlPatterns = {"/ControlProductos"})
public class ControlProductos extends HttpServlet {

    private ModeloProductos modeloProductos;

    private final ConectionPool miConexion = new ConectionPool();

    @Override
    public void init() throws ServletException {

        super.init();

        try {
            modeloProductos = new ModeloProductos(miConexion.getConnection());
        } catch (SQLException ex) {

            System.out.println("Ocurrio algun error");
        }

    }

    // Metodo doGet que recibira  los datos del archivo archivo jsp
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Leer el parametro del formulario 
        String elComando = request.getParameter("instruccion");

        // En el caso de que no se mande el parametro se listan los productos
        if (elComando == null) {

            elComando = "listar";
        }

        // Elegir la opcion que queremos que realice
        switch (elComando) {
            case "listar":
                obtenerProductos(request, response);
                break;

            case "insertarBBDD":

                agregarProductos(response, request);

                break;

            case "cargar": 
                try {
                    cargaProductos(request, response);
                } catch (Exception ex) {
                    System.getLogger(ControlProductos.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            
            break;

            case "actualizarBBDD": 
                try {
                    actualizarProductos(request, response);
                } catch (Exception ex) {
                    System.getLogger(ControlProductos.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            
           
                        
            case "eliminar": 
                try {
                    eliminarProducto(request, response);
                } catch (Exception ex) {
                    System.getLogger(ControlProductos.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            
                     
            
            default:

                obtenerProductos(request, response);

        }

    }

    // -------------------------------Este metodo se encarga de obtener los productos--------------------------------------------
    private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {

        List<Productos> productos;

        try {

            productos = modeloProductos.getProductos();

            // Se agregan la lista de los productos al request
            request.setAttribute("ListaProductos", productos);

            // Se envian al archivo jsp que recibira los datos
            RequestDispatcher miDispatcher = request.getRequestDispatcher("/ListaProductos.jsp");

            miDispatcher.forward(request, response);

        } catch (Exception e) {

            System.err.println("Ocurrio un error");
        }

    }

    // ---------------------------Este metodo se encarga de agregar un producto nuevo a la base datos
    private void agregarProductos(HttpServletResponse response, HttpServletRequest request) {

        // Leer la informacion que viene del formulario 
        int CodArticulo = Integer.parseInt(request.getParameter("CArt"));
        String seccion = request.getParameter("seccion");
        String nombreArticulo = request.getParameter("NArt");

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");

        Date fecha = null;
        try {
            fecha = formatoFecha.parse(request.getParameter("fecha"));
        } catch (ParseException ex) {
            System.getLogger(ControlProductos.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        double precio = Double.parseDouble(request.getParameter("precio"));
        String importado = request.getParameter("importado");
        String paisOrigen = request.getParameter("POrigen");

        // Crear un objeto de tipo producto
        Productos NuevoProducto = new Productos(CodArticulo, seccion, nombreArticulo, precio, fecha, importado, paisOrigen);

        try {
            // Enviar el objeto al modelo  y despues insertar el objeto Producto a la BBDD
            modeloProductos.agregarNuevoProducto(NuevoProducto);
        } catch (Exception ex) {
            System.getLogger(ControlProductos.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        // Volver a listar los productos
        obtenerProductos(request, response);
    }

    //----------------------------Este metodo es el que encarga de editar los registros
    private void cargaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // Leemos el codigo del articulo manadado del archivo ListaProductos.jsp 
        String codigoArticulo = request.getParameter("CArticulo");

        //Se envia el el codigo articulo al modelo
        Productos elProducto = modeloProductos.getProducto(codigoArticulo);

        // Colocar el atributo correspondiente al codigo articulo
        request.setAttribute("ProductoActualizar", elProducto);

        // Enviar el producto a actualizar al archivo actualizarProducto.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/actualizarProducto.jsp");
        dispatcher.forward(request, response);

    }

    private void actualizarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // -----------------------------Leer el articulo que viene del listado-----------------------------------------------------
        int CodArticulo = Integer.parseInt(request.getParameter("CArt"));
        String seccion = request.getParameter("seccion");
        String nombreArticulo = request.getParameter("NArt");

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");

        Date fecha = null;
        try {
            fecha = formatoFecha.parse(request.getParameter("fecha"));
        } catch (ParseException ex) {
            System.out.println("Error al formar la fecha");
        }

        double precio = Double.parseDouble(request.getParameter("precio"));
        String importado = request.getParameter("importado");
        String paisOrigen = request.getParameter("POrigen");
        
        //----------------------------- Crear un objeto de tipo producto------------------------------------------------------------
        
        Productos ProductoActualizado = new Productos(CodArticulo, seccion, nombreArticulo, precio, fecha, importado, paisOrigen);

        //------------------Actualizar la BBDD con la info del producto----------------------------------------------------
        modeloProductos.actualizarProducto(ProductoActualizado);

        //------------------------Volver a listar los productos ya actualizados
        obtenerProductos(request, response);

    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        //------------------Capturar el articulo que se manda ListaProductos.jsp
        int CodArticulo = Integer.parseInt(request.getParameter("CArticulo"));
        
        //-----------------------Borrar el producto de la base de datos---------------------------------
        modeloProductos.eliminarProducto(CodArticulo);
        
        //Listar los productos de la tabla productos 
        
        obtenerProductos(request, response);
           }

}
