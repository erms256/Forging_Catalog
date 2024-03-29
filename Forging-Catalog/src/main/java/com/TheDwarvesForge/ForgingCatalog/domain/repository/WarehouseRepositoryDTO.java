
package com.TheDwarvesForge.ForgingCatalog.domain.repository;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.WarehouseDTO;
import java.util.List;

/**
 *
 * @author Erwin
 */
public interface WarehouseRepositoryDTO {
    
    public boolean increaseStockByProductIdAndBlacksmithOwner(Integer quantityToAdd, Integer productId);
     
    public List<WarehouseDTO> findByProductIdOwner();  
}
