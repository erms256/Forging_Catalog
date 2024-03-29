
package com.TheDwarvesForge.ForgingCatalog.domain.dto;

import java.util.List;
import lombok.Data;

@Data
public class PeddlerDTO {
    private int peddlerID;
    private String peddlerName;
    private List<AcquisitionDTO> acquisitions;    
}
