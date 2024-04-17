package com.restaurant.inventory.models;

import com.restaurant.common.models.Audit;
import com.restaurant.inventory.models.embeddable.CatalogItemType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Document(collection = "MENU_ITEM")
public class CatalogItem extends Audit {
    private String name;
    private String description;
    private CatalogItemType type;
    private double price;
    private int stockQuantity;
    private boolean isAvailable;
}