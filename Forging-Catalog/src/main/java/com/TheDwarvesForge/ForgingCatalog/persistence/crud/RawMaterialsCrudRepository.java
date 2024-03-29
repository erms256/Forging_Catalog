
package com.TheDwarvesForge.ForgingCatalog.persistence.crud;

import com.TheDwarvesForge.ForgingCatalog.persistence.entity.RawMaterial;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Erwin
 */
public interface RawMaterialsCrudRepository extends CrudRepository<RawMaterial,Integer>{
    
//    @Query("SELECT productid FROM raw_material")
//    List<Integer> findRawMaterialProductIds();
    
    @Query("SELECT rm.productID FROM RawMaterial rm")
    List<Integer> findAllRawMaterialIds();
    
    

}
