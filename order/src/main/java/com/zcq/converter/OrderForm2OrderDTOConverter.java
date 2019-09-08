package com.zcq.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zcq.enums.ResultEnum;
import com.zcq.exception.OrderException;
import com.zcq.model.dto.OrderDTO;
import com.zcq.model.form.OrderForm;
import com.zcq.model.po.OrderDetail;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maybeeeee
 * @date 2019-09-08 22:18
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【json转换】错误, string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
