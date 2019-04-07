/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    
    public List<Usuario> findAll(){
      return super.findAll(Usuario.class);
    }
    

    public Usuario buscaPorCorreoContrasenia(String correo,String contrasenia){
        Usuario u =null;
        Session session = this.sessionFactory.openSession();
        Transaction tx =null;
        try{
            tx = session.beginTransaction();
            String hql = "from Usuario where correo = :correo and contrasenia = :contrasenia";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            query.setParameter("contrasenia",contrasenia);
            u = (Usuario)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return u;
    }
    
    
    public Usuario buscaPorCorreo(String correo){
        Usuario u = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Usuario where correo = :correo";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            u = (Usuario)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return u;
    }

}
