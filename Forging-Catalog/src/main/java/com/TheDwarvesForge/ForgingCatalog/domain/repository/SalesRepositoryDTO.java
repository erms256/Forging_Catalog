
package com.TheDwarvesForge.ForgingCatalog.domain.repository;



/**
 *
 * @author Erwin
 */
public interface SalesRepositoryDTO {

public boolean increaseStockByProductIdAndClientId(Integer quantityToAdd, Integer productId, Integer clientId);
    



}
