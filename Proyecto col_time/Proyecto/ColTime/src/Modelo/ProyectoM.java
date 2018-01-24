package Modelo;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    public boolean estadoDeOrdenM(int orden, int op) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "";
            if (op == 1) {
                Qry = "CALL PA_DetallesEnEjecucion(?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, orden);
                ps.setInt(2, 2);
                rs = ps.executeQuery();
                while (rs.next()) {
                    //Activas detalles del almacen...  
                    Qry = "CALL PA_IniciarTomaTiempoDetalleAlmacen(?)";
                    ps = con.prepareStatement(Qry);
                    ps.setInt(1, rs.getInt(1));
                    ps.execute();
                }
            }
            Qry = "CALL PA_EjecucionoParada(?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, orden);
            ps.setInt(2, op);
            res = !ps.execute();
            con.close();
            conexion.destruir();
            conexion.cerrar(rs);
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
        return res;
    }

    public boolean estadoProyecto(int orden) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            //PA_DetallesEnEjecucion
            String Qry = "CALL PA_DetallesEnEjecucion(?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, orden);
            ps.setInt(2, 4);
            rs = ps.executeQuery();
            res = true;
            int cont = 0;
            int v[] = new int[4];
            while (rs.next()) {
                if (rs.getInt(2) == 4) {
                    res = true;
                    v[cont] = rs.getInt(1);
                    cont++;
                } else {
                    res = false;
                    break;
                }
            }
            if (res) {
                //Se cambia el estado de los detalles de almacen a paunsados.
                for (int i = 0; i < v.length; i++) {
                    if (v[i] != 0) {
                        Qry = "CALL PA_PararTomaDeTiempoAlmacen(?,?,?,?)";
                        ps = con.prepareStatement(Qry);
                        ps.setInt(1, v[i]);//Detalle
                        ps.setInt(2, 0);//Proceso
                        ps.setInt(3, 0);//Cantidad
                        ps.setInt(4, 2);//Estado pausado
                        ps.execute();
                    } else {
                        break;
                    }
                }
            }
            Qry = "SELECT FU_EstadoDeProyecto(?)";
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
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
        return res;
    }

    public CachedRowSet diagramaM(String inicio, String fin) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_Diagramas(?,?)";
            ps = con.prepareStatement(Qry);
            ps.setString(1, inicio);
            ps.setString(2, fin);
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

    public CachedRowSet InformacionAreasProduccionM(int accion) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "";
            switch (accion) {
                case 1:
                    Qry = "CALL PA_CantidadProyectosIngresadosArea()";
                    break;
                case 2:
                    Qry = "CALL PA_CantidadProyectosterminadosHoy()";
                    break;
                case 3:
                    Qry = "CALL PA_CantidadProyectosEjecucion()";
                    break;
                case 4:
                    Qry = "CALL PA_CantidadProyectosPorIniciar()";
                    break;
            }
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
            int op, boolean antisolderP, boolean ruteoP, String fechaCircuito1, String fechaCircuito2, String fechaPCB1, String fechaPCB2, String novedades) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = " SELECT FU_RegistrarModificarProyecto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            ps.setInt(19, op);//1) Registrar, 2)Modificar
            ps.setBoolean(20, ruteoP);
            ps.setBoolean(21, antisolderP);
            //Fechas de entrega a áreas
            ps.setString(22, fechaCircuito1);
            ps.setString(23, fechaCircuito2);
            ps.setString(24, fechaPCB1);
            ps.setString(25, fechaPCB2);
            ps.setString(26, novedades);
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

    public boolean registrarDetalleProyectoQRM(int orden, String area, String producto, String Cantidad, String Material, String ruteo, String antisolder) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_RegistrarDetalleProyectoQR(?,?,?,?,?,?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, orden);
            ps.setInt(2, nArea(area));
            ps.setInt(3, nProducto(producto));
            ps.setString(4, Cantidad);
            ps.setString(5, Material);
            ps.setInt(6, (ruteo.equals("SI") ? 1 : 0));
            ps.setInt(7, (antisolder.equals("SI") ? 1 : 0));
            rs = ps.executeQuery();
            rs.next();
            res = rs.getBoolean(1);
            if (res) {
                //Procesos
                if (area.equals("FE")) {
                    //Formato estandar
                    Qry = "CALL PA_RegistrarDetalleFormatoEstandar(?,?,?)";
                    ps = con.prepareStatement(Qry);
                    ps.setInt(1, orden);
                    ps.setInt(2, nProducto(producto));
                    ps.setString(3, "");
                    ps.execute();
                } else if (area.equals("TE")) {
                    //Teclados
                    for (int i = 11; i <= 14; i++) {
                        Qry = "CALL PA_RegistrarDetalleTeclados(?,?,?,?)";
                        ps = con.prepareStatement(Qry);
                        ps.setInt(1, i);
                        ps.setInt(2, orden);
                        ps.setInt(3, nProducto(producto));
                        ps.setString(4, "");
                        ps.execute();
                    }
                } else if (area.equals("IN")) {
                    //Ensamble
                    for (int i = 15; i <= 21; i++) {
                        Qry = "CALL PA_RegistrarDetalleEnsamble(?,?,?,?)";
                        ps = con.prepareStatement(Qry);
                        ps.setInt(1, i);
                        ps.setInt(2, orden);
                        ps.setInt(3, nProducto(producto));
                        ps.setString(4, "");
                        ps.execute();
                    }
                }
            }
            conexion.cerrar(rs);
            ps.close();
            con.close();
            conexion.destruir();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return res;
    }

    public boolean registrarProyectoQRM(String infoP[], String comercial) {
        //Cuerpo del la función...
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = Qry = "SELECT FU_RegistrarModificarProyecto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(Qry);
            ps.setString(1, comercial);
            ps.setString(2, infoP[3]);//Nombre del cliente
            ps.setString(3, infoP[4]);//Nombre del proyecto
            ps.setString(4, infoP[6]);//Tipo de ejecución
            ps.setBoolean(5, false);
            ps.setBoolean(6, false);
            ps.setBoolean(7, false);
            ps.setBoolean(8, false);
            ps.setBoolean(9, false);
            ps.setBoolean(10, false);
            ps.setBoolean(11, false);
            ps.setBoolean(12, false);
            ps.setBoolean(13, false);
            ps.setBoolean(14, false);
            ps.setString(15, infoP[10]);//Fecha de entrega
            ps.setBoolean(16, false);
            ps.setBoolean(17, false);
            ps.setInt(18, Integer.parseInt(infoP[0]));//Numero de orden
            ps.setInt(19, 1);//1) Registrar, 2)Modificar
            ps.setBoolean(20, false);
            ps.setBoolean(21, false);
            rs = ps.executeQuery();
            rs.next();
            res = rs.getBoolean(1);
            conexion.cerrar(rs);
            ps.close();
            con.close();
            conexion.destruir();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return res;
    }

    public boolean ValidarProyectoQRM(int orden) {
        //Cuerpo del la función...
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_ValidarProyectoQR(?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, orden);
            rs = ps.executeQuery();
            rs.next();
            res = rs.getBoolean(1);
            conexion.cerrar(rs);
            ps.close();
            con.close();
            conexion.destruir();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return res;
    }

    public boolean validarDetalleProyectoQRM(int orden, String area, String producto) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_ValidarDetalleProyectoQR(?,?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, orden);
            ps.setInt(2, nArea(area));
            ps.setInt(3, nProducto(producto));
            rs = ps.executeQuery();
            rs.next();
            res = rs.getBoolean(1);
            conexion.cerrar(rs);
            ps.close();
            con.close();
            conexion.destruir();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return res;
    }

    private int nArea(String area) {
        int n = 0;
        switch (area.toUpperCase()) {
            case "FE":
                n = 1;
                break;
            case "TE":
                n = 2;
                break;
            case "IN":
                n = 3;
                break;
        }
        return n;
    }

    private int nProducto(String producto) {
        int n = 0;
        switch (producto.toUpperCase()) {
            case "CIRCUITO":
                n = 1;
                break;
            case "CONVERSOR":
                n = 2;
                break;
            case "REPUJADO":
                n = 3;
                break;
            case "TROQUEL":
                n = 4;
                break;
            case "TECLADO":
                n = 5;
                break;
            case "STENCIL":
                n = 6;
                break;
            case "PCB":
                n = 7;
                break;
        }
        return n;
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
                //Query para buscar por fecha de Entrega''                
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

    public CachedRowSet consultar_ProyectoEliminados() {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = Qry = "CALL PA_ConsultarProyectosEliminados()";
            ps = con.prepareStatement(Qry);
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
    public boolean EliminarProyecto(int orden) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            //PA_DetallesAEliminar
            String Qry = "CALL PA_EliminarCambiarEstadoProyecto(?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, orden);
            res = !ps.execute();

            //Cierre de conexion y finalizacion de variables.
            con.close();
            conexion.destruir();
            conexion.cerrar(rs);
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
        return res;
    }

    public boolean ReacttivarProyecto(int orden) {//Se cambiara el estado del proyecto
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            //PA_DetallesAEliminar
            String Qry = "CALL PA_ReactivarProyecto(?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, orden);
            res = !ps.execute();

            //Cierre de conexion y finalizacion de variables.
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

    public boolean validarEliminacion(int orden) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "SELECT FU_ValidarEstadoEliminado(?)";
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

    public CachedRowSet consutalarProcesosAreaM(int op) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_DiagramaFETEEN(?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, op);
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

    public boolean validarEjecucionOParada(int orden) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "SELECT FU_ValidarEstadoProyectoEjecucionOParada(?)";
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
