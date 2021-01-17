package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zwzx.managersystem.pojo.Monitor;
import top.zwzx.managersystem.service.IMonitorService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author zx
 * @Date 2021/1/17 22:09
 */
@Controller
@RequestMapping("/monitor")
public class MonitorController {
    @Autowired
    IMonitorService iMonitorService;

    @RequestMapping("/showAllMonitor")
    public String showAllMonitor(HttpSession request, Model model){
        Integer permission = (Integer)request.getAttribute("permission");
        if (permission!=1){
            return "/error/400";
        }else{
            List<Monitor> monitors = iMonitorService.queryAllMonitorLog();
            model.addAttribute("monitors",monitors);
            return  "/crud/monitorList";
        }

    }
}
