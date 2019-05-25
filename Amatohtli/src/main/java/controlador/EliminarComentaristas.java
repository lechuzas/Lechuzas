/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Comentario;
import modelo.ComentarioDAO;
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
    private ArrayList<String> lista_correos;
    private List<Usuario> comentaristas;
    
    @PostConstruct
    public void EliminarComentaristas(){
        UsuarioDAO udao = new UsuarioDAO();
        comentaristas = udao.findAll();
        lista_correos = new ArrayList<String>();
        this.correo = "";
        for(Usuario u : udao.findAll()){
            if(u.getRol() == 2)
                lista_correos.add(u.getCorreo());
        }
         
     }

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

    public ArrayList<String> getLista_correos() {
        return lista_correos;
    }

    public void setLista_correos(ArrayList<String> lista_correos) {
        this.lista_correos = lista_correos;
    }

    public List<Usuario> getComentaristas() {
        return comentaristas;
    }

    public void setComentaristas(List<Usuario> comentaristas) {
        this.comentaristas = comentaristas;
    }
    
    
    
    public String muestraVentana(){
        return "/administrador/eliminarComentaristas?faces-redirect=true";
    }
    
     public void eliminaComentarista(){
         System.out.println(this.correo);
         UsuarioDAO udao = new UsuarioDAO();
         Usuario comentarista = udao.buscaPorCorreo(correo);
         ComentarioDAO c = new ComentarioDAO();
         List<Comentario> lista_comentarios = c.finAll();
         if(comentarista != null){
             ControladorSesion.UserLogged us = (ControladorSesion.UserLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("comentarista");
             for(Comentario comentario : lista_comentarios){
                 System.out.println(comentario.getUsuario().getCorreo());
                 if(comentario.getUsuario().getCorreo().equals(us.getCorreo())){
                     c.delete(comentario);
                 }
         }
             udao.delete(comentarista);
             Mensajes.info("Se ha eliminado correctamente el comentarista");
         }else if(comentarista != null && comentarista.getRol() != 1 || comentarista == null){
             Mensajes.fatal("El comentarista que usted desea eliminar no existe, favor de verificar el correo");
            
         }
             
     }
    
}
