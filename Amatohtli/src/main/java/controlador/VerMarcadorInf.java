/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Marcador;
import modelo.Tema;
import modelo.TemaDAO;
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
public class VerMarcadorInf implements Serializable{
    private MapModel simpleModel;
    private Marker marker;
    
    @PostConstruct
    public void VerMarcadorInf(){
        simpleModel = new DefaultMapModel();
        TemaDAO tdao = new TemaDAO();
         ControladorSesion.UserLogged us = (ControladorSesion.UserLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("informador");
        List<Tema>lista_temas = tdao.buscaPorInformador(us.getCorreo());
        //temas = new ArrayList();
        for(Tema t : lista_temas){
            String color = "../" + t.getCatColor().getImagen();
            for(Object o : t.getMarcadorsForIdTema()){
                Marcador m = (Marcador)o;
                LatLng cord = new LatLng(m.getLatitud(),m.getLongitud());
                Marker marcador = new Marker(cord,m.getDescripcion());
                //marcador.setIcon(color);
                simpleModel.addOverlay(marcador); 
            }
        }
    }
    
    
    public MapModel getSimpleModel() {
        return simpleModel;
    }
    
     public void onMarkerSelect(OverlaySelectEvent event) {
       marker =(Marker) event.getOverlay();
       
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }
     
     
    
}
