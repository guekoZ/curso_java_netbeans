// Este codigo se explica en el video 221, pero tambien podria representar los que se hizo en el video 220 que trata sobre las
// transacciones

package transacciones;


import java.sql.*;
import javax.swing.JOptionPane;

public class Transaccion_Producto {
    
    public static void main(String[] args) {
       
        Connection miConexion= null;
        
        try {
            // Se crea la conexion a la base de datos
             miConexion = DriverManager.getConnection("jdbc:mariadb://192.168.1.11:3306/prueba","root","normab");
            
             // Se desactiva el autoCommit para que la transaccion respete el commit o el rollback de la transaccion
            miConexion.setAutoCommit(false);
            
            
            // Se crea la instancia que manejara las declaraciones SQL
            Statement miStatement= miConexion.createStatement();
            
            String instruccion_1 ="DELETE FROM  productos WHERE paisdeorigen = 'italia'";
                                  
            String instruccion_2 ="DELETE FROM  productos WHERE precio > 300";
            
            String instruccion_3 ="UPDATE productos SET precio = precio*1.15 ";
            
            
            
            // Esta funcion es la que permite dar luz verde para que se ejecuten las sentencias SQl
            boolean ejectuar= ejecutar_transaccion();
            
            if (ejectuar) {
                
                //Se ejecutan todas las sentencias SQL y se hace commit en caso contrario se hace el rollback
                miStatement.executeUpdate(instruccion_1);
                miStatement.executeUpdate(instruccion_2);
                miStatement.executeUpdate(instruccion_3);
                
                // Se realiza el cambio con commit()
                miConexion.commit();
                
                System.out.println("Se ejecuto la transaccion correcatamente");
                
                
            }else{
                
                 System.out.println("No se ejecuto la transaccion correcatamente");
            }
            
            
            
             
            
        } catch (Exception e) {
            
            try {
                
                // en el caso de que no se ejecute todo bloque se sentencias SQL se realiza el rollback, lo que retorna a su estado normal la tabla
                miConexion.rollback();
                               
            } catch (SQLException ex) {
                
                ex.printStackTrace();  
            }
            
             System.out.println(" Ocurrio un error con la transaccion");
        }
        
    }
    
    
    
    static boolean  ejecutar_transaccion(){
        
        String ejecucion = JOptionPane.showInputDialog("Quieres ejecutar el codigo?");
        
         
        if (ejecucion.equals("Si")){
            return  true;
        }
        
        else{
            return false;
        }
        
    }
    
}
