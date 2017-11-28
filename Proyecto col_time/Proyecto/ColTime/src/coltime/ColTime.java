package coltime;

import Modelo.Conexion;
import com.sun.awt.AWTUtilities;

public class ColTime {

    public static void main(String[] args) {

//        Login lo=new Login();
//        AWTUtilities.setWindowOpaque(lo, false);
//        lo.setVisible(true);
        Login log = new Login();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
         //Validación de conectividad con el servidor.
//        Conexion con = new Conexion();
//        con.establecerConexion();
    }
}
