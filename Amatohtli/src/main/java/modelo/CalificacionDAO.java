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
    
    public Calificacion buscaPorID(int idCalificacion){
        Calificacion calificacion = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Calificacion where id_calificacion = :idCalificacion";
            Query query = session.createQuery(hql);
            query.setParameter("idCalificacion", idCalificacion);
            calificacion = (Calificacion)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return calificacion;
    }
}
