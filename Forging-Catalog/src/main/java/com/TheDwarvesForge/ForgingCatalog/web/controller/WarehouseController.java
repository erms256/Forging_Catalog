
package com.TheDwarvesForge.ForgingCatalog.web.controller;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.ProductDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.dto.WarehouseDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/weapons-and-armors")
    public ResponseEntity<List<ProductDTO>> findWeaponsAndArmors() {
        List<ProductDTO> weaponsAndArmors = warehouseService.findWeaponsAndArmors();
        return ResponseEntity.ok(weaponsAndArmors);
    }

    @GetMapping("/raw-materials")
    public ResponseEntity<List<ProductDTO>> findRawMaterials() {
        List<ProductDTO> rawMaterials = warehouseService.findRawMaterials();
        return ResponseEntity.ok(rawMaterials);
    }

    @GetMapping("/products")
    public ResponseEntity<List<WarehouseDTO>> findByIdProductOwner() {
        List<WarehouseDTO> productOwners = warehouseService.findByIdProductOwner();
        return ResponseEntity.ok(productOwners);
    }

    
    @PostMapping("/increase-stock/{quantityToAdd}/{productId}")
    public ResponseEntity<Void> increaseStockByProductIdAndBlacksmithOwner(@PathVariable Integer quantityToAdd,
                                                                           @PathVariable Integer productId) {
        boolean success = warehouseService.increaseStockByProductIdAndBlacksmithOwner(quantityToAdd, productId);
        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}