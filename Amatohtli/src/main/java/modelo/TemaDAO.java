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
    
    public List<Tema> findAll(){
      return super.findAll(Tema.class);
    }
    
    public Tema buscaPorID(int idTema){
        Tema tema = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Tema where id_tema = :idTema";
            Query query = session.createQuery(hql);
            query.setParameter("idTema", idTema);
            tema = (Tema)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return tema;
    }
   
    
    public Tema buscaPorNombre(String nombre){
        Tema tema = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Tema where nombreTema = :nombre";
            Query query = session.createQuery(hql);
            query.setParameter("nombre", nombre);
            tema = (Tema)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return tema;
        
    }
    
    public List<Tema> buscaPorInformador(String correo){
        List<Tema> temas = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Tema where usuario.correo = :correo";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            temas = (List<Tema>)query.list();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return temas;
        
    }
}
