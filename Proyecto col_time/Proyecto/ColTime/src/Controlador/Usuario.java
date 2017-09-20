package Controlador;

import javax.sql.rowset.CachedRowSet;

public class Usuario {

    //Variables--------------------------------------------------->
    private CachedRowSet crs = null;

    //Atributos de la clase usuarios----------------------------->
    private String documento = "";
    private String nombres = "";
    private String apellidos = "";
    private String cargo = "";
    private String contraseña = "";

    //get and set---------------------------------------------->
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public CachedRowSet getCrs() {
        return crs;
    }

    public void setCrs(CachedRowSet crs) {
        this.crs = crs;
    }

    //Metodos de la clase usuarios--------------------------------------->
    public boolean registrar_Modificar_Usuario() {

        return true;
    }

    public CachedRowSet consultar_Usuario() {

        return crs;
    }

    public boolean cambiar_Estado_Usuario() {

        return true;
    }

    public boolean iniciarSesion() {

        return true;
    }

    public void cerrarSesion() {

    }

    public boolean validarUsuario() {

        return true;
    }
}
