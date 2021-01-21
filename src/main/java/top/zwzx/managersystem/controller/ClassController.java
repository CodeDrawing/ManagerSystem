package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zwzx.managersystem.pojo.*;
import top.zwzx.managersystem.service.IClassService;
import top.zwzx.managersystem.service.IMonitorService;
import top.zwzx.managersystem.service.IStudentService;
import top.zwzx.managersystem.service.ITeacherService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    IMonitorService iMonitorService;
    @Autowired
    IClassService iClassService;
    @Autowired
    IStudentService iStudentService;
    @Autowired
    ITeacherService iTeacherService;

    @RequestMapping("/showAllClass")
    public String showAllClass(Model model, HttpSession request){
        List<classClass> classClasses = iClassService.showAllClass();
//        日志处理
        String monitorUser=(String)request.getAttribute("loginUser");
        Monitor monitor = new Monitor();
        monitor.setCreateTime(new Date());
        monitor.setWorker(monitorUser);
        monitor.setOperationContent("查询了所有学生信息");
        monitor.setRequest("/class/showAllClass");
        iMonitorService.addMonitor(monitor);


        model.addAttribute("classList",classClasses);
        return "crud/classList";
    }
    @RequestMapping("/add")
    public String add(Model model, HttpSession request){
        //        日志处理
        String monitorUser=(String)request.getAttribute("loginUser");
        Monitor monitor = new Monitor();
        monitor.setCreateTime(new Date());
        monitor.setWorker(monitorUser);
        monitor.setOperationContent("跳转到了新增班级界面");
        monitor.setRequest("/class/add");
        iMonitorService.addMonitor(monitor);

        List<Teacher> teachers = iTeacherService.showAllTeacher();
        model.addAttribute("teacherList",teachers);
        return "crud/classAdd";
    }
    @RequestMapping("/addClass")
    public String addClass(classClass classClass, HttpSession request) {
        //        日志处理
        String monitorUser=(String)request.getAttribute("loginUser");
        Monitor monitor = new Monitor();
        monitor.setCreateTime(new Date());
        monitor.setWorker(monitorUser);
        monitor.setOperationContent("新增了班级班级名为："+classClass.getClassName());
        monitor.setRequest("/class/addClass");
        iMonitorService.addMonitor(monitor);

        iClassService.addClass(classClass);
        iClassService.countStudent(classClass);
        return "redirect:/class/showAllClass";
    }
    //查询改课程的所有学生
    @RequestMapping("/queryStudent/{id}")
    public String queryStudent(Model model,@PathVariable("id") Integer id, HttpSession request){

        //        日志处理
        String monitorUser=(String)request.getAttribute("loginUser");
        Monitor monitor = new Monitor();
        monitor.setCreateTime(new Date());
        monitor.setWorker(monitorUser);
        monitor.setOperationContent("查询了id为："+id+"的班级信息");
        monitor.setRequest("/class/queryStudent");
        iMonitorService.addMonitor(monitor);


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
    public String addStudentToClass(@PathVariable("classId") Integer classId,Student student, HttpSession request){


        //        日志处理
        String monitorUser=(String)request.getAttribute("loginUser");
        Monitor monitor = new Monitor();
        monitor.setCreateTime(new Date());
        monitor.setWorker(monitorUser);
        monitor.setOperationContent("把"+student.getStudentId()+"添加到了id为"+classId+"的班级中");
        monitor.setRequest("/class/addStudentToClass");
        iMonitorService.addMonitor(monitor);

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
    public String toAddClass(@PathVariable("id") Integer id,Model model,HttpSession request){



        //        日志处理
        String monitorUser=(String)request.getAttribute("loginUser");
        Monitor monitor = new Monitor();
        monitor.setCreateTime(new Date());
        monitor.setWorker(monitorUser);
        monitor.setOperationContent("进入了id为"+id+"的班级信息修改页面");
        monitor.setRequest("/class/toUpdateClass"+id);
        iMonitorService.addMonitor(monitor);

        classClass classClasses = iClassService.showOneClass(id);
        model.addAttribute("class",classClasses);
        List<Teacher> teachers = iTeacherService.showAllTeacher();
        model.addAttribute("teacherList",teachers);
        return "crud/updateClass";
    }

    @RequestMapping("/updateClass")
    public String updateClass(classClass classClass,HttpSession request){
        //        日志处理
        String monitorUser=(String)request.getAttribute("loginUser");
        Monitor monitor = new Monitor();
        monitor.setCreateTime(new Date());
        monitor.setWorker(monitorUser);
        monitor.setOperationContent("修改了id为"+classClass.getClassId()+"的课程名"+classClass.getClassName()
                +"上课教室"+classClass.getClassRoom()+"开课日期"+classClass.getClassTime()+
                "上课教师"+classClass.getTeacherId()+"上课时间"+classClass.getText());
        monitor.setRequest("/class/updateClass");
        iMonitorService.addMonitor(monitor);

        iClassService.updateClass(classClass);
        return "redirect:/class/showAllClass";
    }

    //删除记录
    @RequestMapping("/dropClass/{id}")
    public String dropClass(@PathVariable("id")Integer id,HttpSession request){

        //        日志处理
        String monitorUser=(String)request.getAttribute("loginUser");
        Monitor monitor = new Monitor();
        monitor.setCreateTime(new Date());
        monitor.setWorker(monitorUser);
        monitor.setOperationContent("删除了id为"+id+"的班级信息");
        monitor.setRequest("/class/dropClass"+id);
        iMonitorService.addMonitor(monitor);

        iClassService.dropClass(id);
        return "redirect:/class/showAllClass";
    }
    //删除该课程的学生
    @RequestMapping("/dropStudentOfClass/{cId}/{sId}")
    public String dropStudentOfClass(@PathVariable("cId") Integer cId,@PathVariable("sId") Integer sId,HttpSession request){
        //        日志处理
        String monitorUser=(String)request.getAttribute("loginUser");
        Monitor monitor = new Monitor();
        monitor.setCreateTime(new Date());
        monitor.setWorker(monitorUser);
        monitor.setOperationContent("删除了id为"+cId+"的班级中id为"+sId+"的学生");
        monitor.setRequest("/class/dropClass/"+cId+"/"+sId);
        iMonitorService.addMonitor(monitor);

        iClassService.dropStudentOfClass(cId,sId);
        return "redirect:/class/queryStudent/"+cId;
    }
    //点到
    @RequestMapping("/comeOn/{cId}/{sId}")
    public String comeOn(@PathVariable("cId") Integer cId, @PathVariable("sId") Integer sId, HttpServletRequest request,HttpSession request1){
        //        日志处理
        String monitorUser=(String)request1.getAttribute("loginUser");
        Monitor monitor = new Monitor();
        monitor.setCreateTime(new Date());
        monitor.setWorker(monitorUser);
        monitor.setOperationContent("给Id为"+cId+"的班级中的"+sId+"学生点到");
        monitor.setRequest("/class/comeOn/"+cId+"/"+sId);
        iMonitorService.addMonitor(monitor);

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
