package Controlador;

import Modelo.ProyectoM;
import com.sun.rowset.CachedRowSetImpl;
import javax.sql.rowset.CachedRowSet;

public class Proyecto {

    //Constructores------------------------------------------------->
    public Proyecto() {

    }
    //Variables----------------------------------------------------->
    private CachedRowSet crsP = null;
    //Atributos de la clase proyecto-------------------------------->
    private int idOrden;
    private String nombreCliente = "";
    private String nombreProyecto = "";
    private String tipoProyecto = "";
    private String negocio = "";
    private String fecha = "";
    private boolean FE = false;
    private boolean TE = false;
    private boolean IN = false;
    private boolean detalles[] = new boolean[9];//Converosr,Repujado
    private int estado;
    private String fechaCiccuitoFEoGF = "";
    private String fechaCiccuitoCOMFEoGF = "";
    private String fechaPCBFEoGF = "";
    private String fechaPCBCOMFEoGF = "";
    private String novedadProyecto = "";

    //Get and set------------------------------------------------>
    
    public void setNovedadProyecto(String novedadProyecto) {
        this.novedadProyecto = novedadProyecto;
    }

    public void setCrsP(CachedRowSet crsP) {
        this.crsP = crsP;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public void setTipoProyecto(String tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public void setNegocio(String negocio) {
        this.negocio = negocio;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setFE(boolean FE) {
        this.FE = FE;
    }

    public void setTE(boolean TE) {
        this.TE = TE;
    }

    public void setIN(boolean IN) {
        this.IN = IN;
    }

    public void setDetalles(boolean[] detalles) {
        this.detalles = detalles;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setFechaCiccuitoFEoGF(String fechaCiccuitoFEoGF) {
        this.fechaCiccuitoFEoGF = fechaCiccuitoFEoGF;
    }

    public void setFechaCiccuitoCOMFEoGF(String fechaCiccuitoCOMFEoGF) {
        this.fechaCiccuitoCOMFEoGF = fechaCiccuitoCOMFEoGF;
    }

    public void setFechaPCBFEoGF(String fechaPCBFEoGF) {
        this.fechaPCBFEoGF = fechaPCBFEoGF;
    }

    public void setFechaPCBCOMFEoGF(String fechaPCBCOMFEoGF) {
        this.fechaPCBCOMFEoGF = fechaPCBCOMFEoGF;
    }

    //Metodos y funciones------------------------------------------------>
    public CachedRowSet diagrama(String inicio, String fin) {
        ProyectoM obj = new ProyectoM();
        return obj.diagramaM(inicio, fin);
    }

    public boolean estadoDeOrden(int orden, int op) {
        ProyectoM obj = new ProyectoM();
        return obj.estadoDeOrdenM(orden, op);
    }

    public boolean estadoProyecto(int orden) {
        ProyectoM obj = new ProyectoM();
        return obj.estadoProyecto(orden);
    }

    public boolean registrar_Modificar_Proyecto(String comercial, int op) {
        ProyectoM obj = new ProyectoM();
        String nego[] = negocio.split("/");
        for (int i = 0; i < nego.length; i++) {
            if (nego[i].equals("FE")) {
                this.setFE(true);
            } else if (nego[i].equals("TE")) {
                this.setTE(true);
            } else if (nego[i].equals("EN")) {//EN
                this.setIN(true);
            }
        }
        return obj.registrar_Modificar_Proyecto(idOrden, comercial, nombreCliente, nombreProyecto, tipoProyecto, FE, TE, IN, detalles[0], detalles[1], detalles[2], detalles[3], detalles[4], detalles[5], detalles[6], fecha, detalles[7], detalles[8], op, detalles[9], detalles[10],
                fechaCiccuitoFEoGF, fechaCiccuitoCOMFEoGF, fechaPCBFEoGF, fechaPCBCOMFEoGF,novedadProyecto);
    }

    //Registrar mediante un lector de QR----------------------------------------
    public boolean registrarDetalleProyectoQR(int orden, String area, String producto, String Cantidad, String Material, String ruteo, String antisolder) {
        ProyectoM obj = new ProyectoM();
        return obj.registrarDetalleProyectoQRM(orden, area, producto, Cantidad, Material, ruteo, antisolder);
    }

    public boolean registrarProyectoQR(String infoP[], String comercial) {
        ProyectoM obj = new ProyectoM();
        return obj.registrarProyectoQRM(infoP, comercial);
    }

    public boolean validarProyectoQR(int orden) {
        ProyectoM obj = new ProyectoM();
        return obj.ValidarProyectoQRM(orden);
    }

    public boolean validarDetalleProyectoQR(int orden, String area, String producto) {
        ProyectoM obj = new ProyectoM();
        return obj.validarDetalleProyectoQRM(orden, area, producto);
    }

    //Registrar mediante un lector de QR----------------------------------------
    public CachedRowSet consutalarProcesosArea(int op) {
        ProyectoM obj = new ProyectoM();
        return obj.consutalarProcesosAreaM(op);
    }

    public CachedRowSet consultar_Proyecto(String tipo) {
        Modelo.ProyectoM obj = new Modelo.ProyectoM();
        return obj.consultar_Proyecto(idOrden, nombreCliente, nombreProyecto, fecha, tipo);
    }

    public CachedRowSet consultar_ProyectoEliminados() {
        Modelo.ProyectoM obj = new Modelo.ProyectoM();
        return obj.consultar_ProyectoEliminados();
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public boolean EliminarProyecto(int orden) {//Se cambiara el estado del proyecto
        ProyectoM obj = new ProyectoM();
        return obj.EliminarProyecto(orden);
    }

    public boolean ReacttivarProyecto(int orden) {//Se cambiara el estado del proyecto
        ProyectoM obj = new ProyectoM();
        return obj.ReacttivarProyecto(orden);
    }
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    //Información de las areas de producción
    public CachedRowSet InformacionAreasProduccion(int accion) {
        ProyectoM obj = new ProyectoM();
        return obj.InformacionAreasProduccionM(accion);
    }

    public CachedRowSet Consultar_informacion_para_el_QR(int orden) {
        ProyectoM obj = new ProyectoM();
        return obj.Consultar_informacion_para_el_QR(orden);
    }

//    public CachedRowSet generar_Reportes() {//Falta generar los reportes
//        ProyectoM obj=new ProyectoM();
//        
//    }
    public boolean validarNumerOrden(int orden) {
        ProyectoM obj = new ProyectoM();
        return obj.validarNumerOrden(orden);
    }

    public String consultarNumeroOrden() {
        ProyectoM obj = new ProyectoM();
        return obj.consultarNumeroOrden();
    }

    public String fecha() {
        ProyectoM obj = new ProyectoM();
        return obj.fecha();
    }

    public CachedRowSet fechaYdatosProduccion() {
        ProyectoM obj = new ProyectoM();
        return obj.fechaYdatosProduccion();
    }

    public CachedRowSet proyectosNegocio(int negocio, String orden, String cliente, String proyecto, String tipo) {
        ProyectoM obj = new ProyectoM();
        return obj.proyectosNegocio(negocio, orden, cliente, proyecto, tipo);
    }

    public boolean validarEliminacion(int orden) {
        ProyectoM obj = new ProyectoM();
        return obj.validarEliminacion(orden);
    }

    public boolean validarEjecucionOParada(int orden) {
        ProyectoM validar = new ProyectoM();
        return validar.validarEjecucionOParada(orden);
    }

    //Finalizacion de la clase automatica---------------------------------------------------------------->
    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

}
