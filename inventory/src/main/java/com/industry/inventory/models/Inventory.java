package com.industry.inventory.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventories")
public class Inventory extends BaseModel {

    @Column(name = "inventory_name")
    private String inventoryName;

    @Column(name = "is_primary")
    private boolean isPrimary;

    @Column(name = "is_offshore")
    private boolean isOffshore;

    @OneToMany(
        mappedBy = "inventory"
    )
    private Set<InventoryProduct> inventoryProducts;
    
}
