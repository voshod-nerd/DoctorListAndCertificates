/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.dao;

import com.hibernate.tutorial.entity.Sertif;
import java.util.List;

/**
 *
 * @author 
 */
public interface SertifDAO {
        void save(Sertif stock);
	void update(Sertif value);
	void delete(Sertif value);
        List<Sertif> getAllSertif();
        Sertif create(Sertif value);
        
	Sertif findByIddokt(int value);
}
