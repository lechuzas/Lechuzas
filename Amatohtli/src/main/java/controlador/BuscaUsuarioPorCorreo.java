/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 *
 * @author default
 */
@ManagedBean
@SessionScoped
public class BuscaUsuarioPorCorreo {
    private String correo;
    private Usuario resultado;
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Usuario getResultado() {
        return resultado;
    }

    public void setResultado(Usuario resultado) {
        this.resultado = resultado;
    }
    
    public String buscaPorCorreo(){
        if(correo.equals(""))
            return "";
        UsuarioDAO ubd = new UsuarioDAO();
        resultado =  ubd.buscaPorCorreo(correo);
        return "resultado?faces-redirect=true";
    }
}
