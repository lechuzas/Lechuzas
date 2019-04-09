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
import modelo.Marcador;
import modelo.MarcadorDAO;
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
public class VerMarcadoresTema {
    private MapModel simpleModel;
    private Marker marker;
    private String tema;
    
    @PostConstruct
    public void verMarcadoresTema(){
        simpleModel = new DefaultMapModel();
        System.out.println(tema);
        TemaDAO tdao = new TemaDAO();
        MarcadorDAO mdb = new MarcadorDAO();
        List<Marcador> marcadores = mdb.findAll();
        List<Tema> temas = tdao.findAll();
        for(Tema t : temas){
            if(t.getNombreTema().equals(tema)){
                System.out.println(tema);
                for(Marcador m :marcadores){
                    if(m.getTemaByIdTema().equals(t)){
                         LatLng cord = new LatLng(m.getLatitud(),m.getLongitud());
                         Marker marcador = new Marker(cord,m.getDescripcion());
                         simpleModel.addOverlay(marcador);
                        }
                }
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

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    public String muestraVentana(){
        return "/verMarcadoresTema?faces-redirect=true";
    }
}
