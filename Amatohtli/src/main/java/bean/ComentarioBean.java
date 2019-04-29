package bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Comentario;
import modelo.ComentarioDAO;

/**
 *
 * @author felipe luna
 */
@ManagedBean
@RequestScoped

public class ComentarioBean {
    
    private static List<Comentario> lista = new ArrayList();

    public List<Comentario> getLista() {
        return lista;
    }

    public void setLista(List<Comentario> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void listar(){
        ComentarioDAO cdao = new ComentarioDAO();
        this.lista = cdao.finAll();
    }
        
    
}
