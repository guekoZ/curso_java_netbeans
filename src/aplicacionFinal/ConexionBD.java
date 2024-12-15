/*
Esta clase realiza la conexion y raliza la busqueda para despues enviarla a la clase principal
Con el metodo iniciarConexionBD que envia la conexion
La clase obtenerTabla en via los resultados con una clase ResultSet

 */
package aplicacionFinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionBD {

    public void ConexionBD() {

    }

    public Connection iniciarConexionBD() {
        enviaConexion = null;
        String datos[] = new String[3];

        try {
            
                
                entrada = new FileReader("C://Users//gueko//OneDrive//Documentos//NetBeansProjects//cursoJavaNetbeans//src//aplicacionFinal//datos_conexion.txt");
                BufferedReader miBuffer= new BufferedReader(entrada);
                
                for(int i=0; i<=2 ; i++){
                  
                    datos[i]=miBuffer.readLine();
                                        
                }
                
           
            

            enviaConexion = DriverManager.getConnection(datos[0], datos[1], datos[2]);
            entrada.close();

        }catch(IOException e1){
            
            // En este parte lo comente porque no pude poner uno de los parametros para el shoWMessageDialog en el cual se pone el componente padre
            
            
           // JOptionPane.showMessageDialog(jPanel1 ,"Ocurrio un error");
        } 
        
        catch (SQLException e2) {

            e2.printStackTrace();

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
    
    FileReader entrada;

}
