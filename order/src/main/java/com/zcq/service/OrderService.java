package com.zcq.service;

import com.zcq.model.dto.OrderDTO;
import com.zcq.model.po.OrderDetail;
import com.zcq.model.po.OrderMaster;

/**
 * @author Maybeeeee
 * @date 2019-09-08 23:00
 */
public interface OrderService {
    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
