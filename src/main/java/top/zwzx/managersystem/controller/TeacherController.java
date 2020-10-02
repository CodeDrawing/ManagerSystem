package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("/toAddTeacher")
    public String toAddTeacher(){
    return "crud/teacherAdd";
    }
    @RequestMapping("/addTeacher")
    public String addTeacher(Teacher teacher){
    iTeacherService.addTeacher(teacher);
    return "redirect:/teacher/showAllTeacher";
    }
    @RequestMapping("/dropTeacher/{id}")
    public String dropTeacher(@PathVariable("id") Integer id){
        iTeacherService.dropTeacher(id);
        return "redirect:/teacher/showAllTeacher";
    }
    @RequestMapping("/toUpdateTeacher/{id}")
    public String toUpdateTeacher(@PathVariable("id")Integer id,Model model){
        Teacher teacher1 = iTeacherService.queryOneTeacher(id);
        model.addAttribute("teacher",teacher1);
        return "crud/updateTeacher";
    }
    @RequestMapping("/updateTeacher")
    public String updateTeacher(Teacher teacher){
        iTeacherService.updateTeacher(teacher);
        return "redirect:/teacher/showAllTeacher";

    }
}
