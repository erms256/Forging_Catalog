/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TheDwarvesForge.ForgingCatalog.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "acquisition")
public class Acquisition {
    @EmbeddedId
    private AcquisitionPK acquisitionID;
    
    private Integer stock;
    
    @ManyToOne
    @JoinColumn(name= "peddlerid", insertable = false, updatable = false)
    private Peddler peddler;
    
    @ManyToOne
    @JoinColumn(name= "productid", insertable = false, updatable = false)
    private RawMaterial purchasedProduct;

    public AcquisitionPK getAcquisitionID() {
        return acquisitionID;
    }

    public void setAcquisitionID(AcquisitionPK acquisitionID) {
        this.acquisitionID = acquisitionID;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Peddler getPeddler() {
        return peddler;
    }

    public void setPeddler(Peddler peddler) {
        this.peddler = peddler;
    }

    public RawMaterial getPurchasedProduct() {
        return purchasedProduct;
    }

    public void setPurchasedProduct(RawMaterial purchasedProduct) {
        this.purchasedProduct = purchasedProduct;
    }
    
     
    
}
