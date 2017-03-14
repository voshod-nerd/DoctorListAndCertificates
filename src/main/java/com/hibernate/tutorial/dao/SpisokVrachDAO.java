/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.dao;

import com.hibernate.tutorial.entity.SpisokVrach;
import java.util.List;

/**
 *
 * @author 
 */
public interface SpisokVrachDAO {
        void save(SpisokVrach stock);
	void update(SpisokVrach value);
	void delete(SpisokVrach value);
        List<SpisokVrach> getAllSpisokVrach();
        SpisokVrach create(SpisokVrach value);
        
	SpisokVrach findByIddokt(int value);
}
