
package com.TheDwarvesForge.ForgingCatalog.persistence.entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipe_materials")
public class RecipeMaterials {
    @EmbeddedId
    private RecipeMaterialsPK reicpeMaterialsID;
    
    private Integer stock;
    
    @ManyToOne
    @JoinColumn(name= "recipeid", insertable = false, updatable = false)
    private Recipe recipe;
    
    @ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false)
    private RawMaterial ingredient;

    public RecipeMaterialsPK getReicpeMaterialsID() {
        return reicpeMaterialsID;
    }

    public void setReicpeMaterialsID(RecipeMaterialsPK reicpeMaterialsID) {
        this.reicpeMaterialsID = reicpeMaterialsID;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public RawMaterial getIngredient() {
        return ingredient;
    }

    public void setIngredient(RawMaterial ingredient) {
        this.ingredient = ingredient;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    
}
