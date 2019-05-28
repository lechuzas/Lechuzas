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
    private String tema_elegido;
    private ArrayList<String> lista_temas;
    
    @PostConstruct
    public void BuscarTemasInf(){
        simpleModel = new DefaultMapModel();
        MarcadorDAO mdao = new MarcadorDAO();
        TemaDAO tdao = new TemaDAO();
        ControladorSesion.UserLogged us = (ControladorSesion.UserLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("informador");
        temas = tdao.buscaPorInformador(us.getCorreo());
        lista_temas = new ArrayList<String>();
        for(Tema t : temas){
            lista_temas.add(t.getNombreTema());
        }
        tema_elegido = "";
    }

    
    
    public void muestraMarcadores(){
        TemaDAO tdao = new TemaDAO();
        tema = tdao.buscaPorNombre(tema_elegido);
        if(!this.tema_elegido.equals("")){
             simpleModel = new DefaultMapModel();
             MarcadorDAO mdao = new MarcadorDAO();
             String color = "../" + tema.getCatColor().getImagen();
             for(Object o : this.tema.getMarcadorsForIdTema()){
                 Marcador m = (Marcador)o;
                 LatLng cord = new LatLng(m.getLatitud(),m.getLongitud());
                 Marker marc = new Marker(cord,m.getDescripcion());
                 marc.setIcon(color);
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

    

    public String getTema_elegido() {
        return tema_elegido;
    }

    public void setTema_elegido(String tema_elegido) {
        this.tema_elegido = tema_elegido;
    }

    public ArrayList<String> getLista_temas() {
        return lista_temas;
    }

    public void setLista_temas(ArrayList<String> lista_temas) {
        this.lista_temas = lista_temas;
    }
    
    
    
    public String muestraVentana(){
        return "/informador/buscarTemasInf?faces-redirect=true";
    }
    
    
    }
    
