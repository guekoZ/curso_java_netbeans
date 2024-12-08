/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacionFinal;

import java.sql.*;

public class ConexionBD {

    public void ConexionBD() {
        miConexion = null;

        try {

            miConexion = DriverManager.getConnection("jdbc:mariadb://192.168.1.11:3306/prueba", "root", "normab");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public ResultSet obtenerTablas() {

        ResultSet envioResultSet = null;

        try {
            DatabaseMetaData datosBD = miConexion.getMetaData();

            envioResultSet = datosBD.getTables(null, null, null, null);

        } catch (Exception e) {

        }

        return envioResultSet;

    }

    Connection miConexion;

}
