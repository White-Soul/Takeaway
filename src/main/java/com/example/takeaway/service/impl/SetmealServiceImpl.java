package com.example.takeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeaway.common.CustomException;
import com.example.takeaway.dto.SetmealDto;
import com.example.takeaway.entity.Setmeal;
import com.example.takeaway.entity.SetmealDish;
import com.example.takeaway.service.SetmealDishService;
import com.example.takeaway.service.SetmealService;
import com.example.takeaway.mapper.SetmealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author 24343
* @description 针对表【setmeal(套餐)】的数据库操作Service实现
* @createDate 2022-10-09 19:29:17
*/
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal>
implements SetmealService{
    @Autowired
    private SetmealDishService setmealDishService;

    /**
     * 保存套餐
     * @param setmealDto
     */
    @Override
    @Transactional
    public void saveWithDish(SetmealDto setmealDto) {
//        保存套餐的基本信息,操作setmeal，执行insert
        this.save(setmealDto);
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes.stream().map((item)->{
            item.setSetmealId(Long.toString(setmealDto.getId()));
            return item;
        }).collect(Collectors.toList());
//        保存套餐和菜品的相关信息，操作setmeal_dish 执行insert
        setmealDishService.saveBatch(setmealDishes);
    }

    /**
     * 删除套餐
     * @param ids
     */
    @Override
    @Transactional
    public void removeWithDish(List<Long> ids) {
//        查询状态，确定是否可以删除
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.in(Setmeal::getId, ids);
        setmealLambdaQueryWrapper.eq(Setmeal::getStatus, 1);
//        如果不能删除，抛出异常
        int count = this.count(setmealLambdaQueryWrapper);
        if(count > 0){
            throw new CustomException("套餐正在售卖中，不能删除");
        }
//        如果可以删除，先删除套餐表中的数据-----setmeal
        this.removeByIds(ids);
//        删除关系表中的数据----setmal-dish
        LambdaQueryWrapper<SetmealDish> setmealDishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealDishLambdaQueryWrapper.in(SetmealDish::getSetmealId,ids);

        setmealDishService.remove(setmealDishLambdaQueryWrapper);
    }
}
