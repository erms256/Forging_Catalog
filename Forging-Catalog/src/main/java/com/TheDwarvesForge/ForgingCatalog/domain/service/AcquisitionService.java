
package com.TheDwarvesForge.ForgingCatalog.domain.service;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.AcquisitionDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.dto.PeddlerDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.dto.ProductDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.dto.WarehouseDTO;
import com.TheDwarvesForge.ForgingCatalog.persistence.AcquisitionRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.PeddlerRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.ProductRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.WarehouseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erwin
 */
@Service
public class AcquisitionService {
    
    @Autowired
    private AcquisitionRepository acquisitionRepository;
    
    @Autowired
    private PeddlerRepository peddlerRepository;
    
    @Autowired
    private WarehouseRepository warehouseRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    
    public PeddlerDTO getRandomPeddler() {
        return peddlerRepository.getRandomPeddler();
    }
    
    
    public List<AcquisitionDTO> getPeddlerProducts(Integer peddlerId) {
        return acquisitionRepository.getPeddlerProducts(peddlerId);
    }
    
    public List<WarehouseDTO> findByProductIdOwner() {            
        return warehouseRepository.findByProductIdOwner();
    }
    
    public boolean increaseStockByProductIdAndPeddlerId(Integer quantityToAddAcquisition, Integer productIdAcquisition, Integer peddlerId,
                                                        Integer quantityToAddWarehouse, Integer productIdWarehouse) {
        
        warehouseRepository.increaseStockByProductIdAndBlacksmithOwner(quantityToAddWarehouse, productIdWarehouse);
        acquisitionRepository.increaseStockByProductIdAndPeddlerId(quantityToAddAcquisition, productIdAcquisition, peddlerId);
        return true;   
    }
    
    public List<ProductDTO> findWeaponsAndArmors() {
        return productRepository.findWeaponsAndArmors();
    }

    
    public List<ProductDTO> findRawMaterials() {
        return productRepository.findRawMaterials();
    }
     
}
