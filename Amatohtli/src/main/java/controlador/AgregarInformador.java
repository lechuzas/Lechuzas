/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 *
 * @author fermat
 */
@ManagedBean
public class AgregarInformador {
    private String correo;
    private String contrasenia;
    private String nombreUsuario;
    private String nombre;
    private String paterno;
    private int rol;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
    public void agregaInfo(){
            Usuario usr= new Usuario();
            UsuarioDAO dao=new UsuarioDAO();
            usr.setContrasenia(nombreUsuario);
            usr.setPaterno(paterno);
            usr.setNombreUsuario(nombreUsuario);
            usr.setCorreo(correo);
            usr.setNombre(nombre);
            usr.setRol(1);
            String subject="Bienvenido a Amatohlti "+nombre;
            String mensaje= "Tu usuario es "+nombreUsuario  + " y contrasenia es: "+nombreUsuario;
            dao.save(usr);
            Mail.sendMail(subject, mensaje, correo);
            Mensajes.info("Se ha agregado correctamente el informador");   
    }
    
    public void agregaComentarista(){
            Usuario usr= new Usuario();
            UsuarioDAO dao=new UsuarioDAO();
            usr.setContrasenia(nombreUsuario);
            usr.setPaterno(paterno);
            usr.setNombreUsuario(nombreUsuario);
            usr.setCorreo(correo);
            usr.setNombre(nombre);
            usr.setRol(2);
            String subject="Bienvenido a Amatohlti "+nombre;
            String mensaje= "Tu usuario es "+ nombreUsuario + " y contrasenia es: "+nombreUsuario;
            if (dao.buscaPorCorreo(correo) == null){
                dao.save(usr);
                Mail.sendMail(subject, mensaje, correo);
                Mensajes.info("Se ha agregado correctamente el comentarista");    
            }else{
                Mensajes.error("El correo ya esta registrado");
            }
            
    }
}
