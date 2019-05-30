/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author fermat
 */

@ManagedBean
@RequestScoped
@ViewScoped
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
    
    public Comentario buscaPorID(int idComentario){
        Comentario comentario = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Comentario where id_comentario = :idComentario";
            Query query = session.createQuery(hql);
            query.setParameter("idComentario", idComentario);
            comentario = (Comentario)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return comentario;
    }
    
    public Comentario buscaPorAtributos(int idMarcador, String correo, String descripcion, int idCalificacion){
        Comentario comentario = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Comentario where id_marcador = :idMarcador and correo = :correo and descripcion = :descripcion and id_calificacion = :idCalificacion";
            Query query = session.createQuery(hql);
            query.setParameter("idMarcador", idMarcador);
            query.setParameter("correo", correo);
            query.setParameter("descripcion", descripcion);
            query.setParameter("idCalificacion", idCalificacion);
            comentario = (Comentario)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return comentario;
    }
    
    
    public List<Comentario> buscaPorMarcador(int idMarcador){
        List<Comentario> listacom = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Comentario where id_marcador = :idMarcador";
            Query query = session.createQuery(hql);
            query.setParameter("idMarcador", idMarcador);
            listacom = (List<Comentario>) query.list();
            tx.commit();
        }catch(HibernateException e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listacom;
    }
    
}
