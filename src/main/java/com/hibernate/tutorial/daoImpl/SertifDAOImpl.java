/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.daoImpl;

import com.hibernate.tutorial.dao.SertifDAO;
import com.hibernate.tutorial.entity.Sertif;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author 
 */

@Repository("SertifDao")
public class SertifDAOImpl implements SertifDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    

    @Override
    public void save(Sertif value) {
        Session session = this.getSessionFactory().getCurrentSession();
		session.persist(value);
    }

    @Override
    public void update(Sertif value) {
       Session session = this.getSessionFactory().getCurrentSession();
		session.update(value);
    }

    @Override
    public void delete(Sertif value) {
       Session session = this.getSessionFactory().getCurrentSession();
		Sertif p = (Sertif) session.load(Sertif.class, value.getId());
		if(null != p){
			session.delete(p);
		}
    }

    @Override
    public List<Sertif> getAllSertif() {
       Session session = this.getSessionFactory().getCurrentSession();
		List<Sertif> listSertif = session.createQuery("from Sertif").list();
		
		return listSertif;
    }

    @Override
    public Sertif create(Sertif value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sertif findByIddokt(int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
