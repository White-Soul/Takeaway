package com.example.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.takeaway.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 24343
* @description 针对表【setmeal_dish(套餐菜品关系)】的数据库操作Mapper
* @createDate 2022-10-11 14:32:32
* @Entity com.example.takeaway.entity.SetmealDish
*/
@Mapper
public interface SetmealDishMapper extends BaseMapper<SetmealDish> {


}
