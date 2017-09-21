package Controlador;

import Modelo.UsuarioM;
import java.io.FileInputStream;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

public class Usuario {

    //Constructores--------------------------------------------------------->
    public Usuario() {

    }
    //Variables--------------------------------------------------->
    private CachedRowSet crs = null;

    //Atributos de la clase usuarios----------------------------->
    private String documento = "";
    private int tipo = 0;
    private String nombres = "";
    private String apellidos = "";
    private int cargo = 0;
    private String contraseña = "";
    private FileInputStream im = null;

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

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
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

    public FileInputStream getIm() {
        return im;
    }

    public void setIm(FileInputStream im) {
        this.im = im;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    //Metodos de la clase usuarios--------------------------------------->
    public boolean registrar_Modificar_Usuario(int op, int estado) {
        Modelo.UsuarioM obj = new Modelo.UsuarioM();
        return obj.registrar_Modificar_Usuario(documento, tipo, nombres, apellidos, cargo, op, estado);
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

    public boolean validarUsuario(String doc) {     
        UsuarioM obj = new UsuarioM();
        return obj.validarUsuario(doc);
    }
    //Metodo de liberacion de memoria------------------------------------------>

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Clase usuario terminada");
    }

}
