/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Comentario;
import modelo.ComentarioDAO;
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
        ComentarioDAO cdao = new ComentarioDAO();
        Marcador m = mdao.buscaMarcadorPorLatLng(lat, lng);
        List<Comentario> comentarios = cdao.buscaPorMarcador(m.getIdMarcador());
        if(comentarios != null){
            for(Comentario c : comentarios){
                cdao.delete(c);
            }
            mdao.delete(m);
            Mensajes.info("Se ha eliminado correctamente el marcador");
        }else{
            Mensajes.error("El marcador que desea eliminar no existe");
        }
        simpleModel = new DefaultMapModel();
        TemaDAO tdao = new TemaDAO();
        ControladorSesion.UserLogged us = (ControladorSesion.UserLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("informador");
        List<Tema> lista_temas = tdao.buscaPorInformador(us.getCorreo());
        for(Tema t : lista_temas){
            String color = "../" + t.getCatColor().getImagen();
            for(Object o : t.getMarcadorsForIdTema()){
                Marcador mm = (Marcador)o; 
                LatLng cord = new LatLng(mm.getLatitud(),mm.getLongitud());
                Marker marc = new Marker(cord,mm.getDescripcion());
                marc.setIcon(color);
                simpleModel.addOverlay(marc);
            }
        }
    }
           
    
    public String muestraVentana(){
        return "/informador/eliminaMarcador?faces-redirect=true";
    }
    
}
