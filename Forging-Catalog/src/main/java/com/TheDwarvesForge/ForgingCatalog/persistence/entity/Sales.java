/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TheDwarvesForge.ForgingCatalog.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sales")
public class Sales {

    public Sales(Integer clientID,Integer productID,Integer stock, Client client, Product productSold) {
        
        
        this.salesID.setClientID(clientID); 
        this.salesID.setProductID(productID);    
        this.stock = stock;
        this.client = client;
        this.productSold = productSold;
    }
    
    
    @EmbeddedId
    private SalesPK salesID;
    
    private Integer stock;
    
    @ManyToOne
    @JoinColumn(name= "clientid", insertable = false, updatable = false)
    private Client client;
    
    @ManyToOne
    @JoinColumn(name= "productid", insertable = false, updatable = false)
    private Product productSold;

    public SalesPK getSalesID() {
        return salesID;
    }

    public void setSalesID(SalesPK salesID) {
        this.salesID = salesID;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProductSold() {
        return productSold;
    }

    public void setProductSold(Product productSold) {
        this.productSold = productSold;
    }
    
    
}
 