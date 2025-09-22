/*
Este codigo se explica en los vides 250 y es sobre como realizar un CRUD, pero utilizando un pool de
conexiones. En esta ocasion no funciono porque no logre conectar a la base datos y hacer el pool de conexiones
Se puede investigar y ver como se raliza de otra manera un pool de conexiones.
 */
package com.gueko.productos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * esta es la clase principal en donde se tinen los metodos doGet y doPost
 */
@WebServlet(name = "ServletPruebas", urlPatterns = {"/ServletPruebas"})
public class ServletPruebas extends HttpServlet {

    private static final long serialVersionUID = 1L;

    

    public ServletPruebas() {
        super();

      
    }

    /*
    
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

// Este codigo que esta comentado es la forma que se explica en el video 250 para generar una pool de conexiones utilando el archivo context.xml

        /*   //Crear el objeto printWriter
        
        PrintWriter salida=  response.getWriter();
        
        response.setContentType("text/plain");
        
        // Crear la conexion a la BBDD
        
        Connection miConexion = null;
        Statement miStatement= null;
        ResultSet miResultset = null;   
              
       try {
       miConexion=miPool.getConnection();
       String miSql= "SELECT * FROM productos";
       
       miStatement= miConexion.createStatement();
       
       miResultset=miStatement.executeQuery(miSql);
       
       while(miResultset.next()){
           
           String nombreArticulo= miResultset.getString(3);
           System.out.println(nombreArticulo);
        }
       
       }catch(SQLException e){
           System.out.println("Ocurrio un error");
       }*/
    }

    
    
    
    
    /*     
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
