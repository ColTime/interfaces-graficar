package informecoltime;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

public class Logica {

    //Variables
    CachedRowSet crs = null;
    ResultSet rs = null;
    Connection con = null;
    PreparedStatement ps = null;
    String Qry = "";

    //Metodo de consulta
    public CachedRowSet ConsultarInformacion(int op, int orden) {
        //Cuerpo...
        try {
            Conexion conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            if (op == 1) {
                Qry = "CALL PA_InformeDeProduccionFE(?)";
            } else if (op == 2) {
                Qry = "CALL PA_InformeDeProduccionTE(?)";
            } else {
                Qry = "CALL PA_InformeDeProduccionEN(?)";
            }
            ps = con.prepareStatement(Qry);
            ps.setInt(1, orden);
            rs = ps.executeQuery();
            crs = new CachedRowSetImpl();
            crs.populate(rs);

            conexion.cerrar(rs);
            ps.close();
            conexion.destruir();
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
        return crs;
    }
}
