/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Comentario;
import modelo.ComentarioDAO;

/**
 *
 * @author default
 */
@ManagedBean
@SessionScoped
public class BuscaComentarioPorID {
    private int id;
    private Comentario resultado;
    
    public String buscaPorID(){
        if(id == 0)
            return "";
        ComentarioDAO ubd = new ComentarioDAO();
        //resultado =  ubd.;
        return "resultado?faces-redirect=true";
     
    
    }
    
}
