/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ControladorSesion;
import java.util.List;
import javax.faces.context.FacesContext;
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
    @Override
    public void save(Marcador marcador){
      super.save(marcador);
    }
    @Override
    public void update(Marcador marcador){
      super.update(marcador);
    }
    @Override
    public void delete(Marcador marcador){
      super.delete(marcador);
    }
    
    public Marcador find(int Id){
      return super.find(Marcador.class, Id);
    }
    
    public List<Marcador> findAll(){
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
    
     public Marcador buscaMarcadorPorLatLng(double lat,double lng) {
        Marcador m = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Marcador where longitud = :lng and latitud = :lat";
            Query query = session.createQuery(hql);
            query.setParameter("lng", lng);
            query.setParameter("lat", lat);
            m = (Marcador)query.uniqueResult();
            tx.commit();
            
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();

        }finally{
            session.close();
        }
        return m;
    
    }
     public List<Marcador> buscaPorTema(String tema){
        TemaDAO tdao = new TemaDAO();
        List<Marcador> m = null;
        ControladorSesion.UserLogged us = (ControladorSesion.UserLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("informador");
        List<Tema> lista_temas = tdao.findAll();
        Tema principal = null;
        for(Tema t : lista_temas){
            if(tema.equals(t.getNombreTema()) && t.getUsuario().getCorreo().equals(us.getCorreo())){
                principal = t;
            }
               
        }
        int t_id = principal.getIdTema();
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Marcador m where m.temaByIdTema = :t_id";
            Query query = session.createQuery(hql);
            query.setParameter("temaByIdTema", t_id);
            m = (List<Marcador>)query.list();
            tx.commit();
            
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();

        }finally{
            session.close();
        }
        return m;
    }
}
