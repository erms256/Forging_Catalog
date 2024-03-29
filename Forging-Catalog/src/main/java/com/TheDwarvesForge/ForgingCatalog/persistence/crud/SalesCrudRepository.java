package com.TheDwarvesForge.ForgingCatalog.persistence.crud;

import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Sales;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface SalesCrudRepository extends CrudRepository<Sales, Integer>{
    @Modifying
    @Transactional
     @Query("UPDATE Sales SET stock = stock + :quantityToAdd WHERE salesID.productID = :productId AND salesID.clientID = :clientId")
    void increaseStockByProductIdAndClientId(@Param("quantityToAdd")Integer quantityToAdd, @Param("productId")Integer productId,@Param("clientId") Integer clientId);
    
     @Query("SELECT stock FROM Sales WHERE salesID.productID = :productId AND salesID.clientID = :clientid")
    Integer getStock(@Param("productId")Integer productId,@Param("clientid") Integer clientid);
    
    @Query("SELECT EXISTS (SELECT 1 FROM Sales WHERE salesID.productID = :productId and  salesID.clientID = :clientid)")
    Boolean existSales(@Param("productId")Integer productId,@Param("clientid") Integer clientid);
}
