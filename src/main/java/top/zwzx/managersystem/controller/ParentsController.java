package top.zwzx.managersystem.controller;

import com.google.code.kaptcha.Producer;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.*;
import top.zwzx.managersystem.pojo.*;
import top.zwzx.managersystem.service.IMailService;
import top.zwzx.managersystem.service.IParentsService;
import top.zwzx.managersystem.service.IStudentService;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * @Author zx
 * @Date 2021/1/21 12:01
 */
@Controller
@RequestMapping("/parents")
public class ParentsController {
    @Autowired
    IParentsService iParentsService;
    @Autowired
    IMailService iMailService;
    @Autowired
    private Producer kaptchaProducer;
    @Autowired
    IStudentService iStudentService;

    @RequestMapping(path = "/kaptcha", method = RequestMethod.GET)
    @CrossOrigin
    public void getKaptcha(HttpServletResponse response, HttpSession session) {
        // 生成验证码
        String text = kaptchaProducer.createText();
        BufferedImage image = kaptchaProducer.createImage(text);
        // 将验证码存入session
        session.setAttribute("kaptcha", text);
        // 将突图片输出给浏览器
        response.setContentType("image/png");
        try {
            OutputStream os = response.getOutputStream();
            ImageIO.write(image, "png", os);
        } catch (IOException e) {
        }
    }
//    验证码
    @RequestMapping("/verificationKaptcha")
    @ResponseBody
    @CrossOrigin
    public Map verificationKaptcha(HttpSession session,String kaptcha){
        Map<String, Object> map = new HashMap<>();
        String s = kaptcha.toUpperCase();
        if(session.getAttribute("kaptcha").equals(s)){
            map.put("result",200);
        }else{
            map.put("result",4);
        }
        System.out.println(map);
        return map;
    }

