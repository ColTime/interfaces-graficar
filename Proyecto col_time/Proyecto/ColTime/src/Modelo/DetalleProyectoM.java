package Modelo;

import Controlador.*;
import javax.sql.rowset.CachedRowSet;

public class DetalleProyectoM {

    //Constructores------------------------------------------------->
    public DetalleProyectoM() {

    }
    //Variables------------------------------------------------------>
    private CachedRowSet crs = null;

    //Metodos----------------------------------------------------->
    public boolean registrar_Modificar_Detalle_Proycto(String cantidad,String negocio, String tipoNegocio,int estado) {

        return true;
    }

    public CachedRowSet consultar_Detalle_Proyecto() {

        return crs;
    }

    public boolean cambiar_Estado_Detalle() {

        return true;
    }
}
