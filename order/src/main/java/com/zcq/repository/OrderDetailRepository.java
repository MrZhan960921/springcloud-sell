package com.zcq.repository;


import com.zcq.model.po.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Maybeeeee
 * @date 2019-09-08 22:03
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
