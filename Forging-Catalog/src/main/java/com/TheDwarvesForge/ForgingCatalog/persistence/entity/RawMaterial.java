
package com.TheDwarvesForge.ForgingCatalog.persistence.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "raw_material")
@PrimaryKeyJoinColumn(referencedColumnName = "productid")
public class RawMaterial extends Product{
    
    private Integer rarity;
    
    @OneToMany(mappedBy = "purchasedProduct")
    private List<Acquisition> acquisitions;

    @OneToMany(mappedBy = "ingredient")
    private List<RecipeMaterials> ingredients;
    
    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public List<Acquisition> getAcquisitions() {
        return acquisitions;
    }

    public void setAcquisitions(List<Acquisition> acquisitions) {
        this.acquisitions = acquisitions;
    }

    public List<RecipeMaterials> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeMaterials> ingredients) {
        this.ingredients = ingredients;
    }

  

  
    
    
    
}
