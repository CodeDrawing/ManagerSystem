package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.zwzx.managersystem.pojo.Teacher;
import top.zwzx.managersystem.service.IFileService;
import top.zwzx.managersystem.service.ITeacherService;
import top.zwzx.managersystem.service.IUserService;

import java.io.IOException;
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
    @Autowired
    IFileService iFileService;

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
    public String updateTeacher(@RequestParam("file") MultipartFile file, Teacher teacher) throws IOException {
    if(file.isEmpty()) {
        iTeacherService.updateTeacher(teacher);
    }else {
        String s = iFileService.fileUpload(file);
        teacher.setImage(s);
        iTeacherService.updateTeacher(teacher);
    }
        return "redirect:/teacher/showAllTeacher";
    }

//    官网获取教师的信息并展示
    @RequestMapping("/showOneTeacherApp/{id}")
    @ResponseBody
    @CrossOrigin
    public Teacher showOneTeacherApp(@PathVariable("id")Integer id){
        Teacher teacher = iTeacherService.queryOneTeacher(id);
        return teacher;
    }
}
