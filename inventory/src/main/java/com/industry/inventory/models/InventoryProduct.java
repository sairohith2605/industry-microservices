package com.industry.inventory.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory_products")
public class InventoryProduct extends BaseModel {

    @ManyToOne(optional = false)
    @JoinColumn(
        name = "product_id",
        nullable = false,
        updatable = false
    )
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(
        name = "inventory_id",
        nullable = false,
        updatable = false
    )
    private Inventory inventory;

    @Column(name = "sku")
    private String sku;
    
    @Column(name = "quantity")
    private int quantity;

    @Column(name = "available_for_sale")
    private boolean availableForSale;
}
