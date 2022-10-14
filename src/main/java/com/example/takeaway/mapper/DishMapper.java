package com.example.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.takeaway.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 24343
* @description 针对表【dish(菜品管理)】的数据库操作Mapper
* @createDate 2022-10-09 19:29:09
* @Entity com.example.takeaway.entity.Dish
*/
@Mapper
public interface DishMapper extends BaseMapper<Dish> {


}
