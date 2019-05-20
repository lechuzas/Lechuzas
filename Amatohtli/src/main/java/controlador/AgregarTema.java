/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
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
         marcador = new Marker(new LatLng(23.382390, -102.291477),"Arrástrame");
         marcador.setDraggable(true);
         marcador.setClickable(true);
         simpleModel.addOverlay(marcador);
         this.latitud = marcador.getLatlng().getLat();
         this.longitud = marcador.getLatlng().getLng();
         this.catColor = new CatColor();
         this.nombreTema = "";
        
    }
    
    private void creaIcono(String color,int largo,int ancho){
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
        s+="<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n";
			s+="<svg width=\""+largo+"\" height=\""+ancho+"\" version=\"1.1\" id=\"Capa_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\" style=\"enable-background:new 0 0 512 512;\" xml:space=\"preserve\">\n<g>\n";
        int x =largo/2;
        int y = (ancho/3);
        int radio = ((largo+ancho)/2)/4;

        int[] p ={x-radio,y,x+radio,y,x,(y*3)};
        s+= creaPoligono(p,"#"+color);
        s+=creaCirculo(x,y,radio,"#"+color,true);
        s+=creaCirculo(x,y,radio/2,"black",true);

        s+="</g>\n"+"</svg>";
        
        try {
             ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String destino = (servletContext.getRealPath("/"))+"resources/img/";
            System.out.println(destino);
            FileOutputStream fileOut = new FileOutputStream(new File(destino + color+".svg"));
            OutputStreamWriter osOut = new OutputStreamWriter(fileOut);
            BufferedWriter out = new BufferedWriter(osOut);
            out.write(s);
            out.close();
        } catch (IOException ioe) {
            System.out.println("No pude guardar en el archivo" );
//            System.exit(1);
        }


    }

    private String creaCirculo(int x ,int y , int r,String color,boolean stroke){
        String s = stroke ? "<circle cx=\""+x+"\" cy=\"" +y+"\"  r=\"" + r + "\" stroke=\"white\" stroke-width=\"1\"  fill=\"" + color + "\" />\n" : "<circle cx=\""+x+"\" cy=\"" +y+"\"  r=\"" + r + "\" stroke=\"black\" stroke-width=\"0\"  fill=\"" + color + "\" />\n";
        return  s;

    }

    private String creaPoligono(int[] puntos,String color){
        String p = "";
        if(puntos.length%2 != 0)
          return "Los puntos estan mal";
        for(int i=0;i<puntos.length;i+=2){
          p+=puntos[i]+","+puntos[i+1]+" ";
        }
        return "<polygon points=\""+p+"\" \n style=\" fill:" +color+";stroke:black;stroke-width:1;\" /> \n";
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
        if(nombreTema.equals(""))
            Mensajes.error("No ha escrito un tema, favor de insertar uno");
        
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
             this.creaIcono(color, 50, 50);
             this.catColor.setImagen("resources/img/"+color+".svg");
             cdao.save(catColor);
             Usuario usuario = udao.buscaPorCorreo(us.getCorreo());
             t.setNombreTema(this.nombreTema);
             t.setUsuario(usuario);
             t.setCatColor(catColor);
             this.temaByIdTema = t;
             this.temaByIdColor = t;
             tdao.save(t);
             this.agregarMarcador();
             this.nombreTema = "";
             this.descripcion = "";
             
            
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
