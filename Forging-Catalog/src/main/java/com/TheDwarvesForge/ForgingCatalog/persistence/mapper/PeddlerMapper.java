package com.TheDwarvesForge.ForgingCatalog.persistence.mapper;


import com.TheDwarvesForge.ForgingCatalog.domain.dto.PeddlerDTO;
import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Peddler;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {AcquisitionMapper.class})
public interface PeddlerMapper {
           @Mappings({
            @Mapping(source ="peddlerID",target ="peddlerID"),
            @Mapping(source ="peddlerName",target ="peddlerName"),
            @Mapping(source ="acquisitions",target ="acquisitions"),
   })
   PeddlerDTO toDTO(Peddler peddler);

   @InheritInverseConfiguration
   Peddler toEntity(PeddlerDTO peddlerDTO); 
}
