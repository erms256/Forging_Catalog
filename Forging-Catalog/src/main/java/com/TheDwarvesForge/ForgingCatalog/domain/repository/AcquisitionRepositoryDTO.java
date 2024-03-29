

package com.TheDwarvesForge.ForgingCatalog.domain.repository;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.AcquisitionDTO;
import java.util.List;

/**
 *
 * @author Erwin
 */
public interface AcquisitionRepositoryDTO {
    public List<AcquisitionDTO> getPeddlerProducts(Integer peddlerId);

    public boolean increaseStockByProductIdAndPeddlerId(Integer quantityToAdd, Integer productId, Integer peddlerId);
}
