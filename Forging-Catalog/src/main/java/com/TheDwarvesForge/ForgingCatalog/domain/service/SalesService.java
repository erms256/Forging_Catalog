
package com.TheDwarvesForge.ForgingCatalog.domain.service;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.ClientDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.dto.ProductDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.dto.WarehouseDTO;
import com.TheDwarvesForge.ForgingCatalog.persistence.ClientRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.ProductRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.SalesRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.WarehouseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesService {

    @Autowired
    private WarehouseRepository warehouseRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private SalesRepository salesRepository;
    
    public List<ProductDTO> findWeaponsAndArmors() {
        return productRepository.findWeaponsAndArmors();
    }

    public List<ProductDTO> findRawMaterials() {
        return productRepository.findRawMaterials();
    }
     
    public List<WarehouseDTO> findByIdProductOwner() {            
        return warehouseRepository.findByProductIdOwner();
    }

    public ClientDTO getRandomClient() {
        return clientRepository.getRandomClient();
    }
    
    public boolean increaseStockByProductIdAndPeddlerId(Integer quantityToAddClient, Integer productIdClient, Integer clientId,
                                                        Integer quantityToAddWarehouse, Integer productIdWarehouse) {
        
        warehouseRepository.increaseStockByProductIdAndBlacksmithOwner(quantityToAddWarehouse, productIdWarehouse);
        return salesRepository.increaseStockByProductIdAndClientId(quantityToAddClient, productIdClient, clientId);      
    }
}
