
package com.TheDwarvesForge.ForgingCatalog.domain.dto;

import java.util.List;
import lombok.Data;

@Data
public class RecipeDTO {
    private int recipeID;
    private List<RecipeMaterialsDTO> ingredentsList;
}
