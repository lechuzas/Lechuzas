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
public class MarcadorDAO extends AbstractDAO<Marcador>{
    public MarcadorDAO(){
        super();
    }
    
    public void save(Marcador marcador){
      super.save(marcador);
    }
    
    public void update(Marcador marcador){
      super.update(marcador);
    }
    
    public void delete(Marcador marcador){
      super.delete(marcador);
    }
    
    public Marcador find(int Id){
      return super.find(Marcador.class, Id);
    }
    
    public List<Marcador> finAll(){
      return super.findAll(Marcador.class);
    }
}
