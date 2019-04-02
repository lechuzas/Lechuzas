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
    
    
    public Marcador buscaPorID(int idMarcador){
        Marcador marcador = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx =null;
        try{
            tx = session.beginTransaction();
            String hql = "from Marcador where id_marcador = :idMarcador";
            Query query = session.createQuery(hql);
            query.setParameter("idMarcador", idMarcador);
            marcador = (Marcador)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return marcador;
    }
}
