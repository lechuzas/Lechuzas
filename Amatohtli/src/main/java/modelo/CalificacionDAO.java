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
public class CalificacionDAO extends AbstractDAO<Calificacion>{
    public CalificacionDAO(){
        super();   
    }
    
    public void save(Calificacion calificacion){
      super.save(calificacion);
    }
    
    public void update(Calificacion calificacion){
      super.update(calificacion);
    }
    
    public void delete(Calificacion calificacion){
      super.delete(calificacion);
    }
    
    public Calificacion find(int Id){
      return super.find(Calificacion.class, Id);
    }
    
    public List<Calificacion> finAll(){
      return super.findAll(Calificacion.class);
    }
    
    
}
