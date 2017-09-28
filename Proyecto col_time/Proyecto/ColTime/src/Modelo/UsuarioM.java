package Modelo;

import com.sun.rowset.CachedRowSetImpl;
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

    public CachedRowSet consultar_Usuario(String doc, String nombreAp, int cargo) {
        try {
            Conexion obj = new Conexion();
            obj.establecerConexion();
            con = obj.getConexion();
            //Consulta-------
            String Qry = "call PA_ConsultarUsuarios(?,?,?);";
            ps = con.prepareCall(Qry);
            //Preparación de la consulta---------
            ps.setString(1, doc);
            ps.setString(2, nombreAp);
            ps.setInt(3, cargo);

            rs = ps.executeQuery();
            //Recibimiento de la información-----------
            crs = new CachedRowSetImpl();
            crs.populate(rs);
            //Finalizar conexión------------
            rs.close();
            ps.close();
            con.close();
            obj.destruir();
        } catch (Exception e) {
            System.out.print("Erro" + e);
        }
        return crs;
    }

    public boolean cambiar_Estado_Usuario(String doc, boolean estado) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query y ejecución------------------------------------------------------------>
            String Qry = "SELECT FU_ActualizarEstado(?,?)";
            ps = con.prepareCall(Qry);
            ps.setString(1, doc);
            ps.setBoolean(2, estado);
            rs = ps.executeQuery();
            if (rs.next()) {
                res = rs.getBoolean(1);
            } else {
                res = false;
            }
            //Destrucción de conexiones
            con.close();
            conexion.destruir();
            conexion.cerrar(rs);
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return res;
    }

    public boolean iniciarSesion(String user, String pasw) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query y ejecución------------------------------------------------------------>
            String Qry = "SELECT FU_IniciarSesion(?,?)";
            ps = con.prepareCall(Qry);
            ps.setString(1, user);
            ps.setString(2, pasw);
            rs = ps.executeQuery();
            if (rs.next()) {
                res = rs.getBoolean(1);
            } else {
                res = rs.getBoolean(1);
            }
            //Destrucción de conexiones
            con.close();
            conexion.destruir();
            conexion.cerrar(rs);
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return res;
    }

    public boolean cambiarContraseña(String doc, String contra, String anti) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query y ejecución------------------------------------------------------------>
            String Qry = "SELECT FU_CambiarContraseña(?,?,?)";
            ps = con.prepareCall(Qry);
            ps.setString(1, doc);
            ps.setString(2, contra);
            ps.setString(3, anti);
            rs = ps.executeQuery();
            if (rs.next()) {
                res = rs.getBoolean(1);
            } else {
                res = rs.getBoolean(1);
            }
            //Destrucción de conexiones
            con.close();
            conexion.destruir();
            conexion.cerrar(rs);
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return res;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

}
