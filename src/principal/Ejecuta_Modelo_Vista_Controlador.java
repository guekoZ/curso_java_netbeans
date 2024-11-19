// Este codigo esta explicado en los videos 210 al 217 y explica el uso de MVC o modelo vista controlador
// Esta es la clase principal y es la que se ejecuta
package principal;

import javax.swing.JFrame;
import vista.Marco_Aplicacion2;


public class Ejecuta_Modelo_Vista_Controlador {
    
    public static void main(String[] args) {
        
        // Se cran las intancias de la clase Marco_Aplicaion2 y poder mostar el marco principal en donde estan los elementos
        
        Marco_Aplicacion2 mimarco = new Marco_Aplicacion2();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
        
    }
    
}
