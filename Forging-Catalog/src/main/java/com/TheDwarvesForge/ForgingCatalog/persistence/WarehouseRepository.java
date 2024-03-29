
package com.TheDwarvesForge.ForgingCatalog.persistence;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.WarehouseDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.repository.WarehouseRepositoryDTO;
import com.TheDwarvesForge.ForgingCatalog.persistence.crud.WarehouseCrudRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Warehouse;
import com.TheDwarvesForge.ForgingCatalog.persistence.mapper.WarehouseMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 *
 * @author Erwin
 */
@Repository
public class WarehouseRepository implements WarehouseRepositoryDTO{
    @Autowired
    private WarehouseCrudRepository warehouseCrudRepository;
    
    @Autowired
    private WarehouseMapper warehouseMapper;
    
    static final Integer BLACKSMITH_OWNER = 1;
    
    
    @Override
    public boolean increaseStockByProductIdAndBlacksmithOwner(Integer quantityToAdd, Integer productId) {
        int stock = warehouseCrudRepository.getStock(productId, BLACKSMITH_OWNER);
        //falta verificar que haya un warehouse
        //falta restar las materias primas con las cuales se produjo
        
        if (stock <= quantityToAdd) {
            quantityToAdd = -1*stock;
            warehouseCrudRepository.increaseStockByProductIdAndBlacksmithId(quantityToAdd, productId, BLACKSMITH_OWNER);
            
            return true;
        }else{
            warehouseCrudRepository.increaseStockByProductIdAndBlacksmithId(quantityToAdd, productId, BLACKSMITH_OWNER);
            return true;
        }
    }

    @Override
    public List<WarehouseDTO> findByProductIdOwner() {
        List<Warehouse> acquisitions = warehouseCrudRepository.findByProductBlacksmithId(BLACKSMITH_OWNER);
        List<WarehouseDTO> WarehouseDTOs = new ArrayList<>();
        for (Warehouse acquisition : acquisitions) {
            WarehouseDTOs.add(warehouseMapper.toDTO(acquisition));
        }
        return WarehouseDTOs;
    }
    
}
