
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.*;
import vista.*;
import java.sql.*;



public class ControladorBotonEjecuta implements  ActionListener{
    
    
    public  ControladorBotonEjecuta(Marco_Aplicacion2 elmarco){
        
        this.elmarco=elmarco;
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String seleccionSeccion = (String) elmarco.secciones.getSelectedItem();
        String seleccionPais = (String) elmarco.paises.getSelectedItem();
        
        
        resultadoConsulta = obj.filtraBBDD(seleccionSeccion, seleccionPais);
        
        
        try {
            while(resultadoConsulta.next()){
                elmarco.resultado.append(resultadoConsulta.getString(1));
                elmarco.resultado.append("\n");
               
                 elmarco.resultado.append(resultadoConsulta.getString(2));
                elmarco.resultado.append("\n");
                
                 elmarco.resultado.append(resultadoConsulta.getString(3));
                elmarco.resultado.append("\n");
                
                 elmarco.resultado.append(resultadoConsulta.getString(4));
                elmarco.resultado.append("\n");
                
            }
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
    
    }
    
    private  Marco_Aplicacion2 elmarco;
    EjecutaConsultas obj = new EjecutaConsultas();
    private ResultSet resultadoConsulta;
    
}
