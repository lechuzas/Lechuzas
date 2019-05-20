/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Marcador;
import modelo.MarcadorDAO;
import modelo.Tema;
import modelo.TemaDAO;
import org.primefaces.PrimeFaces;
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
public class EliminarMarcador {
    private MapModel simpleModel;
    private double lat;
    private double lng;
    private Marker marcador;
     
     public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng; 
    }
    

    public void onMarkerSelect(OverlaySelectEvent event) {
        marcador =(Marker) event.getOverlay();
        this.lat = marcador.getLatlng().getLat();
        this.lng = marcador.getLatlng().getLng();
        PrimeFaces current = PrimeFaces.current();
        current.executeScript("PF('dlg').show();");
       
    }
    
    public void eliminaMarcador(){
        MarcadorDAO mdao = new MarcadorDAO();
        Marcador m = mdao.buscaMarcadorPorLatLng(lat, lng);
        if(m != null){
            mdao.delete(m);
            Mensajes.info("Se ha eliminado correctamente el marcador");
        }else{
            Mensajes.error("El marcador que desea eliminar no existe");
        }
        simpleModel = new DefaultMapModel();
        TemaDAO tdao = new TemaDAO();
        List<Tema> lista_temas = tdao.findAll();
        List<Marcador> marcadores = mdao.findAll();
        if(lista_temas != null){
            for(Tema t : lista_temas){
                ControladorSesion.UserLogged us = (ControladorSesion.UserLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("informador");
                if(t.getUsuario().getCorreo().equals(us.getCorreo())){
                    for(Marcador mm : marcadores){
                        if(mm.getTemaByIdTema().getIdTema() == t.getIdTema()){
                             LatLng cord = new LatLng(mm.getLatitud(),mm.getLongitud());
                             Marker marc = new Marker(cord,mm.getDescripcion());
                             simpleModel.addOverlay(marc);

                        }
                          
                    }
                }
            }
        }
    }
    
    public String muestraVentana(){
        return "/informador/eliminaMarcador?faces-redirect=true";
    }
    
}
