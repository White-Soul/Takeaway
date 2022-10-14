package com.example.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.takeaway.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 24343
* @description 针对表【category(菜品及套餐分类)】的数据库操作Mapper
* @createDate 2022-10-09 19:12:10
* @Entity com.example.takeaway.entity.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

}
