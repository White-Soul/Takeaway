package com.example.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.takeaway.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 24343
* @description 针对表【order_detail(订单明细表)】的数据库操作Mapper
* @createDate 2022-10-13 12:16:13
* @Entity com.example.takeaway.entity.OrderDetail
*/
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {


}
