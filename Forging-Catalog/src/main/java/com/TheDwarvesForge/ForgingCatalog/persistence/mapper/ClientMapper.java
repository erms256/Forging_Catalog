package com.TheDwarvesForge.ForgingCatalog.persistence.mapper;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.ClientDTO;
import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring", uses = {SalesMapper.class})
public interface ClientMapper {
       @Mappings({
            @Mapping(source ="clientID",target ="clientID"),
            @Mapping(source ="clientName",target ="clientName"),
            @Mapping(source ="profession",target ="profession"),
            @Mapping(source ="money",target ="money"),
            @Mapping(source ="clients",target ="clients"),
   })
   ClientDTO toDTO(Client blacksmith);

   @InheritInverseConfiguration
   Client toEntity(ClientDTO clientDTO); 
}
