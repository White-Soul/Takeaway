package com.example.takeaway.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.takeaway.common.R;
import com.example.takeaway.entity.Employee;
import com.example.takeaway.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
//    员工登录
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee){
//        进行md5加密
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
//        查询数据库
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername, employee.getUsername());
        Employee one = employeeService.getOne(queryWrapper);

        if(one == null){
            return R.error("登录失败");
        }

//        密码比对
        if(!one.getPassword().equals(password)){
            return R.error("登录失败");
        }
//        查看状态
        if(one.getStatus() == 0){
            return R.error("账号已经禁用");
        }
        request.getSession().setAttribute("employee", one.getId());
        return R.success(one);
    }
//    退出
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){
//        清理session中保存的员工id
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }

    /**
     * 保存员工
     * @param request
     * @param employee
     * @return
     */
    @PostMapping
    public R<String> save(HttpServletRequest request, @RequestBody Employee employee){
//        设置初始密码
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
//        employee.setCreateTime(new Date());
//        employee.setUpdateTime(new Date());
//
//        Long employee1 = (Long)request.getSession().getAttribute("employee");
//        employee.setCreateUser(employee1);
//        employee.setUpdateUser(employee1);


        employeeService.save(employee);
        return R.success("新增员工成功");
    }

    /**
     * 员工信息分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name){
        log.info("page={}, pageSize = {}, name = {}", page,pageSize,name);

//        构造分页构造器
        Page page1 = new Page(page, pageSize);
//        条件构造器
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
//        添加一个过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name), Employee::getName, name);
//        添加排序条件
        queryWrapper.orderByDesc(Employee::getUpdateTime);
//        查询
        employeeService.page(page1, queryWrapper);
        return R.success(page1);
    }

    /**
     * 根据id修改员工信息
     * @param employee
     * @return
     */
    @PutMapping
    public R<String> updata(HttpServletRequest request, @RequestBody Employee employee){
        employee.setUpdateTime(new Date());
        employee.setUpdateUser((Long) request.getSession().getAttribute("employee"));
        employeeService.updateById(employee);
        return R.success("员工信息修改成功");
    }

    /**
     *  根据id差员工
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable Long id){

        Employee byId = employeeService.getById(id);
        if(byId != null){
            return R.success(byId);
        }
        return R.error("没有查询到相关员工");
    }


}
