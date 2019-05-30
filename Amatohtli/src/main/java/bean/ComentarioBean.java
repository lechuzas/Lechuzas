package bean;

import controlador.Mensajes;
import controlador.VerMarcadorC;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import modelo.Comentario;
import modelo.ComentarioDAO;
import org.primefaces.event.RowEditEvent;



/**
 *
 * @author felipe luna
 */
@ManagedBean
@RequestScoped
@ViewScoped

public class ComentarioBean implements Serializable {

    public Comentario selectC;
    private static List<Comentario> lista = new ArrayList();

    public Comentario getSelectC() {
        return selectC;
    }

    public void setSelectC(Comentario selectC) {
        this.selectC = selectC;
    }
   
    public List<Comentario> getLista() {
        return lista;
    }

    public static void setLista(List<Comentario> lista) {
        ComentarioBean.lista = lista;
    }
    
    public static void update(){
        if (VerMarcadorC.select != null){
            ComentarioDAO comentarioDAO = new ComentarioDAO();
            ComentarioBean.lista = comentarioDAO.buscaPorMarcador(VerMarcadorC.select.getIdMarcador());
        }
    }
    
    
    public void onRowEdit(RowEditEvent event) {
        try{
            this.selectC = (Comentario) event.getObject();
            ComentarioDAO cDAO = new ComentarioDAO();
            cDAO.update(this.selectC);
            Mensajes.info("El comentario se editó correctamente");
        }catch(Exception e){
            Mensajes.error("Ocurrió un error al editar en comentario");
        }
    }
    
    
    
}
