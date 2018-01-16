package Modelo;

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
                Qry = "CALL PA_ValidarUbicacionPNC(?,?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, Integer.parseInt(numerOrden));
                ps.setString(2, ubicacion);
                ps.setInt(3, id);
                rs = ps.executeQuery();
                rs.next();
                if (rs.getInt(1) != 0) {
                    //Se modifica siempre y cuando el proyecto tenga un PNC ya registrado en la misma ubicacion
                    modificarPNC(numerOrden, rs.getInt(1), cantidad, material, negocio, tipoNegocio, ubicacion);
                } else {
                    //Si no se registra el producto no conforme desde 0 
                    Qry = "SELECT FU_RegistrarDetalleProyecto(?,?,?,?,?,?,?,?)";
                    ps = con.prepareStatement(Qry);
                    ps.setInt(1, Integer.parseInt(numerOrden));
                    if (material.equals("GF")) {
                        //No se permitiran registrar productos no conformes de GF ni de componentes
                        if (negocio.equals("FE") && tipoNegocio.equals("PCB")) {//Gran formato de la PCB del teclado
                            ps.setString(2, "PCB GF");
                        } else if (negocio.equals("FE") && tipoNegocio.equals("Circuito")) {
                            ps.setString(2, "Circuito GF");
                        }
                        ps.setString(3, cantidad);
                        ps.setString(4, "ALMACEN");
                        ps.setInt(5, estado);
                        ps.setString(6, material);
                        ps.setInt(7, pnc);
                        ps.setString(8, ubicacion);
                    } else {
                        ps.setString(2, tipoNegocio);
                        ps.setString(3, cantidad);
                        ps.setString(4, negocio);
                        ps.setInt(5, estado);
                        ps.setString(6, material);
                        ps.setInt(7, pnc);
                        ps.setString(8, ubicacion);
                    }
                    //Ejecucion de la sentencia 
                    rs = ps.executeQuery();
                    rs.next();
                    res = rs.getBoolean(1);
                    //Ebadir esta función siemmpre y cuando el negocio sea Almacen.
                    //Tipo de negocio
                    int tipo = 0;
                    if (!negocio.equals("ALMACEN")) {
                        tipo = numeroDelTipo(tipoNegocio);
                    }

                    if (negocio.equals("IN")) {//tener en cuenta que los procesos se ban a traer de la tabla procesos dependiendo del tipo de negocio!!
                        //Se registran los procesos de IN para este subproyecto.
                        Qry = "CALL PA_RegistrarDetalleEnsamble(?,?,?)";
                        ps = con.prepareStatement(Qry);
                        ps.setInt(1, Integer.parseInt(numerOrden));
                        ps.setInt(2, tipo);
                        if (ubicacion == null) {
                            ps.setString(3, "");
                        } else {
                            ps.setString(3, ubicacion);
                        }
                        ps.execute();
                    } else if (negocio.equals("TE")) {//tener en cuenta que los procesos se ban a traer de la tabla procesos dependiendo del tipo de negocio!!
                        //Se registran los procesos de TE para este subproyecto. 
                        Qry = "CALL PA_RegistrarDetalleTeclados(?,?,?)";
                        ps = con.prepareStatement(Qry);
                        ps.setInt(1, Integer.parseInt(numerOrden));
                        ps.setInt(2, tipo);
                        if (ubicacion == null) {
                            ps.setString(3, "");
                        } else {
                            ps.setString(3, ubicacion);
                        }
                        ps.execute();
                    } else if (negocio.equals("FE")) {//tener en cuenta que los procesos se ban a traer de la tabla procesos dependiendo del tipo de negocio!!
                        //Se registran los procesos de FE para este subproyecto.
                        //Se valida que sea GF.
                        if (material.equals("GF")) {//Negocio del almacen
                            //Se registran los procesos de GF en el almacen y se inicia la toma de tiempos. 
                            Qry = "CALL PA_RegistrarDetalleAlmacen(?,?,?)";
                            ps = con.prepareStatement(Qry);
                            ps.setInt(1, Integer.parseInt(numerOrden));
                            if (negocio.equals("FE") && tipoNegocio.equals("PCB")) {//Gran formato de la PCB del teclado
                                ps.setInt(2, 9);
                            } else if (negocio.equals("FE") && tipoNegocio.equals("Circuito")) {
                                ps.setInt(2, 8);
                            }
                            ps.setInt(3, 22);//Proceso de GF
                            ps.execute();
                        } else {//tener en cuenta que los procesos se ban a traer de la tabla procesos dependiendo del tipo de negocio!!
                            //Si es TH o FV
                            Qry = "CALL PA_RegistrarDetalleFormatoEstandar(?,?,?)";
                            ps = con.prepareStatement(Qry);
                            ps.setInt(1, Integer.parseInt(numerOrden));
                            ps.setInt(2, tipo);
                            if (ubicacion == null) {
                                ps.setString(3, "");
                            } else {
                                ps.setString(3, ubicacion);
                            }
                            ps.execute();
                        }
                    } else {//Negocio del almacen Para registrar los compoennetes
                        //tener en cuenta que los procesos se ban a traer de la tabla procesos dependiendo del tipo de negocio!!
                        Qry = "CALL PA_RegistrarDetalleAlmacen(?,?,?)";
                        ps = con.prepareStatement(Qry);
                        ps.setInt(1, Integer.parseInt(numerOrden));
                        if (tipoNegocio.equals("Circuito COM")) {//Componentes de circuito.
                            ps.setInt(2, 10);
                        } else if (tipoNegocio.equals("PCB COM")) {//Componentes de PCB.
                            ps.setInt(2, 11);
                        }
                        ps.setInt(3, 23);//Proceso de componentes.
                        ps.execute();
                    }
                }
            } else if (op == 2) {
                modificarPNC(numerOrden, id, cantidad, material, negocio, tipoNegocio, ubicacion);
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
            case "Circuito GF":
                tipo = 8;
                break;
            case "PCB GF":
                tipo = 9;
                break;
            case "Circuito COM":
                tipo = 10;
                break;
            case "PCB COM":
                tipo = 11;
                break;
        }
        return tipo;
    }

    public boolean validarEliminacionModificarM(int orden, int negocio, int tipo, int detalle, int accion) {//El busqueda no es necesario
        //PA_EliminarProductosNoConformes(?,?,?)
        try {
            String Qry = "";
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            ResultSet rs1 = null;
            if (accion == 2) {
                //Validar la eliminación de solo un detalle PNC
                Qry = "SELECT FU_validarEliminacion(?,?,?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, detalle);
                ps.setInt(2, orden);
                ps.setInt(3, tipo);
                ps.setInt(4, negocio);

                rs = ps.executeQuery();
                rs.next();
                res = rs.getBoolean(1);
            } else {
                //Validar la eliminación de muchos detalles de proyecto
                Qry = "CALL PA_EliminarProductosNoConformes(?,?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, orden);
                ps.setInt(2, tipo);
                ps.setInt(3, negocio);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Qry = "SELECT FU_validarEliminacion(?,?,?,?)";
                    ps = con.prepareStatement(Qry);
                    ps.setInt(1, rs.getInt(1));
                    ps.setInt(2, orden);
                    ps.setInt(3, tipo);
                    ps.setInt(4, negocio);

                    rs1 = ps.executeQuery();
                    rs1.next();
                    res = rs1.getBoolean(1);
                    if (!res) {
                        break;
                    }
                }
            }
            //Cierre de conexión
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

    private void modificarPNC(String numerOrden, int id, String cantidad, String material, String negocio, String tipoNegocio, String ubicacion) {
        //PreparedSteamate y detalle----------------------------------->
        try {
            String Qry = "SELECT FU_ModificarDetalleProyecto(?,?,?,?,?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, Integer.parseInt(numerOrden));
            ps.setInt(2, id);
            ps.setString(3, cantidad);
            ps.setString(4, material);
            if (material.equals("GF")) {
                ps.setInt(5, 4);
            } else {
                if (negocio.equals("FE")) {
                    ps.setInt(5, 1);
                } else if (negocio.equals("TE")) {
                    ps.setInt(5, 2);
                } else if (negocio.equals("IN")) {
                    ps.setInt(5, 3);
                }
            }
            ps.setString(6, ubicacion);
            rs = ps.executeQuery();
            rs.next();
            res = rs.getBoolean(1);
            if (!material.equals("GF")) {
                if (negocio.equals("FE") && (tipoNegocio.equals("Circuito") || tipoNegocio.equals("PCB"))) {
                    //Modificar procesos de formato estandar
                    Qry = "CALL PA_ModificarDetalleFormatoEstandar(?,?,?)";
                    ps = con.prepareStatement(Qry);
                    ps.setInt(1, Integer.parseInt(numerOrden));
                    ps.setInt(2, id);
                    ps.setString(3, material.trim());
                    rs = ps.executeQuery();
                }
            }
            conexion.cerrar(rs);
            conexion.destruir();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
    }

    public CachedRowSet generar_ReportesM() {//Falta generar los reportes
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_ReporteGeneral()";
            ps = con.prepareStatement(Qry);
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

    public CachedRowSet consultar_Detalle_Proyecto(String numeOrden, int estado) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_ConsultarDetalleProyecto(?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, Integer.parseInt(numeOrden));
            ps.setInt(2, estado);
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
                case 4:
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
            if (vistaC == 1 || vistaC == 3 || vistaC == 4) {
                ps.setInt(3, 0);//Negativo para productos no conforme
            } else {
                ps.setInt(3, 1);//Positivo para un producto no conforme
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

    public boolean eliminarDetallersProyecto(int idDetalle, int numeOrden, String negocio, String tipo, int accion) {
        //Eliminar detalle del proyecto, detalle de formato estandar, detalle de teclado y detalle de ensamble
        String Qry = null;
        int n = 0;
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            ResultSet rs1 = null;

            //numero de tipo de negocio
            if (negocio.equals("FE")) {
                n = 1;
            } else if (negocio.equals("TE")) {
                n = 2;
            } else if (negocio.equals("IN")) {
                n = 3;
            } else if (negocio.equals("ALMACEN")) {
                n = 4;
            }
            if (accion == 2) {
                //Eliminar un solo detalle de PNC
                eliminarDetalleProyecto(negocio, numeOrden, rs, idDetalle);
            } else {
                //Eliminar muchos detalles y PNC
                Qry = "CALL PA_EliminarProductosNoConformes(?,?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, numeOrden);
                //Numero del tipo de producto
                int numeroTipo = numeroDelTipo(tipo);

                ps.setInt(2, numeroTipo);

                ps.setInt(3, n);
                //Ejecucion del procedimiento almacenado
                rs = ps.executeQuery();
                while (rs.next()) {
                    eliminarDetalleProyecto(negocio, numeOrden, rs1, rs.getInt(1));
                }
            }
            //Validar detalles para validar estado del proyecto
            Qry = "CALL PA_DetallesparaValidarEstado(?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, numeOrden);
            //ps.setInt(2, n);
            rs = ps.executeQuery();
            //Detalles  a validar
            while (rs.next()) {
                Qry = "CALL PA_CambiarEstadoDeProductos(?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, rs.getInt(2));
                ps.setInt(2, rs.getInt(1));
                ps.execute();
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

    private boolean eliminarDetalleProyecto(String negocio, int numeOrden, ResultSet rs1, int detalle) {
        //Query------------------------------------------------------------>
        int n = 0;
        try {
            String Qry = "";
            switch (negocio) {
                case "FE":
                    //Quiery para eliminar el detalle de formato estandar
                    Qry = "SELECT FU_EliminarDetalleProyectoFormatoestandar(?,?)";
                    n = 1;
                    break;
                case "TE":
                    Qry = "SELECT FU_EliminarDetalleProyectoTeclados(?,?)";
                    n = 2;
                    break;
                case "IN":
                    Qry = "SELECT FU_EliminarDetalleProyectoEnsamble(?,?)";
                    n = 3;
                    break;
                case "ALMACEN":
                    Qry = "SELECT FU_EliminarDetalleProyectoAlmacen(?,?)";
                    n = 4;
                    break;
            }
            ps = con.prepareStatement(Qry);
            ps.setInt(1, detalle);
            ps.setInt(2, numeOrden);
            //Ejecucion
            rs1 = ps.executeQuery();
            rs1.next();
            res = rs1.getBoolean(1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
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

    public boolean ReiniciarDetalle(int detalle, int negocio, int detalleproducto) {
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
            FE_TE_INM produccion = new FE_TE_INM();
            //Se actualiza la suma total de tiempos totales de procesos
            produccion.actualizarTotalTiempoProyecto(detalleproducto, negocio);
            //Se actualiza el total de producto por minuto siempre y cuando el estado del producto sea terminado
            produccion.totalTiempoPorUnidad(detalleproducto, negocio);
            conexion.cerrar(rs);
            conexion.destruir();
            ps.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!" + e);
        }
        return res;
    }

    public CachedRowSet ConsultarInformacionFiltrariaDelDetalleM(int detalle) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Query------------------------------------------------------------>
            String Qry = "CALL PA_InformacionFiltrariaDetalleProyecto(?)";
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

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

}
