package top.zwzx.managersystem.controller;

import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zwzx.managersystem.pojo.Parents;
import top.zwzx.managersystem.service.IParentsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zx
 * @Date 2021/1/21 12:01
 */

@Controller
@RequestMapping("/parents")
public class ParentsController {
    @Autowired
    IParentsService iParentsService;

    @RequestMapping("/registerParents")
    @ResponseBody
//   hai
    @CrossOrigin
    public Map registerParents(Parents parents){
        System.out.println(parents);
        Map<Object, Object> map = new HashMap<>();
        int i = iParentsService.registerParents(parents);
        System.out.println(i);

        if(i==1){
            map.put("result",200);
        }else{
            map.put("result",4);
        }

        return map;

    }
//    登录家校中心
    @RequestMapping("/loginSFC")
    @ResponseBody
    @CrossOrigin
    public Map loginSFC(@RequestParam("username")String username,@RequestParam("password") String password){
        Map<String, Object> map = new HashMap<>();
        List<Parents> parents = iParentsService.loginSFCByTelephoneNumber(username, password);
        System.out.println(username+"密码"+password);
        if(parents.size()==1){
            map.put("result",200);
        }else{
            map.put("result",4);
        }
        System.out.println(map);

        return map;
    }


}
