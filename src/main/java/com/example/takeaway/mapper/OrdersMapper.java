package com.example.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.takeaway.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 24343
* @description 针对表【orders(订单表)】的数据库操作Mapper
* @createDate 2022-10-13 12:16:16
* @Entity com.example.takeaway.entity.Orders
*/
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {


}
