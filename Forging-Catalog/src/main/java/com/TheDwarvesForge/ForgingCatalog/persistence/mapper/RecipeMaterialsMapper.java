package com.TheDwarvesForge.ForgingCatalog.persistence.mapper;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.RecipeMaterialsDTO;
import com.TheDwarvesForge.ForgingCatalog.persistence.entity.RecipeMaterials;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RecipeMaterialsMapper {
    @Mappings({
            @Mapping(source ="reicpeMaterialsID.productID",target ="rawMaterialID"),
            @Mapping(source ="stock",target ="stock"),
   })
   RecipeMaterialsDTO toDTO(RecipeMaterials recipeMaterials);

   @InheritInverseConfiguration
   @Mapping(target ="recipe", ignore = true)
   @Mapping(target ="ingredient", ignore = true)
   RecipeMaterials toEntity (RecipeMaterialsDTO recipeMaterialsDTO); 
}
