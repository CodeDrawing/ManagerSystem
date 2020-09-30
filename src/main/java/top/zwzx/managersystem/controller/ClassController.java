package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zwzx.managersystem.pojo.classClass;
import top.zwzx.managersystem.service.IClassService;

import java.util.List;

/**
 * @Author zx
 * @Date 2020/9/29 23:04
 */
@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    IClassService iClassService;

    @RequestMapping("/showAllClass")
    public String showAllClass(Model model){
        List<classClass> classClasses = iClassService.showAllClass();
        model.addAttribute("classList",classClasses);
        return "crud/classList";
    }
}
