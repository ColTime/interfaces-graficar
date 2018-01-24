package Modelo;

import Controlador.ConexionPS;
import com.sun.rowset.CachedRowSetImpl;
import java.io.PrintStream;
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
    //No se te olvide tener en cuenta el id del lector y concatenar a la informacion despues de leer el código QR***
    public boolean iniciar_Pausar_Reiniciar_Toma_Tiempo(int orden, int detalle, int negocio, int lector, int cantidadTerminada, int operarios, PrintStream myPS) {
        //Falta hacer que se puedan poner varias tomas de tiempo del mismo proceso al mismo tiempo.
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
            if (rs.getBoolean(1)) {//Pausar O IniciarToma de tiempos
                //-------------------------------------------------------------->
                Qry = "CALL PA_ValidarCantidadDetalleProyecto(?,?,?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, orden);
                ps.setInt(2, detalle);
                ps.setInt(3, lector);
                ps.setInt(4, negocio);
                rs = ps.executeQuery();
                rs.next();
                //Tener en cuenta que tienes que mostrar un mensaje en el celular
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
                int restante = rs.getInt(1) - (cantidadTerminada + cantidadAntigua);
                operarios = rs.getInt(3);
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
                    T_Total = convertirHorasAMinutos(rs.getString(1).split(":"), rs.getString(2).split(":"), operarios);
                    Qry = "CALL PA_PausarTomaDeTiempoDeProcesos(?,?,?,?,?,?,?,?)";
                    ps = con.prepareStatement(Qry);
                    ps.setInt(1, orden);
                    ps.setInt(2, detalle);
                    ps.setInt(3, lector);
                    ps.setInt(4, negocio);
                    ps.setString(5, String.valueOf(T_Total));
                    ps.setInt(6, cantidadTerminada + cantidadAntigua);
                    ps.setInt(7, estado);
                    ps.setInt(8, restante);//Cantidad de productos restantes!!
                    res = !ps.execute();//Respuesta es igual a True para poder agregar los botones
                    //Promedio de producto por minuto.
                    cantidadProductoMinuto(detalle, negocio, lector);
                    //Tiempo total del proceso.
                    actualizarTotalTiempoProyecto(detalle, negocio);
                    //Timepo total por unidad...
                    totalTiempoPorUnidad(detalle, negocio);
                    //Si no cumple la condición va a retornar un falso y monstrara una mensaje de advertencia.
                } else {
                    res = false;
                    //Se enviara desde acá el mensaje al lector diciendo que la cantidad para el proyecto no es la adecuada(Al celular)...................................
//                    enviarMensajeCelular("Mensaje", cps);//Mensaje para el celular

                }
            } else {
                //Si no existe se ejecutara el procedimiento para iniciar o renaudar el tiempo
                Qry = "CALL PA_IniciarRenaudarTomaDeTiempoProcesos(?,?,?,?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, orden);
                ps.setInt(2, detalle);
                ps.setInt(3, lector);
                ps.setInt(4, negocio);
                ps.setInt(5, operarios);
                res = !ps.execute();//Respuesta es igual a True para poder agregar los botones
            }
            con.close();
            conexion.destruir();
            conexion.cerrar(rs);
            ps.close();
            System.gc();//Garbage collector...
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
        return res;
    }

    public boolean pararTiempoAlmacen(int orden, int detalle, int cantidad, int detalleproducto, int proceso) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
            //Falta calcular el estado
            String Qry = "";
            if (proceso == 22) {
                Qry = "CALL PA_ValidarCantidadDetalleProyecto(?,?,?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, orden);
                ps.setInt(2, detalleproducto);
                ps.setInt(3, proceso);
                ps.setInt(4, 4);//Negocio de almacen
                rs = ps.executeQuery();
                rs.next();
                //Si la cantidad terminada ingresada es menos a la cantidad que en total se deben realizar.
                if (rs.getInt(2) + cantidad < rs.getInt(1)) {
                    //Si la afirmación es correcta se ejecutara el procedimiento para parar el tiempo.
                    cantidadAntigua = rs.getInt(2);
                    estado = 4;
                    //Si la cantidad terminada ingresada es igual a la cantidad que en total se deben realizar.
                } else if (rs.getInt(2) + cantidad == rs.getInt(1)) {
                    cantidadAntigua = rs.getInt(2);
                    estado = 3;
                    //Si la cantidad terminada ingresada es mayor a la cantidad que en total se deben realizar.
                } else {
                    cantidadAntigua = rs.getInt(2);
                    estado = 0;
                }
            } else {
                //estado terminado de los componentes del almacen.
                estado = 3;
            }

            if (estado != 0) {
                Qry = "CALL PA_PararTomaDeTiempoAlmacen(?,?,?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, detalleproducto);
                ps.setInt(2, proceso);
                ps.setInt(3, cantidad + cantidadAntigua);
                ps.setInt(4, estado);
                res = !ps.execute();

            } else {
                //Mensaje que la cantidad no es la optima para realizar el procedimiento(Al computador).............................

            }
            //Pendiente.........................................................
            //Cerrar conexiones
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
        return res;//Falta asignarle este tru a una variable
    }

    public void totalTiempoPorUnidad(int detalle, int negocio) {
        try {
            String Qry = "CALL PA_ValidarEstadoProyecto(?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, detalle);
            ps.setInt(2, negocio);
            rs = ps.executeQuery();
            String tiempoTotalProducto = totalTiempoProyectoyProducto(rs);
            if (!tiempoTotalProducto.equals("00:00")) {
                Qry = "CALL PA_ActualizarTiempoTotalPorUnidad(?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, detalle);
                ps.setString(2, String.valueOf(tiempoTotalProducto));
                ps.executeQuery();
            } else {
                //Actualizar el tiempo total por unidad a null
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
    }

    private String totalTiempoProyectoyProducto(ResultSet crsT) {
        int minutos = 0;
        int segundos = 0;
        String tiempo[] = null;
        String cadena = "00:00";
        try {
            while (crsT.next()) {
                tiempo = crsT.getString(1).split(":");
                segundos += Integer.parseInt(tiempo[1]);
                minutos += Integer.parseInt(tiempo[0]);
            }
            //Convrtir minutos a segundos
            while (segundos >= 60) {
                minutos++;
                segundos = segundos - 60;
            }
            //Cadena de String
            cadena = (((minutos <= 9) ? "0" : "") + minutos + ":" + ((segundos <= 9) ? "0" : "") + segundos);
        } catch (Exception e) {
            //Mensaje de error---
        }
        return cadena;
    }

    public void actualizarTotalTiempoProyecto(int detalle, int negocio) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
//          Query------------------------------------------------------------>
            String Qry = "CALL PA_TiempoProceso(?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, detalle);
            ps.setInt(2, negocio);
            rs = ps.executeQuery();
            String cadena = totalTiempoProyectoyProducto(rs);

            //Código...
            Qry = "CALL PA_ActualizarTiempoTotalProducto(?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, detalle);
            ps.setString(2, cadena);
            ps.execute();
            //...

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
    }

    private void cantidadProductoMinuto(int detalle, int negocio, int lector) {
        try {
            conexion = new Conexion();
            conexion.establecerConexion();
            con = conexion.getConexion();
//            Query------------------------------------------------------------>
            String Qry = "CALL PA_PromedioProductoPorMinuto(?,?,?)";
            ps = con.prepareStatement(Qry);
            ps.setInt(1, detalle);
            ps.setInt(2, negocio);
            ps.setInt(3, lector);
            rs = ps.executeQuery();

            if (rs.next()) {
                String timeP = porMinuto(rs.getString(1), Integer.parseInt(rs.getString(2)));
                //Código...
                Qry = "CALL PA_ActualizarProductoPorMinuto(?,?,?,?)";
                ps = con.prepareStatement(Qry);
                ps.setInt(1, detalle);
                ps.setInt(2, negocio);
                ps.setInt(3, lector);
                ps.setString(4, timeP);
                ps.execute();
                //...
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
    }

    public String porMinuto(String timepo, int cantidad) {
        String ms[] = timepo.split(":");
        //Se convierte todo en segundos
        int segundos = (Integer.parseInt(ms[0]) * 60) + Integer.parseInt(ms[1]);
        //Se realiza el promedio
        int promedioEntero = (int) Math.ceil(segundos / cantidad);
        //Se convertira a minutos y segundos otra vez...
        String resultado = "";
        int minutos = 0;
        while (promedioEntero >= 60) {

            minutos++;
            promedioEntero = promedioEntero - 60;

        }
        resultado = ((minutos <= 9) ? "0" : "") + minutos + ":" + ((promedioEntero <= 9) ? "0" : "") + promedioEntero;

        return resultado;
    }

    private String convertirHorasAMinutos(String total[], String hora[], int operarios) {
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
            //Vamos a convertir las horas en minutos siempre y cuando las horas sean mayores a 0 le sumaremos los minutos antiguos.
            m += (h * 60);
        }
        //Tiempo * Numero de operarios----------------------------------------->
        m = m * operarios;//Se multiplican los minutos trabajados por la cantidad de operarios que trabajaron en ese proceso de un proyecto asignado.
        s = s * operarios;//Igualmente se hace con los segundos.
        //--------------------------------------------------------------------->
        //Sumamos los segundos nuevos con los segundos antiguos
        s += sa;
        m += ma;
        while (s >= 60) {
            s = (s - 60);
            m += 1;
        }
        tiempoMS = ((m <= 9) ? "0" : "") + m + ":" + ((s <= 9) ? "0" : "") + s;

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
