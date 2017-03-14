/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.dao;

import com.hibernate.tutorial.entity.SkV015;
import java.util.List;

/**
 *
 * @author 
 */
public interface SkV015DAO {
     void save(SkV015 stock);
	void update(SkV015 value);
	void delete(SkV015 value);
        List<SkV015> getAllSkV015();
        SkV015 create(SkV015 value);
	SkV015 findByIddokt(int value);
}
