package Controlador;

import Modelo.DetalleProyectoM;
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
    private int estado = 0;
    private String material = "";

    //Set-------------------------------------------------------->
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public CachedRowSet getCrs() {
        return crs;
    }

    public void setCrs(CachedRowSet crs) {
        this.crs = crs;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    //Metodos----------------------------------------------------->
    public boolean registrar_Detalle_Proycto(String numerOrden, int op,int id) {
        DetalleProyectoM obj = new DetalleProyectoM();
        return obj.registrar_Detalle_Proycto(cantidad, negocio, tipoNegocio, 1, numerOrden,material,op,id);
    }

    public boolean modificar_Detalle_Proycto(String numerOrden) {

        return true;
    }

    public CachedRowSet consultar_Detalle_Proyecto(String numerOrden) {
        DetalleProyectoM obj=new DetalleProyectoM();
        return obj.consultar_Detalle_Proyecto(numerOrden);
    }

    public boolean cambiar_Estado_Detalle() {

        return true;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
