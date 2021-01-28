package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zwzx.managersystem.pojo.Course;
import top.zwzx.managersystem.pojo.SchoolStyle;
import top.zwzx.managersystem.pojo.Teacher;
import top.zwzx.managersystem.service.ICourseService;
import top.zwzx.managersystem.service.ISchoolStyleService;
import top.zwzx.managersystem.service.ITeacherService;

import java.util.List;

@Controller
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    ICourseService iCourseService;
    @Autowired
    ITeacherService iTeacherService;
    @Autowired
    ISchoolStyleService iSchoolStyleService;

    @RequestMapping("/applyCommit")
    public String applyCommit(Model model){
        List<Course> courses = iCourseService.showAllCourse();
        model.addAttribute("courses",courses);
        return "school/applyCommit";
    }
    @RequestMapping("/applyCommit/{courseName}")
    public String applyCommitDefault(@PathVariable("courseName")String courseName,Model model){
        Course course = new Course();
        course.setCourseName(courseName);
        List<Course> courses = iCourseService.showAllCourse();
        model.addAttribute("defaultCourse",course);
        model.addAttribute("courses",courses);
        return "school/applyCommit";
    }
    @RequestMapping("/courseInfo")
    public String courseInfo(){
        return "school/courseInfo";
    }
    @RequestMapping("/courseIntroduce")
    public String courseIntroduce(Model model){
        List<Course> courses = iCourseService.showAllCourse();
        model.addAttribute("courses",courses);
        return "school/courseIntroduce";
    }
    @RequestMapping("/login")
    public String login(){
        return "school/login";
    }
    @RequestMapping("/register")
    public String register(){
        return "school/register";
    }
    @RequestMapping("/soon")
    public String soon(){
        return "school/soon";
    }
    @RequestMapping("/studentList")
    public String studentList(){
        return "school/studentList";
    }
    @RequestMapping("/studentStyle")
    public String studentStyle(Model model){
        List<SchoolStyle> schoolStyles = iSchoolStyleService.queryAllSchoolStyle();
        model.addAttribute("courses",schoolStyles);
        return "school/studentStyle";
    }
    @RequestMapping("/teacherList")
    public String teacherList(Model model){
        List<Teacher> teachersList = iTeacherService.showAllTeacher();
        model.addAttribute("teacherList",teachersList);
        return "school/teacherList";
    }
    @RequestMapping("/we")
    public String we(){
        return "school/we";
    }
    @RequestMapping("/index")
    public String index(){
        return "school/index";
    }

}
