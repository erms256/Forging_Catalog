
package com.TheDwarvesForge.ForgingCatalog.persistence.crud;

import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Acquisition;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Erwin
 */
public interface AcquisitionCrudRepository extends CrudRepository<Acquisition,Integer>{
    
    @Query("SELECT a FROM Acquisition a WHERE a.acquisitionID.peddlerID = :peddlerId")
    List<Acquisition> findByPeddlerId(@Param("peddlerId") Integer peddlerId);
    
    @Modifying
    @Transactional
    @Query("UPDATE Acquisition SET stock = stock + :quantityToAdd WHERE  acquisitionID.productID = :productId AND  acquisitionID.peddlerID = :peddlerId")
    void increaseStockByProductIdAndPeddlerId(@Param("quantityToAdd")Integer quantityToAdd, @Param("productId")Integer productId,@Param("peddlerId") Integer peddlerId);
    
    
    
    @Query("SELECT stock FROM Acquisition WHERE acquisitionID.productID = :productId AND acquisitionID.peddlerID = :peddlerId")
    Integer getStock(@Param("productId")Integer productId,@Param("peddlerId") Integer peddlerId);
    
}
