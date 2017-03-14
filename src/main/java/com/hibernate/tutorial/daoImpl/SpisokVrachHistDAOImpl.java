/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.daoImpl;

import com.hibernate.tutorial.dao.SpisokVrachHistDAO;
import com.hibernate.tutorial.entity.SpisokVrach;
import com.hibernate.tutorial.entity.SpisokVrachHist;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */
@Repository("SpisokVrachHistDao")
public class SpisokVrachHistDAOImpl implements SpisokVrachHistDAO {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void save(SpisokVrachHist value) {
         Session session = this.getSessionFactory().getCurrentSession();
		session.persist(value);
    }

    @Override
    public void update(SpisokVrachHist value) {
         Session session = this.getSessionFactory().getCurrentSession();
		session.update(value);
    }

    @Override
    public void delete(SpisokVrachHist value) {
        Session session = this.getSessionFactory().getCurrentSession();
		SpisokVrachHist p = (SpisokVrachHist) session.load(SpisokVrachHist.class, value.getIddokt());
		if(null != p){
			session.delete(p);
		}
    }

    @Override
    public List<SpisokVrachHist> getAllSpisokVrachHist() {
         Session session = this.getSessionFactory().getCurrentSession();
		List<SpisokVrachHist> list = session.createQuery("from SpisokVrachHist").list();
		
		return list;
    }

   

    @Override
    public SpisokVrachHist findByIddokt(int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private SessionFactory getSessionFactory() {
       return this.sessionFactory;
    }
    
     /**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    
}
