package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

public class UsuarioM {
//Variables-------------------------------------------------------------------->

    Conexion conexion = null;
    PreparedStatement ps = null;
    Connection con = null;
    CachedRowSet crs = null;
//Metodos---------------------------------------------------------------------->

    public boolean registrar_Modificar_Usuario(String doc, int tipo, String nombres, String apllidos, int cargo, int op, int estado) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con=conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry="insert into usuario(numero_documento,tipo_documento,nombres,apellidos,cargo_idcargo,estado) VALUES('98113053240','TI','juan david','marulanda paniagua',1,1)";
            ps =con.prepareStatement(Qry);
            ps.setInt(1, op);
            ps.setString(2, doc);
            ps.setInt(3, tipo);
            ps.setString(4, nombres);
            ps.setInt(5, cargo);
            ps.setInt(6, estado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return true;
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
        
        return true;
    }
}
