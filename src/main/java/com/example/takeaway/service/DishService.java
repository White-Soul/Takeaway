package com.example.takeaway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.takeaway.dto.DishDto;
import com.example.takeaway.entity.Dish;

/**
* @author 24343
* @description 针对表【dish(菜品管理)】的数据库操作Service
* @createDate 2022-10-09 19:29:09
*/
public interface DishService extends IService<Dish> {
    //    新增菜品，同时插入菜品对应的口味数据
    void saveWithFlavor(DishDto dishDto);
//    根据id查询菜品信息和对应的口味信息
    DishDto getByIdWithFlavor(Long id);

    void updateWithFlavor(DishDto dishDto);
}
