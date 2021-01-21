package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.zwzx.managersystem.pojo.ApplyCourse;
import top.zwzx.managersystem.service.IApplyCourseService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zx
 * @Date 2021/1/18 17:54
 */
@Controller
@RequestMapping("/apply")
public class ApplyCourseController {
    @Autowired
    IApplyCourseService iApplyCourseService;
//接收前端的表单提交
    @RequestMapping("/applyCourseApp")
    @ResponseBody
//    跨域问题，导致一直不能返回ajax的success function（）{}
    @CrossOrigin
    public Map applyCourseApp(ApplyCourse applyCourse){
        Map<Object, Object> map = new HashMap<>();
        if(applyCourse.getApplyCourse().isEmpty()||applyCourse.getStudentName().isEmpty()||
        applyCourse.getComeOnTime().isEmpty()||applyCourse.getTelephone().isEmpty()){
            map.put("result",4);
            return map;
        }else {
            System.out.println(applyCourse.getStudentName());
            iApplyCourseService.addApplyCourse(applyCourse);
            map.put("result",200);
            return map;
        }
    }

    @RequestMapping("/showAllApplyCourse")

    public String showAllApplyCourse(Model model){
        List<ApplyCourse> applyCourses = iApplyCourseService.showAllApplyCourse();
        model.addAttribute("applyList",applyCourses);
        return "crud/applyCourseList";
    }
}
