
//Este codigo se explica en el video 219 y habla sobre procedimientos alamacenados con parametros

package procAlmacenado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Actualiza_Productos {
    
    public static void main(String[] args) {
        
        int precio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el precio"));
        
        String nArtuculo = JOptionPane.showInputDialog("Indroduce el articulo");
        
        try {
            
            Connection miConexion = DriverManager.getConnection("jdbc:mariadb://192.168.1.11:3306/prueba","root","normab");
           CallableStatement miSentencia = miConexion.prepareCall("{call actualiza_precio(?, ?)}");
           
          miSentencia.setInt(1, precio);
          miSentencia.setString(2, nArtuculo);
          miSentencia.execute();
            System.out.println("Actualizacion OK");
           
            
        } catch (Exception e) {
            
            
        }
    }
    
}
