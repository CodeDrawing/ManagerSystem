package top.zwzx.managersystem.controller;

import ch.qos.logback.classic.spi.EventArgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.zwzx.managersystem.pojo.Student;
import top.zwzx.managersystem.service.IFileService;
import top.zwzx.managersystem.service.IStudentService;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author zx
 * @date 2020/9/29
 **/
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService iStudentService;
    @Autowired
    IFileService iFileService;


    //    显示所有学生信息
    @RequestMapping("/showAllStudent")
    public String showAllStudent(Model model, HttpServletRequest request) {
        List<Student> students = iStudentService.showAllStudent();
        model.addAttribute("studentList", students);
        //获取session中的权限信息
        Object permission = request.getSession().getAttribute("permission");

        //返回到一个页面 显示所有学生信息
        return "crud/studentList";
    }

    @RequestMapping("/add")
    public String add() {
        return "crud/studentAdd";
    }

    @RequestMapping("/addStudent")
    public String addStudnet(@RequestParam(value = "studentPhoto") MultipartFile file,Student student) {
        String s = iFileService.fileUpload(file);
        System.out.println(s);
        student.setStudentPhotoPath(s);
        student.setRestOfClass(student.getAllClass());
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
    public String updateStudent(@RequestParam("studentPhoto")MultipartFile file, Student student){
        if(file.isEmpty()){
            iStudentService.updateStudent(student);
        }else {
            String s = iFileService.fileUpload(file);
            student.setStudentPhotoPath(s);
            iStudentService.updateStudent(student);
        }
        return "redirect:/student/showAllStudent";
    }

//    @RequestMapping("/uploadStudentPhoto")
//    public String uploadStudentPhoto(@RequestParam(value = "studentPhoto") MultipartFile file,Model model){
//        String s = iFileService.fileUpload(file);
//        model.addAttribute("file",s);
//        return s;
//    }

@RequestMapping("/showStudent")
public String test(Model model){
    List<Student> students = iStudentService.showAllStudent();
    model.addAttribute("studentsList",students);

    return "crud/show";
}

}
