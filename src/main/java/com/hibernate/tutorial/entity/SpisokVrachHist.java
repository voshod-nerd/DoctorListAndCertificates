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
@Table(name = "spisok_vrach_hist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpisokVrachHist.findAll", query = "SELECT s FROM SpisokVrachHist s"),
    @NamedQuery(name = "SpisokVrachHist.findByIddokt", query = "SELECT s FROM SpisokVrachHist s WHERE s.iddokt = :iddokt"),
    @NamedQuery(name = "SpisokVrachHist.findByLpukod", query = "SELECT s FROM SpisokVrachHist s WHERE s.lpukod = :lpukod"),
    @NamedQuery(name = "SpisokVrachHist.findByIdPodr", query = "SELECT s FROM SpisokVrachHist s WHERE s.idPodr = :idPodr"),
    @NamedQuery(name = "SpisokVrachHist.findByIdOtd", query = "SELECT s FROM SpisokVrachHist s WHERE s.idOtd = :idOtd"),
    @NamedQuery(name = "SpisokVrachHist.findByFam", query = "SELECT s FROM SpisokVrachHist s WHERE s.fam = :fam"),
    @NamedQuery(name = "SpisokVrachHist.findByIm", query = "SELECT s FROM SpisokVrachHist s WHERE s.im = :im"),
    @NamedQuery(name = "SpisokVrachHist.findByOt", query = "SELECT s FROM SpisokVrachHist s WHERE s.ot = :ot"),
    @NamedQuery(name = "SpisokVrachHist.findByDokt", query = "SELECT s FROM SpisokVrachHist s WHERE s.dokt = :dokt"),
    @NamedQuery(name = "SpisokVrachHist.findByDateVn", query = "SELECT s FROM SpisokVrachHist s WHERE s.dateVn = :dateVn"),
    @NamedQuery(name = "SpisokVrachHist.findByDateUv", query = "SELECT s FROM SpisokVrachHist s WHERE s.dateUv = :dateUv"),
    @NamedQuery(name = "SpisokVrachHist.findByDateRed", query = "SELECT s FROM SpisokVrachHist s WHERE s.dateRed = :dateRed")})
public class SpisokVrachHist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDDOKT")
    private Integer iddokt;
    @Column(name = "LPUKOD")
    private Integer lpukod;
    @Column(name = "ID_PODR")
    private Integer idPodr;
    @Column(name = "ID_OTD")
    private Integer idOtd;
    @Column(name = "FAM")
    private String fam;
    @Column(name = "IM")
    private String im;
    @Column(name = "OT")
    private String ot;
    @Column(name = "DOKT")
    private Boolean dokt;
    @Column(name = "DATE_VN")
    @Temporal(TemporalType.DATE)
    private Date dateVn;
    @Column(name = "DATE_UV")
    @Temporal(TemporalType.DATE)
    private Date dateUv;
    @Column(name = "DATE_RED")
    @Temporal(TemporalType.DATE)
    private Date dateRed;
    @JoinColumn(name = "PRVS", referencedColumnName = "RECID")
    @ManyToOne
    private SkV015 prvs;

    public SpisokVrachHist() {
    }

    public SpisokVrachHist(Integer iddokt) {
        this.iddokt = iddokt;
    }

    public Integer getIddokt() {
        return iddokt;
    }

    public void setIddokt(Integer iddokt) {
        this.iddokt = iddokt;
    }

    public Integer getLpukod() {
        return lpukod;
    }

    public void setLpukod(Integer lpukod) {
        this.lpukod = lpukod;
    }

    public Integer getIdPodr() {
        return idPodr;
    }

    public void setIdPodr(Integer idPodr) {
        this.idPodr = idPodr;
    }

    public Integer getIdOtd() {
        return idOtd;
    }

    public void setIdOtd(Integer idOtd) {
        this.idOtd = idOtd;
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public String getOt() {
        return ot;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }

    public Boolean getDokt() {
        return dokt;
    }

    public void setDokt(Boolean dokt) {
        this.dokt = dokt;
    }

    public Date getDateVn() {
        return dateVn;
    }

    public void setDateVn(Date dateVn) {
        this.dateVn = dateVn;
    }

    public Date getDateUv() {
        return dateUv;
    }

    public void setDateUv(Date dateUv) {
        this.dateUv = dateUv;
    }

    public Date getDateRed() {
        return dateRed;
    }

    public void setDateRed(Date dateRed) {
        this.dateRed = dateRed;
    }

    public SkV015 getPrvs() {
        return prvs;
    }

    public void setPrvs(SkV015 prvs) {
        this.prvs = prvs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddokt != null ? iddokt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpisokVrachHist)) {
            return false;
        }
        SpisokVrachHist other = (SpisokVrachHist) object;
        if ((this.iddokt == null && other.iddokt != null) || (this.iddokt != null && !this.iddokt.equals(other.iddokt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hibernate.tutorial.entity.SpisokVrachHist[ iddokt=" + iddokt + " ]";
    }
    
}
