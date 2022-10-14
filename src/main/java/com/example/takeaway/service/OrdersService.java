package com.example.takeaway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.takeaway.entity.Orders;

/**
* @author 24343
* @description 针对表【orders(订单表)】的数据库操作Service
* @createDate 2022-10-13 12:16:16
*/
public interface OrdersService extends IService<Orders> {

    void submit(Orders orders);
}
