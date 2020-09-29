package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zwzx.managersystem.pojo.Teacher;
import top.zwzx.managersystem.service.ITeacherService;
import top.zwzx.managersystem.service.IUserService;

import java.util.List;

/**
 * @Author zx
 * @Date 2020/9/29 21:36
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    ITeacherService iTeacherService;

@RequestMapping("/showAllTeacher")
    public String showAllTeacher(Model model){
        List<Teacher> teachers = iTeacherService.showAllTeacher();
        model.addAttribute("teacherList",teachers);
        return "crud/teacherList";
    }
}
