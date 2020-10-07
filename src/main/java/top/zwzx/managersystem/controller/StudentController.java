package top.zwzx.managersystem.controller;

import ch.qos.logback.classic.spi.EventArgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zwzx.managersystem.pojo.Student;
import top.zwzx.managersystem.service.IStudentService;

import java.util.Date;
import java.util.List;

/**
 * @author zx
 * @date 2020/9/29
 **/
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService iStudentService;


    //    显示所有学生信息
    @RequestMapping("/showAllStudent")
    public String showAllStudent(Model model) {
        List<Student> students = iStudentService.showAllStudent();
        model.addAttribute("studentList", students);
        System.out.println(students);
        //返回到一个页面 显示所有学生信息
        return "crud/studentList";
    }

    @RequestMapping("/add")
    public String add() {
        return "crud/studentAdd";
    }

    @RequestMapping("/addStudent")
    public String addStudnet(Student student) {
        student.setAdmissionTime(new Date());
        iStudentService.addStudent(student);
        return "redirect:/student/showAllStudent";
    }
    @RequestMapping("/dropStudent/{id}")
    public String dropStudent(@PathVariable("id")Integer id){
        System.out.println(id);
        iStudentService.dropStudent(id);
        return "redirect:/student/showAllStudent";
    }
    @RequestMapping("/toUpdateStudent/{id}")
    public String toUpdateStudent(@PathVariable("id") Integer id,Model model){
        Student student = iStudentService.showOneStudent(id);
        model.addAttribute("student",student);
        return "crud/updateStudent";
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(Student student){
        iStudentService.updateStudent(student);
        return "redirect:/student/showAllStudent";
    }
}
