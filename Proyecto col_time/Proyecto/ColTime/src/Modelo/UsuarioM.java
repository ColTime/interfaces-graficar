package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

public class UsuarioM {
//Variables-------------------------------------------------------------------->

    Conexion conexion = null;
    PreparedStatement ps = null;
    Connection con = null;
    CachedRowSet crs = null;
    ResultSet rs = null;
    boolean res;
//Metodos---------------------------------------------------------------------->

    public boolean registrar_Modificar_Usuario(String doc, String tipo, String nombres, String apellidos, int cargo, int op, boolean estado) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "SELECT FU_InsertarModificarUsuar(?,?,?,?,?,?,?)";
            ps = con.prepareStatement(Qry);
            ps.setString(1, doc);
            ps.setString(2, tipo);
            ps.setString(3, nombres);
            ps.setString(4, apellidos);
            ps.setInt(5, cargo);
            ps.setBoolean(6, estado);
            ps.setInt(7, op);
            rs = ps.executeQuery();
            if (rs.next()) {
                res = rs.getBoolean(1);
            } else {
                res = false;
            }
            con.close();
            conexion.destruir();
            conexion.cerrar(rs);
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return res;
    }

    public CachedRowSet consultar_Usuario() {

        return crs;
    }

    public boolean cambiar_Estado_Usuario() {

        return true;
    }

    public boolean iniciarSesion() {

        return true;
    }

    public void cerrarSesion() {

    }

    public boolean validarUsuario(String doc) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "call PA_ValidarUsuario(?)";
            ps = con.prepareStatement(Qry);
            ps.setString(1, doc);
            rs = ps.executeQuery();
            if (rs.next()) {
                res = false;
            } else {
                res = true;
            }
            conexion.cerrar(rs);
            ps.close();
            con.close();
            conexion.destruir();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return res;
    }
}
