/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Талалаев
 */
@Entity
@Table(name = "sk_v015")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SkV015.findAll", query = "SELECT s FROM SkV015 s"),
    @NamedQuery(name = "SkV015.findByRecid", query = "SELECT s FROM SkV015 s WHERE s.recid = :recid"),
    @NamedQuery(name = "SkV015.findByCode", query = "SELECT s FROM SkV015 s WHERE s.code = :code"),
    @NamedQuery(name = "SkV015.findByName", query = "SELECT s FROM SkV015 s WHERE s.name = :name"),
    @NamedQuery(name = "SkV015.findByHigh", query = "SELECT s FROM SkV015 s WHERE s.high = :high"),
    @NamedQuery(name = "SkV015.findByOkso", query = "SELECT s FROM SkV015 s WHERE s.okso = :okso"),
    @NamedQuery(name = "SkV015.findByDatebeg", query = "SELECT s FROM SkV015 s WHERE s.datebeg = :datebeg"),
    @NamedQuery(name = "SkV015.findByDateend", query = "SELECT s FROM SkV015 s WHERE s.dateend = :dateend")})
public class SkV015 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RECID")
    private Short recid;
    @Basic(optional = false)
    @Column(name = "CODE")
    private short code;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "HIGH")
    private short high;
    @Basic(optional = false)
    @Column(name = "OKSO")
    private short okso;
    @Basic(optional = false)
    @Column(name = "DATEBEG")
    @Temporal(TemporalType.DATE)
    private Date datebeg;
    @Column(name = "DATEEND")
    @Temporal(TemporalType.DATE)
    private Date dateend;
    @OneToMany(mappedBy = "prvs")
    private Collection<Sertif> sertifCollection;
    @OneToMany(mappedBy = "prvs")
    private Collection<SpisokVrachHist> spisokVrachHistCollection;
    @OneToMany(mappedBy = "prvs")
    private Collection<SpisokVrach> spisokVrachCollection;

    public SkV015() {
    }

    public SkV015(Short recid) {
        this.recid = recid;
    }

    public SkV015(Short recid, short code, String name, short high, short okso, Date datebeg) {
        this.recid = recid;
        this.code = code;
        this.name = name;
        this.high = high;
        this.okso = okso;
        this.datebeg = datebeg;
    }

    public Short getRecid() {
        return recid;
    }

    public void setRecid(Short recid) {
        this.recid = recid;
    }

    public short getCode() {
        return code;
    }

    public void setCode(short code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getHigh() {
        return high;
    }

    public void setHigh(short high) {
        this.high = high;
    }

    public short getOkso() {
        return okso;
    }

    public void setOkso(short okso) {
        this.okso = okso;
    }

    public Date getDatebeg() {
        return datebeg;
    }

    public void setDatebeg(Date datebeg) {
        this.datebeg = datebeg;
    }

    public Date getDateend() {
        return dateend;
    }

    public void setDateend(Date dateend) {
        this.dateend = dateend;
    }

    @XmlTransient
    public Collection<Sertif> getSertifCollection() {
        return sertifCollection;
    }

    public void setSertifCollection(Collection<Sertif> sertifCollection) {
        this.sertifCollection = sertifCollection;
    }

    @XmlTransient
    public Collection<SpisokVrachHist> getSpisokVrachHistCollection() {
        return spisokVrachHistCollection;
    }

    public void setSpisokVrachHistCollection(Collection<SpisokVrachHist> spisokVrachHistCollection) {
        this.spisokVrachHistCollection = spisokVrachHistCollection;
    }

    @XmlTransient
    public Collection<SpisokVrach> getSpisokVrachCollection() {
        return spisokVrachCollection;
    }

    public void setSpisokVrachCollection(Collection<SpisokVrach> spisokVrachCollection) {
        this.spisokVrachCollection = spisokVrachCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recid != null ? recid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkV015)) {
            return false;
        }
        SkV015 other = (SkV015) object;
        if ((this.recid == null && other.recid != null) || (this.recid != null && !this.recid.equals(other.recid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hibernate.tutorial.entity.SkV015[ recid=" + recid + " ]";
    }
    
}
