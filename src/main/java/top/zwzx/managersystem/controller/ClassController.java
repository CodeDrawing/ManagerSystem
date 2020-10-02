package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zwzx.managersystem.pojo.Student;
import top.zwzx.managersystem.pojo.Teacher;
import top.zwzx.managersystem.pojo.classClass;
import top.zwzx.managersystem.service.IClassService;
import top.zwzx.managersystem.service.IStudentService;
import top.zwzx.managersystem.service.ITeacherService;

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
    @Autowired
    IStudentService iStudentService;
    @Autowired
    ITeacherService iTeacherService;

    @RequestMapping("/showAllClass")
    public String showAllClass(Model model){
        List<classClass> classClasses = iClassService.showAllClass();
        model.addAttribute("classList",classClasses);
        return "crud/classList";
    }
    @RequestMapping("/add")
    public String add(Model model){
        List<Teacher> teachers = iTeacherService.showAllTeacher();
        model.addAttribute("teacherList",teachers);
        return "crud/classAdd";
    }
    @RequestMapping("/addClass")
    public String addClass(Model model,classClass classClass) {
        iClassService.addClass(classClass);
        iClassService.countStudent(classClass);
        return "redirect:/class/showAllClass";
    }
    //查询改课程的所有学生
    @RequestMapping("/queryStudent/{id}")
    public String queryStudent(Model model,@PathVariable("id") Integer id){
        //查询所有学生，然后添加到该班级中去
        List<Student> students1 = iStudentService.showAllStudent();
        model.addAttribute("students",students1);
        List<Student> students = iClassService.queryStudent(id);
        List<Teacher> teachers = iClassService.queryTeacherInfo(id);
        Teacher teacher = teachers.get(0);
        String teacherName = teacher.getTeacherName();
        model.addAttribute("id",id);
        model.addAttribute("teacherName",teacherName);
        model.addAttribute("studentList",students);
        return "crud/classStudentList";
    }
    @RequestMapping("/addStudentToClass/{classId}")
    public String addStudentToClass(@PathVariable("classId") Integer classId,Student student){
        student.setClassId(classId);
        System.out.println(student);
        iClassService.addStudentToClass(student);
        return "redirect:/class/showAllClass";

    }

//    @RequestMapping("/updateClass/{id}")
//    public String updateClass(@PathVariable("id") Integer id,Model model){
//        List<Teacher> teachers = iClassService.queryTeacherInfo(id);
//        model.addAttribute("teacherList",teachers);
//        return "redirect:/class/showAllClass";
//
//    }

    @RequestMapping("/toUpdateClass/{id}")
    public String toAddClass(@PathVariable("id") Integer id,Model model){
        classClass classClasses = iClassService.showOneClass(id);
        model.addAttribute("class",classClasses);
        List<Teacher> teachers = iTeacherService.showAllTeacher();
        System.out.println(teachers);
        model.addAttribute("teacherList",teachers);
        return "crud/updateClass";
    }

    @RequestMapping("/updateClass")
    public String updateClass(classClass classClass){
        iClassService.updateClass(classClass);
        return "redirect:/class/showAllClass";
    }
}
