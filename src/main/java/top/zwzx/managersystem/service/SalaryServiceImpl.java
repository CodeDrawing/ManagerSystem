package top.zwzx.managersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.managersystem.mapper.SalaryMapper;
import top.zwzx.managersystem.pojo.Salary;

import java.util.List;

/**
 * @author zx
 * @date 2020/9/30
 **/
@Service
public class SalaryServiceImpl implements ISalaryService {

    @Autowired
    SalaryMapper salaryMapper;

    @Override
    public List<Salary> showAllSalary() {
        List<Salary> salaries = salaryMapper.showAllSalary();
        return salaries;
    }
}
