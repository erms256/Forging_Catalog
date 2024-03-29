package com.TheDwarvesForge.ForgingCatalog.persistence.entity;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private Integer productID;
    
    @Column(name = "productname")
    private String productName;
   
    private Integer quality;
    
    @Column(name = "recipeid", insertable = false, updatable = false)
    private Integer recipeID;
    
    private Integer price;
    
    
    @OneToMany(mappedBy = "product")
    private List<Warehouse> storedItems;
    
    @OneToMany(mappedBy = "productSold")
    private List<Sales> sales;
    
    @OneToOne(optional = true) 
    @JoinColumn(name = "recipeid") 
    private Recipe recipe;

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(Integer recipeID) {
        this.recipeID = recipeID;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Warehouse> getStoredItems() {
        return storedItems;
    }

    public void setStoredItems(List<Warehouse> storedItems) {
        this.storedItems = storedItems;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    
    
    
}
