package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.zwzx.managersystem.pojo.User;
import top.zwzx.managersystem.service.IUserService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zx
 * @date 2020/9/27
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iUserService;
    @RequestMapping("/toLogin")
    public String toLogin(HttpSession httpSession){
        httpSession.setAttribute("role","teacher");
        return "index";
    }

@RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession httpSession){
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        List<User> users = iUserService.loginIn(user);
        if(users.size()==1){
            httpSession.setAttribute("loginUser",username);
            int i = iUserService.queryPermission(username);
            httpSession.setAttribute("permission",i);
            return "redirect:/teacher/showAllTeacher ";
        }else{
            model.addAttribute("msg","用户名或密码错误，请重试");
            return "index";
        }
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.removeAttribute("loginUser");
        return "redirect:/user/toLogin";
    }

}
