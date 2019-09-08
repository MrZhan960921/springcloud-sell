package com.zcq.service.impl;

import com.zcq.enums.OrderStatusEnum;
import com.zcq.enums.PayStatusEnum;
import com.zcq.model.dto.OrderDTO;
import com.zcq.model.po.OrderMaster;
import com.zcq.repository.OrderDetailRepository;
import com.zcq.repository.OrderMasterRepository;
import com.zcq.service.OrderService;
import com.zcq.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Maybeeeee
 * @date 2019-09-08 23:04
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //todo 1.参数校验
        //todo 2.查询商品信息(调用商品服务)
        //todo 3.计算总价
        //todo 4.扣库存(调用商品服务)
        //5.订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
