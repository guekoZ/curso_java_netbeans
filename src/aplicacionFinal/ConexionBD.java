/*

 */
package aplicacionFinal;

import java.sql.*;

public class ConexionBD {

    public void ConexionBD() {

    }

    public Connection iniciarConexionBD() {
        enviaConexion = null;

        try {

            enviaConexion = DriverManager.getConnection("jdbc:mariadb://192.168.1.11:3306/prueba", "root", "normab");

        } catch (SQLException e) {

            System.out.println("Ocurrio un error");

        }

        return enviaConexion;

    }

    public ResultSet obtenerTablas(Connection recibeConexion) {

        ResultSet envioResultSet = null;
        Connection conexionResulSet = recibeConexion;

        try {
            DatabaseMetaData datosBD = conexionResulSet.getMetaData();

            envioResultSet = datosBD.getTables("punto_venta", null, null, null);

        } catch (SQLException e) {

            System.out.println("Ocurrio un error");

        }

        return envioResultSet;

    }

    Connection enviaConexion;

}
