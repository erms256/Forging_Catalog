
package com.TheDwarvesForge.ForgingCatalog.domain.service;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.ProductDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.dto.WarehouseDTO;
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
public class WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> findWeaponsAndArmors() {
        return productRepository.findWeaponsAndArmors();
    }

    public List<ProductDTO> findRawMaterials() {
        return productRepository.findRawMaterials();
    }
     
    public List<WarehouseDTO> findByIdProductOwner() {            
        return warehouseRepository.findByProductIdOwner();
    }

    public boolean increaseStockByProductIdAndBlacksmithOwner(Integer quantityToAdd, Integer productId) {
        return warehouseRepository.increaseStockByProductIdAndBlacksmithOwner(quantityToAdd, productId);
    }
    
    
}
