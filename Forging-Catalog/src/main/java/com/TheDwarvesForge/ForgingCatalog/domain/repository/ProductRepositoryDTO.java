/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.TheDwarvesForge.ForgingCatalog.domain.repository;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.ProductDTO;
import java.util.List;

/**
 *
 * @author Erwin
 */
public interface ProductRepositoryDTO {
   
    public List<ProductDTO> findWeaponsAndArmors();
   
    public List<ProductDTO> findRawMaterials();
    
    public List<List<Integer>> requestedProducts();
}
