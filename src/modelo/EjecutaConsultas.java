package modelo;

import java.sql.*;

public class EjecutaConsultas {

    public EjecutaConsultas() {

        miConexion = new Conexion();
    }

    public ResultSet filtraBBDD(String seccion, String pais) {

        
        Connection conecta = miConexion.dameConexicon();

        rs = null;

        try {
            if (!seccion.equals("Todos") && pais.equals("Todos")) {

                enviaConsultaSeccion = conecta.prepareStatement(consultaSeccion);
                enviaConsultaSeccion.setString(1, seccion);

                rs = enviaConsultaSeccion.executeQuery();

            } else if (seccion.equals("Todos") && !pais.equals("Todos")) {

            } else {

            }
        } catch (Exception e) {
        }

        return rs;

    }

   

    private Conexion miConexion;
    private ResultSet rs;
    private PreparedStatement enviaConsultaSeccion;
    private PreparedStatement enviaConsultaPais;
    private final String consultaSeccion = "SELECT seccion, nombrearticulo, precio, paisdeorigen FROM productos WHERE seccion = ?";

}
