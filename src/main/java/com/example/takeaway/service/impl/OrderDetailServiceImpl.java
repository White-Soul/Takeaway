package com.example.takeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeaway.entity.OrderDetail;
import com.example.takeaway.service.OrderDetailService;
import com.example.takeaway.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author 24343
* @description 针对表【order_detail(订单明细表)】的数据库操作Service实现
* @createDate 2022-10-13 12:16:13
*/
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
implements OrderDetailService{

}
