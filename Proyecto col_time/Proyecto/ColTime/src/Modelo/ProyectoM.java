package Modelo;

import Controlador.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

public class ProyectoM {

    //Constructores------------------------------------------------->
    public ProyectoM() {

    }
    //Variables------------------------------------------------------>
    public CachedRowSet crsP = null;
    Conexion conexion = null;
    PreparedStatement ps = null;
    Connection con = null;
    ResultSet rs = null;
    boolean res;
    String orden = "";
    String fecha = "";

    //Metodos y funciones------------------------------------------------>
    public boolean registrar_Modificar_Proyecto(int norden, String comercial, String cliente, String proyecto, String tipo, boolean fe, boolean te, boolean in, boolean pcbfe,
            boolean pcbte, boolean conversor, boolean repujado, boolean troquel, boolean stencil, boolean lexan, String fechaEntrega, boolean ruteo, boolean anti,
            boolean pnc, int op) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = " SELECT FU_RegistrarModificarProyecto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(Qry);
            ps.setString(1, comercial);
            ps.setString(2, cliente);
            ps.setString(3, proyecto);
            ps.setString(4, tipo);
            ps.setBoolean(5, fe);
            ps.setBoolean(6, te);
            ps.setBoolean(7, in);
            ps.setBoolean(8, pcbfe);
            ps.setBoolean(9, pcbte);
            ps.setBoolean(10, conversor);
            ps.setBoolean(11, repujado);
            ps.setBoolean(12, troquel);
            ps.setBoolean(13, stencil);
            ps.setBoolean(14, lexan);
            ps.setString(15, fechaEntrega);
            ps.setBoolean(16, ruteo);
            ps.setBoolean(17, anti);
            ps.setBoolean(18, pnc);
            ps.setInt(19, norden);
            ps.setInt(20, op);
            //Ejecución del Query---------------------------------------------->
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

    public CachedRowSet consultar_Proyecto(int numerOrden, String nombreCliente, String nombreProyecto, String tipoProyecto) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_FechaServidor()";
            ps = con.prepareStatement(Qry);
            rs = ps.executeQuery();
            if (rs.next()) {
                fecha = String.valueOf(rs.getString(1));
            }
            con.close();
            conexion.destruir();
            conexion.cerrar(rs);
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return crsP;
    }

    public boolean cambiar_Estado_Proyeto() {

        return true;
    }

    public void generar_CodigoQR_Proyecto() {

    }

    public void generar_Reportes() {

    }

    public String consultarNumeroOrden() {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_ConsultarNumeroOrden()";
            ps = con.prepareStatement(Qry);
            rs = ps.executeQuery();
            if (rs.next()) {
                orden = String.valueOf(rs.getInt(11));
            } else {
                orden = "N#Error";
            }
            con.close();
            conexion.destruir();
            conexion.cerrar(rs);
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return orden;
    }

    public String fecha() {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_FechaServidor()";
            ps = con.prepareStatement(Qry);
            rs = ps.executeQuery();
            if (rs.next()) {
                fecha = String.valueOf(rs.getString(1));
            }
            con.close();
            conexion.destruir();
            conexion.cerrar(rs);
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return fecha;
    }
}
