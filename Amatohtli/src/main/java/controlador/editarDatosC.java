    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Tema;
import modelo.TemaDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.Marker;

/**
 *
 * @author fermat
 */
@ManagedBean
public class editarDatosC {
    private String correo;
    private String contrasenia;
    private String nombreUsuario;
    private String nombre;
    private String paterno;
    private Integer rol;

    private String contraseniaN;
    private String nombreUsuarioN;
    private String nombreN;
    private String paternoN;

    
     @PostConstruct
    public void init(){
        
        UsuarioDAO dao = new UsuarioDAO();
        ControladorSesion.UserLogged us = (ControladorSesion.UserLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("comentarista");
        Usuario usuario=new Usuario();
        usuario = dao.buscaPorCorreo(us.getCorreo());
        contrasenia=usuario.getContrasenia();
        nombreUsuario=usuario.getNombreUsuario();
        nombre=usuario.getNombre();
        paterno=usuario.getPaterno();
        correo=usuario.getCorreo();
        rol=usuario.getRol();
        contraseniaN="";
        nombreUsuarioN="";
        nombreN="";
        paternoN="";
        
    }
    
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getContraseniaN() {
        return contraseniaN;
    }

    public void setContraseniaN(String contraseniaN) {
        this.contraseniaN = contraseniaN;
    }

    public String getNombreUsuarioN() {
        return nombreUsuarioN;
    }

    public void setNombreUsuarioN(String nombreUsuarioN) {
        this.nombreUsuarioN = nombreUsuarioN;
    }

    public String getNombreN() {
        return nombreN;
    }

    public void setNombreN(String nombreN) {
        this.nombreN = nombreN;
    }

    public String getPaternoN() {
        return paternoN;
    }

    public void setPaternoN(String paternoN) {
        this.paternoN = paternoN;
    }

    
    
    public void EditarInfo(){
            Usuario usr= new Usuario();
            UsuarioDAO dao=new UsuarioDAO();
            
            if (!contraseniaN.equals("")){
                usr.setContrasenia(contraseniaN);
            }else{
                usr.setContrasenia(contrasenia);
            }
            
            
            if (!paternoN.equals("")){
                usr.setPaterno(paternoN);
            }else{
                usr.setPaterno(paterno);
            }
            
            
            if (!nombreN.equals("")){
                 usr.setNombre(nombreN);
            }else{
                usr.setNombre(nombre);
            }
            
            if (!nombreUsuarioN.equals("")){
                usr.setNombreUsuario(nombreUsuarioN);
            }else{
                usr.setNombreUsuario(nombreUsuario);
            }
            
           
            usr.setRol(rol);
            usr.setCorreo(correo);
          
            if (!contraseniaN.equals("")|| !paternoN.equals("")|| !nombreUsuarioN.equals("") || !nombreN.equals("")  ){
                dao.update(usr);
  
                init();
                Mensajes.info("Dato(s) actualizado(s)"); 

                
            }else{
                Mensajes.error("No hay datos por actualizar");
            }

    }

    
}
