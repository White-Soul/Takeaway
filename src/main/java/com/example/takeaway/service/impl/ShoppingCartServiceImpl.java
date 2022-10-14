package com.example.takeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeaway.entity.ShoppingCart;
import com.example.takeaway.service.ShoppingCartService;
import com.example.takeaway.mapper.ShoppingCartMapper;
import org.springframework.stereotype.Service;

/**
* @author 24343
* @description 针对表【shopping_cart(购物车)】的数据库操作Service实现
* @createDate 2022-10-13 11:52:13
*/
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart>
implements ShoppingCartService{

}
