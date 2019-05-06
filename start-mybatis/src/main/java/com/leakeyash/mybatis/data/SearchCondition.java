package com.leakeyash.mybatis.data;

import lombok.Data;

@Data
public class SearchCondition {
    private Boolean containsSize;
    private int size;
    private String[] categories;
    private Float price;
}
