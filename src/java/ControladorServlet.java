/*
Este codigo se explica en el video 248 y habla sobre la interfaz RequestDispatcher
 */

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**

 */
public class ControladorServlet extends HttpServlet {

    public ControladorServlet() {
        
        super();
    }

        
    /*
        Este es el metodo doGet y recibe los datos mandados de otro archivo
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        String [] productos = {"Destornillador", "Serrucho", "Tornillo", "Taladro"};
        
        request.setAttribute("lista_productos", productos);
        
        RequestDispatcher miDispatcher = request.getRequestDispatcher("/VistaJSP.jsp");
        miDispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

   
}
