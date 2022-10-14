package com.example.takeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeaway.entity.Employee;
import com.example.takeaway.mapper.EmployeeMapper;
import com.example.takeaway.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
* @author 24343
* @description 针对表【employee(员工信息)】的数据库操作Service实现
* @createDate 2022-10-08 13:38:33
*/
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
