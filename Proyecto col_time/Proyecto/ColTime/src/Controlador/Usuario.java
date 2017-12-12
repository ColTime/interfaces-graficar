package Controlador;

import Modelo.UsuarioM;
import java.io.FileInputStream;
import javax.sql.rowset.CachedRowSet;

public class Usuario {

    //Constructores--------------------------------------------------------->
    public Usuario(String documento, String nombreApe, int cargo) {
        this.documento = documento;
        this.nombres = nombreApe;
        this.cargo = cargo;
    }

    public Usuario() {
    }

    //Variables--------------------------------------------------->
    private CachedRowSet crs = null;

    //Atributos de la clase usuarios----------------------------->
    private String documento = "";
    private String tipo = "";
    private String nombres = "";
    private String apellidos = "";
    private int cargo = 0;
    private String contraseña = "";
    private FileInputStream im = null;
    private String recuperaccion = null;
    //Set---------------------------------------------->

    public String getRecuperaccion() {
        return recuperaccion;
    }

    public void setRecuperaccion(String recuperaccion) {
        this.recuperaccion = recuperaccion;
    }

    public void setCrs(CachedRowSet crs) {
        this.crs = crs;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setIm(FileInputStream im) {
        this.im = im;
    }

    //Metodos de la clase usuarios--------------------------------------->
    public boolean registrar_Modificar_Usuario(int op, int estado) {
        Modelo.UsuarioM obj = new Modelo.UsuarioM();
        return obj.registrar_Modificar_Usuario(documento, tipo, nombres, apellidos, cargo, op, true, recuperaccion);
    }

    public CachedRowSet recuperacionContraseña(String recuperacion) {
        UsuarioM obj = new UsuarioM();
        return obj.recuperacionContraseñaM(recuperacion);
    }

    public CachedRowSet consultar_Usuario() {
        Modelo.UsuarioM obj = new Modelo.UsuarioM();
        setCrs(obj.consultar_Usuario(documento, nombres, cargo));
        return crs;
    }

    public boolean cambiar_Estado_Usuario(boolean estado) {
        Modelo.UsuarioM obj = new Modelo.UsuarioM();
        return obj.cambiar_Estado_Usuario(documento, estado);
    }

    public boolean validarSiEstaActivo() {
        Modelo.UsuarioM obj = new Modelo.UsuarioM();
        return obj.validarSiEstaActivo(documento);
    }

    public int iniciarSesion(String user, String pasw) {
        Modelo.UsuarioM obj = new Modelo.UsuarioM();
        return obj.iniciarSesion(user, pasw);
    }

    public boolean CambiarContraseña(String anti) {
        Modelo.UsuarioM obj = new UsuarioM();
        return obj.cambiarContraseña(documento, contraseña, anti);
    }

    public void sesion(int sec, String doc) {
        Modelo.UsuarioM obj = new UsuarioM();
        obj.sesion(sec, doc);
    }

    //Metodo de liberacion de memoria------------------------------------------>
    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

}
