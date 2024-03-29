
package com.TheDwarvesForge.ForgingCatalog.persistence;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.ProductDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.repository.ProductRepositoryDTO;
import com.TheDwarvesForge.ForgingCatalog.persistence.crud.ArmorCrudRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.crud.ProductCrudRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.crud.RawMaterialsCrudRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.crud.WeaponCrudRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Product;
import com.TheDwarvesForge.ForgingCatalog.persistence.mapper.ProductMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements ProductRepositoryDTO{
    @Autowired
    private ProductCrudRepository productCrudRepository;
    
    @Autowired
    private RawMaterialsCrudRepository rawMaterialsCrudRepository;
    
    @Autowired
    private ArmorCrudRepository armorCrudRepository;
    
    @Autowired
    private WeaponCrudRepository weaponCrudRepository;
    
    @Autowired
    private ProductMapper productMapper;
    
    private List<Product> getWeaponsAndArmors() {
    
        List<Integer> armorIds = armorCrudRepository.findArmorIdsByProduct();
        List<Integer> weaponIds = weaponCrudRepository.findWeaponIdsByProduct();
        List<Integer> allIds = new ArrayList<>();
        allIds.addAll(armorIds);
        allIds.addAll(weaponIds);
        
        
        List<Product> products = (List<Product>) productCrudRepository.findAllById(allIds);
        return products;
    }
    @Override
    public List<ProductDTO> findWeaponsAndArmors() {
        
        
        List<Product> products = this.getWeaponsAndArmors();
       
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            productDTOs.add(productMapper.toDTO(product));
        }
        return productDTOs;
    }

    @Override
    public List<ProductDTO> findRawMaterials() {
        List<Integer> rawMaterialIds = rawMaterialsCrudRepository.findAllRawMaterialIds();
        List<Product> products = (List<Product>) productCrudRepository.findAllById(rawMaterialIds);
   
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            productDTOs.add(productMapper.toDTO(product));
        }
        return productDTOs;
    }

    @Override
    public List<List<Integer>> requestedProducts() {
        List<Product> products = this.getWeaponsAndArmors();
        
        List<List<Integer>> productIdAndQuantityList = new ArrayList<>();
        int randomQuantityOfProducts = (int) ((Math.random() * 3 ) +1);
        
        for (int i = 0; i < randomQuantityOfProducts; i++) {
            List<Integer> productIdAndQuantity = new ArrayList<>();

            int randomProductId =  (int) ((Math.random() * products.size())+1);
            int randomQuantity = (int) ((Math.random() * 5 ) +1);
        
            productIdAndQuantity.add(randomProductId);
            productIdAndQuantity.add(randomQuantity);
        
            productIdAndQuantityList.add(productIdAndQuantity);               
        }
        
        
        
        return productIdAndQuantityList;
    }
    
}
