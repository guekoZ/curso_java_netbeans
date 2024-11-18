package controlador;

import java.awt.event.*;
import modelo.CargaSecciones;
import vista.Marco_Aplicacion2;

public class ControladorCargaSecciones extends WindowAdapter {

    public ControladorCargaSecciones(Marco_Aplicacion2 elmarco) {

        this.elmarco = elmarco;

    }

    @Override
    public void windowOpened(WindowEvent e) {

        obj.ejecutaConsultas();
        
        try {
          
            while (obj.rs.next()) {                
                
                elmarco.secciones.addItem(obj.rs.getString(1));
                
                
            }
            
            
        } catch (Exception e2) {
            
            e2.printStackTrace();
        }

    }

    CargaSecciones obj = new CargaSecciones();
    private Marco_Aplicacion2 elmarco;

}
