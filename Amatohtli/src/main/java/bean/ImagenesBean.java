package bean;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author felipe luna
 */
@ManagedBean
public class ImagenesBean {
    private List<String> images;
    
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 3; i++) {
            images.add("nosotros" + i + ".png");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}
 
