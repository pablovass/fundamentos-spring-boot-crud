package com.pablovass.domain;

import com.pablovass.domain.Category;
import lombok.Data;

@Data
public class Product {
    private int productId;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;
    private Category category;
}
