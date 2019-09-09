package com.zcq.service;

import com.zcq.model.dto.CartDTO;
import com.zcq.model.po.ProductInfo;

import java.util.List;

/**
 * @author Maybeeeee
 * @date 2019-09-08 02:59
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 根据商品id集合查询商品列表
     *
     * @param productIdList 商品id
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param cartDTOList 购物车集合
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
