package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.zwzx.managersystem.pojo.*;
import top.zwzx.managersystem.service.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Author zx
 * @Date 2020/9/29 23:04
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    ICourseService iCourseService;


    @Autowired
    IFileService iFileService;

@RequestMapping("/showAllCourse")
    public String showAllCourse(Model model){
    List<Course> courseList = iCourseService.showAllCourse();
    model.addAttribute("courseList",courseList);
    return "crud/courseList";
    }

    @RequestMapping("/showAllCourseApp")
    @ResponseBody
    @CrossOrigin
    public List<Course> showAllCourseApp(){
        List<Course> courseList = iCourseService.showAllCourse();
        return courseList;
    }
    @RequestMapping("/showOneCourseApp/{id}")
    @ResponseBody
    @CrossOrigin
     public Course showOneCourseApp(@PathVariable("id")Integer courseId){
        Course Course = iCourseService.showOneCourse(courseId);
        return Course;
    }

    @RequestMapping("/dropCourse/{courseId}")
    public String dropCourse(@PathVariable("courseId") Integer courseId){
        iCourseService.dropCourse(courseId);
        return "redirect:/course/showAllCourse";
    }
    @RequestMapping("/addCourse")
    public String insertCourse(@RequestParam("file") MultipartFile file, Course course) throws IOException {
        String s = iFileService.fileUpload(file);
        course.setImage(s);
        iCourseService.insertCourse(course);
        return  "redirect:/course/showAllCourse";
    }
    @RequestMapping("/add")
    public String toAddCourse(){
    return "crud/CourseAdd";
    }
    @RequestMapping("/update/{id}")
    public String toUpdateCourse(@PathVariable("id") Integer courseId,Model model){
        Course course = iCourseService.showOneCourse(courseId);
        model.addAttribute("courseInfo",course);
        return "crud/updateCourse";
    }
    @RequestMapping("/updateCourse")
    public String updateCourse(@RequestParam("file") MultipartFile file, Course course) throws IOException {
    if(file.isEmpty()){
        iCourseService.updateCourse(course);
    }else{
        String s = iFileService.fileUpload(file);
        course.setImage(s);
        iCourseService.updateCourse(course);
    }
    return "redirect:/course/showAllCourse";
    }

}
