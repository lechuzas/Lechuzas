package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import modelo.Pregunta;

/**
 *
 * @author felipe luna
 */

@ManagedBean
@RequestScoped
@ViewScoped
public class PreguntasBean implements Serializable{
    
    public static List<Pregunta> lista = new ArrayList();
    
    public static List<Pregunta> getLista() {
        return lista;
    }

    public static void setLista(List<Pregunta> lista) {
        PreguntasBean.lista = lista;
    }
    
    
    public List<Pregunta> generaLista(){
        List<Pregunta> l = new ArrayList();
        Pregunta p1 = new Pregunta();
        p1.setPregunta("¿Que es Amatohtli?");
        p1.setRespuesta("Un sitio web donde puedes compartir información relvante sobre lugares de interés");
        l.add(p1);
        
        Pregunta p2 = new Pregunta();
        p2.setPregunta("¿Que es un comentarista?");
        p2.setRespuesta("Cuando te registras como comentarista puedes hacer comentarios sobre los marcadores de tu interés, además puedes crear los tuyos, calificarlos, editarlos");
        l.add(p2);
        
        return l;
    }
    
    
    
}
