package Controlador;

import Modelo.FE_TE_INM;
import java.io.PrintStream;
import javax.sql.rowset.CachedRowSet;

public class FE_TE_IN {

    int porIniciar = 0;
    int pausa = 0;
    int ejecucion = 0;

    //Constructores--------------------------------------------->
    public FE_TE_IN() {

    }

    //Metodos------------------------------------------------->
    //Ten en cuenta el identificador del lector***
    public boolean iniciar_Pausar_Reiniciar_Toma_Tiempo(int orden, int detalle, int negocio, int lector, int cantidad, int operario, PrintStream myPS) {
        FE_TE_INM obj = new FE_TE_INM();
        return obj.iniciar_Pausar_Reiniciar_Toma_Tiempo(orden, detalle, negocio, lector, cantidad, operario, myPS);
    }

    public CachedRowSet consultarProyectosEnEjecucion(int negocio) {
        FE_TE_INM obj = new FE_TE_INM();
        return obj.consultarProyectosEnEjecucion(negocio);
    }

    public boolean pararTiempoAlmacen(int orden, int detalle, int cantidad, int detalleproducto, int proceso) {
        FE_TE_INM obj = new FE_TE_INM();
        return obj.pararTiempoAlmacen(orden, detalle, cantidad, detalleproducto, proceso);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //Este metodo obliga a la intancia se elimine sola y libere el espacio en el puntero.
    }

}
