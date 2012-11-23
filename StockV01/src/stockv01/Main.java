/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockv01;

import gui.Principal;
import javax.swing.UIManager;



/**
 *
 * @author willy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
           /* String kwonOS = System.getProperty("os.name");
            System.out.println(kwonOS);
//            if(kwonOS.equals("Windows Server 2008 R2")){
//                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            }
            //obtener la palabra windows
            //si es verdadero utiliza el tema windows
            String ckwonOSWIN = "windows";
            String lnx = "linux";
            String subkwonOS = ckwonOSWIN.substring(0,7);
            System.out.println(subkwonOS);
            //si el sistema operativo es windows el tema se integra
            if(ckwonOSWIN.equals("Windows")){
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //si el sistema operativo es linux el tema se integra GTK
            }else if(kwonOS.equals("Linux")){
                //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            }*/
            //cambiar el aspecto visual del programa
            //estilo GTK se ajusto a ubuntu :D
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            //windowns skin
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Principal p = new Principal();
            p.setVisible(true);
            //obtener parte de una cadena
            /*String cadena = "abcd";
            String subCadena = cadena.substring(1,4);
            System.out.println(subCadena);*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
