/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.daoImpl;

import com.hibernate.tutorial.dao.SkV015DAO;
import com.hibernate.tutorial.entity.SkV015;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */
@Repository("SkV015Dao")
public class SkV015DAOImpl implements SkV015DAO {
     
    
    @Autowired
    private SessionFactory sessionFactory;

    

    @Override
    public void save(SkV015 value) {
        Session session = this.getSessionFactory().getCurrentSession();
		session.persist(value);
    }

    @Override
    public void update(SkV015 value) {
       Session session = this.getSessionFactory().getCurrentSession();
		session.update(value);
    }

    @Override
    public void delete(SkV015 value) {
       Session session = this.getSessionFactory().getCurrentSession();
		SkV015 p = (SkV015) session.load(SkV015.class, value.getRecid());
		if(null != p){
			session.delete(p);
		}
    }

    @Override
    public List<SkV015> getAllSkV015() {
       Session session = this.getSessionFactory().getCurrentSession();
		List<SkV015> listSkV015 = session.createQuery("from SkV015").list();
		
		return listSkV015;
    }

    @Override
    public SkV015 create(SkV015 value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SkV015 findByIddokt(int value) {
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
