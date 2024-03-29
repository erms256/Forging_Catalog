package com.TheDwarvesForge.ForgingCatalog.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RecipeMaterialsPK implements Serializable{
   @Column(name = "recipeid") 
   private Integer recipeID;
   
    @Column(name = "productid") 
   private Integer productID;

    public Integer getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(Integer recipeID) {
        this.recipeID = recipeID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }
    
    
    
}
