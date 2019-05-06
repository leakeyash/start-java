package com.leakeyash.mybatis.data;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private int size;
    private float price;
    private String category;
}
