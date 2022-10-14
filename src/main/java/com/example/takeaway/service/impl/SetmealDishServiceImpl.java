package com.example.takeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeaway.entity.SetmealDish;
import com.example.takeaway.service.SetmealDishService;
import com.example.takeaway.mapper.SetmealDishMapper;
import org.springframework.stereotype.Service;

/**
* @author 24343
* @description 针对表【setmeal_dish(套餐菜品关系)】的数据库操作Service实现
* @createDate 2022-10-11 14:32:32
*/
@Service
public class SetmealDishServiceImpl extends ServiceImpl<SetmealDishMapper, SetmealDish>
implements SetmealDishService{

}
