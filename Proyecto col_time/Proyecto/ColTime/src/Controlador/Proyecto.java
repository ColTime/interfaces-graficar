package Controlador;

import Modelo.ProyectoM;
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

    //Get and set------------------------------------------------>
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

    //Metodos y funciones------------------------------------------------>
    public boolean registrar_Modificar_Proyecto(String comercial, int op) {
        ProyectoM obj = new ProyectoM();
        String nego[] = negocio.split("/");
        for (int i = 0; i < nego.length; i++) {
            if (nego[i].equals("FE")) {
                this.setFE(true);
            } else if (nego[i].equals("TE")) {
                this.setTE(true);
            } else if (nego[i].equals("IN")) {
                this.setIN(true);
            }
        }
        return obj.registrar_Modificar_Proyecto(idOrden, comercial, nombreCliente, nombreProyecto, tipoProyecto, FE, TE, IN, detalles[0], detalles[1], detalles[2], detalles[3], detalles[4], detalles[5], detalles[6], fecha, detalles[7], detalles[8], op, detalles[9], detalles[10]);
    }

    public CachedRowSet consultar_Proyecto(String tipo) {
        Modelo.ProyectoM obj = new Modelo.ProyectoM();
        return obj.consultar_Proyecto(idOrden, nombreCliente, nombreProyecto, fecha, tipo);
    }

    public boolean cambiar_Estado_Proyeto() {

        return true;
    }

    public CachedRowSet Consultar_informacion_para_el_QR(int orden) {
        ProyectoM obj = new ProyectoM();
        return obj.Consultar_informacion_para_el_QR(orden);
    }

    public void generar_Reportes() {

    }

    public String consultarNumeroOrden() {
        ProyectoM obj = new ProyectoM();
        return obj.consultarNumeroOrden();
    }

    public String fecha() {
        ProyectoM obj = new ProyectoM();
        return obj.fecha();
    }

    public CachedRowSet proyectosNegocio(int negocio) {
        ProyectoM obj = new ProyectoM();
        return obj.proyectosNegocio(negocio);
    }

    //Finalizacion de la clase automatica---------------------------------------------------------------->
    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

}
