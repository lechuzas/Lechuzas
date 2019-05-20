/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bean.ComentarioBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Calificacion;
import modelo.CalificacionDAO;
import modelo.Comentario;
import modelo.ComentarioDAO;
import modelo.Marcador;
import modelo.MarcadorDAO;
import modelo.TemaDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RateEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author ailyn
 */
@ManagedBean
@ViewScoped

public class VerMarcadorC implements Serializable{
    private MapModel simpleModel;
    private Marker marker;
    private double latitud;
    private double longitud;
    private String tema;
    private int idMarcador;
    private String correo;
    private String descripcion;
    private int idCalificacion;
    public static Marcador select;
    private List<Comentario> listacom;
    
     
    @PostConstruct
    public void verMarcadoresC(){
        
        simpleModel = new DefaultMapModel();
        MarcadorDAO mdb = new MarcadorDAO();
        List<Marcador> marcadores = mdb.findAll();
        for(Marcador m :marcadores){
            LatLng cord = new LatLng(m.getLatitud(),m.getLongitud());
            Marker marcador = new Marker(cord,m.getDescripcion());
            simpleModel.addOverlay(marcador);
            TemaDAO tdao = new TemaDAO();
        }
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }
    
    public void onMarkerSelect(OverlaySelectEvent event) {
       marker =(Marker) event.getOverlay();
       this.latitud = marker.getLatlng().getLat();
       this.longitud = marker.getLatlng().getLng();
       MarcadorDAO marcadorDAO = new MarcadorDAO();
       select = marcadorDAO.buscaMarcadorPorLatLng(latitud, longitud);
       ComentarioBean.update();
    }

    public Marcador getSelect() {
        return select;
    }
    
    public Marker getMarker() {
        return marker;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
    public String muestraVentanaAgregar(){
        return "/comentarista/aemcComentario?faces-redirect=true";
    }
    
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
        Comentario comentario = new Comentario();
        Calificacion calificacion = new Calificacion();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        MarcadorDAO marcadorDAO = new MarcadorDAO();
        Marcador m = marcadorDAO.buscaMarcadorPorLatLng(latitud, longitud);
        if(this.descripcion != null && m != null){
            Usuario usuario = usuarioDAO.buscaPorCorreo(us.getCorreo());
            CalificacionDAO udbc = new CalificacionDAO();
            calificacion.setUsuario(usuario);
            calificacion.setPuntaje(0);
            udbc.save(calificacion);
            comentario.setCalificacion(calificacion);
            comentario.setMarcador(m);
            comentario.setUsuario(usuario);
            comentario.setDescripcion(descripcion); 
            //comentario.setIdComentario(100);
            ComentarioDAO udb = new ComentarioDAO();
            udb.save(comentario);
            this.descripcion="";
            ComentarioBean.update();
            Mensajes.info("Su comentario se agregó correctamente");
        }else{
            Mensajes.error("Elija un marcador");
        }
    }
    
    
    public void eliminarComentario(Comentario c){
        try{
            ComentarioDAO udb = new ComentarioDAO();
            udb.delete(c);
            this.descripcion="";
            ComentarioBean.update();
            Mensajes.info("Su comentario se eliminó correctamente");
        }catch(Exception e){
            Mensajes.error("Elija un marcador");
        }   
    }
    
    public void onrate(RateEvent rateEvent) {
            
            Comentario c = (Comentario) rateEvent.getComponent().getAttributes().get("com");   
            int estrellas = ((Integer) rateEvent.getRating()).intValue();
            Calificacion calf = c.getCalificacion();
            calf.setPuntaje(estrellas);
            c.setCalificacion(calf);
            c.setNumCalificaciones(c.getNumCalificaciones() + 1);
            ComentarioDAO udb = new ComentarioDAO();
            udb.update(c);
            CalificacionDAO udbc = new CalificacionDAO();
            udbc.update(calf);
            this.descripcion="";
            ComentarioBean.update();
            Mensajes.info("Calificaste el comentario con puntaje: " + estrellas);
        
    }
    
    public void oncancel(Comentario c) {
            
            Calificacion calf = c.getCalificacion();
            calf.setPuntaje(0);
            c.setCalificacion(calf);
            c.setNumCalificaciones(c.getNumCalificaciones() - 1);
            ComentarioDAO udb = new ComentarioDAO();
            udb.update(c);
            CalificacionDAO udbc = new CalificacionDAO();
            udbc.update(calf);
            this.descripcion="";
            ComentarioBean.update();
            Mensajes.info("Quitaste la calificaición del comentario");
        
    }
    
    
}