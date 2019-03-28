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
public class CatColorDAO extends AbstractDAO<CatColor>{
    public CatColorDAO(){
        super();   
    }
    
    public void save(CatColor catcolor){
      super.save(catcolor);
    }
    
    public void update(CatColor catcolor){
      super.update(catcolor);
    }
    
    public void delete(CatColor catcolor){
      super.delete(catcolor);
    }
    
    public CatColor find(int Id){
      return super.find(CatColor.class, Id);
    }
    
    public List<CatColor> finAll(){
      return super.findAll(CatColor.class);
    }
    
    
}
