package com.zcq.service;

import com.zcq.model.dto.OrderDTO;

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

    /**
     * 完结订单(只能卖家操作)
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);
}
