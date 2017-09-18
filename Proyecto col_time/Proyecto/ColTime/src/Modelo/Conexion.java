package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

    private Connection conexion;
    static String bd = "coltime";
    static String user = "root";
    static String password = "jorbol811";
    static String server = "jdbc:mysql://192.168.0.100:3306/" + bd;

    public Conexion() {
    }

    public void establecerConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(server, user, password);
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
}
