/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Marcador;
import modelo.MarcadorDAO;
import modelo.Tema;
import modelo.TemaDAO;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.event.map.PointSelectEvent;
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
public class AgregarMarcador implements Serializable {
    private int idMarcador;
    private int idTema;
    private String tema;
    private Tema temaByIdColor;
    private Tema temaByIdTema;
    private double latitud;
    private double longitud;
    private String descripcion;
    private Set comentarios = new HashSet(0);
    private Marker marcador;
    private MapModel simpleModel;
    
    
    
    @PostConstruct
    public void init(){
        simpleModel = new DefaultMapModel();
        marcador = new Marker(new LatLng(23.382390, -102.291477),"Arrastrame");
        marcador.setDraggable(true);
        marcador.setClickable(true);
        simpleModel.addOverlay(marcador);
        this.latitud = marcador.getLatlng().getLat();
        this.longitud = marcador.getLatlng().getLng();
        
        
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }
    public Marker getMarcador() {
        return marcador;
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public int getIdMarcador() {
        return idMarcador;
    }

    public void setIdMarcador(int idMarcador) {
        this.idMarcador = idMarcador;
    }

    public Tema getTemaByIdColor() {
        return temaByIdColor;
    }

    public void setTemaByIdColor(Tema temaByIdColor) {
        this.temaByIdColor = temaByIdColor;
    }

    public Tema getTemaByIdTema() {
        return temaByIdTema;
    }

    public void setTemaByIdTema(Tema temaByIdTema) {
        this.temaByIdTema = temaByIdTema;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set comentarios) {
        this.comentarios = comentarios;
    }
    
      public void onMarkerDrag(MarkerDragEvent event){
        marcador = event.getMarker();
        this.latitud = marcador.getLatlng().getLat();
        this.longitud = marcador.getLatlng().getLng();
    }
      
    public void onPointSelect(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();
        marcador = simpleModel.getMarkers().get(0);
        marcador.setLatlng(latlng);
        this.latitud = latlng.getLat();
        this.longitud = latlng.getLng();
        
    }
    
    public String muestraVentana(){
        return "/informador/agregarMarcadores?faces-redirect=true";
    }


    
    public void agregaMarcador(){
        Marcador m = new Marcador();
        MarcadorDAO mdao = new MarcadorDAO();
        TemaDAO tdao = new TemaDAO();
        ControladorSesion.UserLogged us = (ControladorSesion.UserLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("informador");
        List<Tema> lista_temas = tdao.findAll();
        for(Tema t : lista_temas){
            if(this.tema.equals(t.getNombreTema()) && t.getUsuario().getCorreo().equals(us.getCorreo())){
                this.temaByIdTema = t;
                this.temaByIdColor = t;
            }
        }
        
        if(this.temaByIdTema == null || this.temaByIdColor == null){
            Mensajes.error("El tema que usted escogió no existe, escriba otro");
        }else if(this.temaByIdTema != null && this.temaByIdColor != null){
            m.setLatitud(latitud);
            m.setLongitud(longitud);
            m.setTemaByIdColor(temaByIdColor);
            m.setTemaByIdTema(temaByIdTema);
            m.setDescripcion(descripcion);
            Marcador marc = mdao.buscaMarcadorPorLatLng(latitud, longitud);
            if(marc != null){
                Mensajes.error("El marcador no se pudo agregar correctamente. El marcador que desea agregar ya existe");
            }else{
                mdao.save(m);
                Mensajes.info("Se ha agregado correctamente su marcador");
            }
            
        }
        
        
    }
}
