/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author fermat
 */
public class ComentarioDAO extends AbstractDAO<Comentario>{
    public ComentarioDAO(){
        super();   
    }
    
    public void save(Comentario comentario){
      super.save(comentario);
    }
    
    public void update(Comentario comentario){
      super.update(comentario);
    }
    
    public void delete(Comentario comentario){
      super.delete(comentario);
    }
    
    public Comentario find(int Id){
      return super.find(Comentario.class, Id);
    }
    
    public List<Comentario> finAll(){
      return super.findAll(Comentario.class);
    }
    
}
