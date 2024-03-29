package com.TheDwarvesForge.ForgingCatalog.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "peddler")
public class Peddler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "peddlerid")
    private Integer peddlerID;
    
    @Column(name = "peddlername")
    private String peddlerName;
    
    
    
    @OneToMany(mappedBy = "peddler")
    private List<Acquisition> acquisitions;

    public Integer getPeddlerID() {
        return peddlerID;
    }

    public void setPeddlerID(Integer peddlerID) {
        this.peddlerID = peddlerID;
    }

    public String getPeddlerName() {
        return peddlerName;
    }

    public void setPeddlerName(String peddlerName) {
        this.peddlerName = peddlerName;
    }

    public List<Acquisition> getAcquisitions() {
        return acquisitions;
    }

    public void setAcquisitions(List<Acquisition> acquisitions) {
        this.acquisitions = acquisitions;
    }


    
    
    
    
    
}
