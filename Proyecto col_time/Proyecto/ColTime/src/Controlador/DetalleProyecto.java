package Controlador;

import javax.sql.rowset.CachedRowSet;

public class DetalleProyecto {

    //Constructores------------------------------------------------->
    public DetalleProyecto() {

    }
    //Variables------------------------------------------------------>
    private CachedRowSet crs = null;
    //Atributos------------------------------------------------------>
    private String cantidad = "";
    private String negocio = "";
    private String tipoNegocio = "";
    private String estado = "";

    //GET ann SET-------------------------------------------------------->
    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNegocio() {
        return negocio;
    }

    public void setNegocio(String negocio) {
        this.negocio = negocio;
    }

    public String getTipoNegocio() {
        return tipoNegocio;
    }

    public void setTipoNegocio(String tipoNegocio) {
        this.tipoNegocio = tipoNegocio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public CachedRowSet getCrs() {
        return crs;
    }

    public void setCrs(CachedRowSet crs) {
        this.crs = crs;
    }

    //Metodos----------------------------------------------------->
    public boolean registrar_Modificar_Detalle_Proycto() {

        return true;
    }

    public CachedRowSet consultar_Detalle_Proyecto() {

        return crs;
    }

    public boolean cambiar_Estado_Detalle() {

        return true;
    }
}
