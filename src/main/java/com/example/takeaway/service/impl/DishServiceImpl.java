package com.example.takeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeaway.dto.DishDto;
import com.example.takeaway.entity.Dish;
import com.example.takeaway.entity.DishFlavor;
import com.example.takeaway.service.DishFlavorService;
import com.example.takeaway.service.DishService;
import com.example.takeaway.mapper.DishMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author 24343
* @description 针对表【dish(菜品管理)】的数据库操作Service实现
* @createDate 2022-10-09 19:29:09
*/
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish>
implements DishService{
    @Autowired
    private DishFlavorService dishFlavorService;


    /**
     *  新增菜品，同时插入菜品对应的口味数据
     * @param dishDto
     */
    @Transactional
    public void saveWithFlavor(DishDto dishDto){
//        保存菜品基本信息到菜品表
        this.save(dishDto);
        Long id = dishDto.getId();

        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map((item)->{
            item.setDishId(id);
            return item;
        }).collect(Collectors.toList());

//        保存菜品口味表
        dishFlavorService.saveBatch(flavors);
    }

    /**
     * 根据id查询菜品信息和对应的口味信息
     * @param id
     * @return
     */
    @Override
    public DishDto getByIdWithFlavor(Long id) {
//        查询基本信息
        Dish dish = this.getById(id);

        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish, dishDto);
//        查询口味信息
        LambdaQueryWrapper<DishFlavor> dishFlavorLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishFlavorLambdaQueryWrapper.eq(DishFlavor::getDishId, dish.getId());
        List<DishFlavor> list = dishFlavorService.list(dishFlavorLambdaQueryWrapper);
        dishDto.setFlavors(list);
        return dishDto;
    }

    /**
     *
     * @param dishDto
     */
    @Override
    public void updateWithFlavor(DishDto dishDto) {
//        更新dish表基本信息
        this.updateById(dishDto);
//        清理当前菜品对应的口味数据===dish_flavor delete
        LambdaQueryWrapper<DishFlavor> dishFlavorLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishFlavorLambdaQueryWrapper.eq(DishFlavor::getDishId, dishDto.getId());
        dishFlavorService.remove(dishFlavorLambdaQueryWrapper);
//        添加提交过来的数据====dish_flavor insert
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map((item)->{
            item.setDishId(dishDto.getId());
            return item;
        }).collect(Collectors.toList());
        dishFlavorService.saveBatch(flavors);
    }
}
