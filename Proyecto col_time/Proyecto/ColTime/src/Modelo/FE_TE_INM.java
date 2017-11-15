package Modelo;

import com.sun.rowset.CachedRowSetImpl;
import elaprendiz.gui.label.LabelCustom;
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
    String T_Total = "";
    int cantidadAntigua = 0;
    int estado = 0;

    //Metodos------------------------------------------------->
    //No se te olvide tener en cuenta el id del lector y concatenar a la informacion despues de leer el codigo***
    public boolean iniciar_Pausar_Reiniciar_Toma_Tiempo(int orden, int detalle, int negocio, int lector, int cantidadTerminada) {
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
                //-------------------------------------------------------------->
                Qry = "CALL PA_ValidarCantidadDetalleProyecto(?,?,?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, orden);
                ps.setInt(2, detalle);
                ps.setInt(3, lector);
                ps.setInt(4, negocio);
                rs = ps.executeQuery();
                rs.next();
                //Si la cantidad terminada ingresada es menos a la cantidad que en total se deben realizar.
                if (rs.getInt(2) + cantidadTerminada < rs.getInt(1)) {
                    //Si la afirmación es correcta se ejecutara el procedimiento para parar el tiempo.
                    cantidadAntigua = rs.getInt(2);
                    estado = 2;
                    //Si la cantidad terminada ingresada es igual a la cantidad que en total se deben realizar.
                } else if (rs.getInt(2) + cantidadTerminada == rs.getInt(1)) {
                    cantidadAntigua = rs.getInt(2);
                    estado = 3;
                    //Si la cantidad terminada ingresada es mayor a la cantidad que en total se deben realizar.
                } else {
                    cantidadAntigua = rs.getInt(2);
                    estado = 0;
                }
                // si el estado es dos o tres (2 o 3) procedera a realizar la actualización.
                if (estado != 0) {
                    Qry = "CALL PA_CalcularTiempoMinutos(?,?,?,?)";
                    ps = con.prepareStatement(Qry);
                    ps.setInt(1, orden);
                    ps.setInt(2, detalle);
                    ps.setInt(3, lector);
                    ps.setInt(4, negocio);
                    rs = ps.executeQuery();
                    rs.next();
                    T_Total = convertirHorasAMinutos(rs.getString(1).split(":"), rs.getString(2).split(":"));
                    Qry = "CALL PA_PausarTomaDeTiempoDeProcesos(?,?,?,?,?,?,?)";
                    //CALL PA_CambiarEstadoDeProductos(busqueda,detalle);
                    ps = con.prepareStatement(Qry);
                    ps.setInt(1, orden);
                    ps.setInt(2, detalle);
                    ps.setInt(3, lector);
                    ps.setInt(4, negocio);
                    ps.setString(5, String.valueOf(T_Total));
                    ps.setInt(6, cantidadTerminada + cantidadAntigua);
                    ps.setInt(7, estado);
                    res = ps.execute();
                    //Si no cumple la condición va a retornar un falso y monstrara una mensaje de advertencia.
                } else {
                    res = false;
                }

            } else {
                //Si no existe se ejecutara el procedimiento para iniciar o renaudar el tiempo
                Qry = "CALL PA_IniciarRenaudarTomaDeTiempoProcesos(?,?,?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, orden);
                ps.setInt(2, detalle);
                ps.setInt(3, lector);
                ps.setInt(4, negocio);
                res = ps.execute();
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

    private String convertirHorasAMinutos(String total[], String hora[]) {
        int h = 0, m = 0, s = 0, ma = 0, sa = 0;
        String tiempoMS = "";
        //Horas, minutos y segundos
        h = Integer.parseInt(hora[0]);
        m = Integer.parseInt(hora[1]);
        s = Integer.parseInt(hora[2]);
        //Minutos y segundos antiguos
        ma = Integer.parseInt(total[0]);
        sa = Integer.parseInt(total[1]);
        if (h >= 1) {
            //Vamos a convertir las horas en minutos siempre y cuando sean mayores a 0 y sumarle los minutos antiguos
            m += (h * 60);
        }
        //Sumamos los segundos nuevos con los segundos antiguos
        s += sa;
        m += ma;
        while (s >= 60) {
            s = (s - 60);
            m += 1;
        }
        tiempoMS = ((m < 9) ? "0" : "") + m + ":" + ((s<9)?"0":"")+s;

        return tiempoMS;
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

    @Override
    protected void finalize() throws Throwable {
        super.finalize();//Este metodo obliga a la intancia se elimine sola y libere el espacio en el puntero.
    }

}
