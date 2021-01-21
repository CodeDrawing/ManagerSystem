package top.zwzx.managersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.zwzx.managersystem.mapper.SchoolStyleMapper;
import top.zwzx.managersystem.pojo.DangAn;
import top.zwzx.managersystem.pojo.SchoolStyle;
import top.zwzx.managersystem.service.IFileService;
import top.zwzx.managersystem.service.ISchoolStyleService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Author zx
 * @Date 2021/1/16 12:56
 */
@Controller
@RequestMapping("/schoolStyle")
public class SchoolStyleController {

    @Autowired
    IFileService iFileService;

    @Autowired
    ISchoolStyleService iSchoolStyleService;

    @RequestMapping("/showAllSchoolImage")
    public String showAllSchoolImage(Model model){
        List<SchoolStyle> schoolStyle = iSchoolStyleService.queryAllSchoolStyle();
        model.addAttribute("schoolStyles",schoolStyle);
        return "crud/showSchoolStyle";
    }
    @ResponseBody
    @GetMapping("/showAllSchoolImageApp")
    @CrossOrigin
    public List<SchoolStyle> showAllSchoolImageApp(){
        List<SchoolStyle> schoolStyle = iSchoolStyleService.queryAllSchoolStyle();
        return schoolStyle;
    }
    @RequestMapping("/addSchoolImage")
    public String addSchoolImage(@RequestParam("file") MultipartFile file, SchoolStyle schoolStyle, HttpServletRequest request) throws IOException {
        String s = iFileService.fileUpload(file);
        schoolStyle.setImage(s);
        schoolStyle.setCreateTime(new Date());
        schoolStyle.setCreateUser((String) request.getSession().getAttribute("loginUser"));
        iSchoolStyleService.addSchoolImage(schoolStyle);
        return "redirect:/schoolStyle/showAllSchoolImage";
    }
    @RequestMapping("/showOneBigImageApp/{id}")
    @ResponseBody
    @CrossOrigin
    public SchoolStyle schoolStyle(@PathVariable("id")Integer id){
        SchoolStyle schoolStyle = iSchoolStyleService.showOneBigImage(id);
        return schoolStyle;

    }
}
