package top.zwzx.managersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.managersystem.dao.EmployeeDao;
import top.zwzx.managersystem.mapper.EmployeeMapper;
import top.zwzx.managersystem.pojo.Employee;

import java.util.List;

/**
 * @author zx
 * @date 2020/6/2
 **/
@Service
public class EmployeesServiceImpl implements EmployeeService{
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> employeeList() {
        return employeeMapper.employeeList();
    }

    @Override
    public Employee quaryById(int id) {
        return employeeMapper.quaryById(id);
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeMapper.addEmployee(employee);
    }

    @Override
    public int deleteEmployee(int id) {
        return employeeMapper.deleteEmployee(id);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }
}
