/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.TheDwarvesForge.ForgingCatalog.persistence.crud;

import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Armor;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Erwin
 */
public interface ArmorCrudRepository extends CrudRepository<Armor,Integer>{
    
    @Query("SELECT productID FROM Armor")
    List<Integer> findArmorIdsByProduct();
    
}
