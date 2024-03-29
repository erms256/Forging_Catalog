
package com.TheDwarvesForge.ForgingCatalog.persistence.entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "warehouse")
public class Warehouse {
    @EmbeddedId
    private WarehousePK warehouseID;
    
    private Integer stock;

    @ManyToOne
    @JoinColumn(name= "blacksmithid", insertable = false, updatable = false)
    private Blacksmith blacksmith;
    
    @ManyToOne
    @JoinColumn(name= "productid", insertable = false, updatable = false)
    private Product product;
    
    public WarehousePK getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(WarehousePK warehouseID) {
        this.warehouseID = warehouseID;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Blacksmith getBlacksmith() {
        return blacksmith;
    }

    public void setBlacksmith(Blacksmith blacksmith) {
        this.blacksmith = blacksmith;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    
}
