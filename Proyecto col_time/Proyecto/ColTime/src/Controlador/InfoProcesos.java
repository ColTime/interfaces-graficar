package Controlador;

public abstract class InfoProcesos {

    //Constructores------------------------------------------------------->
    public InfoProcesos() {

    }
    //Variables-------------------------------------->

    //Atributos---------------------------------------->
    private String estado = "";
    private String fechaIngreso = "";
    private String fechaSalida = "";
    private String numeroCantidadesTerminadas = "";
    private String tempoUnidadProceso = "";
    private String tiempoTotalProceso = "";

    //GET and SET-------------------------------------------------------->
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getNumeroCantidadesTerminadas() {
        return numeroCantidadesTerminadas;
    }

    public void setNumeroCantidadesTerminadas(String numeroCantidadesTerminadas) {
        this.numeroCantidadesTerminadas = numeroCantidadesTerminadas;
    }

    public String getTempoUnidadProceso() {
        return tempoUnidadProceso;
    }

    public void setTempoUnidadProceso(String tempoUnidadProceso) {
        this.tempoUnidadProceso = tempoUnidadProceso;
    }

    public String getTiempoTotalProceso() {
        return tiempoTotalProceso;
    }

    public void setTiempoTotalProceso(String tiempoTotalProceso) {
        this.tiempoTotalProceso = tiempoTotalProceso;
    }

    //Metodos--------------------------------------------------------->
    protected abstract boolean cambiar_Estado_Proceso();

    public abstract boolean iniciar_Toma_Tiempo();

    public abstract boolean detener_Toma_Tiempo();
}
