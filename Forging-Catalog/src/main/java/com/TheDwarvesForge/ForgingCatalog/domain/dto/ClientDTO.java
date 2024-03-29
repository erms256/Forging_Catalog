package com.TheDwarvesForge.ForgingCatalog.domain.dto;

import java.util.List;
import lombok.Data;



@Data
public class ClientDTO {
    private int clientID;
    private String clientName;
    private String profession;
    private int money;
    private List<SalesDTO> clients;
}
