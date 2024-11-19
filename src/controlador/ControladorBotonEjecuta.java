// Este codigo esta explicado en ls videos del 210 al 217 y explica el uso de JDBC y el modelo vista controlador

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.*;
import vista.*;
import java.sql.*;


// Esta clase se activia cuando se da click al boton 
public class ControladorBotonEjecuta implements  ActionListener{
    
    // El constructor de la clase pide un parametro de tipo Marco_Aplicacion2, lo que permite enviar desde la clase los datos que 
    // que se requieren de los JComboBox
    public  ControladorBotonEjecuta(Marco_Aplicacion2 elmarco){
        
               
        this.elmarco=elmarco;
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String seleccionSeccion = (String) elmarco.secciones.getSelectedItem();
        String seleccionPais = (String) elmarco.paises.getSelectedItem();
        
        // Se crea la instancia de la clase EjecutaConsultas en especifico el metodo filtaBBDD que retorna un tipo ResultSet
        //y poder asi manejar las opciones que se presentaran en el JTextArea
        resultadoConsulta = obj.filtraBBDD(seleccionSeccion, seleccionPais);
        
        
        try {
            
            // Se recorren los registro que se obtuvieron, los cuales estan en clase tipo ResultSet
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
        }
    
    }
    
    private  Marco_Aplicacion2 elmarco;
    EjecutaConsultas obj = new EjecutaConsultas();
    private ResultSet resultadoConsulta;
    
}
