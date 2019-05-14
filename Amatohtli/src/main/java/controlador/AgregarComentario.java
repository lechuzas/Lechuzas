/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import modelo.CalificacionDAO;
import modelo.Comentario;
import modelo.ComentarioDAO;
import modelo.MarcadorDAO;
import modelo.UsuarioDAO;

/**
 *
 * @author default
 */
@ManagedBean()
public class AgregarComentario {
    
    private int idMarcador;
    private String correo;
    private String descripcion;
    private int idCalificacion;

    
    public int getIdMarcador() {
        return idMarcador;
    }

    public void setIdMarcador(int idMarcador) {
        this.idMarcador = idMarcador;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }
    
    public void agregarComentario(){
        
        ControladorSesion.UserLogged us = (ControladorSesion.UserLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("comentarista");
        
        System.out.println(idCalificacion);
        System.out.println(idMarcador);
        System.out.println(idMarcador);
        System.out.println(us.getCorreo());
        
        /*
        Comentario comentario = new Comentario();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        MarcadorDAO marcadorDAO = new MarcadorDAO();
        CalificacionDAO calificacionDAO = new CalificacionDAO();
        
        comentario.setCalificacion(calificacionDAO.buscaPorID(idCalificacion));
        comentario.setMarcador(marcadorDAO.buscaPorID(idMarcador));
        comentario.setUsuario(usuarioDAO.buscaPorCorreo(correo));
        comentario.setDescripcion(descripcion); 
        ComentarioDAO udb = new ComentarioDAO();
        udb.save(comentario);
        */
    }
}
