/*
Este codigo se describe en el video 227 y trata de como utilizar la clase JFileChooser para abrir una venta 
para explorar los archivos de la computdora
 */
package aplicacionFinal;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
En el video mejora la clase AplicacionFinal para que si no encuentra el archivo automaticamente la busque con seleccionador de archivos
, pero no lo pude hacer como dice el video porque desde un pricipio lo hice diferente
 */
public class ExplorarArchivos {

    public static void main(String[] args) {

        Marco mimarco = new Marco();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter( "Archivos de texto", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(mimarco);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: "+ chooser.getSelectedFile().getAbsolutePath());
        }

    }

}

class Marco extends JFrame {

    public Marco() {

        setBounds(300, 300, 300, 300);
        setVisible(true);

    }

}
