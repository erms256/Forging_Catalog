
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
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipeid")
    private Integer recipeID;
    
    @OneToMany(mappedBy = "recipe")
    private List<RecipeMaterials> ingredentsList;
    

    public Integer getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(Integer recipeID) {
        this.recipeID = recipeID;
    }

    public List<RecipeMaterials> getIngredentsList() {
        return ingredentsList;
    }

    public void setIngredentsList(List<RecipeMaterials> ingredentsList) {
        this.ingredentsList = ingredentsList;
    }


    
    
}
