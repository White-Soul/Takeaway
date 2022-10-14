package com.example.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.takeaway.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 24343
* @description 针对表【shopping_cart(购物车)】的数据库操作Mapper
* @createDate 2022-10-13 11:52:13
* @Entity com.example.takeaway.entity.ShoppingCart
*/
@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {


}