    @RequestMapping("/registerParents")
    @ResponseBody
//   hai
    @CrossOrigin
    public Map registerParents(Parents parents){
        Map<Object, Object> map = new HashMap<>();
        if(parents.getParentsName().isEmpty()||parents.getPassword().isEmpty()||parents.getTelephoneNumber().isEmpty()||parents.getFinalPassword().isEmpty()){
            map.put("result",5);
        }else if(!parents.getPassword().equals(parents.getFinalPassword())){
            map.put("result",6);
        }else{
            List<Parents> parents1 = iParentsService.showOneParentsByTelephoneNumber(parents.getTelephoneNumber());
            if(parents1.size()!=0){
//                输入的手机号已存在，请登陆或者重新输入手机号
                map.put("result",1);
                return map;
            }
            if(!parents.getEmail().isEmpty()){
//                iMailService.sendSimpleMail(parents.getEmail(),"欢迎来到能力风暴","欢迎注册内江能力风暴家校中心！" +
//                        "请牢记账号密码，如果忘记请联系老师更改！" +
//                        "" +
//                        "现在，你只需要联系老师，稍等片刻后你就可以在家校中心里面访问您孩子的上课情况和表现");
                iMailService.sendHtmlMail(parents.getEmail(),"欢迎来到能力风暴","<h1>欢迎来到内江能力风暴</h1><p style='color:red'>请牢记账号密码，如果忘记请联系老师更改！</p>" +
                        "<h4>现在,你只需要稍等片刻,你就可以在家校中心里面访问您孩子的上课情况和表现</h4>");
            }

        int i = iParentsService.registerParents(parents);
        if(i==1){
            map.put("result",200);
        }else{
            map.put("result",4);
        }
        }
        return map;

    }
//    登录家校中心
    @RequestMapping("/loginSFC")
    @ResponseBody
    @CrossOrigin
    public Map loginSFC(@RequestParam("username")String username,@RequestParam("password") String password, HttpSession httpSession){
        Map<String, Object> map = new HashMap<>();
        List<Parents> parents = iParentsService.loginSFCByTelephoneNumber(username, password);
        if(parents.size()==1){
            Integer loginUser=parents.get(0).getParentsId();
            Integer studentId=parents.get(0).getStudentId();
            //            httpSession.setAttribute("loginUser",loginUser);
            httpSession.setAttribute("loginUser",loginUser);
            httpSession.setAttribute("studentId",studentId);
            map.put("result",200);
        }else{
            map.put("result",4);
        }
        return map;
    }
    @RequestMapping("/showAllParents")
    public String showAllParentsList(Model model){
        List<Parents> parents = iParentsService.showAllParentsList();
        model.addAttribute("parents",parents);
        return "crud/parentsList";
    }
    @RequestMapping("/dropParents/{id}")
    public String dropParents(@PathVariable("id") Integer id){
        iParentsService.dropParents(id);
        return "redirect:/parents/showAllParents";
    }
    @RequestMapping("/toUpdateParents/{id}")
    public String toUpdateParents(@PathVariable("id") Integer id,Model model){
        Parents parents = iParentsService.showOneParents(id);
        model.addAttribute("parent",parents);
        List<Student> students = iStudentService.showAllStudent();
        model.addAttribute("students",students);
        return "crud/updateParents";
    }
    @RequestMapping("/updateParents")
    public String updateParents(Parents parents){
        iParentsService.updateParents(parents);
        return "redirect:/parents/showAllParents";
    }
    @RequestMapping("/updateParentsApp")
    @ResponseBody
    @CrossOrigin
    public Map updateParentsApp(Parents parents){
        HashMap<String, Object> map = new HashMap<>();
        iParentsService.updateParents(parents);
        map.put("result",200);
        return map;
    }
    @RequestMapping("/updatePassword")
    @ResponseBody
    @CrossOrigin
    public Map updatePassword(HttpSession httpSession,Parents parents){
        parents.setParentsId((Integer) httpSession.getAttribute("loginUser" ));
        HashMap<String, Object> map = new HashMap<>();
        Integer loginUser = (Integer) httpSession.getAttribute("loginUser");
        Parents parents1 = iParentsService.showOneParents(loginUser);
        String oldPassword = parents1.getPassword();
        if(parents.getPassword().isEmpty()){
            map.put("result",4);
        }else if(parents.getNewPassword().isEmpty()||parents.getFinalPassword().isEmpty()){
            map.put("result",5);
        }else if(!parents.getNewPassword().equals(parents.getFinalPassword())){
            map.put("result",6);
        }else if(!parents.getPassword().equals(oldPassword)){
//            原密码不符
            map.put("result",7);
        }else{
            parents.setPassword(parents.getNewPassword());
            int i = iParentsService.updatePasswrod(parents);
            if(i==1){
                map.put("result",200);
            }else{
                map.put("result",500);
            }
        }
        return map;
    }
    @RequestMapping("/commitAdvice")
    @ResponseBody
    @CrossOrigin
    public Map commitAdvice(HttpSession httpSession,@RequestParam("content")String content,@RequestParam("courseName")String courseName){
        HashMap<String, Object> map = new HashMap<>();
        if(content.isEmpty()||courseName.isEmpty()){
            map.put("result",5);
            return map;
        }
        Integer loginUser=(Integer) httpSession.getAttribute("loginUser");

        Advice advice = new Advice();
        advice.setCourseName(courseName);
        advice.setContent(content);
        advice.setCreateTime(new Date());
        advice.setParentsId(loginUser);
        advice.setFeedBack("暂无");
        advice.setFeedBackUser("暂无");
        Parents parents = iParentsService.showOneParents(loginUser);
        advice.setParentsName(parents.getParentsName());
        int i = iParentsService.addAdvice(advice);
        if(i==1){
            map.put("result",200);
        }else{
            map.put("result",500);
        }
return map;
    }
    @RequestMapping("/showAllAdvice")
    public String showAllAdvice(Model model){
        List<Advice> advice = iParentsService.showAdvice();
        model.addAttribute("advices",advice);
        return "/crud/adviceList";
    }
    @RequestMapping("/dropAdvice/{id}")
    public String dropAdvice(@PathVariable("id") Integer adviceId){
        System.out.println(adviceId);
        iParentsService.dropAdvice(adviceId);
        return "redirect:/parents/showAllAdvice";
    }
    @RequestMapping("/feedBack/{id}")
    public String feedBack(@PathVariable("id")Integer adviceId,Model model){
        Advice advice = iParentsService.showOneAdvice(adviceId);
        model.addAttribute("advice",advice);
        return "/crud/feedBack";
    }
    @RequestMapping("/commitFeedBack")
    @ResponseBody
    public Map commitFeedBack(HttpSession httpSession,Advice advice){
        HashMap<String, Object> map = new HashMap<>();
        String loginUser = (String) httpSession.getAttribute("loginUser");
        advice.setFeedBackUser(loginUser);
        iParentsService.updateAdvice(advice);
        map.put("result",200);
        return map;
    }
    @RequestMapping("/showNotice")
    public String showNotice(Model model){
        List<Notice> notices = iParentsService.showNotice();

        model.addAttribute("notices",notices);

        return "/crud/notice";
    }
    @RequestMapping("/commitNotice")
    @ResponseBody
    public Map commitNotice(HttpSession httpSession,Notice notice){
        System.out.println(notice.getFirst());
        HashMap<String, Object> map = new HashMap<>();
        String loginUser =(String) httpSession.getAttribute("loginUser");
        notice.setCreateUser(loginUser);
        notice.setCreateTime(new Date());
        notice.setReadedCount(0);
        if(("on").equals(notice.getFirst())){
            iParentsService.updateAllFirerIsFalse();
            iParentsService.addNotice(notice);
        }else {
            iParentsService.addNotice(notice);
        }
        map.put("result",200);
        return map;
    }
    @RequestMapping("/remindClass")
    @ResponseBody
    public Map remindClass(@RequestParam("classTime")String classTime,@RequestParam("classId") Integer classId,@RequestParam("text") String text,HttpSession httpSession){
        HashMap<String, Object> map = new HashMap<>();
        RemindClass remindClass = new RemindClass();
        remindClass.setClassId(classId);
        remindClass.setClassTime(classTime);
        remindClass.setCreateTime(new Date());
        remindClass.setCreateUser((String) httpSession.getAttribute("loginUser"));
        remindClass.setText(text);
        System.out.println(remindClass);
        iParentsService.addRemindClass(remindClass);
        map.put("result",200);
        return map;
    }


}
