/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 *
 * @author ailyn
 */
@ManagedBean
@ViewScoped
public class EliminarComentaristas {
    private String correo;
     private String contrasenia;
     private String nombreUsuario;
     private String nombre;
     private String paterno;
     private Integer rol;
     private Set temas = new HashSet(0);
     private Set comentarios = new HashSet(0);
     private Set calificacions = new HashSet(0);

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

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public Set getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set comentarios) {
        this.comentarios = comentarios;
    }

    public Set getCalificacions() {
        return calificacions;
    }

    public void setCalificacions(Set calificacions) {
        this.calificacions = calificacions;
    }
    
    public String muestraVentana(){
        return "/administrador/eliminarComentaristas?faces-redirect=true";
    }
    
     public void eliminaComentarista(){
         UsuarioDAO udao = new UsuarioDAO();
         Usuario comentarista = udao.buscaPorCorreo(correo);
         
         if(comentarista != null && comentarista.getRol() == 2){
             udao.delete(comentarista);
             Mensajes.info("Se ha eliminado correctamente el comentarista");
         }else if(comentarista != null && comentarista.getRol() != 1 || comentarista == null){
             Mensajes.fatal("El comentarista que usted desea eliminar no existe, favor de verificar el correo");
            
         }
             
     }
    
}
