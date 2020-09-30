package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import top.zwzx.managersystem.mapper.DepartmentMapper;
import top.zwzx.managersystem.mapper.EmployeeMapper;
import top.zwzx.managersystem.pojo.Department;
import top.zwzx.managersystem.pojo.Employee;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author zx
 * @date 2020/6/1
 **/
@Controller
public class EmplpyeeController {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;

    @RequestMapping("/emps")
    public String list(Model model) {
        List<Employee> employees = employeeMapper.employeeList();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @RequestMapping("/emp")
    public String toAddpage(Model model) {
//        查出所有部门的信息
        List<Department> all = departmentMapper.all();
        model.addAttribute("departments",all);
        return "emp/add";
    }


    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeMapper.addEmployee(employee);
        return "redirect:/emps";
    }
@GetMapping("/emp/{id}")
    public String updateEmp(@PathVariable("id") Integer id,Model model){
//        查出原来的数据
    Employee employee = employeeMapper.quaryById(id);
    List<Department> all = departmentMapper.all();
    model.addAttribute("departments",all);
    model.addAttribute("emp",employee);
    return "emp/update";
    }

    @RequestMapping("/updateEmp/{id}")
    public String updateEmp(Employee employee){
        System.out.println(employee);
        employeeMapper.updateEmployee(employee);
        return "redirect:/emps";
    }

//    删除
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeMapper.deleteEmployee(id);
        return "redirect:/emps";
    }
}
