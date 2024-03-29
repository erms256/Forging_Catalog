
package com.TheDwarvesForge.ForgingCatalog.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "armor")
@PrimaryKeyJoinColumn(referencedColumnName = "productid")
public class Armor extends Product{
    private Integer protection;
    
    private Integer resistance;

    public Integer getProtection() {
        return protection;
    }

    public void setProtection(Integer protection) {
        this.protection = protection;
    }

    public Integer getResistance() {
        return resistance;
    }

    public void setResistance(Integer resistance) {
        this.resistance = resistance;
    }
    
    
}
