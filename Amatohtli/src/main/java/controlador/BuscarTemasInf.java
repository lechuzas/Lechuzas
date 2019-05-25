/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Marcador;
import modelo.MarcadorDAO;
import modelo.Tema;
import modelo.TemaDAO;
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
public class BuscarTemasInf implements Serializable {
    private MapModel simpleModel;
    private List<Tema> temas;
    private Tema tema;
    private Tema tema_elegido;
    
    @PostConstruct
    public void BuscarTemasInf(){
        simpleModel = new DefaultMapModel();
        MarcadorDAO mdao = new MarcadorDAO();
        TemaDAO tdao = new TemaDAO();
        ControladorSesion.UserLogged us = (ControladorSesion.UserLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("informador");
        temas = tdao.buscaPorInformador(us.getCorreo());
        tema_elegido = null;
    }

    
    
    public void muestraMarcadores(){
        if(this.tema_elegido != null){
             simpleModel = new DefaultMapModel();
             MarcadorDAO mdao = new MarcadorDAO();
             for(Object o : this.tema.getMarcadorsForIdTema()){
                 Marcador m = (Marcador)o;
                 LatLng cord = new LatLng(m.getLatitud(),m.getLongitud());
                 Marker marc = new Marker(cord,m.getDescripcion());
                 simpleModel.addOverlay(marc);      
             }
             this.tema_elegido = null;
        }else{
            Mensajes.error("No se ha elegido un tema, favor de seleccionar uno");
        }
       
    }
     

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }

   
    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    

    public Tema getTema_elegido() {
        return tema_elegido;
    }

    public void setTema_elegido(Tema tema_elegido) {
        this.tema_elegido = tema_elegido;
    }
    
    
    public String muestraVentana(){
        return "/informador/buscarTemasInf?faces-redirect=true";
    }
    
    
    }
    
