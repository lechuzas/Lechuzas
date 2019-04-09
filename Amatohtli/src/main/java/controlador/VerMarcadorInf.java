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
public class VerMarcadorInf {
    private MapModel simpleModel;
    
    @PostConstruct
    public void VerMarcadorInf(){
        simpleModel = new DefaultMapModel();
        MarcadorDAO mdao = new MarcadorDAO();
        TemaDAO tdao = new TemaDAO();
        List<Tema> lista_temas = tdao.findAll();
        List<Marcador> marcadores = mdao.findAll();
        if(lista_temas != null){
            for(Tema t : lista_temas){
                ControladorSesion.UserLogged us = (ControladorSesion.UserLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("informador");
                if(t.getUsuario().getCorreo().equals(us.getCorreo())){
                    for(Marcador m : marcadores){
                        LatLng cord = new LatLng(m.getLatitud(),m.getLongitud());
                        Marker marc = new Marker(cord,m.getDescripcion());
                        simpleModel.addOverlay(marc);

                    }
                }
            }
        }
    }
    
    
    public MapModel getSimpleModel() {
        return simpleModel;
    }
    
}
