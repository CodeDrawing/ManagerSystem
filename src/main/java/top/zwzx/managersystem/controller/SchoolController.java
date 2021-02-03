package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zwzx.managersystem.pojo.*;
import top.zwzx.managersystem.service.ICourseService;
import top.zwzx.managersystem.service.IParentsService;
import top.zwzx.managersystem.service.ISchoolStyleService;
import top.zwzx.managersystem.service.ITeacherService;

import javax.servlet.http.HttpSession;
import java.nio.file.LinkOption;
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
    @Autowired
    IParentsService iParentsService;

    @RequestMapping("/normal/applyCommit")
    public String applyCommit(Model model){
        List<Course> courses = iCourseService.showAllCourse();
        model.addAttribute("defaultCourse",courses.get(0));
        model.addAttribute("courses",courses);
        return "school/applyCommit";
    }
    @RequestMapping("/normal/applyCommit/{courseName}")
    public String applyCommitDefault(@PathVariable("courseName")String courseName,Model model){
        Course course = new Course();
        course.setCourseName(courseName);
        List<Course> courses = iCourseService.showAllCourse();
        model.addAttribute("defaultCourse",course);
        model.addAttribute("courses",courses);
        return "school/applyCommit";
    }
    @RequestMapping("/normal/courseInfo")
    public String courseInfo(){
        return "school/courseInfo";
    }
    @RequestMapping("/normal/courseIntroduce")
    public String courseIntroduce(Model model){
        List<Course> courses = iCourseService.showAllCourse();
        model.addAttribute("courses",courses);
        return "school/courseIntroduce";
    }
    @RequestMapping("/normal/login")
    public String login(HttpSession httpSession){
        if(httpSession.getAttribute("loginUser")==null) {
            String role = "parents";
            httpSession.setAttribute("role", role);
            return "school/login";
        }else{
            return "redirect:/school/personal";
        }
    }
    @RequestMapping("/normal/register")
    public String register(){
        return "school/register";
    }
    @RequestMapping("/normal/soon")
    public String soon(){
        return "school/soon";
    }
    @RequestMapping("/normal/studentList")
    public String studentList(){
        return "school/studentList";
    }
    @RequestMapping("/normal/studentStyle")
    public String studentStyle(Model model){
        List<SchoolStyle> schoolStyles = iSchoolStyleService.queryAllSchoolStyle();
        model.addAttribute("courses",schoolStyles);
        return "school/studentStyle";
    }
    @RequestMapping("/normal/teacherList")
    public String teacherList(Model model){
        List<Teacher> teachersList = iTeacherService.showAllTeacher();
        model.addAttribute("teacherList",teachersList);
        return "school/teacherList";
    }
    @RequestMapping("/normal/we")
    public String we(){
        return "school/we";
    }
    @RequestMapping("/normal/index")
    public String index(){
        return "school/index";
    }

    @RequestMapping("/personal")
    public String personal(HttpSession httpSession){
        return "school/personal";
    }
    @RequestMapping("/adviceToTeacher")
    public String adviceToTeacher(Model model,HttpSession httpSession){
        Integer loginUser =(Integer) httpSession.getAttribute("loginUser");
        Parents parents = iParentsService.showOneParents(loginUser);
        List<haveClass> haveClasses = iParentsService.showHaveClass(parents.getStudentId());
        model.addAttribute("haveClasses",haveClasses);
        List<Advice> notFeedBackAdvice = iParentsService.showAdviceByParentsIdNotFeedBack(loginUser);
        List<Advice> AlreadyFeedBackAdvice = iParentsService.showAdviceByParentsIdAlreadyFeedBack(loginUser);
        model.addAttribute("notFeedBackAdvice",notFeedBackAdvice);
        model.addAttribute("AlreadyFeedBackAdvice",AlreadyFeedBackAdvice);
        return "school/adviceToTeacher";
    }
    @RequestMapping("/alterPassword")
    public String alterPassword(){
        return "school/alterPassword";
    }
    @RequestMapping("/classPerform")
    public String classPerform(HttpSession session){
        System.out.println(session.getAttribute("loginUser"));
        return "school/classPerform";
    }
    @RequestMapping("/myAccount")
    public String myAccount(HttpSession session, Model model){
        if(session.getAttribute("loginUser").equals(null)){
            Parents parents = new Parents();
            model.addAttribute("parents",parents);
            return "school/myAccount";
        }else{
            Integer loginUser = (Integer) session.getAttribute("loginUser");
            Parents parents = iParentsService.showOneParentsAndStudent(loginUser);
            model.addAttribute("parents",parents);
            return "school/myAccount";
        }
    }
    @RequestMapping("/myCourses")
    public String myCourses(HttpSession httpSession,Model model){
        List<haveClass> haveClasses = iParentsService.showHaveClass((Integer) httpSession.getAttribute("studentId"));
        System.out.println(httpSession.getAttribute("studentId"));
        model.addAttribute("classes",haveClasses);
        System.out.println(haveClasses);
        return "school/myCourses";
    }
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession httpSession){
        httpSession.removeAttribute("loginUser");
        return "redirect:/school/normal/login";
    }


}
