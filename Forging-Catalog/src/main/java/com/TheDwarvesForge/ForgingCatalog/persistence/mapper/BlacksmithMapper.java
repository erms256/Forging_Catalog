package com.TheDwarvesForge.ForgingCatalog.persistence.mapper;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.BlacksmithDTO;
import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Blacksmith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {WarehouseMapper.class})
public interface BlacksmithMapper{
   @Mappings({
       @Mapping(source ="blacksmithID",target ="blacksmithID"),
       @Mapping(source ="blacksmithName",target ="blacksmithName"),
       @Mapping(source ="clan",target ="clan"),
       @Mapping(source ="quality",target ="quality"),
       @Mapping(source ="money",target ="money"),
       @Mapping(source ="storedItems",target ="storedItems"),
   })
   BlacksmithDTO toDTO(Blacksmith blacksmith);

   @InheritInverseConfiguration
   @Mapping(target = "dateOfBirth", ignore = true )
   Blacksmith toEntity(BlacksmithDTO blacksmithDTO); 
   
}
