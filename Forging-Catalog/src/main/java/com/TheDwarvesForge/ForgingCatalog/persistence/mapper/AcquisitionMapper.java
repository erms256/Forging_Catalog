package com.TheDwarvesForge.ForgingCatalog.persistence.mapper;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.AcquisitionDTO;
import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Acquisition;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AcquisitionMapper {
    @Mappings({
            @Mapping(source ="acquisitionID.productID",target ="productID"),
            @Mapping(source ="stock",target ="stock"),
   })
   AcquisitionDTO toDTO(Acquisition acquisition);

   @InheritInverseConfiguration
   @Mapping(target ="peddler", ignore = true)
   @Mapping(target ="purchasedProduct", ignore = true)
   Acquisition toEntity (AcquisitionDTO acquisitionDTO); 
}

