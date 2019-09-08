package com.zcq.service.impl;


import com.zcq.model.po.ProductCategory;
import com.zcq.repository.ProductCategoryRepository;
import com.zcq.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Maybeeeee
 * @date 2019-09-08 02:59
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
