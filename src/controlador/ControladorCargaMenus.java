//Este codigo esta explicado en los videos 210 al 217 y explica el uso del MVC

package controlador;

import java.awt.event.*;
import modelo.CargaMenus;
import vista.Marco_Aplicacion2;

// Esta clase se llama cuando la aplicacion o la venta principal es abierta
public class ControladorCargaMenus extends WindowAdapter {

    public ControladorCargaMenus(Marco_Aplicacion2 elmarco) {

        this.elmarco = elmarco;

    }

    @Override
    public void windowOpened(WindowEvent e) {

        obj.ejecutaConsultas();
        
        try {
          
            while (obj.rs.next()) {  
                
                
                elmarco.secciones.addItem(obj.rs.getString(1));
                
                
            }
            
            while (obj.rs2.next()) {  
                
                
                elmarco.paises.addItem(obj.rs2.getString(1));
                
                
            }
            
            
            
        } catch (Exception e2) {
            
            e2.printStackTrace();
        }

    }

    CargaMenus obj = new CargaMenus();
    private Marco_Aplicacion2 elmarco;

}
