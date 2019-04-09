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
import modelo.CatColor;
import modelo.CatColorDAO;
import modelo.Marcador;
import modelo.MarcadorDAO;
import modelo.Tema;
import modelo.TemaDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
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
public class AgregarTema implements Serializable {
     private CatColor catColor;
     private String nombreTema;
     private String color;
     private Tema temaByIdColor;
     private Tema temaByIdTema;
     private double latitud;
     private double longitud;
     private String descripcion;
     private Marker marcador;
     private MapModel simpleModel;

     @PostConstruct
    public void init(){
         DefaultMapModel simpleModel = new DefaultMapModel();
         marcador = new Marker(new LatLng(23.382390, -102.291477),"Arrastrame");
         marcador.setDraggable(true);
         marcador.setClickable(true);
         simpleModel.addOverlay(marcador);
         this.latitud = marcador.getLatlng().getLat();
         this.longitud = marcador.getLatlng().getLng();
         this.catColor = new CatColor();
        
    }
    
    private void agregarMarcador(){
        Marcador m = new Marcador();
        MarcadorDAO mdao = new MarcadorDAO();
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
    
    public void agregarTema(){
        System.out.println(nombreTema);
        System.out.println(color);
        TemaDAO tdao = new TemaDAO();
        Tema aux = tdao.buscaPorNombre(nombreTema); 
        if(aux != null){
            Mensajes.error("Éste tema ya existe,inténte con otro");
        }else{
             Tema t = new Tema();
             ControladorSesion.UserLogged us = (ControladorSesion.UserLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("informador");
             UsuarioDAO udao = new UsuarioDAO();
             CatColorDAO cdao = new CatColorDAO();
             this.catColor.setDescripcion(color);
             cdao.save(catColor);
             Usuario usuario = udao.buscaPorCorreo(us.getCorreo());
             t.setNombreTema(this.nombreTema);
             t.setUsuario(usuario);
             t.setCatColor(catColor);
             this.temaByIdTema = t;
             this.temaByIdColor = t;
             tdao.save(t);
             this.agregarMarcador();
             
            
        }
           
        
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        return "/informador/agregarTema?faces-redirect=true";
    }
    
}
