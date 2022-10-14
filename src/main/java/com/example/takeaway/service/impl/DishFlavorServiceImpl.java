package com.example.takeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeaway.entity.DishFlavor;
import com.example.takeaway.service.DishFlavorService;
import com.example.takeaway.mapper.DishFlavorMapper;
import org.springframework.stereotype.Service;

/**
* @author 24343
* @description 针对表【dish_flavor(菜品口味关系表)】的数据库操作Service实现
* @createDate 2022-10-10 19:20:52
*/
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor>
implements DishFlavorService{

}
