package com.zcq.service;

import com.zcq.model.po.ProductCategory;

import java.util.List;

/**
 * @author Maybeeeee
 * @date 2019-09-08 02:59
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
