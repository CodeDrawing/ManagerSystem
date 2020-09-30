package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zwzx.managersystem.pojo.Salary;
import top.zwzx.managersystem.service.ISalaryService;

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
    @RequestMapping("/showAllSalary")
    public String showAllSalary(Model model){
        List<Salary> salaries = iSalaryService.showAllSalary();
        model.addAttribute("salaryList",salaries);
        return "crud/salaryList";
    }

}
