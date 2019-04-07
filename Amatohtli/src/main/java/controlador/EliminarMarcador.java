/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Marcador;
import modelo.MarcadorDAO;
import org.primefaces.PrimeFaces;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.Marker;

/**
 *
 * @author ailyn
 */
@ManagedBean
@ViewScoped
public class EliminarMarcador {
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
    }
    
    public String muestraVentana(){
        return "/informador/eliminaMarcadores?faces-redirect=true";
    }
    
}
