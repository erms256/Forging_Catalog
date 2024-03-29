
package com.TheDwarvesForge.ForgingCatalog.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "weapon")
@PrimaryKeyJoinColumn(referencedColumnName = "productid")
public class Weapon extends Product{
    private Integer damage;
    
    private Integer edge;
     
    private Integer resistance;

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getEdge() {
        return edge;
    }

    public void setEdge(Integer edge) {
        this.edge = edge;
    }

    public Integer getResistance() {
        return resistance;
    }

    public void setResistance(Integer resistance) {
        this.resistance = resistance;
    }
    
    
}
