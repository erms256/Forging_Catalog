
package com.TheDwarvesForge.ForgingCatalog.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class WarehousePK implements Serializable{
    @Column(name="blacksmithid")
    private Integer blacksmithID;
    
    @Column(name="productid")
    private Integer productID;

    public Integer getBlacksmithID() {
        return blacksmithID;
    }

    public void setBlacksmithID(Integer blacksmithID) {
        this.blacksmithID = blacksmithID;
    }

   

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }
    
    
    
}
