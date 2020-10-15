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

    @Override
    public void salaryAdd(Salary salary) {
        salary.setRealWages(salary.getBaseSalary()+salary.getClassMoney()+salary.getCommission()-salary.getLeaveDays()*50-salary.getDeductions());
        
        salaryMapper.salaryAdd(salary);
    }

    @Override
    public Salary toSalaryUpdate(Integer id) {
        Salary salary = salaryMapper.toSalaryUpdate(id);
        return salary;
    }

    @Override
    public void salaryUpdate(Salary salary) {
        salaryMapper.salaryUpdate(salary);
    }

    @Override
    public void dropSalary(Integer id) {
        salaryMapper.dropSalary(id);
    }


}
