// Este codigo se explica en los videos 210 al 217 y habla sobre el modelo MVC (modelo vista controlador)

package modelo;

import java.sql.*;


// Esta clase realiza las consultas que se eligieron en los JComboBox de la clase Marco_Aplicacion2
public class EjecutaConsultas {

    public EjecutaConsultas() {

        miConexion = new Conexion();
    }

    public ResultSet filtraBBDD(String seccion, String pais) {

        
        Connection conecta = miConexion.dameConexicon();

        rs = null;

        try {
            if (!seccion.equals("Todos") && pais.equals("Todos")) {
                
                
                // La instancia PreparedStatement recibe la coneccion con la consulta que hara en la base datos
                enviaConsultaSeccion = conecta.prepareStatement(consultaSeccion);
                
                // Esta sentencia sirve para acomdar la columna 1 de la columna seccion 
                enviaConsultaSeccion.setString(1, seccion);
                // Se asigna los resultados a una variable ResultSet y poder ejecutar la conuslta
                rs = enviaConsultaSeccion.executeQuery();

            } else if (seccion.equals("Todos") && !pais.equals("Todos")) {
                
                enviaConsultaPais= conecta.prepareStatement(consultaPais);
                enviaConsultaPais.setString(1, pais);
                rs= enviaConsultaPais.executeQuery();
                

            } else {
                
                enviaConsultaTodos= conecta.prepareStatement(consultaTodos);
                enviaConsultaTodos.setString(1, seccion);
                enviaConsultaTodos.setString(2, pais);
                
               rs= enviaConsultaTodos.executeQuery();
            }
        } catch (SQLException e) {
        }

        return rs;

    }

   

    // Se declara la instancia de la clase que realiza la consulta, en este caso la clase Conexion que forma parate dle modelo
    private Conexion miConexion;
    
    //Esta es la instancia de la clase ResultSet que recibe los registros obtenidos por la 
    private ResultSet rs;
    
    private PreparedStatement enviaConsultaSeccion;
    private final String consultaSeccion = "SELECT seccion, nombrearticulo, precio, paisdeorigen FROM productos WHERE seccion = ?";
    
    
    private PreparedStatement enviaConsultaPais;
    private final String consultaPais = "SELECT seccion, nombrearticulo, precio, paisdeorigen FROM productos WHERE paisdeorigen = ?";
    
    private PreparedStatement enviaConsultaTodos;
    private final String consultaTodos = "SELECT seccion, nombrearticulo, precio, paisdeorigen FROM productos WHERE seccion=? AND paisdeorigen=?"; 
}
