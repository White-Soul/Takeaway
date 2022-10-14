package com.example.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.takeaway.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 24343
* @description 针对表【dish_flavor(菜品口味关系表)】的数据库操作Mapper
* @createDate 2022-10-10 19:20:52
* @Entity com.example.takeaway.entity.DishFlavor
*/
@Mapper
public interface DishFlavorMapper extends BaseMapper<DishFlavor> {


}
