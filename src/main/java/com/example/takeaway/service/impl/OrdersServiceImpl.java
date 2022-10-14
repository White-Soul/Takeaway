package com.example.takeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeaway.entity.Orders;
import com.example.takeaway.service.OrdersService;
import com.example.takeaway.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author 24343
* @description 针对表【orders(订单表)】的数据库操作Service实现
* @createDate 2022-10-13 12:16:16
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
implements OrdersService{
    /**
     * 用户下单
     * @param orders
     */
    @Override
    public void submit(Orders orders) {

    }
}
