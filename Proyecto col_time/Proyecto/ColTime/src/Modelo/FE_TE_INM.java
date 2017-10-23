package Modelo;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

public class FE_TE_INM {

    //Constructores--------------------------------------------->
    public FE_TE_INM() {

    }
//variables--------------------------------------------------->
    public CachedRowSet crsP = null;
    Conexion conexion = null;
    PreparedStatement ps = null;
    Connection con = null;
    ResultSet rs = null;
    boolean res;
    String orden = "";
    String fecha = "";
    int T_Total = 0;
   //Metodos------------------------------------------------->
    //No se te olvide tener en cuenta el id del lector y concatenar a la informacion despues de leer el codigo***
    public boolean iniciar_Pausar_Reiniciar_Toma_Tiempo(int orden, int detalle, int negocio, int lector,int cantidadTerminada) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "Select FU_ValidarTomaDeTiempo(?,?,?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, orden);
            ps.setInt(2, detalle);
            ps.setInt(3, lector);
            ps.setInt(4, negocio);
            rs = ps.executeQuery();
            rs.next();
            if (rs.getBoolean(1)) {
                //Si existe se ejecutara el procedimiento para parar el tiempo
                Qry = "CALL PA_CalcularTiempoMinutos(?,?,?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, orden);
                ps.setInt(2, detalle);
                ps.setInt(3, lector);
                ps.setInt(4, negocio);
                rs = ps.executeQuery();
                rs.next();
                T_Total = convertirHorasAMinutos(Integer.parseInt(rs.getString(1)), rs.getString(2).split(":"));
                Qry = "CALL PA_PausarTomaDeTiempoDeProcesos(?,?,?,?,?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, orden);
                ps.setInt(2, detalle);
                ps.setInt(3, lector);
                ps.setInt(4, negocio);
                ps.setString(5, String.valueOf(T_Total));
                ps.setInt(6, cantidadTerminada);
                res = !ps.execute();

            } else {
                //Si no existe se ejecutara el procedimiento para iniciar o renaudar el tiempo
                Qry = "CALL PA_IniciarRenaudarTomaDeTiempoProcesos(?,?,?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, orden);
                ps.setInt(2, detalle);
                ps.setInt(3, lector);
                ps.setInt(4, negocio);
                res = !ps.execute();
            }

            con.close();
            conexion.destruir();
            conexion.cerrar(rs);
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
        return res;
    }

    private int convertirHorasAMinutos(int total, String hora[]) {
        total += ((Integer.parseInt(hora[0]) * 60) + Integer.parseInt(hora[1]));
        return total;
    }

    public CachedRowSet consultarProyectosEnEjecucion(int negocio) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_ProyectosEnEjecucion(?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, negocio);
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

//    protected boolean cambiar_Estado_Proceso() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public boolean detener_Toma_Tiempo() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();//Este metodo obliga a la intancia se elimine sola y libere el espacio en el puntero.
    }
    
    
}
