/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informecoltime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Aprendiz
 */
public class Conexion {

    private Connection conexion;
    static String bd = "coltime";
    static String user = "coltime1";
    static String password = "123";
    static String server = "jdbc:mysql://192.168.4.76/" + bd;
    //192.168.0.103

    public Conexion() {

    }

    public void establecerConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(server, user, password);
//            if (conexion != null) {
//                JOptionPane.showMessageDialog(null, "Conexion exitosa");
//            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Imposible realizar conexion con la BD" + e);
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrar(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.print("No es posible cerrar la Conexion");
            }
        }
    }

    public void destruir() {

        if (conexion != null) {

            try {
                conexion.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
