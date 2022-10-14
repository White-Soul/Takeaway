package com.example.takeaway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.takeaway.dto.SetmealDto;
import com.example.takeaway.entity.Setmeal;

import java.util.List;

/**
* @author 24343
* @description 针对表【setmeal(套餐)】的数据库操作Service
* @createDate 2022-10-09 19:29:17
*/
public interface SetmealService extends IService<Setmeal> {
//    新增套餐同时需要保存菜品和套餐的关系
    void saveWithDish(SetmealDto setmealDto);
//    删除套餐同时删除套餐和菜品的关联数据
    void removeWithDish(List<Long> ids);
}
