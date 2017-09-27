/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Талалаев
 */
@Entity
@Table(name = "sertif")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sertif.findAll", query = "SELECT s FROM Sertif s"),
    @NamedQuery(name = "Sertif.findByNSert", query = "SELECT s FROM Sertif s WHERE s.nSert = :nSert"),
    @NamedQuery(name = "Sertif.findByRegNum", query = "SELECT s FROM Sertif s WHERE s.regNum = :regNum"),
    @NamedQuery(name = "Sertif.findByDateEnd", query = "SELECT s FROM Sertif s WHERE s.dateEnd = :dateEnd"),
    @NamedQuery(name = "Sertif.findByDateadd", query = "SELECT s FROM Sertif s WHERE s.dateadd = :dateadd"),
    @NamedQuery(name = "Sertif.findById", query = "SELECT s FROM Sertif s WHERE s.id = :id")})
public class Sertif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "N_SERT")
    private String nSert;
    @Column(name = "REG_NUM")
    private String regNum;
    @Column(name = "DATE_END")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Column(name = "DATEADD")
    @Temporal(TemporalType.DATE)
    private Date dateadd;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "PRVS", referencedColumnName = "RECID")
    @ManyToOne
    private SkV015 prvs;
    @JoinColumn(name = "IDDOKT", referencedColumnName = "IDDOKT")
    @ManyToOne
    private SpisokVrach iddokt;

    public Sertif() {
    }

    public Sertif(Integer id) {
        this.id = id;
    }

    public String getNSert() {
        return nSert;
    }

    public void setNSert(String nSert) {
        this.nSert = nSert;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateadd() {
        return dateadd;
    }

    public void setDateadd(Date dateadd) {
        this.dateadd = dateadd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SkV015 getPrvs() {
        return prvs;
    }

    public void setPrvs(SkV015 prvs) {
        this.prvs = prvs;
    }

    public SpisokVrach getIddokt() {
        return iddokt;
    }

    public void setIddokt(SpisokVrach iddokt) {
        this.iddokt = iddokt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sertif)) {
            return false;
        }
        Sertif other = (Sertif) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hibernate.tutorial.entity.Sertif[ id=" + id + " ]";
    }
    
}
