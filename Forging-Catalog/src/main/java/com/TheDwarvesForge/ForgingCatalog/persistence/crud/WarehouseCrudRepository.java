package com.TheDwarvesForge.ForgingCatalog.persistence.crud;

import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Warehouse;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface WarehouseCrudRepository extends CrudRepository<Warehouse,Integer>{  
    @Query("SELECT w.stock FROM Warehouse w WHERE w.warehouseID.productID = :productId AND w.warehouseID.blacksmithID = :blacksmithId")
    Integer findStockByProductIdAndBlacksmithId(@Param("productId") Integer productId,@Param("blacksmithId") Integer blacksmithId);
    
  
    @Modifying
    @Transactional
    @Query("UPDATE Warehouse SET stock = stock + :quantityToAdd WHERE warehouseID.productID = :productId AND warehouseID.blacksmithID = :blacksmithId")
    void increaseStockByProductIdAndBlacksmithId(@Param("quantityToAdd")Integer quantityToAdd, @Param("productId")Integer productId,@Param("blacksmithId") Integer blacksmithId);
    
    @Query("SELECT w FROM Warehouse w WHERE w.warehouseID.blacksmithID = :blacksmithid")
    List<Warehouse> findByProductBlacksmithId(@Param("blacksmithid") Integer blacksmithid);
    
    @Query("SELECT stock FROM Warehouse WHERE warehouseID.productID = :productId AND warehouseID.blacksmithID = :blacksmithid")
    Integer getStock(@Param("productId")Integer productId,@Param("blacksmithid") Integer blacksmithid);
}

