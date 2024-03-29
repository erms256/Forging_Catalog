
package com.TheDwarvesForge.ForgingCatalog.persistence;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.AcquisitionDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.repository.AcquisitionRepositoryDTO;
import com.TheDwarvesForge.ForgingCatalog.persistence.crud.AcquisitionCrudRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Acquisition;

import com.TheDwarvesForge.ForgingCatalog.persistence.mapper.AcquisitionMapper;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class AcquisitionRepository implements AcquisitionRepositoryDTO{
    @Autowired
    private AcquisitionCrudRepository acquisitionCrudRepository; 
    
    @Autowired
    private AcquisitionMapper acquisitionMapper;
    
    @Override
    public List<AcquisitionDTO> getPeddlerProducts(Integer peddlerId) {
        List<Acquisition> acquisitions = acquisitionCrudRepository.findByPeddlerId(peddlerId);
        List<AcquisitionDTO> AcquisitionDTOs = new ArrayList<>();
        for (Acquisition acquisition : acquisitions) {
            AcquisitionDTOs.add(acquisitionMapper.toDTO(acquisition));
        }
        return AcquisitionDTOs;
    }

    @Override
    public boolean increaseStockByProductIdAndPeddlerId(Integer quantityToAdd, Integer productId, Integer peddlerId) {
        int stock = acquisitionCrudRepository.getStock(productId, peddlerId);

        //falta verificar si existe el acquisition
        
        if (stock <= quantityToAdd) {
            quantityToAdd = -1*stock;
            acquisitionCrudRepository.increaseStockByProductIdAndPeddlerId(quantityToAdd, productId, peddlerId);
            return true;
        }else{
            acquisitionCrudRepository.increaseStockByProductIdAndPeddlerId(quantityToAdd, productId, peddlerId);
            return true;
        }
    }
    

}
