
package com.TheDwarvesForge.ForgingCatalog.persistence;

import com.TheDwarvesForge.ForgingCatalog.domain.dto.ClientDTO;
import com.TheDwarvesForge.ForgingCatalog.domain.repository.ClientRepositoryDTO;
import com.TheDwarvesForge.ForgingCatalog.persistence.crud.ClientCrudRepository;
import com.TheDwarvesForge.ForgingCatalog.persistence.entity.Client;
import com.TheDwarvesForge.ForgingCatalog.persistence.mapper.ClientMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erwin
 */
@Repository
public class ClientRepository implements ClientRepositoryDTO{
    @Autowired
    private ClientCrudRepository clientCrudRepository; 
    
    @Autowired
    private ClientMapper clientMapper;
    
    
    @Override
    public ClientDTO getRandomClient() {
        List<Client> clients = (List<Client>) clientCrudRepository.findAll();
        
        int randomPeddler =  (int) ((Math.random() * clients.size())+1);  
  
        return clientMapper.toDTO(clients.get(randomPeddler));
    }
    
}
