
package com.TheDwarvesForge.ForgingCatalog.domain.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private int productID;
    private String productName;
    private int quality;
    private int recipeID;
    private int price;
    private RecipeDTO recipe;
}
