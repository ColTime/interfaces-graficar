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
    public boolean registrar_Detalle_Proycto(String numerOrden, int op, int id) {
        DetalleProyectoM obj = new DetalleProyectoM();
        return obj.registrar_Detalle_Proycto(cantidad, negocio, tipoNegocio, 1, numerOrden, material, op, id, 0, null);
    }

    public boolean registrarModificarPNC(String numerOrden, int op, int id, String ubicacion) {
        DetalleProyectoM obj = new DetalleProyectoM();
        return obj.registrar_Detalle_Proycto(cantidad, negocio, tipoNegocio, 1, numerOrden, material, op, id, 1, ubicacion);
    }

    public int ValidarCnatidadPNC(String numerOrden, int detalle, int op, String tipo, String negocio) {
        DetalleProyectoM obj = new DetalleProyectoM();
        return obj.ValidarCnatidadPNCM(numerOrden, detalle, op, tipo, negocio);
    }

    //Esta linea esta pendiente
    public boolean modificar_Detalle_Proycto(String numerOrden) {

        return true;
    }

    public CachedRowSet consultar_Detalle_Proyecto(String numerOrden, int estado) {
        DetalleProyectoM obj = new DetalleProyectoM();
        return obj.consultar_Detalle_Proyecto(numerOrden, estado);
    }

    public CachedRowSet consultarProcesosFE(int detalle) {
        DetalleProyectoM obj = new DetalleProyectoM();
        return obj.consultarprocesosFE(detalle);
    }

    public boolean validarEliminacionModificar(int negocio, int orden, int tipo, int detalle, int accion) {
        DetalleProyectoM obj = new DetalleProyectoM();
        return obj.validarEliminacionModificarM(orden, negocio, tipo, detalle, accion);
    }

//  Reiniciar toma de tiempo
    public boolean ReiniciarDetalle(int detalle, int negocio, int detalleproducto) {
        DetalleProyectoM obj = new DetalleProyectoM();
        return obj.ReiniciarDetalle(detalle, negocio, detalleproducto);
    }

    public boolean eliminarDetallersProyecto(int idDetalle, int numerOrden, String negocio, String tipo, int accion) {
        DetalleProyectoM obj = new DetalleProyectoM();
        return obj.eliminarDetallersProyecto(idDetalle, numerOrden, negocio, tipo, accion);
    }

    public CachedRowSet consultarDetalleProyectoProduccion(int orden, int negocio, int vistaC) {
        DetalleProyectoM obj = new DetalleProyectoM();
        return obj.consultarDetalleProyectoProduccion(orden, negocio, vistaC);
    }

    public CachedRowSet consultarDetalleProduccion(int detalle, int negocio) {
        DetalleProyectoM obj = new DetalleProyectoM();
        return obj.consultarDetalleProduccion(detalle, negocio);
    }

    public CachedRowSet ConsultarInformacionFiltrariaDelDetalle(int detalle) {
        DetalleProyectoM obj = new DetalleProyectoM();
        return obj.ConsultarInformacionFiltrariaDelDetalleM(detalle);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

}
