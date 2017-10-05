package Modelo;

import Controlador.*;
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
    public boolean registrar_Detalle_Proycto(String cantidad, String negocio, String tipoNegocio, int estado, String numerOrden, String material) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "SELECT FU_RegistrarDetalleProyecto(?,?,?,?,?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, Integer.parseInt(numerOrden));
            ps.setString(2, tipoNegocio);
            ps.setString(3, cantidad);
            ps.setString(4, negocio);
            ps.setInt(5, estado);
            ps.setString(6, material);
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
                //Falta completar esta parte del codigo
                for (int i = 1; i <= 10; i++) {
                    Qry = "CALL PA_RegistrarDetalleFormatoEstandar(?)";
                    ps = con.prepareStatement(Qry);
                    ps.setInt(1, i);
                    ps.execute();
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

    public CachedRowSet consultar_Detalle_Proyecto() {

        return crs;
    }

    public boolean cambiar_Estado_Detalle() {

        return true;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Se finalizo la clase del modelo del detalle proyecto");
    }
    
}
