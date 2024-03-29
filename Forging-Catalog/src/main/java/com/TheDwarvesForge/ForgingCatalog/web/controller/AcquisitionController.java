
package com.TheDwarvesForge.ForgingCatalog.web.controller;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.AcquisitionDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.dto.PeddlerDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.dto.ProductDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.dto.WarehouseDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.service.AcquisitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acquisitions")
public class AcquisitionController {

    @Autowired
    private AcquisitionService acquisitionService;

    @GetMapping("/random-peddler")
    @ResponseStatus(HttpStatus.OK)
    public PeddlerDTO getRandomPeddler() {
        return acquisitionService.getRandomPeddler();
    }

    @GetMapping("/peddler-products/{peddlerId}")
    public ResponseEntity<List<AcquisitionDTO>> getPeddlerProducts(@PathVariable Integer peddlerId) {
        List<AcquisitionDTO> peddlerProducts = acquisitionService.getPeddlerProducts(peddlerId);
        return ResponseEntity.ok().body(peddlerProducts);
    }

    @GetMapping("/warehouse-products")
    public ResponseEntity<List<WarehouseDTO>> findByProductIdOwner() {
        List<WarehouseDTO> warehouseProducts = acquisitionService.findByProductIdOwner();
        return ResponseEntity.ok().body(warehouseProducts);
    }

    

    
    @PostMapping("/increase-stock/{quantityToAddAcquisition}/{productIdAcquisition}/{peddlerId}/{quantityToAddWarehouse}/{productIdWarehouse}")
    public ResponseEntity<Void> increaseStock(
            @PathVariable Integer quantityToAddAcquisition,
            @RequestParam Integer productIdAcquisition,
            @RequestParam Integer peddlerId,
            @RequestParam Integer quantityToAddWarehouse,
            @RequestParam Integer productIdWarehouse) {
        
        boolean success = acquisitionService.increaseStockByProductIdAndPeddlerId(
                quantityToAddAcquisition, productIdAcquisition, peddlerId,
                quantityToAddWarehouse, productIdWarehouse);
        
        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/weapons-armors")
    public ResponseEntity<List<ProductDTO>> findWeaponsAndArmors() {
        List<ProductDTO> weaponsAndArmors = acquisitionService.findWeaponsAndArmors();
        return ResponseEntity.ok().body(weaponsAndArmors);
    }

    @GetMapping("/raw-materials")
    public ResponseEntity<List<ProductDTO>> findRawMaterials() {
        List<ProductDTO> rawMaterials = acquisitionService.findRawMaterials();
        return ResponseEntity.ok().body(rawMaterials);
    }
}