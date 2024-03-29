 
package com.TheDwarvesForge.ForgingCatalog.persistence.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientid")
    private Integer clientID;
    
    @Column(name = "clientname")
    private String clientName;
    
    private String profession;
    
    private Integer money;
    
    @OneToMany(mappedBy = "client")
    private List<Sales> clients;

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public List<Sales> getClients() {
        return clients;
    }

    public void setClients(List<Sales> clients) {
        this.clients = clients;
    }
    
    
    
}
