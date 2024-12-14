CREATE TABLE products (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    created_on TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    last_modified_on TIMESTAMP WITH TIME ZONE DEFAULT NOW() ,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price NUMERIC(19, 4) NOT NULL
);

CREATE TABLE inventories (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    created_on TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    last_modified_on TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    inventory_name VARCHAR(255) NOT NULL,
    is_primary BOOLEAN NOT NULL,
    is_offshore BOOLEAN NOT NULL
);

CREATE TABLE inventory_products (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    created_on TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    last_modified_on TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    product_id UUID NOT NULL,
    inventory_id UUID NOT NULL,
    sku VARCHAR(10) NOT NULL,
    quantity INTEGER NOT NULL,
    available_for_sale BOOLEAN NOT NULL,
    CONSTRAINT uk_inventory_product_product_id_sku UNIQUE (product_id, sku),
    CONSTRAINT fk_inventory_product_product FOREIGN KEY (product_id) REFERENCES products(id),
    CONSTRAINT fk_inventory_product_inventory FOREIGN KEY (inventory_id) REFERENCES inventories(id)
);
