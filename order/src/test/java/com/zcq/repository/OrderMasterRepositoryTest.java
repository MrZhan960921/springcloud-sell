package com.zcq.repository;

import com.zcq.enums.OrderStatusEnum;
import com.zcq.enums.PayStatusEnum;
import com.zcq.model.po.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Maybeeeee
 * @date 2019-09-08 22:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("超群啊");
        orderMaster.setBuyerPhone("1886131241241");
        orderMaster.setBuyerAddress("上海松江");
        orderMaster.setBuyerOpenid("1101110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);
    }
}