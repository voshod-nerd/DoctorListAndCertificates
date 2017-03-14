/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.dao;


import com.hibernate.tutorial.entity.SpisokVrachHist;
import java.util.List;

/**
 *
 * @author 
 */
public interface SpisokVrachHistDAO {
      void save(SpisokVrachHist stock);
	void update(SpisokVrachHist value);
	void delete(SpisokVrachHist value);
        List<SpisokVrachHist> getAllSpisokVrachHist();
        SpisokVrachHist create(SpisokVrachHist value);
        
	SpisokVrachHist findByIddokt(int value);
}
