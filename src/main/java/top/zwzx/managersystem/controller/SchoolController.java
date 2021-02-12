package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zwzx.managersystem.pojo.*;
import top.zwzx.managersystem.service.*;

import javax.servlet.http.HttpSession;
import java.nio.file.LinkOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    @Autowired
    IStudentService iStudentService;

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
    public String personal(HttpSession httpSession,Model model){
        Integer loginUser =(Integer) httpSession.getAttribute("loginUser");
        Parents parents = iParentsService.showOneParentsAndStudent(loginUser);
        RemindClass remindClass = new RemindClass();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        remindClass.setClassTime(formatter.format(date));
        remindClass.setStudentId(parents.getStudentId());
//今日课程内容
        List<RemindClass> remindClasses = iParentsService.showTodayClass(remindClass);
        model.addAttribute("todayClass",remindClasses);
//        明日课程内容

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);//-1.昨天时间 0.当前时间 1.明天时间 *以此类推
        String time = formatter.format(c.getTime());

        remindClass.setClassTime(time);
        List<RemindClass> remindClasses1 = iParentsService.showTomorrowClass(remindClass);
        model.addAttribute("tomorrowClass",remindClasses1);
//        今日课程数量
        int size = remindClasses.size();
        model.addAttribute("todayClassCount",size);
//        明日课程数量
        int size1 = remindClasses1.size();
        model.addAttribute("tomorrowClassCount",size1);
//        公告
        Notice notice = iParentsService.showFirstIsOn();
        iParentsService.addReadedCount(notice.getNoticeId());
        model.addAttribute("notice",notice);
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
    public String classPerform(HttpSession session,Model model){
        Integer loginUser =(Integer) session.getAttribute("loginUser");
        Parents parents = iParentsService.showOneParentsAndStudent(loginUser);
        List<ClassRecord> classRecords = iSchoolStyleService.showAllClassRecord(parents.getStudentId());
        model.addAttribute("classRecords",classRecords);
        int size = classRecords.size();
        model.addAttribute("allClassCount",size);
        Student student = iStudentService.showOneStudent(parents.getStudentId());
        Integer restOfClass = student.getRestOfClass();
        model.addAttribute("restOfClass",restOfClass);
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
    @RequestMapping("/showClassImage/{id}")
    @ResponseBody
    public ImageJSON showClassImage(@PathVariable("id")Integer id){
        Image image = new Image();
        ImageJSON imageJSON = new ImageJSON();
        List<Image> images = iSchoolStyleService.showImageByClassRecordId(id);
        imageJSON.setTitle("上课风采");
        imageJSON.setId(123);
        imageJSON.setStart(0);
        imageJSON.setData(images);
        return imageJSON;
    }
    @RequestMapping("/toAllClassImage")
    public String showAllClassImage(){
        return "/school/allClassImage";
    }
    @RequestMapping("/showAllClassImageApp")
    @ResponseBody
    public List<ImageStyle> showAllClassImageApp(HttpSession httpSession){
        Integer loginUser =(Integer) httpSession.getAttribute("loginUser");
        System.out.println(loginUser);
        Parents parents = iParentsService.showOneParentsAndStudent(loginUser);
        List<ImageStyle> imageStyles = iSchoolStyleService.showAllClassImageByStudentId(parents.getStudentId());
        return imageStyles;
    }


}
