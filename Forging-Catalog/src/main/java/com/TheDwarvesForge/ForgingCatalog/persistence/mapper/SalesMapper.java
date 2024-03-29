package com.TheDwarvesForge.ForgingCatalog.persistence.mapper;


import com.TheDwarvesForge.ForgingCatalog.domain.dto.SalesDTO;
import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Sales;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SalesMapper {
        @Mappings({
            @Mapping(source ="salesID.productID",target ="productID"),
            @Mapping(source ="stock",target ="stock"),
   })
   SalesDTO toDTO(Sales sales);

   @InheritInverseConfiguration
   @Mapping(target ="clientID", ignore = true)
   @Mapping(target ="client", ignore = true)
   @Mapping(target ="productSold", ignore = true)        
   Sales toEntity (SalesDTO salesDTO); 
   
}
