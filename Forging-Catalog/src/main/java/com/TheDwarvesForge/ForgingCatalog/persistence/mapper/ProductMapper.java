package com.TheDwarvesForge.ForgingCatalog.persistence.mapper;


import com.TheDwarvesForge.ForgingCatalog.domain.dto.ProductDTO;
import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {RecipeMapper.class})
public interface ProductMapper {
           @Mappings({
            @Mapping(source ="productID",target ="productID"),
            @Mapping(source ="productName",target ="productName"),
            @Mapping(source ="quality",target ="quality"),
            @Mapping(source ="recipeID",target ="recipeID"),
            @Mapping(source ="price",target ="price"),
            @Mapping(source ="recipe",target ="recipe"),
          
   })
   ProductDTO toDTO(Product product);

   @InheritInverseConfiguration
   @Mapping(target = "storedItems", ignore = true)
   @Mapping(target = "sales", ignore = true)
   Product toEntity(ProductDTO peddlerDTO); 
}


