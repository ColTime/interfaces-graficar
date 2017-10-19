package Modelo;

import Controlador.*;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

public class DetalleProyectoM {

    //Constructores------------------------------------------------->
    public DetalleProyectoM() {

    }
    //Variables------------------------------------------------------>
    Conexion conexion = null;
    PreparedStatement ps = null;
    Connection con = null;
    CachedRowSet crs = null;
    ResultSet rs = null;
    boolean res = false;

    //Metodos----------------------------------------------------->
    //Este metodo también funcionara para registrar y modificar los productos no conformes PNC.
    public boolean registrar_Detalle_Proycto(String cantidad, String negocio, String tipoNegocio, int estado, String numerOrden, String material, int op, int id,int pnc,String ubicacion) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "";
            if (op == 1) {
                Qry = "SELECT FU_RegistrarDetalleProyecto(?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, Integer.parseInt(numerOrden));
                ps.setString(2, tipoNegocio);
                ps.setString(3, cantidad);
                ps.setString(4, negocio);
                ps.setInt(5, estado);
                ps.setString(6, material);
                ps.setInt(7, pnc);
                ps.setString(8, ubicacion);
                //Ejecucion de la sentencia 
                rs = ps.executeQuery();
                rs.next();
                res = rs.getBoolean(1);

                if (negocio.equals("IN")) {
                    //Se registran los procesos de IN para este subproyecto
                    for (int i = 15; i <= 20; i++) {
                        Qry = "CALL PA_RegistrarDetalleEnsamble(?)";
                        ps = con.prepareStatement(Qry);
                        ps.setInt(1, i);
                        ps.execute();
                    }
                } else if (negocio.equals("TE")) {
                    //Se registran los procesos de TE para este subproyecto 
                    for (int i = 11; i <= 14; i++) {
                        Qry = "CALL PA_RegistrarDetalleTeclados(?)";
                        ps = con.prepareStatement(Qry);
                        ps.setInt(1, i);
                        ps.execute();
                    }
                } else if (negocio.equals("FE")) {
                    //Se registran los procesos de FE para este subproyecto 
                    Qry = "CALL PA_RegistrarDetalleFormatoEstandar()";
                    ps = con.prepareStatement(Qry);
                    ps.execute();
                }
            } else if (op == 2) {
                Qry = "SELECT FU_ModificarDetalleProyecto(?,?,?,?)";
                //PreparedSteamate y detalle----------------------------------->
                ps = con.prepareStatement(Qry);
                ps.setInt(1, Integer.parseInt(numerOrden));
                ps.setInt(2, id);
                ps.setString(3, cantidad);
                ps.setString(4, material);

                rs = ps.executeQuery();
                rs.next();
                res = rs.getBoolean(1);
                if (negocio.equals("FE") && (tipoNegocio.equals("Circuito") || tipoNegocio.equals("PCB"))) {
                    //Modificar procesos de formato estandar
                    Qry = "CALL PA_ModificarDetalleFormatoEstandar(?,?)";
                    ps = con.prepareStatement(Qry);
                    ps.setInt(1, Integer.parseInt(numerOrden));
                    ps.setInt(2, id);
                    rs = ps.executeQuery();
                }
            }
            //Cierre de conexiones
            conexion.cerrar(rs);
            conexion.destruir();
            ps.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return res;
    }

    public boolean regitrarPNC() {
        

        return true;
    }

    public CachedRowSet consultar_Detalle_Proyecto(String numeOrden) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_ConsultarDetalleProyecto(?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, Integer.parseInt(numeOrden));
            rs = ps.executeQuery();
            crs = new CachedRowSetImpl();
            crs.populate(rs);
            //Cierre de conexiones
            conexion.cerrar(rs);
            conexion.destruir();
            ps.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return crs;
    }

    public CachedRowSet consultarprocesosFE(int detalle) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_ConsultarProcesosFE(?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, detalle);
            rs = ps.executeQuery();
            crs = new CachedRowSetImpl();
            crs.populate(rs);
            //Cierre de conexiones
            conexion.cerrar(rs);
            conexion.destruir();
            ps.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return crs;
    }

    public boolean cambiar_Estado_Detalle() {

        return true;
    }
//Este es el detalle del la orden deacuerdo en donde se encuentren los detalles

    public CachedRowSet consultarDetalleProyectoProduccion(int orden, int negocio) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_DetalleProyectosProduccion(?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, orden);
            ps.setInt(2, negocio);
            rs = ps.executeQuery();
            crs = new CachedRowSetImpl();
            crs.populate(rs);
            //Cierre de conexiones
            conexion.cerrar(rs);
            conexion.destruir();
            ps.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return crs;
    }

    public boolean eliminarDetallersProyecto(int idDetalle, int numeOrden, String negocio) {
        //Eliminar detalle del proyecto, detalle de formato estandar, detalle de teclado y detalle de ensamble
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "";/////
            if (negocio.equals("FE")) {
                //Quiery para eliminar el detalle de formato estandar
                Qry = "SELECT FU_EliminarDetalleProyectoFormatoestandar(?,?)";
            } else if (negocio.equals("TE")) {

                Qry = "SELECT FU_EliminarDetalleProyectoTeclados(?,?)";

            } else if (negocio.equals("IN")) {
                Qry = "SELECT FU_EliminarDetalleProyectoEnsamble(?,?)";

            }
            ps = con.prepareStatement(Qry);
            ps.setInt(1, idDetalle);
            ps.setInt(2, numeOrden);
            //Ejecucion
            rs = ps.executeQuery();
            rs.next();
            res = rs.getBoolean(1);
            //Cierre de conexiones
            conexion.cerrar(rs);
            conexion.destruir();
            ps.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return res;
    }

    public CachedRowSet consultarDetalleProduccion(int detalle, int negocio) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_DetalleDelDetalleDelproyecto(?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, detalle);
            ps.setInt(2, negocio);
            rs = ps.executeQuery();
            crs = new CachedRowSetImpl();
            crs.populate(rs);
            //Cierre de conexiones
            conexion.cerrar(rs);
            conexion.destruir();
            ps.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return crs;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

}
