/*
 Este codigo se explica en el video 252
 */
package com.gueko.productos;

import java.io.IOException;
import java.sql.SQLException;
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

        List<Productos> productos;

        try {

            productos = modeloProductos.getProductos();

            // Se agregan la lista de los productos al request
            request.setAttribute("ListaProductos", productos);

            // Se envian al archivo jsp que recibira los datos
            RequestDispatcher miDispatcher = request.getRequestDispatcher("/WEB-INF/ListaProductos.jsp");

            miDispatcher.forward(request, response);

        } catch (Exception e) {
            
            System.err.println("Ocurrio un error");
        }

    }

}
