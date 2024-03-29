
package com.TheDwarvesForge.ForgingCatalog.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AcquisitionPK implements Serializable{
    
    @Column(name="peddlerid")
    private Integer peddlerID;
    
    @Column(name="productid")
    private Integer productID;

    public AcquisitionPK(Integer peddlerID, Integer productID) {
        this.peddlerID = peddlerID;
        this.productID = productID;
    }

    public AcquisitionPK() {
    }
    
    

    public Integer getPeddlerID() {
        return peddlerID;
    }

    public void setPeddlerID(Integer peddlerID) {
        this.peddlerID = peddlerID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }


}
