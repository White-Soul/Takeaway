package com.example.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.takeaway.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 24343
* @description 针对表【employee(员工信息)】的数据库操作Mapper
* @createDate 2022-10-08 13:38:45
* @Entity com.example.takeaway.entity.Employee
*/
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

//    int deleteByPrimaryKey(Long id);
//
//    int insert(Employee record);
//
//    int insertSelective(Employee record);
//
//    Employee selectByPrimaryKey(Long id);
//
//    int updateByPrimaryKeySelective(Employee record);
//
//    int updateByPrimaryKey(Employee record);

}
