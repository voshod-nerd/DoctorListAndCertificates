/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.daoImpl;
import com.hibernate.tutorial.dao.SpisokVrachDAO;
import com.hibernate.tutorial.entity.SpisokVrach;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */
@Repository("SpisokVrachRep")
public class SpisokVrachDAOImpl implements SpisokVrachDAO  {

   @Autowired
    private SessionFactory sessionFactory;

    

    public void save(SpisokVrach value) {
        Session session = this.getSessionFactory().getCurrentSession();
		session.persist(value);
    }

    public void update(SpisokVrach value) {
       Session session = this.getSessionFactory().getCurrentSession();
		session.update(value);
    }

    public void delete(SpisokVrach value) {
       Session session = this.getSessionFactory().getCurrentSession();
		SpisokVrach p = (SpisokVrach) session.load(SpisokVrach.class, value.getIddokt());
		if(null != p){
			session.delete(p);
		}
    }

    public List<SpisokVrach> getAllSpisokVrach() {
       Session session = this.getSessionFactory().getCurrentSession();
		List<SpisokVrach> listSpisokVrach = session.createQuery("from SpisokVrach").list();
		
		return listSpisokVrach;
    }

    public SpisokVrach create(SpisokVrach value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SpisokVrach findByIddokt(int value) {
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
