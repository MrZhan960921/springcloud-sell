package com.zcq.repository;

import com.zcq.model.po.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Maybeeeee
 * @date 2019-09-08 02:40
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatuc);

    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
