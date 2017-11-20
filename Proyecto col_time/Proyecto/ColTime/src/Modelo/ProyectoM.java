package Modelo;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
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
    public CachedRowSet diagramaM() {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_Diagramas()";
            ps = con.prepareStatement(Qry);
            rs = ps.executeQuery();
            crsP = new CachedRowSetImpl();
            crsP.populate(rs);
            con.close();
            conexion.destruir();
            conexion.cerrar(rs);
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
        return crsP;
    }

    public boolean registrar_Modificar_Proyecto(int norden, String comercial, String cliente, String proyecto, String tipo, boolean fe, boolean te, boolean in, boolean pcbfe,
            boolean pcbte, boolean conversor, boolean repujado, boolean troquel, boolean stencil, boolean lexan, String fechaEntrega, boolean ruteo, boolean anti,
            int op, boolean antisolderP, boolean ruteoP) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = " SELECT FU_RegistrarModificarProyecto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            ps.setInt(18, norden);
            ps.setInt(19, op);
            ps.setBoolean(20, ruteoP);
            ps.setBoolean(21, antisolderP);
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

    public CachedRowSet consultar_Proyecto(int numerOrden, String nombreCliente, String nombreProyecto, String fecha, String TipoFecha) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = Qry = "CALL PA_ConsultarProyectosIngreso(?,?,?,?)";
            if (TipoFecha.equals("Ingreso")) {
                //Query para buscar por fecha de Ingreso
                Qry = "CALL PA_ConsultarProyectosIngreso(?,?,?,?)";
            } else if (TipoFecha.equals("Entrega")) {
                //Query para buscar por fecha de Entrega
                Qry = "CALL PA_ConsultarProyectosEntrega(?,?,?,?)";
            } else if (TipoFecha.equals("Salida")) {
                //Query para buscar por fecha de Salida
                Qry = "CALL PA_ConsultarProyectosSalida(?,?,?,?)";
            }
            ps = con.prepareStatement(Qry);
            ps.setInt(1, numerOrden);
            ps.setString(2, nombreCliente);
            ps.setString(3, nombreProyecto);
            ps.setString(4, fecha);
            rs = ps.executeQuery();
            crsP = new CachedRowSetImpl();
            crsP.populate(rs);
            conexion.cerrar(rs);
            ps.close();
            con.close();
            conexion.destruir();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return crsP;
    }

    //!!!!!!!!!!!!!!!!!
    // Esta parte del codigo es muy sencible, se utilizara para proyectos que lleven mas de un cierto tiempo terminados o no hayan comenzado la toma de timepos.
    public boolean EliminarProyecto(int orden) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_EliminarNivel3(?)";//----------------------------------------- esta pendiente-----
            ps = con.prepareStatement(Qry);
            ps.setInt(1, orden);
            rs = ps.executeQuery();
            crsP = new CachedRowSetImpl();
            crsP.populate(rs);
            con.close();
            conexion.destruir();
            conexion.cerrar(rs);
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
        return res;
    }

    //!!!!!!!!!!!!!!
    public CachedRowSet Consultar_informacion_para_el_QR(int orden) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_InformacionQR(?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, orden);
            rs = ps.executeQuery();
            crsP = new CachedRowSetImpl();
            crsP.populate(rs);
            con.close();
            conexion.destruir();
            conexion.cerrar(rs);
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
        return crsP;
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

    public CachedRowSet fechaYdatosProduccion() {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_InformacionDeTodaElAreaDeProduccion()";
            ps = con.prepareStatement(Qry);
            rs = ps.executeQuery();
            crsP = new CachedRowSetImpl();
            crsP.populate(rs);

            con.close();
            conexion.destruir();
            conexion.cerrar(rs);
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return crsP;
    }

    public CachedRowSet proyectosNegocio(int negocio, String orden, String cliente, String proyecto, String tipo) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_InformacionProyectosProduccion(?,?,?,?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, negocio);
            if (!orden.equals("")) {
                ps.setInt(2, Integer.parseInt(orden));
            } else {
                ps.setInt(2, 0);
            }
            ps.setString(3, cliente);
            ps.setString(4, proyecto);
            if (!tipo.equals("Seleccione...")) {
                ps.setString(5, tipo);
            } else {
                ps.setString(5, "");
            }
            rs = ps.executeQuery();
            crsP = new CachedRowSetImpl();
            crsP.populate(rs);
            con.close();
            conexion.destruir();
            conexion.cerrar(rs);
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return crsP;
    }

    public boolean validarNumerOrden(int orden) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "SELECT FU_ValidarNumerOrden(?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, orden);
            rs = ps.executeQuery();
            rs.next();
            res = rs.getBoolean(1);
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
