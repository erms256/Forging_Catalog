package com.TheDwarvesForge.ForgingCatalog.persistence.mapper;


import com.TheDwarvesForge.ForgingCatalog.domain.dto.WarehouseDTO;
import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Warehouse;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface WarehouseMapper {
     @Mappings({
            @Mapping(source ="warehouseID.productID",target ="productID"),
            @Mapping(source ="stock",target ="stock"),
   })
   WarehouseDTO toDTO(Warehouse warehouse);

   @InheritInverseConfiguration
   @Mapping(target ="blacksmith", ignore = true)
   @Mapping(target ="product", ignore = true)
   Warehouse toEntity (WarehouseDTO warehouseDTO); 
}
