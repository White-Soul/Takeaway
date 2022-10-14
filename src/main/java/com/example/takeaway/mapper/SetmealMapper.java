package com.example.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.takeaway.entity.Setmeal;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 24343
* @description 针对表【setmeal(套餐)】的数据库操作Mapper
* @createDate 2022-10-09 19:29:17
* @Entity com.example.takeaway.entity.Setmeal
*/
@Mapper
public interface SetmealMapper extends BaseMapper<Setmeal> {


}
