package Controlador;

import javax.sql.rowset.CachedRowSet;

public class Proyecto {

    //Constructores------------------------------------------------->
    public Proyecto() {

    }
    //Variables----------------------------------------------------->
    private CachedRowSet crsP = null;
    //Atributos de la clase proyecto-------------------------------->
    private String idOrden = "";
    private String nombreCliente = "";
    private String nombreProyecto = "";
    private String tipoProyecto = "";
    private String negocio = "";
    private String fechaEntrega = "";
    private String fechaEntrada = "";
    private String fechaSalida = "";
    private int detalles[] = new int[9];//Converosr,Repujado
    private boolean Ruteo;
    private boolean antisolder;
    private String estado = "";

    //Get and set------------------------------------------------>
    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(String tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public String getNegocio() {
        return negocio;
    }

    public void setNegocio(String negocio) {
        this.negocio = negocio;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int[] getDetalles() {
        return detalles;
    }

    public void setDetalles(int[] detalles) {
        this.detalles = detalles;
    }

    public boolean isRuteo() {
        return Ruteo;
    }

    public void setRuteo(boolean Ruteo) {
        this.Ruteo = Ruteo;
    }

    public boolean isAntisolder() {
        return antisolder;
    }

    public void setAntisolder(boolean antisolder) {
        this.antisolder = antisolder;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public CachedRowSet getCrsP() {
        return crsP;
    }

    public void setCrs(CachedRowSet crsP) {
        this.crsP = crsP;
    }

    //Metodos y funciones------------------------------------------------>
    public boolean registrar_Modificar_Proyecto() {

        return true;
    }

    public CachedRowSet consultar_Proyecto() {

        return crsP;
    }

    public boolean cambiar_Estado_Proyeto() {

        return true;
    }

    public void generar_CodigoQR_Proyecto() {

    }

    public void generar_Reportes() {

    }
}
