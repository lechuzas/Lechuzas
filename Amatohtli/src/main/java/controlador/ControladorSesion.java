/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import modelo.Usuario;
import modelo.UsuarioDAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fermat
 */
@ManagedBean
@SessionScoped
public class ControladorSesion implements Serializable{
    private String correo;
    private String contrasenia;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

   
    
    public String login(){
        UsuarioDAO udb = new UsuarioDAO();
        Usuario user = udb.buscaPorCorreoContrasenia(correo, contrasenia);
        FacesContext context = FacesContext.getCurrentInstance();
        if(user !=null){
            UserLogged u = new UserLogged(user.getNombre(),user.getCorreo(),user.getRol());
            if(true){
                
                context.getExternalContext().getSessionMap().put("user", u);
                return "/user/perfiluser?faces-redirect=true";
            }else{
                
                context.getExternalContext().getSessionMap().put("user", u);
                return "/superuser/perfilsuperuser?faces-redirect=true";
            }
        }
        Mensajes.error("NO hay usuarios con este correo "+this.correo);
        return "";
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }
    
    public class UserLogged implements Serializable{
        private String nombre;
        private String correo;
        private Integer rol;

        public UserLogged(String nombre, String correo, Integer rol) {
            this.nombre = nombre;
            this.correo = correo;
            this.rol = rol;
        }

        
        
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public Integer getRol() {
            return rol;
        }

        public void setRol(Integer rol) {
            this.rol = rol;
        }
        
        
    }
}
