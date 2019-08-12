package com.retail.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * The class to represent the Item data base object
 */
@Entity
@Table(name = "RS_ITEM")
public class Item extends BaseDto {

    private String itemName;
    private BigDecimal price;
    private boolean isGroceryItem;

    @Column(name = "ITEM_NAME")
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "IS_GROCERY")
    public boolean isGroceryItem() {
        return isGroceryItem;
    }

    public void setGroceryItem(boolean groceryItem) {
        isGroceryItem = groceryItem;
    }
}
