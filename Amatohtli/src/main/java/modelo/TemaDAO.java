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
public class TemaDAO extends AbstractDAO<Tema>{
    
    public TemaDAO(){
        super();   
    }
    
    public void save(Tema tema){
      super.save(tema);
    }
    
    public void update(Tema tema){
      super.update(tema);
    }
    
    public void delete(Tema tema){
      super.delete(tema);
    }
    
    public Tema find(int Id){
      return super.find(Tema.class, Id);
    }
    
    public List<Tema> finAll(){
      return super.findAll(Tema.class);
    }
    
}
