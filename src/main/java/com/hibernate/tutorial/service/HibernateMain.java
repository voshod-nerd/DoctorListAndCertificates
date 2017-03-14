package com.hibernate.tutorial.service;

import com.hibernate.tutorial.dao.SertifDAO;
import com.hibernate.tutorial.dao.SkV015DAO;
import com.hibernate.tutorial.dao.SpisokVrachDAO;
import com.hibernate.tutorial.entity.Sertif;
import com.hibernate.tutorial.entity.SkV015;
import com.hibernate.tutorial.entity.SpisokVrach;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HibernateMain {

    @Autowired
    private SertifDAO sertifRep;

    @Autowired
    private SpisokVrachDAO spisokVrachRepository;
    
    @Autowired
    private SkV015DAO spisokSkV015Repository;

    public List<Sertif> getSertifAll() {
        return sertifRep.getAllSertif();
    }
    
    public void UpdateSpisokVrach(List<SpisokVrach> list){
    for (SpisokVrach x :list) {
    spisokVrachRepository.update(x);
    }
    
    }
    

    public List<SpisokVrach> getSpisokVrach() {
        return spisokVrachRepository.getAllSpisokVrach();
    }
    
    public List<SkV015> getSpisokSkV015() {
        return spisokSkV015Repository.getAllSkV015();
    }
    
    public boolean InputDoctorToDB(SpisokVrach value) {
    spisokVrachRepository.save(value);
    return true;
    }
    
    
}
