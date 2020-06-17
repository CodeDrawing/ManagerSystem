package top.zwzx.managersystem.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zwzx.managersystem.pojo.Employee;

import java.util.List;

/**
 * @author zx
 * @date 2020/6/2
 **/

public interface EmployeeService {

//查询所有员工
    List<Employee> employeeList();
//    通过id查询员工
    Employee quaryById(int id);
//    增加员工
    int addEmployee(Employee employee);
//    删除员工
    int deleteEmployee(int id);
//    修改员工信息
    int updateEmployee(Employee employee);


}
