package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zwzx.managersystem.pojo.ClassRecord;
import top.zwzx.managersystem.pojo.Student;
import top.zwzx.managersystem.pojo.Teacher;
import top.zwzx.managersystem.pojo.classClass;
import top.zwzx.managersystem.service.IClassService;
import top.zwzx.managersystem.service.IStudentService;
import top.zwzx.managersystem.service.ITeacherService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
        model.addAttribute("classId",id);
        return "crud/classStudentList";
    }
    @RequestMapping("/addStudentToClass/{classId}")
    public String addStudentToClass(@PathVariable("classId") Integer classId,Student student){
        student.setClassId(classId);
        iClassService.addStudentToClass(student);
        return "redirect:/class/queryStudent/"+classId;

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

    //删除记录
    @RequestMapping("/dropClass/{id}")
    public String dropClass(@PathVariable("id")Integer id){
        iClassService.dropClass(id);
        return "redirect:/class/showAllClass";
    }
    //删除该课程的学生
    @RequestMapping("/dropStudentOfClass/{cId}/{sId}")
    public String dropStudentOfClass(@PathVariable("cId") Integer cId,@PathVariable("sId") Integer sId){
        iClassService.dropStudentOfClass(cId,sId);
        return "redirect:/class/queryStudent/"+cId;
    }
    //点到
    @RequestMapping("/comeOn/{cId}/{sId}")
    public String comeOn(@PathVariable("cId") Integer cId, @PathVariable("sId") Integer sId, HttpServletRequest request){
        iClassService.comeOn(sId);
        ClassRecord classRecord=new ClassRecord();
        classRecord.setClassId(cId);
        classRecord.setStudentId(sId);
        classRecord.setDate(new Date());
        classRecord.setCreateTeacher((String) request.getSession().getAttribute("loginUser"));
        iClassService.classRecord(classRecord);
        return "redirect:/class/queryStudent/"+cId;
    }
}
