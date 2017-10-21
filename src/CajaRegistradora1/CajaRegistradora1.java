package CajaRegistradora1;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author home
 */
public class CajaRegistradora1 {

    public CajaRegistradora1() {
        estilo();
        VentanaPrincipal a = new  VentanaPrincipal();
	a.setVisible(true);
    }
    
    public void estilo(){
        try{

          JFrame.setDefaultLookAndFeelDecorated(true);
          JDialog.setDefaultLookAndFeelDecorated(true);
          UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
          //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
          //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
          //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        }
        catch (Exception e){
          e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        CajaRegistradora1 cajaRegistradora1 = new CajaRegistradora1();
    }
    
    
}
