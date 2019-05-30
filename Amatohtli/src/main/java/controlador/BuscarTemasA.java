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
import modelo.Comentario;
import modelo.ComentarioDAO;
import modelo.Marcador;
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
public class BuscarTemasA implements Serializable {
    private MapModel simpleModel;
    private List<Tema> lista_temas;
    private ArrayList<String> temas;
    private Tema tema;
    private String tema_elegido;
    private String guarda_elegido = "";

    @PostConstruct
    public void BuscarTemasA(){
        simpleModel = new DefaultMapModel();
        TemaDAO tdao = new TemaDAO();
        lista_temas = tdao.findAll();
        temas = new ArrayList();
        for(Tema t : lista_temas){
            temas.add(t.getNombreTema());
            
        }
        tema_elegido = "";
        
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }

    public List<Tema> getLista_temas() {
        return lista_temas;
    }

    public void setLista_temas(List<Tema> lista_temas) {
        this.lista_temas = lista_temas;
    }

    public ArrayList<String> getTemas() {
        return temas;
    }

    public void setTemas(ArrayList<String> temas) {
        this.temas = temas;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public String getTema_elegido() {
        return tema_elegido;
    }

    public void setTema_elegido(String tema_elegido) {
        this.tema_elegido = tema_elegido;
    }
    
    public String getGuarda_elegido() {
        return guarda_elegido;
    }

    public void setGuarda_elegido(String guarda_elegido) {
        this.guarda_elegido = guarda_elegido;
    }
    
    public List<Comentario> regresaListaComentarios(){
        List<Comentario> lista_com;
        List<Comentario> lista_completa = new ArrayList();
        System.out.println(this.guarda_elegido);
        if(!this.guarda_elegido.equals("")){
            TemaDAO tdao = new TemaDAO();
            ComentarioDAO cdao = new ComentarioDAO(); 
            tema = tdao.buscaPorNombre(this.guarda_elegido);
            for(Object o : tema.getMarcadorsForIdTema()){
                Marcador m = (Marcador)o;
                lista_com = cdao.buscaPorMarcador(m.getIdMarcador());
                for(Comentario c : lista_com){
                    lista_completa.add(c);
                }
            }
        }
        return lista_completa;
    }
    
    public void muestraMarcadores(){
        if(!this.tema_elegido.equals("")){
            TemaDAO tdao = new TemaDAO();
            tema = tdao.buscaPorNombre(tema_elegido);
            String color = "../" + tema.getCatColor().getImagen();
            simpleModel = new DefaultMapModel();
            for(Object o : tema.getMarcadorsForIdTema()){
                Marcador m = (Marcador)o;
                LatLng cord = new LatLng(m.getLatitud(),m.getLongitud());
                Marker marc = new Marker(cord,m.getDescripcion());
                marc.setIcon(color);
                simpleModel.addOverlay(marc);
                 
            }
            this.guarda_elegido = this.tema_elegido;
            this.tema_elegido = "";
        }else{
            Mensajes.error("No se ha elegido un tema, favor de seleccionar uno");
            
        }
        
    }
    
    public String muestraVentana(){
        return "/administrador/buscarTemasA?faces-redirect=true";
    }
    
}
