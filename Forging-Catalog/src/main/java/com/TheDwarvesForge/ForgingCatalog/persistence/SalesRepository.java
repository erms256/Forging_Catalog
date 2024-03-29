
package com.TheDwarvesForge.ForgingCatalog.persistence;

import com.TheDwarvesForge.ForgingCatalog.domain.repository.SalesRepositoryDTO;
import com.TheDwarvesForge.ForgingCatalog.persistence.crud.ClientCrudRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.crud.ProductCrudRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.crud.SalesCrudRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erwin
 */
@Repository
public class SalesRepository implements SalesRepositoryDTO{
    
    @Autowired
    private SalesCrudRepository salesCrudRepository;
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    @Autowired
    private ProductCrudRepository productCrudRepository;
    
    @Override
    public boolean increaseStockByProductIdAndClientId(Integer quantityToAdd, Integer productId, Integer clientId) {
        
        if(salesCrudRepository.existSales(productId, clientId) == true){
        
            int stock = salesCrudRepository.getStock(productId, clientId);
        
            if (stock <= quantityToAdd) {
                quantityToAdd = -1*stock;
                salesCrudRepository.increaseStockByProductIdAndClientId(quantityToAdd, productId, clientId);
                return true; 
            }else{
                salesCrudRepository.increaseStockByProductIdAndClientId(quantityToAdd, productId, clientId);
                return true; 
            }
        }else if(clientCrudRepository.existsById(clientId) &&  productCrudRepository.existsById(clientId)){
            salesCrudRepository.save(new Sales(clientId,productId,quantityToAdd,
            clientCrudRepository.findById(clientId).get(), productCrudRepository.findById(productId).get()));
            return true; 
        }else{
            return false; 
        }
    }
    
}
