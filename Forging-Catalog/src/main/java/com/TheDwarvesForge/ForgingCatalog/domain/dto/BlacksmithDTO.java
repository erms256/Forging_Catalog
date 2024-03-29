
package com.TheDwarvesForge.ForgingCatalog.domain.dto;

import java.util.List;
import lombok.Data;

@Data
public class BlacksmithDTO {
    private int blacksmithID;
    private String blacksmithName; 
    private String clan;
    private String quality;
    private int money;
    private List<WarehouseDTO> storedItems;
    
}
