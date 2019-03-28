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
public class UsuarioDAO extends AbstractDAO<Usuario>{
    public UsuarioDAO(){
        super();   
    }
    
    public void save(Usuario usuario){
      super.save(usuario);
    }
    
    public void update(Usuario usuario){
      super.update(usuario);
    }
    
    public void delete(Usuario usuario){
      super.delete(usuario);
    }
    
    public Usuario find(int Id){
      return super.find(Usuario.class, Id);
    }
    
    public List<Usuario> finAll(){
      return super.findAll(Usuario.class);
    }
    
}
