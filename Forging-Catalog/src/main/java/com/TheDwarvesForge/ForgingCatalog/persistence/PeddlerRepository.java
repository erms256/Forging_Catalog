/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TheDwarvesForge.ForgingCatalog.persistence;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.PeddlerDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.repository.PeddlerRepositoryDTO;
import com.TheDwarvesForge.ForgingCatalog.persistence.crud.PeddlerCrudRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Peddler;
import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Product;
import com.TheDwarvesForge.ForgingCatalog.persistence.mapper.PeddlerMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erwin
 */
@Repository
public class PeddlerRepository implements PeddlerRepositoryDTO{
    @Autowired
    private PeddlerCrudRepository peddlerCrudRepository; 
    
    @Autowired
    private PeddlerMapper peddlerMapper;
    

    @Override
    public PeddlerDTO getRandomPeddler() {
        List<Peddler> peddlers = (List<Peddler>) peddlerCrudRepository.findAll();
        
        int randomPeddler =  (int) ((Math.random() * peddlers.size())+1);  
  
        return peddlerMapper.toDTO(peddlers.get(randomPeddler));
    }
    
}
