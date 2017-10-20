package Controlador;

import Modelo.FE_TE_INM;

public class FE_TE_IN {

    //Constructores--------------------------------------------->
    public FE_TE_IN() {

    }

    //Metodos------------------------------------------------->
    //Ten en cuenta el identificador del lector***
    public boolean iniciar_Toma_Tiempo(int orden, int detalle, int negocio,int lector) {
        FE_TE_INM obj = new FE_TE_INM();
        return obj.iniciar_Toma_Tiempo(orden, detalle, negocio,lector);
    }

    //No me acuerdo el funcionamiento de este metodo:v
    protected boolean cambiar_Estado_Proceso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean detener_Toma_Tiempo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
