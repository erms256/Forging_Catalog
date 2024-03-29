package com.TheDwarvesForge.ForgingCatalog.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "blacksmith_seller")
public class Blacksmith {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blacksmithid")
    private Integer blacksmithID;

    @Column(name = "blacksmithname")
    private String blacksmithName;
    
    private String clan;
    
    private String quality;
    
    @Column(name = "sellername")
    private LocalDateTime dateOfBirth;
    
    private Integer money;
    
    @OneToMany(mappedBy = "blacksmith")
    private List<Warehouse> storedItems;

    public Integer getBlacksmithID() {
        return blacksmithID;
    }

    public void setBlacksmithID(Integer blacksmithID) {
        this.blacksmithID = blacksmithID;
    }

    public String getBlacksmithName() {
        return blacksmithName;
    }

    public void setBlacksmithName(String blacksmithName) {
        this.blacksmithName = blacksmithName;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Warehouse> getStoredItems() {
        return storedItems;
    }

    public void setStoredItems(List<Warehouse> storedItems) {
        this.storedItems = storedItems;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
    
}
