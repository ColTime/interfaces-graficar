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
    public int ValidarCnatidadPNCM(String numerOrden, int detalle, int op, String tipo, String negocio) {
        int cantidad = 0;
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_ValidarCantidadPNCOrigen(?,?,?,?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, Integer.parseInt(numerOrden));
            ps.setInt(2, detalle);
            ps.setInt(3, op);
            //Tipo de negocio
            int tipoN = numeroDelTipo(tipo);

            ps.setInt(4, tipoN);
            //Negocio
            if (negocio.equals("FE")) {
                ps.setInt(5, 1);
            } else if (negocio.equals("TE")) {
                ps.setInt(5, 2);
            } else {
                ps.setInt(5, 3);
            }

            rs = ps.executeQuery();
            rs.next();
            cantidad = rs.getInt(1);
            //Cierre de conexiones
            conexion.cerrar(rs);
            conexion.destruir();
            ps.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return cantidad;
    }

    //Este metodo también funcionara para registrar y modificar los productos no conformes PNC.
    public boolean registrar_Detalle_Proycto(String cantidad, String negocio, String tipoNegocio, int estado, String numerOrden, String material, int op, int id, int pnc, String ubicacion) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "";
            if (op == 1) {
                //Se valida si el proyecto ya tenia antecedentes registrados en esa misma ubicacion
                Qry = "CALL PA_ValidarUbicacionPNC(?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, Integer.parseInt(numerOrden));
                ps.setString(2, ubicacion);
                rs = ps.executeQuery();
                rs.next();
                if (rs.getInt(1) != 0) {
                    //Se modifica siempre y cuando el proyecto tenga un PNC ya registrado en la misma ubicacion
                    modificarPNC(numerOrden, rs.getInt(1), cantidad, material, negocio, tipoNegocio);
                } else {
                    //Si no se registra el producto no conforme desde 0 
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
                    //Tipo de negocio
                    int tipo = numeroDelTipo(tipoNegocio);

                    if (negocio.equals("IN")) {
                        //Se registran los procesos de IN para este subproyecto
                        for (int i = 15; i <= 21; i++) {
                            Qry = "CALL PA_RegistrarDetalleEnsamble(?,?,?)";
                            ps = con.prepareStatement(Qry);
                            ps.setInt(1, i);
                            ps.setInt(2, Integer.parseInt(numerOrden));
                            ps.setInt(3, tipo);
                            ps.execute();
                        }
                    } else if (negocio.equals("TE")) {
                        //Se registran los procesos de TE para este subproyecto 
                        for (int i = 11; i <= 14; i++) {
                            Qry = "CALL PA_RegistrarDetalleTeclados(?,?,?)";
                            ps = con.prepareStatement(Qry);
                            ps.setInt(1, i);
                            ps.setInt(2, Integer.parseInt(numerOrden));
                            ps.setInt(3, tipo);
                            ps.execute();
                        }
                    } else if (negocio.equals("FE")) {
                        //Se registran los procesos de FE para este subproyecto 
                        Qry = "CALL PA_RegistrarDetalleFormatoEstandar(?,?)";
                        ps = con.prepareStatement(Qry);
                        ps.setInt(1, Integer.parseInt(numerOrden));
                        ps.setInt(2, tipo);
                        ps.execute();
                    }
                }
            } else if (op == 2) {
                modificarPNC(numerOrden, id, cantidad, material, negocio, tipoNegocio);
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

    private int numeroDelTipo(String tipoNegocio) {
        int tipo = 0;
        switch (tipoNegocio) {
            case "Circuito":
                tipo = 1;
                break;
            case "Conversor":
                tipo = 2;
                break;
            case "PCB":
                tipo = 7;
                break;
            case "Repujado":
                tipo = 3;
                break;
            case "Stencil":
                tipo = 6;
                break;
            case "Teclado":
                tipo = 5;
                break;
            case "Troquel":
                tipo = 4;
                break;
        }
        return tipo;
    }

    public boolean validarEliminacionModificarM(int orden, int negocio, int tipo, int busqueda) {//El busqueda no es necesario
        //PA_EliminarProductosNoConformes(?,?,?)
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();

            String Qry = "CALL PA_EliminarProductosNoConformes(?,?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, orden);
            ps.setInt(2, tipo);
            ps.setInt(3, negocio);
            rs = ps.executeQuery();
            ResultSet rs1 = null;
            while (rs.next()) {
                Qry = "SELECT FU_validarEliminacion(?,?,?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, rs.getInt(1));
                ps.setInt(2, orden);
                ps.setInt(3, tipo);
                ps.setInt(4, busqueda);

                rs1 = ps.executeQuery();
                rs1.next();
                res = rs1.getBoolean(1);
                if (!res) {
                    break;
                }
            }
            conexion.cerrar(rs);
            conexion.cerrar(rs1);
            conexion.destruir();
            ps.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return res;
    }
//----------------------------------------------

    private void modificarPNC(String numerOrden, int id, String cantidad, String material, String negocio, String tipoNegocio) {
        //PreparedSteamate y detalle----------------------------------->
        try {
            String Qry = "SELECT FU_ModificarDetalleProyecto(?,?,?,?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, Integer.parseInt(numerOrden));
            ps.setInt(2, id);
            ps.setString(3, cantidad);
            ps.setString(4, material);
            if (negocio.equals("FE")) {
                ps.setInt(5, 1);
            } else if (negocio.equals("TE")) {
                ps.setInt(5, 2);
            } else if (negocio.equals("IN")) {
                ps.setInt(5, 3);
            }
            rs = ps.executeQuery();
            rs.next();
            res = rs.getBoolean(1);
            if (negocio.equals("FE") && (tipoNegocio.equals("Circuito") || tipoNegocio.equals("PCB"))) {
                //Modificar procesos de formato estandar
                Qry = "CALL PA_ModificarDetalleFormatoEstandar(?,?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, Integer.parseInt(numerOrden));
                ps.setInt(2, id);
                ps.setString(3, material.trim());
                rs = ps.executeQuery();
            }
            conexion.cerrar(rs);
            conexion.destruir();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
    }

//    public boolean regitrarPNC() {
//
//        return true;
//    }
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

    public CachedRowSet consultarDetalleProyectoProduccion(int orden, int negocio, int vistaC) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "";
            switch (vistaC) {
                case 1:
                case 2:
                    Qry = "CALL PA_DetalleProyectosProduccion(?,?,?)";
                    break;
                case 3:
                    Qry = "CALL PA_DetalleDeProduccionProyectosActivos(?,?,?)";
                    break;
            }
            //----------------------------------------------------------------->
            ps = con.prepareStatement(Qry);
            ps.setInt(1, orden);
            ps.setInt(2, negocio);
            if (vistaC == 1 || vistaC == 3) {
                ps.setInt(3, 0);
            } else {
                ps.setInt(3, 1);
            }
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

    public boolean eliminarDetallersProyecto(int idDetalle, int numeOrden, String negocio, String tipo) {
        //Eliminar detalle del proyecto, detalle de formato estandar, detalle de teclado y detalle de ensamble
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            ResultSet rs1 = null;
            String Qry = "CALL PA_EliminarProductosNoConformes(?,?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, numeOrden);
            //Numero del tipo de producto
            int numeroTipo = numeroDelTipo(tipo);

            ps.setInt(2, numeroTipo);
            //numero de tipo de negocio
            int n = 0;
            if (negocio.equals("FE")) {
                n = 1;
            } else if (negocio.equals("TE")) {
                n = 2;
            } else if (negocio.equals("IN")) {
                n = 3;
            }
            ps.setInt(3, n);
            //Ejecucion del procedimiento almacenado
            rs = ps.executeQuery();
            while (rs.next()) {
                //Query------------------------------------------------------------>
                switch (negocio) {
                    case "FE":
                        //Quiery para eliminar el detalle de formato estandar
                        Qry = "SELECT FU_EliminarDetalleProyectoFormatoestandar(?,?)";
                        break;
                    case "TE":
                        Qry = "SELECT FU_EliminarDetalleProyectoTeclados(?,?)";
                        break;
                    case "IN":
                        Qry = "SELECT FU_EliminarDetalleProyectoEnsamble(?,?)";
                        break;
                }
                ps = con.prepareStatement(Qry);
                ps.setInt(1, rs.getInt(1));
                ps.setInt(2, numeOrden);
                //Ejecucion
                rs1 = ps.executeQuery();
                rs1.next();
                res = rs1.getBoolean(1);
            }

            //Cierre de conexiones
            conexion.cerrar(rs);
            conexion.cerrar(rs1);
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

    public boolean ReiniciarDetalle(int detalle, int negocio) {
        //Cuerpo del procedimiento
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "SELECT FU_ReiniciarTiempo(?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, detalle);
            ps.setInt(2, negocio);
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

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

}
