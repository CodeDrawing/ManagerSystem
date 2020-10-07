package top.zwzx.managersystem.service;

import top.zwzx.managersystem.pojo.Salary;

import java.util.List;

/**
 * @author zx
 * @date 2020/9/30
 **/
public interface ISalaryService {
    public List<Salary> showAllSalary();
    public void salaryAdd(Salary salary);
    public Salary  toSalaryUpdate(Integer id);
    public void salaryUpdate(Salary salary);
    public void dropSalary(Integer id);

}
