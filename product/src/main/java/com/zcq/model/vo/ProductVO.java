package com.zcq.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Maybeeeee
 * @date 2019-09-08 03:10
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    List<ProductInfoVO> productInfoVOList;
}
