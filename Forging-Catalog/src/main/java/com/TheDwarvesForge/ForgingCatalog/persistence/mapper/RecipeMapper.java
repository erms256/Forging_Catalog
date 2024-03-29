package com.TheDwarvesForge.ForgingCatalog.persistence.mapper;


import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Recipe;
import com.TheDwarvesForge.ForgingCatalog.domain.dto.RecipeDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {RecipeMaterialsMapper.class})
public interface RecipeMapper {
    @Mappings({
            @Mapping(source ="recipeID",target ="recipeID"),
            @Mapping(source = "ingredentsList" ,target ="ingredentsList"),
   })
   RecipeDTO toDTO(Recipe recipe);

   @InheritInverseConfiguration
   Recipe toEntity(RecipeDTO recipeDTO); 
}
    