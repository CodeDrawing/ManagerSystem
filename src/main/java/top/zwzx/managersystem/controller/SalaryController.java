package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zwzx.managersystem.pojo.Salary;
import top.zwzx.managersystem.pojo.Teacher;
import top.zwzx.managersystem.service.ISalaryService;
import top.zwzx.managersystem.service.ITeacherService;

import java.util.List;

/**
 * @author zx
 * @date 2020/9/30
 **/
@Controller
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    ISalaryService iSalaryService;
    @Autowired
    ITeacherService iTeacherService;
    @RequestMapping("/showAllSalary")
    public String showAllSalary(Model model){
        List<Salary> salaries = iSalaryService.showAllSalary();
        model.addAttribute("salaryList",salaries);
        return "crud/salaryList";
    }
    @RequestMapping("/toSalaryAdd")
    public String toSalaryAdd(Model model){
        List<Teacher> teachers = iTeacherService.showAllTeacher();
        model.addAttribute("teacherList",teachers);
        return "/crud/salaryAdd";
    }
    @RequestMapping("/salaryAdd")
    public String salaryAdd(Salary salary){
        iSalaryService.salaryAdd(salary);
        return "redirect:/salary/showAllSalary";
    }
    @RequestMapping("/toAddSalary")
    public String toAddSalary(){
        return "crud/salaryAdd";
    }

    @RequestMapping("/toSalaryUpdate/{id}")
    public String toSalaryUpdate(@PathVariable("id") Integer id,Model model){
        Salary salary = iSalaryService.toSalaryUpdate(id);
        model.addAttribute("salary",salary);
        return "/crud/salaryUpdate";
    }
    @RequestMapping("/salaryUpdate")
    public String salaryUpdate(Salary salary){
         iSalaryService.salaryUpdate(salary);
        return "redirect:/salary/showAllSalary";
    }
    @RequestMapping("/dropSalary/{id}")
    public String dropSalary(@PathVariable("id") Integer id){
        iSalaryService.dropSalary(id);
        return "redirect:/salary/showAllSalary";
    }


}
