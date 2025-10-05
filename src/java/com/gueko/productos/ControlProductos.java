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

    // Metodo doGet que enviara los datos al archivo jsp
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
                    
                    agregarProductos(response,request);
                
                break;
            default:
                
                obtenerProductos(request, response);
               
        }

        

    }

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

    private void agregarProductos(HttpServletResponse response, HttpServletRequest request) {
        
    // Leer la informacion que viene del formulario 
    
    int CodArticulo = Integer.parseInt(request.getParameter("CArt"));
    String seccion = request.getParameter("seccion");
    String nombreArticulo = request.getParameter("NArt");
    
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy,MM,dd");
     
    
    Date fecha= null;
        try {
            fecha=formatoFecha.parse(request.getParameter("fecha"));
        } catch (ParseException ex) {
            System.getLogger(ControlProductos.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    
    
    Double precio = Double.parseDouble(request.getParameter("precio"));
    String importado = request.getParameter("importado");
    String paisOrigen = request.getParameter("POrigen");
    
    
    // Crear un objeto de tipo producto
    
    Productos NuevoProducto = new Productos(CodArticulo,seccion, nombreArticulo,precio, fecha, importado, paisOrigen);
    
    
    
    // Enviar el objeto al modelo  y despues insertar el objeto Producto a la BBDD
    
    modeloProductos.agregarNuevoProducto(NuevoProducto);
    
      // Volver a listar los productos
    
        obtenerProductos(request, response);
    }

}
