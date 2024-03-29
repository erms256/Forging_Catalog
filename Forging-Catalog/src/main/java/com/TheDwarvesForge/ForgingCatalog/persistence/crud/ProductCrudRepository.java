
package com.TheDwarvesForge.ForgingCatalog.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Product;



public interface ProductCrudRepository extends CrudRepository<Product, Integer>{
    
}
