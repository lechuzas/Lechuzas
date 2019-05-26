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
            String mensaje= "Hola, binvenido a Amatohlti " + nombre + " " + paterno +"\n"
                            + "Gracias por querer aportar tu granito de arena y hacer una comunidad más grande"+"\n"
                            + " a continuación se te otorgan tus datos para que puedas ingresar a tu cuenta: "+"\n\n"
                            +"Tu usuario es: "+nombreUsuario +"\n"
                            +"Contrasenia: "+nombreUsuario +"\n\n"
                            +"Recuerda actualizar tu contraseña cuando entres a tu cuenta!"+"\n\n"
                            +"Atte: Equipo Amatohtli";
            if (dao.buscaPorCorreo(correo) == null){
                dao.save(usr);
                Mail.sendMail(subject, mensaje, correo);
                Mensajes.info("Se ha agregado correctamente el Informador"); 
                this.nombre="";
                this.correo="";
                this.nombreUsuario="";
                this.paterno="";
                
            }else{
                Mensajes.error("El correo ya esta registrado");
            }

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
            String mensaje= "Hola, binvenido a Amatohlti " + nombre + " " + paterno +"\n"
                            + "Gracias por querer aportar tu granito de arena y hacer una comunidad más grande"+"\n"
                            + " a continuación se te otorgan tus datos para que puedas ingresar a tu cuenta: "+"\n\n"
                            +"Tu usuario es: "+nombreUsuario +"\n"
                            +"Contrasenia: "+nombreUsuario +"\n\n"
                            +"Recuerda actualizar tu contraseña cuando entres a tu cuenta!"+"\n\n"
                            +"Atte: Equipo Amatohtli";
            if (dao.buscaPorCorreo(correo) == null){
                dao.save(usr);
                Mail.sendMail(subject, mensaje, correo);
                this.nombre="";
                this.correo="";
                this.nombreUsuario="";
                this.paterno="";
                Mensajes.info("Se te ha enviado un correo, gracias :D ");    
            }else{
                Mensajes.error("El correo ya esta registrado");
            }
            
    }
}
