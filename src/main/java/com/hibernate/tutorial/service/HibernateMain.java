package com.hibernate.tutorial.service;

import com.hibernate.tutorial.dao.SertifDAO;
import com.hibernate.tutorial.dao.SkV015DAO;
import com.hibernate.tutorial.dao.SpisokVrachDAO;
import com.hibernate.tutorial.dao.SpisokVrachHistDAO;
import com.hibernate.tutorial.entity.Sertif;
import com.hibernate.tutorial.entity.SkV015;
import com.hibernate.tutorial.entity.SpisokVrach;
import com.hibernate.tutorial.entity.SpisokVrachHist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HibernateMain {

    @Autowired
    private SertifDAO sertifRepository;

    @Autowired
    private SpisokVrachDAO spisokVrachRepository;

    @Autowired
    private SkV015DAO spisokSkV015Repository;

    @Autowired
    private SpisokVrachHistDAO spisokVrachHistRepository;

    public List<Sertif> getSertifAll() {
        return sertifRepository.getAllSertif();
    }

    public void InsertSpisokVrachHist(SpisokVrachHist value) {
        spisokVrachHistRepository.save(value);
    }

    public void UpdateSpisokVrach(List<SpisokVrach> list) {
        for (SpisokVrach x : list) {
            spisokVrachRepository.update(x);
        }

    }
    
    
    public void UpdateSertificates(List<Sertif> list) {
        for (Sertif x : list) {
            sertifRepository.update(x);
        }

    }
    

    public List<SpisokVrach> getSpisokVrach() {
        return spisokVrachRepository.getAllSpisokVrach();
    }

    public List<SkV015> getSpisokSkV015() {
        return spisokSkV015Repository.getAllSkV015();
    }

    public boolean InsertSpisokVrach(SpisokVrach value) {
        spisokVrachRepository.save(value);
        return true;
    }

}
