package com.leakeyash.mybatis.data;

import java.util.List;

public interface ProductMapper {

    List<Product> findProductBySearchCondition(SearchCondition searchCondition);
}
