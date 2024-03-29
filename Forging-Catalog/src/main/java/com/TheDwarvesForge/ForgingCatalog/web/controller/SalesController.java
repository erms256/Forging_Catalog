
package com.TheDwarvesForge.ForgingCatalog.web.controller;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.ClientDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.dto.ProductDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.dto.WarehouseDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    


    @GetMapping("/weapons-and-armors")
    public ResponseEntity<List<ProductDTO>> findWeaponsAndArmors() {
        List<ProductDTO> weaponsAndArmors = salesService.findWeaponsAndArmors();
        return ResponseEntity.ok().body(weaponsAndArmors);
    }

    @GetMapping("/raw-materials")
    public ResponseEntity<List<ProductDTO>> findRawMaterials() {
        List<ProductDTO> rawMaterials = salesService.findRawMaterials();
        return ResponseEntity.ok().body(rawMaterials);
    }

    @GetMapping("/warehouses/{productId}/owner")
    public ResponseEntity<List<WarehouseDTO>> findByIdProductOwner() {
        List<WarehouseDTO> warehouses = salesService.findByIdProductOwner();
        return ResponseEntity.ok().body(warehouses);
    }

    @GetMapping("/random-client")
    public ResponseEntity<ClientDTO> getRandomClient() {
        ClientDTO client = salesService.getRandomClient();
        return ResponseEntity.ok().body(client);
    }

    @GetMapping("/increase-stock/{quantityToAddClient}/{productIdClient}/{clientId}/{quantityToAddWarehouse}/{productIdWarehouse}")
    public ResponseEntity<String> increaseStockByProductIdAndPeddlerId(
            @PathVariable Integer quantityToAddClient, @PathVariable Integer productIdClient, @PathVariable Integer clientId,
            @PathVariable Integer quantityToAddWarehouse, @PathVariable Integer productIdWarehouse) {
        
        boolean success = salesService.increaseStockByProductIdAndPeddlerId(
                quantityToAddClient, productIdClient, clientId, quantityToAddWarehouse, productIdWarehouse);

        if (success) {
            return ResponseEntity.ok().body("Stock increased successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to increase stock");
        }
    }
}